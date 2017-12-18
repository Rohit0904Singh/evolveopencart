package Evolve;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
		WebDriver driver2 = new ChromeDriver();
		driver2.manage().window().maximize();
		
		driver2.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		driver2.findElement(By.id("identifierId")).sendKeys("sanjeevan.dignitas");
		String a="8882025060";
		driver2.findElement(By.xpath("//*[@class='CwaK9']/span")).click();
		Thread.sleep(5000);
		driver2.findElement(By.xpath("//*[@class='Xb9hP']/input")).sendKeys(a);
		driver2.findElement(By.xpath("//*[@class='CwaK9']")).click();
		Thread.sleep(3000);
		driver2.navigate().refresh();
		Thread.sleep(3000);

		for(int i=1;i<10;i++)
		{
		WebElement b=driver2.findElement(By.xpath("//*[@id=':34']/tbody/tr["+i+"]/td[4]/div[2]/span"));
		String b1=b.getText();
		System.out.println(b1);
		if(b1.equals("Evolve Snacks"))
		{
			WebElement d=driver2.findElement(By.xpath("//*[@id=':34']/tbody/tr["+i+"]/td[6]/div/div/div/span"));
			String d1=d.getText();
			System.out.println(d1);
			
		if(d1.equals("Reset Your Account Password"))
			{
				driver2.findElement(By.xpath("//*[@id=':34']/tbody/tr["+i+"]/td[6]")).click();
				Thread.sleep(5000);
				driver2.findElement(By.xpath("//*[@class='gs']/div[7]/div/table/tbody/tr/td/table/tbody/tr/td")).click();
			
			
				
			}
		}
		break;
		}
		
		Set<String> ids = driver2.getWindowHandles();
		System.out.println(ids.size());
		Iterator it=ids.iterator();
		 
		String parentid=(String) it.next();
		String popup=(String) it.next();
		
		driver2.switchTo().window(popup);
		Thread.sleep(5000);
		driver2.findElement(By.name("password")).sendKeys("123456");
		Thread.sleep(3000);
		driver2.findElement(By.name("confirm")).sendKeys("123456");
		Thread.sleep(5000);
		driver2.findElement(By.xpath("//*[@class='pull-right']/button")).click();
		Thread.sleep(5000);


		//driver2.manage().window().maximize();
	//	driver2.findElement(By.xpath("//*[@id='pro-modal']/div/div/div/button")).click();
		driver2.switchTo().window(parentid);
		
	}

}
