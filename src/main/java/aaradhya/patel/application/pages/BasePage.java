package aaradhya.patel.application.pages;


import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;

public class BasePage extends FluentWebDriverPage{
    private WebElement webElement;

    public BasePage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    private BasePage currentPage(WebElement webElement){
        this.webElement = webElement;
        return BasePage.this;
    }


}
