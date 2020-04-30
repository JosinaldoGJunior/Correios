import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConsultaCEP {



  @Test
  public void testValidarConsultaDeCEP() {
     System.setProperty("webdriver.chrome.driver", "c:\\temp\\drivers\\chromedriver.exe");
      WebDriver navegador = new ChromeDriver();
      navegador.get("http://www.buscacep.correios.com.br/sistemas/buscacep/buscaCepEndereco.cfm");
      navegador.findElement(By.name("relaxation")).click();
      navegador.findElement(By.name("relaxation")).sendKeys("06445500");
      navegador.findElement(By.cssSelector(".btn2")).click();
      // testar commit
  }

}
