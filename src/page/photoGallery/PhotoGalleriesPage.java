/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.photoGallery;

import page.basic.Page;
import domen.PhotoGallery;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Sofija
 */
public class PhotoGalleriesPage extends Page {
    
    private void clickOnAddPhotoGallery(WebDriver driver){
        clickOnElement(driver, By.xpath("//*[@id='page-wrapper']/div/div[3]/div/div/div[1]/div/a"));
    }
    
    private String sendTextOnTitleField(WebDriver driver){
      return  sendTextOnField(driver, By.name("title"));
    }
    
    private String sendTextOnDescriptionField(WebDriver driver){
        return sendTextOnField(driver, By.id("description"));
    }
    
    private void sendPhoto(WebDriver driver, String photoLocation){

       sendTextOnField(driver, By.id("photo_gallery_leading_photo"), photoLocation);
    }
    
    private void clickOnSave(WebDriver driver){
        clickOnElement(driver, By.id("new_photoGallery_submit"));
    }
    
    public void backToPhoto(WebDriver driver){
        clickOnElement(driver, By.className("glyphicon-arrow-left"));
    }
    
    
    public PhotoGallery addNewPhoto(WebDriver driver){
        PhotoGallery pg = new PhotoGallery();
        clickOnAddPhotoGallery(driver);
//        sendAndSavePhoto(driver, "C:/Users/Sofija/Desktop/bunny.jpg");
        pg.setTitle(sendTextOnTitleField(driver));
        pg.setDescription(sendTextOnDescriptionField(driver));
        sendPhoto(driver, "/Users/qa/Desktop/bunny.jpg");
        clickOnSave(driver);
        backToPhoto(driver);
        pg.setId(getIdFromLastRow(driver, "data-photo-gallery-id"));
        
        return pg;
    }
    
    public void chooseEditFromLastRow(WebDriver driver){
        chooseOptionFromLastRow(driver, By.className("glyphicon-pencil"));
    }
    

    public PhotoGallery editPhotoGallery(WebDriver driver){
        PhotoGallery pg = new PhotoGallery();
        pg.setId(getIdFromWeb(driver));
        chooseEditFromLastRow(driver);
        String title = sendTextOnTitleField(driver);
        pg.setTitle(title);
        pg.setDescription(title);
        sendPhoto(driver, "/Users/qa/Desktop/rabbit.jpg");
        clickOnSave(driver);
        return pg;
    
        
        
    }
    
    public PhotoGallery deletePhoto(WebDriver driver){
        PhotoGallery pg = new PhotoGallery();
        pg.setId(getIdFromWeb(driver));
        chooseOptionFromLastRow(driver, By.className("glyphicon-trash"));
        clickOnElement(driver, By.className("btn-danger"));
        return pg;
    }
    

    
     public int getIdFromWeb(WebDriver driver){
         return getIdFromLastRow(driver, "data-photo-gallery-id");
     }
    
    
    
   
    
    
}
    

    

