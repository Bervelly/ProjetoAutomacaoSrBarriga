package ProjetoBasico.homePage;

import ProjetoBasico.bases.BasePage;
import org.junit.Test;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void preencherNome(String nome) {
        dsl.escrever("nome", nome);
    }
    public void salvarNome(){
        dsl.clicarBotãoBy(By.xpath("//button[@type='submit']"));
    }
}
