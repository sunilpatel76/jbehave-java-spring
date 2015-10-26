package aaradhya.patel.application;


import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.failures.PendingStepStrategy;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.FreemarkerViewGenerator;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.jbehave.web.selenium.*;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.web.selenium.WebDriverHtmlOutput.WEB_DRIVER_HTML;

public class WebApplicationStories extends JUnitStories {

    ApplicationContext context = new SpringApplicationContextFactory("jbehave-steps.xml").createApplicationContext();
    SeleniumContext seleniumContext = new SeleniumContext();
    PendingStepStrategy pendingStepStrategy = new FailingUponPendingStep();
    ContextView contextView = new LocalFrameContextView().sized(140, 30);
    CrossReference crossReference = new CrossReference();

    SeleniumStepMonitor stepMonitor = new SeleniumStepMonitor(contextView,seleniumContext, crossReference.getStepMonitor());
    Format[] formats = new Format[] {new SeleniumContextOutput(seleniumContext), Format.CONSOLE, WEB_DRIVER_HTML};

    @Override
    public Configuration configuration(){
        StoryReporterBuilder storyReporterBuilder;

        storyReporterBuilder = new StoryReporterBuilder().withCodeLocation(codeLocationFromClass(WebApplicationStories.class))
        .withFailureTrace(true).withFailureTraceCompression(true).withDefaultFormats().withFormats(formats);

        JBehaveStoryLoader storyLoader = (JBehaveStoryLoader) context.getBean("storyLoader");
        JBehaveStoryParser storyParser = (JBehaveStoryParser) context.getBean("storyParser");
        return new SeleniumConfiguration().useSeleniumContext(seleniumContext)
                .useStoryLoader(storyLoader).useStoryParser(storyParser)
                .useStoryControls(new StoryControls())
                .useStoryReporterBuilder(storyReporterBuilder.withCrossReference(crossReference))
                .useStepMonitor(stepMonitor).useStoryControls(new StoryControls().doResetStateBeforeScenario(true))
                .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));
    }

    @Override
    public InjectableStepsFactory stepsFactory(){
        return new SpringStepsFactory(configuration(), context);

        /*Configuration configuration = configuration();
        return new InstanceStepsFactory(configuration, new HomePageSteps(),
                webDriverSteps);*/
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
                asList("**/*.story"), null);
    }
}
