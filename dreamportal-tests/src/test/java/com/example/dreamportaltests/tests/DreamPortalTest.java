package com.example.dreamportaltests.tests;

import com.example.dreamportaltests.pages.DiaryPage;
import com.example.dreamportaltests.pages.HomePage;
import com.example.dreamportaltests.pages.SummaryPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DreamPortalTest {
	WebDriver driver;
	HomePage homePage;
	DiaryPage diaryPage;
	SummaryPage summaryPage;
	String originalWindowHandle;
	WebDriverWait wait;

	@BeforeAll
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://arjitnigam.github.io/myDreams/");
		homePage = new HomePage(driver);
		originalWindowHandle = driver.getWindowHandle();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void testHomePageLoading() {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(homePage.getLoadingAnimation()));
		assertTrue(homePage.isMainContentVisible(), "Main content not visible!");
		assertTrue(homePage.isMyDreamsBtnVisible(), "'My Dreams' button not visible!");
	}

	@Test
	public void testMyDreamsButtonOpensTabs() {

		closeAllTabsExceptOriginal();

		wait.until(ExpectedConditions.elementToBeClickable(homePage.getMyDreamsButton()));
		homePage.clickMyDreams();
		wait.until(d -> driver.getWindowHandles().size() == 3);


		switchToTabWithUrlContains("dreams-diary.html");
		assertTrue(driver.getCurrentUrl().contains("dreams-diary.html"), "Diary page not opened!");


		switchToTabWithUrlContains("dreams-total.html");
		assertTrue(driver.getCurrentUrl().contains("dreams-total.html"), "Summary page not opened!");

		driver.switchTo().window(originalWindowHandle);
	}

	@Test
	public void testDiaryPageEntries() {

		closeAllTabsExceptOriginal();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.getMyDreamsButton()));
		homePage.clickMyDreams();
		wait.until(d -> driver.getWindowHandles().size() == 3);


		switchToTabWithUrlContains("dreams-diary.html");
		diaryPage = new DiaryPage(driver);


		assertEquals(10, diaryPage.getDreamCount(), "There should be exactly 10 dream entries!");


		assertTrue(diaryPage.areDreamTypesValid(), "Dream types must be 'Good' or 'Bad'!");


		assertTrue(diaryPage.areAllColumnsFilled(), "All columns must be filled!");

		driver.switchTo().window(originalWindowHandle);
	}

	@Test
	public void testSummaryPageStats() {

		closeAllTabsExceptOriginal();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.getMyDreamsButton()));
		homePage.clickMyDreams();
		wait.until(d -> driver.getWindowHandles().size() == 3);


		switchToTabWithUrlContains("dreams-total.html");
		summaryPage = new SummaryPage(driver);

		assertEquals(6, summaryPage.getGoodDreamsCount(), "Good Dreams count mismatch!");
		assertEquals(4, summaryPage.getBadDreamsCount(), "Bad Dreams count mismatch!");



		driver.switchTo().window(originalWindowHandle);
	}


	@AfterAll
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}


	private void closeAllTabsExceptOriginal() {
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalWindowHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(originalWindowHandle);
	}


	private void switchToTabWithUrlContains(String urlFragment) {
		WebDriverWait tabWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		tabWait.until(d -> {
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
				if (driver.getCurrentUrl().contains(urlFragment)) {
					return true;
				}
			}
			return false;
		});
	}
}
