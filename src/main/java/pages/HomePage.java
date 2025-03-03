package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By themeButton = By.cssSelector("button.mat-mdc-icon-button.mat-unthemed.mat-mdc-button-base");
    private By sideNavButton = By.xpath("//button[@mat-icon-button]//mat-icon[text()='assignment_add']");
    private By htmlElement = By.tagName("html");
    private By topicPanelElement = By.xpath("//div[@class ='mat-drawer-inner-container ng-tns-c48-0']//h2");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickThemeButton() {
        driver.findElement(themeButton).click();
    }

    public void clickSideNavButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(sideNavButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(sideNavButton));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getThemeValue() {
        return driver.findElement(htmlElement).getAttribute("theme");
    }

    public boolean isSideNavButtonDisplayed() {
        return isElementDisplayed(sideNavButton);
    }

    public boolean isTopicPanelDisplayed() {
        return isElementDisplayed(topicPanelElement);
    }

    private boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException exception) {
            return false;
        }
    }
}
