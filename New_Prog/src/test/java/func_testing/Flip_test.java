package func_testing;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ResultPage;

public class Flip_test {

	
	  public void commonCode(String browser) { 
	  HomePage hp = new HomePage();
	   ResultPage rp = new ResultPage(); 
	   hp.setup(browser);
	   hp.openURL("https://www.flipkart.com/"); 
	   hp.error(); 
	   hp.search("mobiles");
	   String title = rp.gettitle().toLowerCase(); 
	   String str =rp.getheading().toLowerCase(); 
	   System.out.println(title + " " + str);
	   
	   if (title.contains("mobiles") && str.matches("mobiles"))
	   
	   System.out.println("the title and heading are as expected"); 
	   else
	   System.out.println("not expected");
	   
	   }
	   
	   
	   @Test
	   public void mouni() { 
	   commonCode("firefox");
	   commonCode("chrome");
	   }
	 
	
	
	//@Test
	public void commonCode() {
		ResultPage rp = new ResultPage();
		HomePage hp = new HomePage();

        hp.openURL("https://www.flipkart.com/");
		hp.error();
		hp.search("mobiles");
		String title = rp.gettitle().toLowerCase();
		String str = rp.getheading().toLowerCase();
		System.out.println(title + " " + str);

		if (title.contains("mobiles") && str.matches("mobiles"))

			System.out.println("the title and heading are as expected");
		else
			System.out.println("not expected");

	}
	
	//@Test
	public void verifypricesaresorted() {
		HomePage hp = new HomePage();
		ResultPage rp = new ResultPage();
	    hp.openURL("https://www.flipkart.com/");
		hp.error();
		hp.search("mobiles");
		rp.clicklowtohigh();
		List<Integer> actprices = rp.getprices();

		List<Integer> expprices = rp.getprices().stream().sorted().collect(Collectors.toList());
		System.out.println(actprices);
		System.out.println(expprices);
		if (actprices.equals(expprices)) 
			System.out.println("all the prices are in sorted order");
		else 
			System.out.println("prices are not sorted");
		

	}

	
	 public void verifypricesaresorted(String browser) {
		HomePage hp = new HomePage();
		ResultPage rp = new ResultPage();
		hp.setup(browser);
		hp.openURL("https://www.flipkart.com/");
		hp.error();
		hp.search("mobiles");
		rp.clicklowtohigh();
		List<Integer> actprices = rp.getprices();

		List<Integer> expprices = rp.getprices().stream().sorted().collect(Collectors.toList());
		System.out.println(actprices);
		System.out.println(expprices);
		if (actprices.equals(expprices)) 
			System.out.println("all the prices are in sorted order");
		else 
			System.out.println("prices are not sorted");
		

	}
	@Test
	public void kavya() {
		verifypricesaresorted("firefox");
		verifypricesaresorted("chrome");

	} 

}