/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.indexSlider;

import page.basic.Page;
import domen.IndexSlider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Sofija
 */
public class IndexSliderPage extends Page {

    private void clickOnAddIndexSlider(WebDriver driver) {
        clickOnElement(driver, By.className("glyphicon-plus"));
    }

    private String sendTextOnTitleField(WebDriver driver) {
        return sendTextOnField(driver, By.id("title"));
    }

    private String sendTextOnDescriptionField(WebDriver driver) {
        return sendTextOnField(driver, By.id("description"));
    }

    private int chooseLinkOption(WebDriver driver, int i) {
        return chooseLinkType(driver, By.id("link_type"), i);
    }

    private String sendUrlOnExternalField(WebDriver driver) {
        return sendUrlOnUrlField(driver, By.id("external_link_url"));
    }
    
    private String sendUrlOnInternalField(WebDriver driver) {
        return sendUrlOnUrlField(driver, By.id("internal_link_url"));
    }
    
    private String textOnLinkLabel(WebDriver driver) {
        return sendTextOnField(driver, By.id("link_label"));
    }

    private void sendUrlOnUrlField(WebDriver driver) {
        sendUrlOnField(driver, By.id("internal_link_url"));
    }

    private void sendPic(WebDriver driver, String photoLocation) {
        sendTextOnField(driver, By.id("index_slide_photo"), photoLocation);

    }

    public void clickOnSave(WebDriver driver) {
        clickOnElement(driver, By.id("new_indexSlide_submit"));
    }

    public IndexSlider addIndexSlider(WebDriver driver) {
        IndexSlider is = new IndexSlider();
        clickOnAddIndexSlider(driver);
        is.setTitle(sendTextOnTitleField(driver));
        is.setDescription(sendTextOnDescriptionField(driver));
        is.setLinkType(chooseLinkOption(driver, 2));
        is.setLinkLabel(textOnLinkLabel(driver));
        is.setUrl(sendUrlOnInternalField(driver));
        sendPic(driver, "C:/Users/Sofija/Desktop/bunny.jpg");
        clickOnSave(driver);
        is.setId(getIdFromLastRow(driver, "data-index-slide-id"));
        return is;
    }

    public void chooseEditFromLastRow(WebDriver driver) {
        chooseOptionFromLastRow(driver, By.className("glyphicon-pencil"));
    }

    public IndexSlider editIndexSlider(WebDriver driver) {
        IndexSlider is = new IndexSlider();
        is.setId(getIdFromWeb(driver));
        chooseEditFromLastRow(driver);

        is.setTitle(sendTextOnTitleField(driver));
        is.setDescription(sendTextOnDescriptionField(driver));
        is.setLinkType(chooseLinkOption(driver, 3));
        is.setLinkLabel(sendTextOnTitleField(driver));
        is.setUrl(sendUrlOnExternalField(driver));
        sendPic(driver, "C:/Users/Sofija/Desktop/rabbit.jpg");
        clickOnSave(driver);
        return is;

    }

    public IndexSlider deleteIndexSlider(WebDriver driver) {
        IndexSlider is = new IndexSlider();
        is.setId(getIdFromWeb(driver));
        chooseOptionFromLastRow(driver, By.className("glyphicon-trash"));
        clickOnElement(driver, By.className("btn-danger"));
        return is;
    }

    public int getIdFromWeb(WebDriver driver) {
        return getIdFromLastRow(driver, "data-index-slide-id");
    }
}
