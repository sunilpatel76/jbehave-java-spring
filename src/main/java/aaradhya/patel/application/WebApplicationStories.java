package aaradhya.patel.application;


import aaradhya.patel.application.steps.HomePageSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.web.selenium.*;

import java.util.List;

import static java.util.Arrays.asList;

public class WebApplicationStories extends JUnitStories {
    private WebDriverProvider driverProvider = new PropertyWebDriverProvider();
    private WebDriverSteps driverSteps = new PerStoriesWebDriverSteps(driverProvider);


    @Override
    public InjectableStepsFactory stepsFactory(){
        Configuration configuration = configuration();

        return new InstanceStepsFactory(configuration, new HomePageSteps(),
                driverSteps, new WebDriverScreenshotOnFailure(driverProvider, configuration.storyReporterBuilder()));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
                asList("**/*.story"), null);
    }
}
