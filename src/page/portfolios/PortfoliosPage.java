/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.portfolios;

import domen.Portfolios;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.basic.Page;

/**
 *
 * @author qa
 */
public class PortfoliosPage extends Page {

    

    private void clickOnAllPortfolios(WebDriver driver) {
        clickOnElement(driver, By.xpath("//*[@id='side-menu']/li[7]/ul/li[1]/a"));
    }

    private void clickOnAddPortfolio(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String sendFirstName(WebDriver driver) {
        return sendTextOnField(driver, By.id("title"));

    }

    private void checkBoxDataElement(WebDriver driver){
        WebElement table = driver.findElement(By.className("multiselect-selected-text"));
        List<WebElement> checkBoxes = table.findElements(By.className("multiselect-container"));
        for (WebElement checkBox : checkBoxes) {
          
            if (checkBox.getAttribute("value").equals("16") || checkBox.getAttribute("value").equals("18")) {
                checkBox.click();
            }

        }
    }
    
    private String textOnCharacteristic1(WebDriver driver){
        return sendTextOnField(driver, By.id("characteristic1"));
    }
    
    private String textOnCharacteristic2(WebDriver driver){
        return sendTextOnField(driver, By.id("characteristic2"));
    }
    
    private String textOnResume(WebDriver driver){
        return sendTextOnField(driver, By.id("description"));
    }
    
    private void sendPhoto(WebDriver driver, String photoLocation){
        sendTextOnField(driver, By.id("portfolio_photo"), "/Users/qa/Desktop/pineapple.jpg");
    }
    
    private void clickOnSave(WebDriver driver){
        clickOnElement(driver, By.id("new_portfolio_submit"));
    }
    
    private void backOnPortfolios(WebDriver driver){
        clickOnElement(driver, By.className("glyphicon-chevron-left"));
    }
    
    public Portfolios addNewPortfolio(WebDriver driver) throws InterruptedException{
        Portfolios pp = new Portfolios();
        clickOnAllPortfolios(driver);
        clickOnAddPortfolio(driver);
        Thread.sleep(2000);
        pp.setFirstName(sendFirstName(driver));
        checkBoxDataElement(driver);
        Thread.sleep(2000);
        pp.setChar1(textOnCharacteristic1(driver));
        pp.setChar2(textOnCharacteristic2(driver));
        pp.setResume(textOnResume(driver));
        Thread.sleep(2000);
        sendPhoto(driver, "/Users/qa/Desktop/pineapple.jpg");
        clickOnSave(driver);
        backOnPortfolios(driver);
        return pp;   
            
        }

}
