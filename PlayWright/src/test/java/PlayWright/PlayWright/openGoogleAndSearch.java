package PlayWright.PlayWright;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

public class openGoogleAndSearch {
	Playwright playwright;
	BrowserType chromium ;
	Browser browser;
	Page page;
	
	
	@BeforeTest
	public void setUp() {
		
		playwright = Playwright.create();
		chromium = playwright.chromium();
		browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		page.navigate("http://www.google.com");	     

	}
	
	@Test
	public void search() {
		page.waitForLoadState(LoadState.NETWORKIDLE);
		//page.locator("xpath=//textarea[@aria-label=\"Search\"]").fill("Disney World Orlando");
		
		Locator google_textarea= page.locator("xpath=//textarea[@aria-label=\"Search\"]");
		google_textarea.fill("Disney World Orlando");
		page.keyboard().press("Enter");
		page.waitForLoadState(LoadState.NETWORKIDLE);	
		//page.getByText("All").click();
		//page.waitForLoadState(LoadState.NETWORKIDLE);
		
	}
	
	@AfterTest
	public void tearDown() {
		browser.close();
	}
}
