/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.basic;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUtil.PageUtilities;

/**
 *
 * @author Sofija
 */
public class Page {
    
    private WebElement waitForElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
    
    public void sendTextOnField(WebDriver driver, By locator, String text) {
        WebElement element = waitForElement(driver, locator);
        element.clear();
        element.sendKeys(text);
    }
    
    public void clickOnElement(WebDriver driver, By locator) {
        WebElement element = waitForElement(driver, locator);
        element.click();
    }
    
    public String sendTextOnField(WebDriver driver, By locator) {
        WebElement title = waitForElement(driver, locator);
        title.clear();
        String text = PageUtilities.getRandomText();
        title.sendKeys(text);
        return text;
    }
    
   
    
    public void sendUrlOnField(WebDriver driver, By locator) {
        WebElement urlLink = waitForElement(driver, locator);
        urlLink.sendKeys(PageUtilities.getRandomUrl());
    }
    
     public String sendUrlOnUrlField(WebDriver driver, By locator) {
        WebElement urlLink = waitForElement(driver, locator);
        urlLink.clear();
        String text = PageUtilities.getRandomUrl();
        urlLink.sendKeys(text);
        return text;
        
    }
    
    public void chooseOptionFromLastRow(WebDriver driver, By locator) {
        
        WebElement lastRow = findLastRow(driver);
        WebElement optionButton = lastRow.findElement(locator);
        optionButton.click();
    }
    
    public int getIdFromLastRow(WebDriver driver, String attributeName) {
        
        WebElement lastRow = findLastRow(driver);
        String id = lastRow.getAttribute(attributeName);
        return Integer.valueOf(id);
    }
    
    private WebElement findLastRow(WebDriver driver) {
        WebElement table = driver.findElement(By.id("rows-table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        
        WebElement lastRow = rows.get(rows.size() - 1);
        System.out.println("size" + rows.size());
        System.out.println(lastRow);
        return lastRow;
    }
}
