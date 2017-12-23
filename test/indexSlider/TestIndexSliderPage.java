/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexSlider;

import dbConnection.DbConnection;
import domen.IndexSlider;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.basic.HomePage;
import page.indexSlider.IndexSliderPage;
import page.basic.LoginPage;
import pageUtil.PageUtilities;
import setup.SeleniumProperties;

/**
 *
 * @author Sofija
 */
public class TestIndexSliderPage {

    private static WebDriver driver;
    private IndexSliderPage indexSliderPage;
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
    public void testOpenIndexSlider() {
        indexSliderPage = homePage.clickOnIndexSlider(driver);
        System.out.println("Page title is: " + driver.getTitle());
    }

    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void createNewIndexSlider() {
        IndexSlider indexWeb = indexSliderPage.addIndexSlider(driver);

        System.out.println("IndexSlider is created!");

        IndexSlider indexDb = DbConnection.getIndexSlider("SELECT * FROM `cms_index_slides` WHERE id =" + indexWeb.getId());

        Assert.assertEquals(indexWeb.getId(), indexDb.getId());
        Assert.assertEquals(indexWeb.getTitle(), indexDb.getTitle());
    }

    @Test
    public void testEditIndexSlider() {
        IndexSlider indexWeb = indexSliderPage.editIndexSlider(driver);
        
        System.out.println("IndexSlider is edited!");

        IndexSlider indexDb = DbConnection.getIndexSlider("SELECT * FROM `cms_index_slides` WHERE id =" + indexWeb.getId());

        Assert.assertEquals(indexWeb.getId(), indexDb.getId());
 

    }

    @Test
    public void deleteIndexSlider() {
        IndexSlider indexWeb = indexSliderPage.deleteIndexSlider(driver);
        
        Boolean isDeleted = DbConnection.isDeleted("SELECT * FROM `cms_photo_galleries` WHERE id ="+indexWeb.getId());
        Assert.assertEquals(Boolean.TRUE, isDeleted);
    }
}
