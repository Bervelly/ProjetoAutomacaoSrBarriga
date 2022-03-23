package ProjetoBasico.SenhorBarrigaProjeto;

import ProjetoBasico.bases.BasePage;
import ProjetoBasico.homePage.ContasPage;
import org.junit.Test;


public class BarrigaTestes extends BasePage {


    @Test
    public void inserirConta(){
        ContasPage contas = new ContasPage();
        contas.criarConta();
        contas.adicionarConta();
        contas.preencherConta();
    }
}




