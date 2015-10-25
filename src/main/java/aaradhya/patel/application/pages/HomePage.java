package aaradhya.patel.application.pages;


import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class HomePage extends FluentWebDriverPage{
    private String webURL;
    private BasePage currentPage;

    public HomePage(WebDriverProvider driverProvider) {
        super(driverProvider);
        currentPage = new BasePage(driverProvider);
    }

    public void gotoHome(){
        get("https://securustech.net/friends");
    }


}
