package ant.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClassSecond 
{
	@Test
	  public void m2() throws InterruptedException
	  {
	    
	  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.navigate().to("https://www.facebook.com/");
		  Thread.sleep(2000);
		  driver.quit();
     }
}
