package ProjetoBasico.homePage;

import ProjetoBasico.bases.BasePage;


public class MenuPage extends BasePage {

    public void criarConta() {
        dsl.clicarLink("Contas");
        dsl.clicarLink("Adicionar");
    }

}
