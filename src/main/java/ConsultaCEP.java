import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ConsultaCEP {
    private  WebDriver navegador;

    @Before
    public void inicializa(){
        System.setProperty("webdriver.chrome.driver", "c:\\temp\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.get("http://www.buscacep.correios.com.br/sistemas/buscacep/buscaCepEndereco.cfm");
    }
    @After
    public void finalizar(){
        navegador.quit();
    }

    @Test
    public void testValidarConsultaDeLogradouro() {
        navegador.findElement(By.name("relaxation")).click();
        navegador.findElement(By.name("relaxation")).sendKeys("06445500");
        navegador.findElement(By.cssSelector(".btn2")).click();
        String logradouro = navegador.findElement(By.cssSelector("td:nth-child(1)")).getText();
        Assert.assertEquals("Avenida Francisco Lourenço da Costa ", logradouro );
        String bairro = navegador.findElement(By.cssSelector("td:nth-child(2)")).getText();
        Assert.assertEquals("Vila do Conde ", bairro );
        String localidadeUF = navegador.findElement(By.cssSelector("td:nth-child(3)")).getText();
        Assert.assertEquals("Barueri/SP ", localidadeUF );
        String CEP = navegador.findElement(By.cssSelector("td:nth-child(4)")).getText();
        Assert.assertEquals("06445-500", CEP );
        System.out.println(logradouro);
        System.out.println(bairro);
        System.out.println(localidadeUF);
        System.out.println(CEP);

  }
}
