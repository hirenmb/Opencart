package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	Properties prop;
	public static String highlight;
	public OptionManager optionManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser");
		String browserVersion = prop.getProperty("browserVersion");
		
		optionManager = new OptionManager(prop);

		System.out.println("Browser name is : " + browserName);
				highlight = prop.getProperty("highlight");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			//			driver = new ChromeDriver(optionManager.getChromOptions());
			// when u use ThreadLocal driver u need to call set method to set driver
				if(Boolean.parseBoolean(prop.getProperty("remote"))) {
					init_remoteDriver("chrome", browserVersion);
				}
				else {
				tlDriver.set(new ChromeDriver(optionManager.getChromOptions()));
				}
		} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.chromedriver().setup();
				
				if(Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("firefox" , browserVersion);
					}
				else {
						tlDriver.set(new ChromeDriver(optionManager.getChromOptions()));
					}

		} else {
			System.out.println("Please pass right browser name : -" + browserName);
		}

		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	private void init_remoteDriver(String browser, String browserVersion) {
		System.out.println("Running test on remote grid server: " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			//selenium 3.x
			DesiredCapabilities cap = new DesiredCapabilities();
			//cap.setBrowserName("chrome");
			
			cap.setCapability("browserName", "chrome");
			cap.setCapability("browserVersion", browserVersion);
			cap.setCapability("enableVNC", true);
			cap.setCapability(ChromeOptions.CAPABILITY,optionManager.getChromOptions());
			try {
				tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
			
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}	
		else if(browser.equalsIgnoreCase("firefox")){
			DesiredCapabilities cap = new DesiredCapabilities();
		//	cap.setBrowserName("firefox");
			
			cap.setCapability("browserName", "firefox");
			cap.setCapability("browserVersion", browserVersion);
			cap.setCapability("enableVNC", true);
			cap.setCapability(ChromeOptions.CAPABILITY,optionManager.getFirefoxOptions());
			cap.setAcceptInsecureCerts(true);
			
			try {
				tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
			
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}	

		}
	

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties prop_init() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		String env  = System.getProperty("env");
		if(env == null) {
			System.out.println("Running on Production Enviorment");
			fis =new FileInputStream("./src/test/java/resources/config.properties"); 
		}else {
				System.out.println("running on Enviorment : " + env);
			switch(env.toLowerCase()) {
			case "qa":
				fis =new FileInputStream("./src/test/java/resources/qa.config.properties");
				break;
			case "dev":
				fis =new FileInputStream("./src/test/java/resources/dev.config.properties");
				break;
			
			default :
				System.out.println("Please pass correct enviorment");
			}
		}
		
		prop.load(fis);
		return prop;

	}

	/*
	 * 
	 * take screenshot
	 */
	public static String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/sreenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
