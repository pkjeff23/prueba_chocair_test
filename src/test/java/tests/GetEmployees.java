package tests;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ChoucairTestingEmployees;
import pages.ChoucairTestingHome;
import util.Hook;
import util.PageGenerator;

public class GetEmployees {

    static WebDriver driver;

    @Before
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^Ingreso a la pagina de choucairtesting$")
    public void ingresoALaPaginaDeChoucairtesting() throws Exception {
        PageGenerator.getInstance(ChoucairTestingHome.class, driver).goToTheHomePage();
    }

    @And("^Navego a la opcion Empleos$")
    public void navegoALaOpcionEmpleos() throws Exception {
        PageGenerator.getInstance(ChoucairTestingHome.class, driver).goToEmployed();
    }

    @And("^Ingreso la palabra Migracion en el campo search_keywords$")
    public void ingresoLaPalabraMigracionEnElCampoSearch_keywords() throws Exception {
        PageGenerator.getInstance(ChoucairTestingEmployees.class, driver).InputKeyWords("Migracion");
    }

    @When("^Doy Click en la opcion Search Jobs$")
    public void doyClickEnLaOpcionSearchJobs() throws Exception {
        PageGenerator.getInstance(ChoucairTestingEmployees.class, driver).SearchJobs();

    }

    @Then("^Visualizo la oferta de empleo disponible$")
    public void visualizoLaOfertaDeEmpleoDisponible() throws Exception {
        Assert.assertTrue(PageGenerator.getInstance(ChoucairTestingEmployees.class, driver).HasEmployedMigracion());
    }

}
