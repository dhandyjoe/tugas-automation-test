package demo.pages.base;

import demo.webdriver.WebdriverInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePageObject {

    public WebDriver getDriver() {
        return WebdriverInstance.webdriver;
    }

    public void clickOn(By element) {
        getDriver().findElement(element).click();
    }

    public void typeOn(By element, String text) {
        getDriver().findElement(element).sendKeys(text);
    }

    public boolean isPresent(By element) {
        return getDriver().findElement(element).isDisplayed();
    }

    public String getTextProductCart(String value) {
        List<WebElement> elements = getDriver().findElements(By.className("cart_item_label"));
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).findElement(By.className("inventory_item_name")).getText().equals(value)) {
                return elements.get(i).findElement(By.className("inventory_item_name")).getText();
            }
        }
        return "";
    }

    public String getTextProductInventory(String value) {
        List<WebElement> elements = getDriver().findElements(By.className("inventory_item"));
        if (elements.get(0).findElement(By.className("inventory_item_name")).getText().equals(value)) {
            return elements.get(0).findElement(By.className("inventory_item_name")).getText();
        }
        return "";
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scroll(0, 350)");
    }

    public void moveToTab(int index) {
        ArrayList<String> tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(index));
        System.out.println(tabs);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

}
