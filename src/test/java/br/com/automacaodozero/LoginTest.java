package br.com.automacaodozero;

import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;

public class LoginTest extends BaseTest{
    
@Test
public void TC_012_LoginSemPreencherEmailESenha(){
    LoginPO login = new LoginPO(driver);
    login.buttonAcess();
    waiting();
    Assert.assertEquals("É campo obrigatório", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/p")).getText());
    Assert.assertEquals("É campo obrigatório", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/p")).getText());

}

@Test
public void TC_013_LoginComSenhaVazia(){
    LoginPO login = new LoginPO(driver);
    login.inputEmailLogin("lucas@lucas.com");
    login.inputPasswordLogin("");
    login.buttonAcess();
    waiting();
    Assert.assertEquals("É campo obrigatório", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/p")).getText());
    Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/p")).getText());

}

@Test
public void TC_014_LoginComSenhaInvalida(){
    LoginPO login = new LoginPO(driver);
    login.inputEmailLogin("lucas@lucas.com");
    login.inputPasswordLogin("162222");
    login.buttonAcess();
    waiting();
    Assert.assertEquals("Usuário ou senha inválido."
    + "\nTente novamente ou verifique suas informações!",driver.findElement(By.id("modalText")).getText());

}

@Test
public void TC_015_LoginComEmailVazio(){
    LoginPO login = new LoginPO(driver);
    login.inputPasswordLogin("1234");
    login.buttonAcess();
    waiting();
    Assert.assertEquals("É campo obrigatório", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/p")).getText());
    Assert.assertEquals("" ,driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/p")).getText());
}

@Test
public void TC_016_LoginComEmailInvalido(){
    LoginPO login = new LoginPO(driver);
    login.inputEmailLogin("lucas12122@gmail.com");
    login.inputPasswordLogin("1234");
    login.buttonAcess();
    waiting();
    Assert.assertEquals("Usuário ou senha inválido."
    + "\nTente novamente ou verifique suas informações!",driver.findElement(By.id("modalText")).getText());

}
@Test
public void TC_017_LoginComEmailESenhaValidas(){
    LoginPO login = new LoginPO(driver);
    RegisterPO register = new RegisterPO(driver);
    login.registerButtonLogin();
    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys("lucas@lucas.com");
    driver.findElement(By.cssSelector("input[type='name']")).sendKeys("Lucas");
    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")).sendKeys("1234");
    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input")).sendKeys("1234");
    register.registerSubmit();
    waiting();
    driver.findElement(By.id("btnCloseModal")).click();
    waiting();
    login.inputEmailLogin("lucas@lucas.com");
    login.inputPasswordLogin("1234");
    login.buttonAcess();
    waiting();
    Assert.assertEquals("bem vindo ao BugBank :)", 
    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/p[2]")).getText());
}



}
