package ProjetoBasico.homePage;

import ProjetoBasico.bases.BasePage;
import ProjetoBasico.bases.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResumoMensalPage extends BasePage {

    public void exluirMovimentacao(){
        dsl.clicarBotãoBy(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
    }

    public void obterMes(String opcao){
        List<WebElement> meses = DriverFactory.getDriver().findElements(By.xpath("//*[@id='mes']//option"));
            for (WebElement mes: meses){
            if (mes.getText().equals(opcao)){
                mes.click();
                break;
            }
        }
    }

    public void obterAno(String opcao){
        List<WebElement> anos = DriverFactory.getDriver().findElements(By.xpath("//*[@id='ano']//option"));
        for (WebElement ano: anos){
            if (ano.getText().equals(opcao)){
                ano.click();
                break;
            }
        }
    }

    public void clicarBuscar(){
        dsl.clicarBotãoBy(By.xpath("//*[@value='Buscar']"));
    }
}

