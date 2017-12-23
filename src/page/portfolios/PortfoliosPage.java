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

    

 

    private void clickOnAddPortfolio(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String sendFirstName(WebDriver driver) {
        return sendTextOnField(driver, By.id("title"));

    }

    private void checkBoxDataElement(WebDriver driver){
        WebElement multiSelectButton = driver.findElement(By.className("multiselect"));
        multiSelectButton.click();
        WebElement table = driver.findElement(By.className("multiselect-container"));
        List<WebElement> checkBoxes = table.findElements(By.tagName("li"));
        int counter = 0;
        for (WebElement checkBox : checkBoxes) {
            WebElement input = checkBox.findElement(By.tagName("input"));
            if (input.getAttribute("value").equals("16") || input.getAttribute("value").equals("18")) {
                checkBox.click();
                counter ++;
            }
            if(counter > 1) {
                break;
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
        sendTextOnField(driver, By.id("portfolio_photo"), "C:/Users/Sofija/Desktop/pineapple.jpg");
    }
    
    private void clickOnSave(WebDriver driver){
        clickOnElement(driver, By.id("new_portfolio_submit"));
    }
    
    private void backOnPortfolios(WebDriver driver){
        clickOnElement(driver, By.className("glyphicon-chevron-left"));
    }
    
    public Portfolios addNewPortfolio(WebDriver driver) throws InterruptedException{
        Portfolios pp = new Portfolios();
        clickOnAddPortfolio(driver);
        pp.setFirstName(sendFirstName(driver));
        checkBoxDataElement(driver);       
        pp.setChar1(textOnCharacteristic1(driver));
        pp.setChar2(textOnCharacteristic2(driver));
        pp.setResume(textOnResume(driver));
        sendPhoto(driver, "C:/Users/Sofija/Desktop/pineapple.jpg");
        clickOnSave(driver);
        backOnPortfolios(driver);
        return pp;   
            
        }

}
