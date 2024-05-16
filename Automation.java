import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.flipkart.com/");
		
		
		Thread.sleep(3000);
		String s = driver.getCurrentUrl();
		System.out.println(s);
		
		

		driver.findElement(By.name("q")).sendKeys("Home Appliances");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		List<WebElement> product = driver.findElements(By.className("wjcEIp"));
		for (int i = 0; i < 1; i++) {
			product.get(i).click();
		}

		//driver.getWindowHandles();
		String oldTab = driver.getWindowHandle();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		tabs.remove(oldTab);

		driver.switchTo().window(tabs.get(0));
		
		


		WebElement addToCart = driver
				.findElement(By.cssSelector("button[class='QqFHMw vslbG+ In9uk2']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
		addToCart.click();

		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.cssSelector("div[class=\"_1Y9Lgu\"]")).getText());

		driver.close();

		driver.switchTo().window(oldTab);

		
		Thread.sleep(5000);

		for (int i = 4; i < 5; i++) {
			product.get(i).click();
		}
	
		tabs = new ArrayList<String>(driver.getWindowHandles());
		tabs.remove(oldTab);

		driver.switchTo().window(tabs.get(0));


		
		WebElement addToCart2 = driver
				.findElement(By.cssSelector("button[class='QqFHMw vslbG+ In9uk2']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart2);
		addToCart2.click();

		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.cssSelector("div[class=\"_1Y9Lgu\"]")).getText());
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(oldTab);
		driver.navigate().back();
		driver.quit();
	}

}


