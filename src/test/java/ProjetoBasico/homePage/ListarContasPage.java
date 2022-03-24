package ProjetoBasico.homePage;

import ProjetoBasico.bases.BasePage;
import org.openqa.selenium.By;

public class ListarContasPage extends BasePage {

    public void editarConta(){
        dsl.clicarBotãoBy(By.xpath("//*[@id='tabelaContas']//span[@class='glyphicon glyphicon-edit']"));
    }
    public void preencherNome(String nome) {
        dsl.escrever("nome", nome);
    }
    public void salvarNome(){
        dsl.clicarBotãoBy(By.xpath("//button[@type='submit']"));
    }
}
