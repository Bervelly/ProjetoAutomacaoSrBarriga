package ProjetoBasico.homePage;

import ProjetoBasico.bases.BasePage;


public class MenuPage extends BasePage {

    public void criarConta() {
        dsl.clicarLink("Contas");
        dsl.clicarLink("Adicionar");
    }
    public void listaContas(){
        dsl.clicarLink("Contas");
        dsl.clicarLink("Listar");
    }
    public void criarMovimentacao(){
        dsl.clicarLink("Criar Movimentação");
    }
}
