package br.com.automacaodozero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BasePO{

  

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public  void registerButtonLogin(){
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();
    }
    
}
