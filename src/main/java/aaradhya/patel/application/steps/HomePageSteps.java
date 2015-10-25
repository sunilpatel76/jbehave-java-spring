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
    public void GoToHome(){
        homePage.gotoHome();
    }

}
