package Evolve;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class signup {

	public static void main(String[] args) {


		try {
			

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get("http://opencart.evolvesnacks.com");
		
		FileInputStream ExcelFile = new FileInputStream("E:/signup data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFile); 
		XSSFSheet sheet = wb.getSheet("Sheet1");
			
		
		for(int i=17;i<19;i++)
		{
			//Go to login screen
			WebElement login=driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/a/span/span/i"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", login);
			Thread.sleep(2000);	
			
			
			String uuid1 = RandomStringUtils.random(16, "0123456789abcdef"); 
			
			// long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
			XSSFRow row = sheet.getRow(i);
		    String firstname = row.getCell(0).getStringCellValue();
		    String lastname = row.getCell(1).getStringCellValue();
		    String email = row.getCell(2).getStringCellValue();
		    int telephone = (int) row.getCell(3).getNumericCellValue();
		    String state = row.getCell(4).getStringCellValue();
		    String city = row.getCell(5).getStringCellValue();
		   int postcode = (int) row.getCell(6).getNumericCellValue();
		    String address = row.getCell(7).getStringCellValue();

		    Thread.sleep(2000);
		
			
		//Click on signup
		driver.findElement(By.xpath("//*[@id='System_HsRdKbkl']/div/div[1]/div/div[2]/div/a")).click();

		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("telephone")).sendKeys(""+telephone);
		driver.findElement(By.name("password")).sendKeys(""+uuid1);
		driver.findElement(By.name("confirm")).sendKeys(""+uuid1);
		driver.findElement(By.name("address_1")).sendKeys(address);
		driver.findElement(By.name("address_2")).sendKeys("test address");
		driver.findElement(By.xpath("//*[@id='input-custom-field1']")).sendKeys(""+telephone);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("postcode")).sendKeys(""+postcode);
		driver.findElement(By.xpath("//*[@id='input-zone']")).sendKeys(state);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='System_6OjM9zPg']/form/div[2]/div[2]/input")).click();
		
		
		Thread.sleep(5000);
		//Click on BuySnacks 
		WebElement buysnacks=driver.findElement(By.xpath("//*[@id='menu_category_Menu_VIfWm2LT_461']/a/span/span"));
		JavascriptExecutor buysnacks1 = (JavascriptExecutor)driver;
		buysnacks1.executeScript("arguments[0].click()", buysnacks);
		Thread.sleep(2000);
		
		//hover on my account
		WebElement myaccount = driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(myaccount).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/ul/li[5]/a/span")));  // until this submenu is found

		//identify logout
		WebElement logout = driver.findElement(By.xpath("//*[@id='Menu_YnwtL2RI']/nav/ul/li[1]/ul/li[5]/a/span"));
		
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click()", logout);
		Thread.sleep(2000);

		
				 XSSFCell cell=row.getCell(8);

		
			cell.setCellValue(""+uuid1);
		
			
		 FileOutputStream fileOut = new FileOutputStream(new File("E:/signup data.xlsx"));
      wb.write(fileOut);
      fileOut.flush();
      fileOut.close();
		

	}
		driver.close();

}
		catch(Exception e)
		{
			System.out.println(e);
}
}
}