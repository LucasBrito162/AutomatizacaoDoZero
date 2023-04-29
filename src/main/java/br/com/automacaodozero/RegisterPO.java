package br.com.automacaodozero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPO extends BasePO {

    public RegisterPO(WebDriver driver) {
        super(driver);
    }

    public void inputEmail(String emailComArroba) {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input"))
                .sendKeys(name + emailComArroba);

    }

    public void inputName() {
        driver.findElement(By.cssSelector("#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(3) > input"))
                .sendKeys(fullName);
    }
    public void inputNameFail() {
        driver.findElement(By.cssSelector("#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(3) > input"))
                .sendKeys(fullName + "@# 151");
    }

    public void registerPassword() {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input"))
                .sendKeys("R@nD0M#$");
    }

    public void registerPasswordConfirm(String confirmaSenha) {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input"))
                .sendKeys(confirmaSenha);
    }

    public void balanceButton() {
        driver.findElement(By.id("toggleAddBalance")).click();
    }

    public void iconEye() {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/button/span/img")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/button/span/img")).click();
    }

    public void registerSubmit() {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")).click();
    }

    public void backButton() {
        driver.findElement(By.id("#btnBackButton")).click();
    }

   public boolean textConfirm(String text){
     return driver.getPageSource().contains(text);


    }

    public boolean confirmEyes(){
        WebElement eyeOpen =driver.findElement(By.cssSelector("[alt='Icon Open Eye']"));
        WebElement eyeClose =driver.findElement(By.cssSelector("[alt='Icon Close Eye']"));
    
        if(eyeOpen != eyeClose){
            return true;


        }else{
            return false;
        }
    }

  

}

