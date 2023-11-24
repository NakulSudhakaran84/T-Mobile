package com.TMobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabletFilter {

	public static WebDriver driver;
	public static String[] allCheckBox= {"New","Special offer","Alcatel","Apple","Samsung","T-Mobile","TCL","Android","iPadOS","Other"};
	public static String[] allTabs= {"Deals","Brands","Operating System"};
	public static String[] allDeals= {"New","Special offer"};
	public static String[] allBrands= {"Alcatel","Apple","Samsung","T-Mobile","TCL"};
	public static String[] allOS= {"Android","iPadOS","Other"};

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.t-mobile.com/tablets");
		Thread.sleep(2000);
		
						//selectFilter("Deals","Special offer");
						//selectFilter("Brands","Alcatel","Samsung","TCL");
						//selectFilter("Operating System","Android","Other");
						//selectFilter("Brands","All");
						//selectFilter("Operating System","All");
						selectFilter("All");
		Thread.sleep(3000);
		driver.quit(); 
		}

		public static void selectFilter(String filterTab,String...items) throws InterruptedException {
			switch(filterTab) {
				case "Deals":
					filterTab(filterTab);
					for(String values:items) {
						switch(values) {
							case "New":
								filterSelection(values);
								break;
							case "Special offer":
								filterSelection(values);
								break;
							case "All":
								filterSelection(allDeals);
								break; 
								}
									}
				break;
				case "Brands":
					filterTab(filterTab);
					for(String values:items) {
						switch(values) {
							case "Alcatel":
								filterSelection(values);
								break;
							case "Apple":
								filterSelection(values);
								break;
							case "Samsung":
								filterSelection(values);
								break;
							case "T-Mobile":
								filterSelection(values);
								break;
							case "TCL":
								filterSelection(values);
								break;
							case "All":
								filterSelection(allBrands);
								break; 
								}
									}
				break;
				case "Operating System":filterTab(filterTab);
					for(String values:items) {
						switch(values) {
							case "Android":filterSelection(values);
							break;
							case "iPadOS":filterSelection(values);
							break;
							case "Other":filterSelection(values);
							break;
							case "All":
								filterSelection(allOS);
								break; 
								}
									}
			break;
			case "All":
				filterTab(allTabs );
				filterSelection(allCheckBox);
				break;
				}
			} 
		private static void filterTab(String... value) {
				for(String tabs:value) {
					String filterTabs="//div//mat-panel-title//legend[contains(text(),'"+tabs+"')]";
					driver.findElement(By.xpath(filterTabs)).click();
								}
							}
		private static void filterSelection(String... checkbox) {
				for(String checkboxSelection:checkbox) {
					String filterItems="//div//span[2][contains(text(),'"+checkboxSelection+"')]";
					driver.findElement(By.xpath(filterItems)).click(); 
							}
						}	
	}


