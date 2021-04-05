package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoucairTestingHome extends BasePage {

    private String baseURL = "https://www.choucairtesting.com";

    @FindBy(id = "menu-item-550")
    private WebElement linkEmpleos;

    public ChoucairTestingHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ChoucairTestingHome goToTheHomePage(){
        driver.get(baseURL);
        return this;
    }

    public void goToEmployed() {
        waitVisibility(linkEmpleos);
        click(linkEmpleos);
    }
}
