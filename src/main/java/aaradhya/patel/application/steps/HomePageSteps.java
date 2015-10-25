package aaradhya.patel.application.steps;


import aaradhya.patel.application.pages.HomePage;
import aaradhya.patel.application.pages.JBehavePageFactory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class HomePageSteps {
    private HomePage homePage;

    public HomePageSteps(JBehavePageFactory pageFactory){
        homePage = pageFactory.homePage();
    }

    @Given("I am on securustech.net")
    public void givenAnnotation(){
        System.out.println("a system state");
    }

    @When("I do something")
    public void doSomething(){
        System.out.println("I do something");
    }

    @Then("system is in a different state")
    public void theTellMe(){
        System.out.println("Hello India");
    }
}
