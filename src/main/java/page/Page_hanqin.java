package page;

import com.sun.javafx.stage.WindowCloseRequestHandler;
import io.appium.java_client.android.AndroidDriver;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Page_hanqin extends Page_base {
    private By input5 = By.xpath("//*[contains(@resource-id,'tab_name') and @text='交易']");
    private By jijin = By.id("page_type_fund");
    private By fund = By.cssSelector(".dj-button.blank");


    By pasword = By.cssSelector(".pass_switch");
    By name = By.name("请输入手机号");
    By password = By.name("请输入密码");
    By sign = By.name("安全登录");

    public Page_hanqin webview(String key, String Value) {
        new Page_shouye().syup(AppDriver.driver.findElement(input5));
        find(input5).click();
//        find(jijin).click();


//        AppDriver.driver.findElement(input5).click();
//        AppDriver.driver.findElement(jijin).click();
        AppDriver.driver.getContextHandles();

        AppDriver.driver.context("WEBVIEW_com.xueqiu.android");
        new WebDriverWait(AppDriver.driver, 20);
        AppDriver.driver.findElement(fund).click();


//        AppDriver.driver.findElementByLinkText("已有蛋卷基金账户登录").click();

        String handles = AppDriver.driver.getWindowHandle();
        Set<String> handle = AppDriver.driver.getWindowHandles();
        for (String s : handle) {
            if (s.equals(handles))
                continue;
            else {
                AppDriver.driver.switchTo().window(s);
            }
        }
        System.out.println(AppDriver.driver.getPageSource());
        new WebDriverWait(AppDriver.driver, 20);
        AppDriver.driver.findElement(pasword).click();
        AppDriver.driver.findElement(name).sendKeys(key);
        AppDriver.driver.findElement(password).sendKeys(Value);
        AppDriver.driver.findElement(sign).click();
//        AppDriver.driver.context("NATIVE_APP");
        return this;
    }
}
