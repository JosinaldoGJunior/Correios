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
    public void testValidarConsultaDeCEP() {
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

    @Test
    public void testValidarConsultaDeLogradouro() {
        navegador.findElement(By.name("relaxation")).click();
        navegador.findElement(By.name("relaxation")).sendKeys("Josinaldo Silva");
        navegador.findElement(By.cssSelector(".btn2")).click();

        //logradoura 1
        String logradouro1 = navegador.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).getText();
        Assert.assertEquals("Rua Josinaldo Belo da Silva ", logradouro1 );
        String bairro1 = navegador.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText();
        Assert.assertEquals("Paratibe ", bairro1 );
        String localidadeUF1 = navegador.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).getText();
        Assert.assertEquals("João Pessoa/PB ", localidadeUF1 );
        String CEP1 = navegador.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(4)")).getText();
        Assert.assertEquals("58062-333", CEP1 );

        //logradoura 2
        String logradouro2 = navegador.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(1)")).getText();
        Assert.assertEquals("Rua Josinaldo Lopes da Silva ", logradouro2 );
        String bairro2 = navegador.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText();
        Assert.assertEquals("Jardins ", bairro2 );
        String localidadeUF2 = navegador.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(3)")).getText();
        Assert.assertEquals("São Gonçalo do Amarante/RN ", localidadeUF2 );
        String CEP2 = navegador.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(4)")).getText();
        Assert.assertEquals("59293-300", CEP2 );

        //logradoura 3
        String logradouro3 = navegador.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(1)")).getText();
        Assert.assertEquals("Rua Josinaldo Florêncio da Silva ", logradouro3 );
        String bairro3 = navegador.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(2)")).getText();
        Assert.assertEquals("Gramame ", bairro3 );
        String localidadeUF3 = navegador.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(3)")).getText();
        Assert.assertEquals("João Pessoa/PB ", localidadeUF3 );
        String CEP3 = navegador.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(4)")).getText();
        Assert.assertEquals("58069-472", CEP3 );

        System.out.println("-------------------------------------------------------------");
        System.out.println(logradouro1 + "     | " + bairro1 + "| " + localidadeUF1 + "            | " + CEP1 );
        System.out.println(logradouro2 + "    | " + bairro2 + " | " + localidadeUF2 + "| " + CEP2 );
        System.out.println(logradouro3 + "| " + bairro3 + " | " + localidadeUF3 + "            | " + CEP3 );
    }
}
