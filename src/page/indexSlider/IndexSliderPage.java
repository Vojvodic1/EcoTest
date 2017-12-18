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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

//    private String chooseLinkTypeField(WebDriver driver) {
//        return chooseLinkType(driver, By.id("link_type"));
//    }
    private String sendUrlOnExternalField(WebDriver driver) {
        return sendUrlOnUrlField(driver, By.id("external_link_url"));
    }

    private String sendUrlOnInternalField(WebDriver driver) {
        return sendUrlOnUrlField(driver, By.id("internal_link_url"));
    }

    private String textOnLinkLabel(WebDriver driver) {
        return sendTextOnField(driver, By.id("link_label"));
    }

    public String chooseLinkTypeField(WebDriver driver, int i) {
        WebElement linkType = driver.findElement(By.id("link_type"));
        Select chooseLinkType = new Select(linkType);
        chooseLinkType.selectByIndex(i);
        return chooseLinkType.getFirstSelectedOption().getAttribute("value");
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
        is.setLinkType(chooseLinkTypeField(driver, 2));
        is.setLinkLabel(textOnLinkLabel(driver));
        is.setUrl(sendUrlOnInternalField(driver));
        sendPic(driver, "/Users/qa/Desktop/bunny.jpg");
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
        is.setLinkType(chooseLinkTypeField(driver, 3));
        is.setLinkLabel(sendTextOnTitleField(driver));
        is.setUrl(sendUrlOnExternalField(driver));
        sendPic(driver, "/Users/qa/Desktop/rabbit.jpg");
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
