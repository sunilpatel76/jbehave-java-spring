package aaradhya.patel.application.steps;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class HomePageSteps {

    @Given("a system state")
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
