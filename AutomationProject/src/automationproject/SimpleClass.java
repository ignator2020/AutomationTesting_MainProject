package automationproject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class SimpleClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Web Driver\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://mybageecha.com/");
		driver.manage().window().maximize();
		
		//Fetching title 
		String title = driver.getTitle();
		System.out.println(title); 
		
		//Fetching url
		String url = driver.getCurrentUrl();
		System.out.println(url);   
		
		//Searching for an item
		driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16564157350079__header\"]/section/header/div/div/div[1]/form/div[1]/div/div/input")).sendKeys("Peace lily");
		driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16564157350079__header\"]/section/header/div/div/div[1]/form/div[1]/div/button")).click();
		
		//Finding the item and adding to cart
		driver.findElement(By.xpath("//*[@id=\"shopify-section-template--16564160266431__main\"]/section/div[1]/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"product_form_template--16564160168127__main9077793027\"]/div[5]/div/button")).click();
		
		//Screenshot of the Add to cart page
		Thread.sleep(5000);
		driver.get("https://mybageecha.com/cart");
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\vilsy\\Dropbox\\My PC (DESKTOP-E28ART4)\\Documents\\Software Testing - Techmindz\\Automation Testing\\Screenshots\\Addtocart.jpg"));
	}

}
