/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.categories;

import domen.Categories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.basic.Page;

/**
 *
 * @author qa
 */
public class CategoriesPage extends Page{
    
  
    
    private void clickOnAddPortfolio(WebDriver driver){
        clickOnElement(driver, By.className("glyphicon-plus"));
    }
    
    private String sendTextOnName(WebDriver driver){
        return sendTextOnField(driver, By.id("name"));
    }
    
    private String sendTextOnResume(WebDriver driver){
        return sendTextOnField(driver, By.id("description"));
    }
    
    private void clickOnSave(WebDriver driver){
        clickOnElement(driver, By.id("new_category_submit"));
    }
    
    public Categories addNewCategories(WebDriver driver){
        Categories cp = new Categories();
        clickOnAddPortfolio(driver);
        cp.setName(sendTextOnName(driver));
        cp.setResume(sendTextOnResume(driver));
        clickOnSave(driver);
        cp.setId(getIdFromLastRow(driver, "data-portfolio-id"));
        return cp;
    }
    
    public void chooseEditFromLastRow(WebDriver driver){
        chooseOptionFromLastRow(driver, By.className("glyphicon-pencil"));
    }
    
    public Categories editCategory(WebDriver driver){
        Categories cp = new Categories();
        cp.setId(getIdFromWeb(driver));
        chooseEditFromLastRow(driver);
        cp.setName(sendTextOnName(driver));
        cp.setResume(sendTextOnResume(driver));
        clickOnSave(driver);
        return cp;
        
    }
    
    public Categories deleteCategory(WebDriver Driver){
        Categories cp = new Categories();
        chooseOptionFromLastRow(Driver, By.className("glyphicon-trash"));
        clickOnElement(Driver, By.className("btn-danger"));
        return cp;
    }
    
    public int getIdFromWeb(WebDriver driver){
         return getIdFromLastRow(driver, "data-portfolio-id");
    }
}
