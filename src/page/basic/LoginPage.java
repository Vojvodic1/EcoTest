/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.basic;

import page.basic.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Sofija
 */
public class LoginPage extends Page {
    
    public HomePage logIn(WebDriver driver, String url, String userName, String password){ 
        driver.get(url);
        
        sendTextOnField(driver, By.name("username"), userName);
        sendTextOnField(driver, By.name("password"), password);
        clickOnElement(driver, By.className("btn-success"));
        
        HomePage hp = new HomePage();
        return hp;
        
    }
    
}
