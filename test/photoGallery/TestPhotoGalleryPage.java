package photoGallery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dbConnection.DbConnection;
import domen.PhotoGallery;
import javax.xml.crypto.dsig.keyinfo.PGPData;
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
import page.photoGallery.PhotoGalleriesPage;
import pageUtil.PageUtilities;
import setup.SeleniumProperties;

/**
 *
 * @author Sofija
 */
public class TestPhotoGalleryPage {

    private static WebDriver driver;
    private PhotoGalleriesPage photoGalleriesPage;
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
    public void testOpenPhotoGalleries() {
        photoGalleriesPage = homePage.clickOnPhotoGalleries(driver);
        System.out.println("Page title is: " + driver.getTitle());

    }

    @After
    public void tearDown() {
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
   public void testAddPhotoGallery() {
        
        PhotoGallery photoWeb = photoGalleriesPage.addNewPhoto(driver);
        System.out.println("PhotoGallery is saved!");
        
        PhotoGallery photoDb = DbConnection.getPhotoGallery( "SELECT * FROM eco_test.cms_photo_galleries as c WHERE c.id = " +photoWeb.getId());

        Assert.assertEquals(photoWeb.getId(), photoDb.getId());
        Assert.assertEquals(photoWeb.getTitle(), photoDb.getTitle());
    }

    @Test
    public void testEditPhotoGallery() {
        PhotoGallery photoWeb =  photoGalleriesPage.editPhotoGallery(driver);
    }
    
    @Test
    public void testDeletePhoto(){
        PhotoGallery photoWeb = photoGalleriesPage.deletePhoto(driver);
    }
}
