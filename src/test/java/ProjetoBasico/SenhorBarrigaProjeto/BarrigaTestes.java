package ProjetoBasico.SenhorBarrigaProjeto;

import ProjetoBasico.bases.BasePage;
import ProjetoBasico.homePage.ContasPage;
import ProjetoBasico.homePage.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class BarrigaTestes extends BasePage {
    MenuPage menu = new MenuPage();
    ContasPage contas = new ContasPage();

    @Test
    public void inserirConta(){
        menu.criarConta();
        contas.preencherNome("Laura Almeida");
        contas.salvarNome();
        Assert.assertEquals("Conta adicionada com sucesso!",
                dsl.obterTexto(By.xpath("//div[@class='alert alert-success']")));
    }
}




