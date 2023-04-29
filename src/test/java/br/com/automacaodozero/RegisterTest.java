package br.com.automacaodozero;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    @Test
    public void TC_001_CadastroUsuarioComDadosValidosComSucesso() {
        RegisterPO register = new RegisterPO(driver);
        LoginPO login = new LoginPO(driver);
        login.registerButtonLogin();
        register.inputEmail("@gmail.com");
        register.inputName();
        register.registerPassword();
        register.registerPasswordConfirm("R@nD0M#$");
        register.registerSubmit();
        Assert.assertTrue(register.textConfirm("foi criada com sucesso"));

    }

    @Test
    public void TC_002_CadastroDeUsuarioComEmailInvalido() {
        RegisterPO register = new RegisterPO(driver);
        LoginPO login = new LoginPO(driver);
        login.registerButtonLogin();
        register.inputEmail("gmail.com");
        register.inputName();
        register.registerPassword();
        register.registerPasswordConfirm("R@nD0M#$");
        register.registerSubmit();
        Assert.assertEquals("Formato inválido",
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/p")).getText());

    }

    @Test
    public void TC_003_CadastroDeUsuarioComNomeInvalido() {
        RegisterPO register = new RegisterPO(driver);
        LoginPO login = new LoginPO(driver);
        login.registerButtonLogin();
        register.inputEmail("@gmail.com");
        register.inputNameFail();
        register.registerPassword();
        register.registerPasswordConfirm("R@nD0M#$");
        register.registerSubmit();
        Assert.assertTrue(register.textConfirm("Formato inválido"));
    }

    @Test
    public void TC_004_CadastroComNomeVazio() {
        RegisterPO register = new RegisterPO(driver);
        LoginPO login = new LoginPO(driver);
        login.registerButtonLogin();
        register.inputEmail("@gmail.com");
        register.registerPassword();
        register.registerPasswordConfirm("R@nD0M#$");
        register.registerSubmit();
        waiting();
        Assert.assertEquals("Nome não pode ser vazio.",
                driver.findElement(By.xpath("//*[@id=\"modalText\"]")).getText());

    }

    @Test
    public void TC_005_CadastroComEmailVazio() {
        RegisterPO register = new RegisterPO(driver);
        LoginPO login = new LoginPO(driver);
        login.registerButtonLogin();
        register.inputName();
        register.registerPassword();
        register.registerPasswordConfirm("R@nD0M#$");
        register.registerSubmit();
        waiting();
        Assert.assertEquals("É campo obrigatório",
                driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/p")).getText());

    }

    @Test
    public void TC_006_CadastroComSenhaVazia() {
        RegisterPO register = new RegisterPO(driver);
        LoginPO login = new LoginPO(driver);
        login.registerButtonLogin();
        register.inputEmail("@gmail.com");
        register.inputName();
        register.registerPasswordConfirm("R@nD0M#$");
        register.registerSubmit();
        waiting();
        Assert.assertEquals("É campo obrigatório",
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/p")).getText());
}

@Test
public void TC_007_CadastroComConfirmacaoDeSenhaVazia() {
    RegisterPO register = new RegisterPO(driver);
    LoginPO login = new LoginPO(driver);
    login.registerButtonLogin();
    register.inputEmail("@gmail.com");
    register.inputName();
    register.registerPassword();
    register.registerSubmit();
    waiting();
    Assert.assertEquals("É campo obrigatório",
    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/p")).getText());
}

@Test
public void TC_008_CadastroComConfirmacaoDeSenhaDiferente() {
    RegisterPO register = new RegisterPO(driver);
    LoginPO login = new LoginPO(driver);
    login.registerButtonLogin();
    register.inputEmail("@gmail.com");
    register.inputName();
    register.registerPassword();
    register.registerPasswordConfirm("diferente");
    register.registerSubmit();
    waiting();
    Assert.assertEquals("As senhas não são iguais.",
    driver.findElement(By.xpath("//*[@id=\"modalText\"]")).getText());
}

@Test
public void TC_009_CadastroComEmailExistente() {
    RegisterPO register = new RegisterPO(driver);
    LoginPO login = new LoginPO(driver);
    login.registerButtonLogin();
    register.inputEmail("@gmail.com");
    register.inputName();
    register.registerPassword();
    register.registerPasswordConfirm("R@nD0M#$");
    waiting();
    register.balanceButton();
    register.registerSubmit();
    waiting();
    Assert.assertEquals("Email ja cadastrado",
    driver.findElement(By.xpath("//*[@id=\"modalText\"]")).getText());

}

@Test
public void TC_010_VerificarOcultacaoDeSenha() {
    RegisterPO register = new RegisterPO(driver);
    LoginPO login = new LoginPO(driver);
    login.registerButtonLogin();
    register.registerPassword();
    register.registerPasswordConfirm("R@nD0M#$");
    waiting();
   register.iconEye();
    waiting();
    Assert.assertTrue(register.confirmEyes());

 
}
}



