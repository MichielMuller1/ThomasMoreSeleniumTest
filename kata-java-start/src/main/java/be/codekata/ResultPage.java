package be.codekata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
    private final WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void FirstResult() {
        WebElement artikel = driver.findElement(By.xpath("//*[@id=\"page-main-content\"]/div[2]/div/div/div[1]/div/ul/li[1]/article/a"));
        artikel.click();
    }

    public String getTitel(){
        WebElement titel = driver.findElement(By.xpath("//*[@id=\"page-main-content\"]/div[2]/div[2]/div/div/div[1]/article/div/header/h1"));
        return titel.getText();
    }

}
