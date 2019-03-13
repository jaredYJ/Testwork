package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import utils.AppDriver;

import java.util.ArrayList;
import java.util.List;

public class Page_shouye extends Page_base {
    private By input = By.xpath("//*[contains(@resource-id,'tab_name') and @text='自选']");
    private By fandjin = By.id("action_create_cube");

    public Page_sousuo main() {

        syup(find(input));
        find(input).click();
        find(fandjin).click();
//        syup(AppDriver.driver.findElement(input));
//        AppDriver.driver.findElement(input).click();
//        AppDriver.driver.findElement(fandjin).click();
        return new Page_sousuo();
    }


    public void syup(WebElement elem) {
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            WebElement elements = elem;
            list.add(elements.getLocation());
            if (i > 0) {
                if (list.get(i - 1).equals(list.get(i))) {
                    break;
                }
            }

        }
    }
}
