package ProjetoBasico.bases;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;

public class BasePage {
    protected DSL dsl;

    public BasePage() {
        dsl = new DSL();
    }

    @Before
    public void fazerLogin() {
        DriverFactory.getDriver().navigate().to("https://seubarriga.wcaquino.me/login");
        dsl.escrever("email", "bervelly@gmail");
        dsl.escrever("senha","1234");
        dsl.clicarBotãoBy(By.xpath("//button[@type='submit']"));
        Assert.assertEquals("Bem vindo, bervelly!",
                dsl.obterTexto(By.xpath("//*[@role='alert']")));
    }

    @After
    public void finaliza(){
        DriverFactory.KillDriver();
    }

}