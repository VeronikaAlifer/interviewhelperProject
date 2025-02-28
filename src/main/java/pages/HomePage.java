package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By themeButton = By.xpath("//button[text()='brightness_4']");
    private By editorButton = By.xpath("//button[text()='assignment_add']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

}
