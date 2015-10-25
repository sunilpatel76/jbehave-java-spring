package aaradhya.patel.application;


import aaradhya.patel.application.steps.HomePageSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.failures.PendingStepStrategy;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.jbehave.web.selenium.*;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static java.util.Arrays.asList;

public class WebApplicationStories extends JUnitStories {

    /*private WebDriverProvider driverProvider = new PropertyWebDriverProvider();
    private WebDriverSteps webDriverSteps = new PerStoryWebDriverSteps(driverProvider);*/

    ApplicationContext context = new SpringApplicationContextFactory("jbehave-steps.xml").createApplicationContext();
    SeleniumContext seleniumContext = new SeleniumContext();
    //private PendingStepStrategy pendingStepStrategy = new FailingUponPendingStep();
    ContextView contextView = new LocalFrameContextView().sized(140, 30);
    CrossReference crossReference = new CrossReference();

    SeleniumStepMonitor stepMonitor = new SeleniumStepMonitor(contextView,seleniumContext, crossReference.getStepMonitor());

    @Override
    public Configuration configuration(){
        StoryReporterBuilder storyReporterBuilder;

        storyReporterBuilder = new StoryReporterBuilder();

        JBehaveStoryLoader storyLoader = (JBehaveStoryLoader) context.getBean("storyLoader");
        JBehaveStoryParser storyParser = (JBehaveStoryParser) context.getBean("storyParser");
        return new SeleniumConfiguration().useSeleniumContext(seleniumContext)
                .useStoryLoader(storyLoader).useStoryParser(storyParser)
                .useStoryControls(new StoryControls())
                .useStoryReporterBuilder(new StoryReporterBuilder().withCrossReference(crossReference))
                .useStepMonitor(stepMonitor);
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
