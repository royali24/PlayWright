package PlayWright.PlayWright;

import static org.testng.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

public class hello_Playwright {


	Playwright play;
	Browser browser;
	Page page;

	@BeforeTest
	public void setUp() {
		play = Playwright.create();
		browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
	}

	@Test
	public void helloPlayWright() { 

		page.navigate("http://playwright.dev");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		String title = page.title();
		System.out.println("page.title(): " + title);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Homescreen.png")));
		assertEquals("Fast and reliable end-to-end testing for modern web apps | Playwright", title);
	}
	
	@AfterTest
	public void tearDown() {
		page.close();
	}
}
