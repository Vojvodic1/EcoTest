/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.portfolios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.basic.Page;

/**
 *
 * @author qa
 */
public class Portfolios extends Page {
    
    private void clickOnPortfolios(WebDriver driver){
        clickOnElement(driver, By.className("a-paper-plane"));
    }
    
    private void clickOnAllPortfolios(WebDriver driver){
        clickOnElement(driver, By.xpath("//*[@id='side-menu']/li[7]/ul/li[1]/a"));
    }
    
    private void addNewPortfolio(WebDriver driver){
        clickOnElement(driver, By.className("glyphicon-plus"));
    }
    
    private String sendFirstName(WebDriver driver){
        return sendTextOnField(driver, By.id("title"));
        
    }
    
    
    
}
