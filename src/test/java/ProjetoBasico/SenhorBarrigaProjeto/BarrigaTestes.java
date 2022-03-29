package ProjetoBasico.SenhorBarrigaProjeto;

import ProjetoBasico.bases.BasePage;
import ProjetoBasico.bases.DriverFactory;
import ProjetoBasico.homePage.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;


public class BarrigaTestes extends BasePage {
    MenuPage menu = new MenuPage();
    ContasPage contas = new ContasPage();
    ListarContasPage listas = new ListarContasPage();
    MovimentacaoPage movimentacao = new MovimentacaoPage();
    ResumoMensalPage resumo = new ResumoMensalPage();


    @Test
    public void inserirConta(){
        menu.criarConta();
        contas.preencherNome("Bervelly N");
        contas.salvarNome();
        Assert.assertEquals("Conta adicionada com sucesso!",
                dsl.obterTexto(By.xpath("//div[@class='alert alert-success']")));
    }

    @Test
    public void alterarConta(){
        menu.listaContas();
        listas.editarConta("Bervelly N");
        listas.preencherNome("Maria B");
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
        movimentacao.setConta("Bervelly O");
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

    @Test
    public void removerMovimentaçao(){
        menu.verResumoMensal();
        resumo.obterMes("Março");
        resumo.obterAno("2022");
        resumo.clicarBuscar();
        resumo.exluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!",
                dsl.obterTexto(By.xpath("//*[@class='alert alert-success']")));

    }

    @Test
    public void removerContaMovimentada(){
        menu.listaContas();
        listas.excluirConta();
        Assert.assertEquals("Conta em uso na movimentações",
                dsl.obterTexto(By.xpath("//*[@class='alert alert-danger']")));
    }

    @Test
    public void verificarSaldoResumoZerado(){
        menu.verResumoMensal();
        resumo.obterMes("Março");
        resumo.obterAno("2020");
        resumo.clicarBuscar();
        List <WebElement> elementosEncontrados =
            DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        Assert.assertEquals(0, elementosEncontrados.size());
    }

}




