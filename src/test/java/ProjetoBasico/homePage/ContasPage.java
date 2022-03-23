package ProjetoBasico.homePage;

import ProjetoBasico.bases.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void criarConta() {
        dsl.clicarBotaoBy(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
    }
    public void adicionarConta() {
        dsl.clicarBotaoBy(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[1]/a"));
    }
    public void preencherConta(){
    dsl.escrever("nome", "Bervelly Nobrega");
    }
}
