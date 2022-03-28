package ProjetoBasico.homePage;

import ProjetoBasico.bases.BasePage;
import org.openqa.selenium.By;

public class ListarContasPage extends BasePage {

    public void editarConta(String nome){
        dsl.buscarTextoNaPag("tabelaContas").equals(nome);
        dsl.clicarBotãoBy(By.xpath("//*[@id='tabelaContas']//span[@class='glyphicon glyphicon-edit']"));
    }

    public void preencherNome(String nome) {
        dsl.escrever("nome", nome);
    }

    public void salvarNome(){
        dsl.clicarBotãoBy(By.xpath("//button[@type='submit']"));
    }

    public void excluirConta(){
        dsl.clicarBotãoBy(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
        }

}
