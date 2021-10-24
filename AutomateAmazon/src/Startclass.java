import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Startclass {
	
	public static void main(String[] args) throws SQLException, InterruptedException {
		//fetch values from DB
		
		DBConnections dbc=new DBConnections();
		dbc.FetchfromDB();
		String category=dbc.category;
		String Brand=dbc.brand;
		String productname=dbc.Product;
		String CangetTomorrow=dbc.CanGetitTomorrow;
		
		
		//Open the browser and launch url
		ChromeDriver  driver=new  ChromeDriver();
		driver.manage().window().maximize();
		String url="https://www.amazon.in/";
	    driver.get(url);
	    WebDriverWait wait1=new WebDriverWait(driver,20);
	//sELECT A SAMSUNG SMART PHONE FROM ELECTRONIC  CATEGORY 
	if(category.contains("Electronics") && Brand.contains("SAMSUNG") && CangetTomorrow.contains("yes") ) 
	   {
	    	
         WebElement searchdropdownbox=driver.findElement(By.id("searchDropdownBox"));
	     Select select=new Select(searchdropdownbox);
	     select.selectByVisibleText("Electronics");
	     WebElement searchbutton= driver.findElement(By.id("nav-search-submit-button"));
	     searchbutton.click();
	     System.out.println("button clicked");
	     WebElement mobileacc=driver.findElementByXPath("//*[@id=\"nav-subnav\"]/a[2]/span[1]");
	     wait1.until(ExpectedConditions.elementToBeClickable(mobileacc));
	     mobileacc.click();
         System.out.println("mobile and accessories selected");
         WebElement brand=driver.findElementByXPath("//*[@id=\"s-refinements\"]/div[5]/ul/li[1]/span/a/div/label/i");
         wait1.until(ExpectedConditions.elementToBeClickable(brand));
         brand.click();
         System.out.println("brand selected");
	     WebElement Deliveryday =driver.findElementByXPath("//*[@id=\"p_90/6741118031\"]/span/a/div/label/i");
	     wait1.until(ExpectedConditions.elementToBeClickable(Deliveryday));
         Deliveryday.click();
         System.out.println("Choose delivery day selected");
	     WebElement phone=driver.findElementByXPath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[1]/h2/a/span");
	     wait1.until(ExpectedConditions.elementToBeClickable(phone));
	     phone.click();
	     System.out.println("phone selected");
	 
	//NAVIGATING TO CART WINDOW
	 Set<String> amazonwindow=driver.getWindowHandles();
	 Iterator<String> it=amazonwindow.iterator();
	 String mainwindow=it.next();
	 String cartwindow=it.next();
	 driver.switchTo().window(cartwindow);
	
	 //ADDING TO CART
	 WebElement addtocart=driver.findElementByXPath("//*[@id=\"add-to-cart-button\"]");
	 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-button\"]")));
	 addtocart.click();
	 
	 System.out.println("added to cart SUCCESSFULLY");
	
	   }
	
	 
}
	
	
	
	

	}
	
	


