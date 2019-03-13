package page;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppDriver;


public class Page_sousuo extends Page_base {
    private By sosu = By.id("search_input_text");
    private WebElement webElement = AppDriver.driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(9)");


    public Page_sousuo serch(String keyword) {
        find(sosu).sendKeys(keyword);
//        AppDriver.driver.findElement(sosu).sendKeys(keyword);
        new WebDriverWait(AppDriver.driver, 5);
        webElement.click();

        return this;
    }

    public Page_sousuo end() {
        webElement.click();
        AppDriver.driver.navigate().back();
        return this;
    }

    public String stock() {
        String name = webElement.getAttribute("resourceId");
        return name;
    }

}
