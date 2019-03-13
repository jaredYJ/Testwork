package page;


import com.sun.xml.internal.bind.v2.model.core.ID;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.tools.ant.types.resources.selectors.None;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.AppDriver;

import javax.xml.soap.Text;

public class Page_base {

    static WebElement find(By locator) {
        try {
            return AppDriver.getCurrentDriver().findElement(locator);

        } catch (Exception e) {
            System.out.println("not found");
            e.printStackTrace();
            AppDriver.getCurrentDriver().findElement(text1("cancel")).click();
            AppDriver.getCurrentDriver().findElement(text("下次再说")).click();
            return AppDriver.getCurrentDriver().findElement(locator);
        }
    }

    static By locate(String locator) {
        if (locator.matches("/.*")) {
            return By.xpath(locator);
        } else {
            return By.id(locator);
        }
    }

    static By text(String content) {
        return By.xpath("//*[@text='" + content + "']");
    }

    static By text1(String content) {
        return By.id("//*[@text='" + content + "']");
    }


}
