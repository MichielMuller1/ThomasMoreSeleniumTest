package be.codekata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        driver.switchTo().frame("sp_message_iframe_609148");
        WebElement cookieAccept = driver.findElement(By.xpath("//*[@id=\"notice\"]/div[3]/button[1]"));
        cookieAccept.click();
    }

    public void fillSearchText(String searchText) {
        WebElement searchQuery = driver.findElement(By.xpath("/html/body/header/section[3]/div[2]/div[2]/div/form/input"));
        searchQuery.sendKeys(searchText);
    }

    public void clickSearch() {
        WebElement searchButton = driver.findElement(By.xpath("/html/body/header/section[3]/div[2]/div[2]/div/form/input"));
        searchButton.submit();
    }

    public void clickSearchIcon() {
        WebElement search = driver.findElement(By.xpath("/html/body/header/section[3]/div[1]/div/nav/div[1]/div/label"));
        search.click();
    }
}
