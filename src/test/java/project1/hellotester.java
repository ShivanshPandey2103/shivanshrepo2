package project1;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hellotester {
	
    public static String browser = "chrome";
    public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		if(browser.equals("Firefox")) 
		{
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	    }
		//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("hello");
		//driver.close();
	    //simple alert
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]")).click();
		Alert simpleAlert = driver.switchTo().alert();
		System.out.print(simpleAlert.getText());
		simpleAlert.accept();
		Thread.sleep(4000);
		//driver.close();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
	    driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[3]/div[2]/span/a/u")).click();
		driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/input[2]")).click();
		Alert SimpleAlert = driver.switchTo().alert();
		System.out.print(SimpleAlert.getText());
		simpleAlert.accept();
		Thread.sleep(2000);
		//driver.close();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		String parent=driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/div/div[3]/a[2]")).click();
		Set<String> windows=driver.getWindowHandles();
		
		for(String child:windows ) {
	    	 if(!parent.equalsIgnoreCase(child)) {
	    				driver.switchTo().window(child);
	    				Thread.sleep(4000);
	    				System.out.print("Verifying the Privacy police New tab Page Title: ");
	    				System.out.println(driver.getTitle());
	    				
	    		 driver.close();
	    	 }
	    }
		
		 Thread.sleep(4000);
		 driver.quit();
		
		
		
		
		
		
		
		//driver.get("https:/www.saucedemo.com/");
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		//driver.close();
   }
}