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
import org.junit.Assert;
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
         DbConnection.close();
        driver.quit();
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
    public void testAddPortfolio() {
        Portfolios portWeb = portfoliosPage.addNewPortfolio(driver);
        System.out.println("Portfolio is created");
        Portfolios portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE id =" + portWeb.getId());
        portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE title =" + portWeb.getFirstName());
        portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE data_categories =" + portWeb.getDataCategories());
        portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE characteristic1 =" + portWeb.getChar1());
        portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE characteristic2 =" + portWeb.getChar2());
        portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE description =" + portWeb.getResume());

        Assert.assertEquals(portWeb.getId(), portDb.getId());
        Assert.assertEquals(portWeb.getFirstName(), portDb.getFirstName());
        Assert.assertEquals(portWeb.getDataCategories(), portDb.getDataCategories());
        Assert.assertEquals(portWeb.getChar1(), portDb.getDataCategories());
        Assert.assertEquals(portWeb.getChar2(), portDb.getChar1());
        Assert.assertEquals(portWeb.getResume(), portDb.getResume());

    }

    @Test
    public void testEditPortfolio() {
       Portfolios portWeb = portfoliosPage.editPortfolio(driver);
       System.out.println("Portfolio is edited");
        Portfolios portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE id =" + portWeb.getId());
        portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE title =" + portWeb.getFirstName());
        portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE data_categories =" + portWeb.getDataCategories());
        portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE characteristic1 =" + portWeb.getChar1());
        portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE characteristic2 =" + portWeb.getChar2());
        portDb = DbConnection.getPortfolios("SELECT * FROM `cms_portfolios` WHERE description =" + portWeb.getResume());

        Assert.assertEquals(portWeb.getId(), portDb.getId());
        Assert.assertEquals(portWeb.getFirstName(), portDb.getFirstName());
        Assert.assertEquals(portWeb.getDataCategories(), portDb.getDataCategories());
        Assert.assertEquals(portWeb.getChar1(), portDb.getDataCategories());
        Assert.assertEquals(portWeb.getChar2(), portDb.getChar1());
        Assert.assertEquals(portWeb.getResume(), portDb.getResume());
    }

    @Test
    public void testDeletePortfolio() {
        Portfolios portWeb = portfoliosPage.deletePortfolio(driver);
        System.out.println("Portfolio is deleted");
        
        Boolean isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_portfolios` WHERE id =" + portWeb.getId());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
        isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_portfolios` WHERE title =" + portWeb.getFirstName());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
        isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_portfolios` WHERE data_categories =" + portWeb.getDataCategories());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
        isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_portfolios` WHERE characteristic1 =" + portWeb.getChar1());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
        isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_portfolios` WHERE characteristic2 =" + portWeb.getChar2());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
        isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_portfolios` WHERE description =" + portWeb.getResume());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
        
        
    }
}
