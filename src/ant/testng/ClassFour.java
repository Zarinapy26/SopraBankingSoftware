package ant.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class ClassFour
{
   @Test	
   public void m4() throws InterruptedException
   {
	WebDriver driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.navigate().to("https:gmail.com/");
	  Thread.sleep(2000);
	  driver.quit();
   }
}
