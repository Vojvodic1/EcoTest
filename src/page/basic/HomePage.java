/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.indexSlider.IndexSliderPage;
import page.photoGallery.PhotoGalleriesPage;
import page.portfolios.PortfoliosPage;

/**
 *
 * @author Sofija
 */
public class HomePage extends Page {
    
    public IndexSliderPage clickOnIndexSlider(WebDriver driver){
        clickOnElement(driver, By.xpath("//*[@id='side-menu']/li[2]/a"));
        IndexSliderPage isp = new IndexSliderPage();
        return isp;
    }
    
    public PhotoGalleriesPage clickOnPhotoGalleries(WebDriver driver){
        clickOnElement(driver, By.xpath("//*[@id='side-menu']/li[3]/a"));
        PhotoGalleriesPage pgp = new PhotoGalleriesPage();
        return pgp;
    }
    
    public PortfoliosPage clickOnPortfolios(WebDriver driver){
        clickOnElement(driver, By.xpath("//*[@id='side-menu']/li[7]/a"));
        PortfoliosPage pp = new PortfoliosPage();
        return pp;
    
    }
   
  
}
