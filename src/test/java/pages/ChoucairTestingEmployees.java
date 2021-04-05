package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoucairTestingEmployees extends BasePage {

    public ChoucairTestingEmployees(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_keywords")
    private WebElement searchKeywords;

    @FindBy(xpath = "//input[@type='submit']")
    private  WebElement SearchJobsSubmit;

    @FindBy(xpath = "//*[contains(text(),'Analista de Migraci')]")
    private WebElement AnalistaMigracionElement;

    public void InputKeyWords(String keyword){
        waitVisibility(searchKeywords);
        writeText(searchKeywords, keyword);
    }

    public  void SearchJobs(){
        waitVisibility(SearchJobsSubmit);
        click(SearchJobsSubmit);
    }

    public boolean HasEmployedMigracion(){
        waitVisibility(AnalistaMigracionElement);
        return  AnalistaMigracionElement.isDisplayed();
    }
}
