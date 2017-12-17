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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
    }

    @AfterClass
    public static void tearDownClass() {
//        DbConnection.close();
//        driver.quit();
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
    public void createNewIndexSlider(){
        indexSliderPage.addIndexSlider(driver);
    }
    
    @Test
    public void testEditIndexSlider(){
        IndexSlider indexWeb = indexSliderPage.editIndexSlider(driver);
        
    }
    
    @Test
    public void deleteIndexSlider(){
        IndexSlider indexWeb = indexSliderPage.deleteIndexSlider(driver);
    }
}
