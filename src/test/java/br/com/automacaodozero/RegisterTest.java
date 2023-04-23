package br.com.automacaodozero;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
   
@Test
public void TC_001_CadastroUsuarioComDadosValidosComSucesso(){
    RegisterPO register = new RegisterPO(driver);
    LoginPO login = new LoginPO(driver);
    login.registerButtonLogin();
    register.inputEmail("@gmail.com");
    register.inputName();
    register.registerPassword();
    register.registerPasswordConfirm();
    register.registerSubmit();
    Assert.assertTrue(register.textConfirm("foi criada com sucesso"));
}

@Test
public void TC_002_CadastroDeUsuarioComEmailInvalido(){
    RegisterPO register = new RegisterPO(driver);
    LoginPO login = new LoginPO(driver);
    login.registerButtonLogin();
    register.inputEmail("gmail.com");
    register.inputName();
    register.registerPassword();
    register.registerPasswordConfirm();
    register.registerSubmit();
   Assert.assertEquals("Formato inválido", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/p")).getText());

}

@Test
public void TC_003_CadastroDeUsuarioComNomeInvalido(){
    RegisterPO register = new RegisterPO(driver);
    LoginPO login = new LoginPO(driver);
    login.registerButtonLogin();
    register.inputEmail("@gmail.com");
    register.inputNameFail();
    register.registerPassword();
    register.registerPasswordConfirm();
    register.registerSubmit();
    Assert.assertTrue(register.textConfirm("Formato inválido"));
}

    
}
