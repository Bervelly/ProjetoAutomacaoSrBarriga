package ProjetoBasico.SenhorBarrigaProjeto;

import ProjetoBasico.bases.BasePage;
import ProjetoBasico.homePage.ContasPage;
import ProjetoBasico.homePage.ListarContasPage;
import ProjetoBasico.homePage.MenuPage;
import ProjetoBasico.homePage.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.Arrays;
import java.util.List;


public class BarrigaTestes extends BasePage {
    MenuPage menu = new MenuPage();
    ContasPage contas = new ContasPage();
    ListarContasPage listas = new ListarContasPage();
    MovimentacaoPage movimentacao = new MovimentacaoPage();

    @Test
    public void inserirConta(){
        menu.criarConta();
        contas.preencherNome("Laura Almeida");
        contas.salvarNome();
        Assert.assertEquals("Conta adicionada com sucesso!",
                dsl.obterTexto(By.xpath("//div[@class='alert alert-success']")));
    }
    @Test
    public void alterarConta(){
        menu.listaContas();
        listas.editarConta();
        listas.preencherNome("Maria A");
        listas.salvarNome();
        Assert.assertEquals("Conta alterada com sucesso!",
                dsl.obterTexto(By.xpath("//div[@class='alert alert-success']")));;
    }
    @Test
    public void inserirContaExistente(){
        menu.criarConta();
        contas.preencherNome("Bervelly Oliveira");
        contas.salvarNome();
        Assert.assertEquals("Já existe uma conta com esse nome!",
                dsl.obterTexto(By.xpath("//div[@class='alert alert-danger']")));
    }
    @Test
    public void criarMovimentacao(){
        menu.criarMovimentacao();
        movimentacao.tipoMovimentacaoReceita();
        movimentacao.setDataMovimentacao("24/03/2022");
        movimentacao.setDataPagamento("30/03/2022");
        movimentacao.setDescricao("Casa");
        movimentacao.setInteressado("Helena");
        movimentacao.setValor("1500");
        movimentacao.setConta("Bervelly Nobrega");
        movimentacao.contaPaga();
        movimentacao.salvarMovimentacao();
        Assert.assertEquals("Movimentação adicionada com sucesso!",
                dsl.obterTexto(By.xpath("//*[@class='alert alert-success']")));
    }
    @Test
    public void testarCamposObrigatorios(){
        menu.criarMovimentacao();
        movimentacao.salvarMovimentacao();
        List<String> erros = movimentacao.obterErros();
        //Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
        //Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
        Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório", "Descrição é obrigatório",
                "Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }
    @Test
    public void testarMovimentacaoFutura(){
        menu.criarMovimentacao();
        movimentacao.tipoMovimentacaoReceita();
        movimentacao.setDataMovimentacao("25/03/2022");
        movimentacao.setDataPagamento("30/03/2022");
        movimentacao.setDescricao("Casa");
        movimentacao.setInteressado("Helena");
        movimentacao.setValor("1500");
        movimentacao.setConta("Bervelly Nobrega");
        movimentacao.contaPaga();
        movimentacao.salvarMovimentacao();
        List<String> erros = movimentacao.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
        //Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", dsl.obterTexto(By.xpath("//*[@class='alert alert-danger']//li")));

    }


}




