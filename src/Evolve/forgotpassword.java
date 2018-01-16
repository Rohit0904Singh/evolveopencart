package Evolve;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class forgotpassword {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
			WebDriver driver,driver2;
			
		
			
			driver = new ChromeDriver();
			    driver.manage().window().maximize();
			
			    String email= "sanjeevan.dignitas@gmail.com";
			    String password= "123456";
			    
			  //open evolve snacks
				driver.get("https://evolvesnacks.com/");
				
				//Go to login screen
				WebElement login=driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/a/span/span/i"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click()", login);
				Thread.sleep(2000);		
				
				//Go to forgot password
				WebElement forgot=driver.findElement(By.xpath("//*[@id='System_aaSXCFZb']/div/div[2]/div/form/div/div[1]/a"));
				JavascriptExecutor executor2 = (JavascriptExecutor)driver;
				executor2.executeScript("arguments[0].click()", forgot);
				Thread.sleep(3000);
				
				//Enter email
				driver.findElement(By.id("input-email")).sendKeys(email);
				System.out.println("\nentered email");

				//click continue button
				WebElement cont = driver.findElement(By.xpath("//*[@id='System_aaSXCFZb']/form/div/div[2]/input"));
				JavascriptExecutor executor3 = (JavascriptExecutor)driver;
				executor3.executeScript("arguments[0].click()", cont);
				Thread.sleep(60000);
				WebElement message= driver.findElement(By.xpath("//*[@id='System_aaSXCFZb']/div[1]"));
				String message1=message.getText();
				System.out.println("message :- "+message1);
				
				
			     driver2 = new ChromeDriver();

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
					Thread.sleep(10000);

					for(int i=1;i<10;i++)
					{
					WebElement b=driver2.findElement(By.xpath("//*[@id=':34']/tbody/tr["+i+"]/td[4]/div[2]/span"));
					String b1=b.getText();
					System.out.println("From:- "+b1);
					 if(b1.equals("Evolve Snacks"))
					{
						WebElement d=driver2.findElement(By.xpath("//*[@id=':34']/tbody/tr["+i+"]/td[6]/div/div/div/span"));
						String d1=d.getText();
						System.out.println("Email subject:-" +d1);
						
					if(d1.equals("Reset Your Account Password"))
						{
							driver2.findElement(By.xpath("//*[@id=':34']/tbody/tr["+i+"]/td[6]")).click();
							Thread.sleep(5000);
							driver2.findElement(By.xpath("//*[@class='gs']/div[7]/div/table/tbody/tr/td/table/tbody/tr/td")).click();
							
							
						
					
					
					
					Set<String> ids = driver2.getWindowHandles();
					Iterator<String> it=ids.iterator();
					 
					String parentid=(String) it.next();
					String popup=(String) it.next();
					
					driver2.switchTo().window(popup);
					Thread.sleep(5000);
					driver2.findElement(By.name("password")).sendKeys(password);
					Thread.sleep(3000);
					driver2.findElement(By.name("confirm")).sendKeys(password);
					Thread.sleep(5000);
					WebElement submit=driver2.findElement(By.xpath("//*[@class='pull-right']/button"));
					JavascriptExecutor submit1 = (JavascriptExecutor)driver2;
					submit1.executeScript("arguments[0].click()", submit);
					Thread.sleep(5000);
					System.out.println("password changed successfuly");

					break;
					}
					}
					}
					
					driver2.quit();
					
					//Enter email and password
					driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys(email);
					driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(password);
					
					//click on login button
					WebElement login1=driver.findElement(By.xpath("//*[@class='buttons']/div[2]/input"));
					JavascriptExecutor loginex = (JavascriptExecutor)driver;
					loginex.executeScript("arguments[0].click()", login1);
					Thread.sleep(3000);
					System.out.println("login successful");
					
					//Click on BuySnacks 
					WebElement buysnacks=driver.findElement(By.xpath("//*[@id='menu_category_Menu_VIfWm2LT_461']/a/span/span"));
					JavascriptExecutor buysnacks1 = (JavascriptExecutor)driver;
					buysnacks1.executeScript("arguments[0].click()", buysnacks);
					Thread.sleep(2000);
					
					//hover my account
					WebElement myaccount = driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/a"));
					Actions action = new Actions(driver);
					action.moveToElement(myaccount).build().perform();

					WebDriverWait wait = new WebDriverWait(driver, 5); 
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/ul/li[5]/a/span")));  // until this submenu is found

					//identify logout
					WebElement logout = driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/ul/li[5]/a/span"));
					JavascriptExecutor logout1 = (JavascriptExecutor)driver;
					logout1.executeScript("arguments[0].click()", logout);
					Thread.sleep(2000);
					System.out.println("logout successful");

					
					driver.quit();

		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
