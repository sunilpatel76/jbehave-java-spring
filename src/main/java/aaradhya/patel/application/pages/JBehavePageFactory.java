package aaradhya.patel.application.pages;


import org.jbehave.web.selenium.WebDriverProvider;

public class JBehavePageFactory {
    private final WebDriverProvider driverProvider;
    private HomePage homePage;

    public JBehavePageFactory(WebDriverProvider driverProvider){
        this.driverProvider = driverProvider;
    }

    public void setHomePage(HomePage homePage){
        this.homePage = homePage;
    }
    public HomePage homePage(){
        return homePage;
    }
}
