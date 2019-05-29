package ant.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ClassThird 
{
	@Test
	  public void m3() throws InterruptedException
	  {
		
	  
	  WebDriver driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.navigate().to("http://tumbler.com/");
		  Thread.sleep(2000);
		  driver.quit();
		  
	  }
}
