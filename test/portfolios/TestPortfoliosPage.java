/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolios;

import dbConnection.DbConnection;
import domen.Portfolios;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import page.basic.HomePage;
import page.basic.LoginPage;
import page.portfolios.PortfoliosPage;
import pageUtil.PageUtilities;
import setup.SeleniumProperties;

/**
 *
 * @author qa
 */
public class TestPortfoliosPage {
    
    private static WebDriver driver;
    private PortfoliosPage portfoliosPage;
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
//         DbConnection.close();
//        driver.quit();
    }
    
    @Before
    public void testNewPortfolio() {
        portfoliosPage = homePage.clickOnAllPortfolios(driver);
        System.out.println("Page title is: " + driver.getTitle());
    }
    
    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());
    }

   @Test
   public void testAddPortfolio() throws InterruptedException{
       portfoliosPage.addNewPortfolio(driver);
    
   }
}
