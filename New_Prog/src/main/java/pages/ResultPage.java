package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import base.Base;

public class ResultPage extends Base {
	// By heading=By.xpath("//span[@class='_10Ermr']/span");
	By heading = By.cssSelector("._10Ermr span");
	By lowtohigh = By.xpath("//div[text()='Price -- Low to High']");
    By prices=By.xpath("//div[@class='_30jeq3 _1_WHN1']");
    By product=By.cssSelector("._4rR01T");
    
	public String gettitle() {
		String title = driver.getTitle();
		return title;

	}

	public String getheading() {
		String str = driver.findElement(heading).getText();
		return str;

	}

	public void clicklowtohigh() {
		driver.findElement(lowtohigh).click();
		try { Thread.sleep(2000);
			
		}
		catch(Exception e) {
			
		}
	}
	public List<Integer>  getprices(){
	List<Integer>actprices=driver.findElements(prices).stream().map(w->Integer.parseInt(w.getText().substring(1).replace(",", ""))).collect(Collectors.toList());
	return actprices;
		
	}
	public String[] clickoneproduct(int index) {
		String first[]=new String[2];
		first[0]= driver.findElements(product).get(index).getText();
		first[1]= driver.findElements(product).get(index).getText();		
 	    driver.findElements(product).get(index).click();
 	return first;	
	}

	
	  
	
	
	
	
	/*
	 * another method public String getheading() { String str
	 * =driver.findElement(heading).getText(); String arr[]= str.split("for");
	 * return arr[1];
	 */

}
