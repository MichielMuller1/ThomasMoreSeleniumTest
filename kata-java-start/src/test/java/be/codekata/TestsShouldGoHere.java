package be.codekata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsShouldGoHere {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        setChromeDriverLocation();
        driver = new ChromeDriver();
        openHlnPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void searchTest() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.acceptCookies();
        Thread.sleep(1000);

        searchPage.clickSearchIcon();

        searchPage.fillSearchText("Turnhout");
        searchPage.clickSearch();

        ResultPage resultPage = new ResultPage(driver);
        resultPage.FirstResult();

        String titelSet = "Vince Colpaert en KFC Diest blijven steken op 0-0 tegen Termien: “Scoren blijft een probleem”";

        searchPage.clickSearchIcon();
        String titel = resultPage.getTitel();
        assertThat(titel,equalTo(titelSet));

    }

    @Test
    public void searchTitelTest() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.acceptCookies();
        Thread.sleep(1000);

        searchPage.clickSearchIcon();

        searchPage.fillSearchText("Vince Colpaert en KFC Diest blijven steken op 0-0 tegen Termien: “Scoren blijft een probleem”");
        searchPage.clickSearch();

        ResultPage resultPage = new ResultPage(driver);
        resultPage.FirstResult();

        String titelSet = "Vince Colpaert en KFC Diest blijven steken op 0-0 tegen Termien: “Scoren blijft een probleem”";

        searchPage.clickSearchIcon();
        String titel = resultPage.getTitel();
        assertThat(titel,equalTo(titelSet));

    }

    @Test
    public void searchAuteurTest() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.acceptCookies();
        Thread.sleep(1000);

        searchPage.clickSearchIcon();

        searchPage.fillSearchText("Sven Oeyen");
        searchPage.clickSearch();

        ResultPage resultPage = new ResultPage(driver);
        resultPage.FirstResult();

        String titelSet = "Lowie De Wit en leider RWL Sport halen stevig uit tegen VZ Glabbeek (9-0): “De ballen vlogen vlotjes binnen”";

        searchPage.clickSearchIcon();
        String titel = resultPage.getTitel();
        assertThat(titel,equalTo(titelSet));

    }

    private void setChromeDriverLocation() {
        System.setProperty("webdriver.chrome.driver", "D:/Program Files/chromedriver.exe");
    }

    private void openHlnPage(WebDriver driver) {
        this.driver.get("https://www.hln.be/");
    }
}
