package ProjetoBasico.homePage;

import ProjetoBasico.bases.BasePage;
import ProjetoBasico.bases.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MovimentacaoPage extends BasePage {

    public void tipoMovimentacaoReceita(){
        dsl.selecionarCombo("tipo", "Receita");
    }

    public void tipoMovimentaçãoDespesa(){
        dsl.selecionarCombo("tipo", "Despesa");
    }

    public void setDataMovimentacao(String data){
        dsl.escrever("data_transacao", data);
    }

    public void setDataPagamento(String dataPagamento){
        dsl.escrever("data_pagamento", dataPagamento);
    }

    public void setDescricao(String descricao){
        dsl.escrever("descricao", descricao);
    }

    public void setInteressado(String interessado){
        dsl.escrever("interessado", interessado);
    }

    public void setValor(String valor){
        dsl.escrever("valor", valor);
    }

    public void setConta(String valor){
        dsl.selecionarCombo("conta", valor);
    }

    public void contaPaga(){
        dsl.clicarBotão("status_pago");
    }

    public void contaPendente() {
        dsl.clicarBotão("status_pendente");
    }

    public void salvarMovimentacao(){
        dsl.clicarBotãoBy(By.xpath("//*[@class='btn-group']"));
    }

    public List<String> obterErros(){
        List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//*[@class='alert alert-danger']//li"));
        List<String> retorno = new ArrayList<String>();
        for (WebElement erro: erros) {
            retorno.add(erro.getText());
        }
        return retorno;
    }
}
