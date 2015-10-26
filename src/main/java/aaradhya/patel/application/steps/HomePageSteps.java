package aaradhya.patel.application.steps;


import aaradhya.patel.application.pages.BasePage;
import aaradhya.patel.application.pages.HomePage;
import aaradhya.patel.application.pages.JBehavePageFactory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

public class HomePageSteps {
    private HomePage homePage;
    private BasePage currentPage;

    private static final By INPUT_EMAIL = By.xpath("//*[@title='Type your email address']");

    public HomePageSteps(JBehavePageFactory pageFactory){
        homePage = pageFactory.homePage();
        currentPage = pageFactory.basePage();
    }

    @Given("I am on securustech.net")
    public void GoToHome(){
        homePage.gotoHome();
    }

    @When("User enter $username and $password")
    public void InputUserNamePassword(String username, String password){
        currentPage.webEdit(INPUT_EMAIL).inputText(username);
        System.out.println("");
    }

}
