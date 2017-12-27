/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categories;

import dbConnection.DbConnection;
import domen.Categories;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import page.basic.HomePage;
import page.basic.LoginPage;
import page.categories.CategoriesPage;
import pageUtil.PageUtilities;
import setup.SeleniumProperties;

/**
 *
 * @author qa
 */
public class TestCategories {
    
    private static WebDriver driver;
    private CategoriesPage categoriesPage;
    private static LoginPage loginPage;
    private static HomePage homePage;
    
  
    
    @BeforeClass
    public static void testLogin() {
        driver = PageUtilities.initWebDriver(driver);
        SeleniumProperties.init();
        loginPage = new LoginPage();
        homePage = loginPage.logIn(driver, SeleniumProperties.url, SeleniumProperties.username, SeleniumProperties.password);
        DbConnection.getConnection();
    }
    
    @AfterClass
    public static void tearDownClass() {
        DbConnection.close();
        driver.quit();
    }
    
    @Before
    public void testOpenCategories() {
        categoriesPage = homePage.clickOnCategories(driver);
        System.out.println("Page title is: " + driver.getTitle());
        
    }
    
    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void testAddCategory() {
        Categories catWeb = categoriesPage.addNewCategories(driver);
        System.out.println("Category is saved!");
        
        Categories catDb = DbConnection.getCategories("SELECT * FROM `cms_portfolios_categories` WHERE id ="+catWeb.getId());
        Assert.assertEquals(catWeb.getId(), catDb.getId());
        Assert.assertEquals(catWeb.getName(), catDb.getName());
        Assert.assertEquals(catWeb.getResume(), catDb.getResume());
        
    }
    
    @Test 
    public void testEditCategory() {
        Categories catWeb = categoriesPage.editCategory(driver);
        System.out.println("Category is edited!");
        
        Categories catDb = DbConnection.getCategories("SELECT * FROM `cms_portfolios_categories` WHERE id ="+catWeb.getId());
        Assert.assertEquals(catWeb.getId(), catDb.getId());
        Assert.assertEquals(catWeb.getName(), catDb.getName());
        Assert.assertEquals(catWeb.getResume(), catDb.getResume());
    }
    
    @Test 
    public void testDeleteCategory() {
        Categories catWeb = categoriesPage.deleteCategory(driver);
        Boolean isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_portfolios_categories` WHERE id ="+catWeb.getId());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
    }
}
