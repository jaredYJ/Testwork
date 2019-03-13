package testcase;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;
import page.Page_hanqin;
import page.Page_shouye;
import page.Page_sousuo;
import utils.AppDriver;

import java.net.MalformedURLException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StartTest {
    @BeforeAll
    public static void beforeclass() throws MalformedURLException {
        AppDriver.start();
    }


    @ParameterizedTest
    @DisplayName("A case")
    @ValueSource(strings = {
            "pdd",
            "baidu",
            "alibaba"
    })
//    @CsvSource({"pdd,com.xueqiu.android:id/followed_btn","baidu,com.xueqiu.android:id/followed_btn","alibaba,com.xueqiu.android:id/followed_btn"} )
    void testname(String id) {
        String name = "com.xueqiu.android:id/followed_btn";
        new Page_shouye().main();
        new Page_sousuo().serch(id);
        assertAll("test case",
                () -> assertEquals(name, new Page_sousuo().stock()));
//        Assertions.assertEquals(new Page_sousuo().stock(),name);
        new Page_sousuo().end();

    }

    @ParameterizedTest
    @DisplayName("B case")
    @CsvSource({
            "18510546563,123456"
    })
    void testview(String key, String value) {
        new Page_hanqin().webview(key, value);
    }

    @AfterAll
    public static void afterclass() {
        AppDriver.driver.quit();
    }
}
