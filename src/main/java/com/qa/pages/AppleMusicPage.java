package com.qa.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;

public class AppleMusicPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	ExcelReader excelReader;

//	public AppleMusicPage() {
//		excelReader = new ExcelReader();
//	}

	// Declare variable
	List<String> selectedAdditionalGenreList = new ArrayList<>();
	List<String> selectedMoodsList = new ArrayList<>();

	// 1. Constructor of page Class
	public AppleMusicPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		excelReader = new ExcelReader();
	}

	// 2. By Locators
	private By password = By.xpath("//input[@type='Password']");
	private By nextBtn = By.cssSelector("input#NextButton");
	private By submitBtn = By.cssSelector("input#NextButton");
	private By headerText = By.xpath("//div[contains(text(),'Keep our editorial teams up to date with your rele')]");
	private By yourNameInputBox = By.xpath("//label[normalize-space()='Your name']/../..//input");
	private By yourBusinessEmailInputBox = By.xpath("//label[normalize-space()='Your business email']/../..//input");
	private By yourCompanyInputBox = By.xpath("//label[normalize-space()='Your company']/../..//input");
	private By yourTerritoryDrpDown = By.xpath("//select[@id='QR~QID71']");
	private By yourTerritoriesToPitchToQuestions = By.cssSelector("table[role='presentation'] tr td label span");

	private By contentDetailsPageheaderText = By.xpath("//span[contains(text(),'Content Details')]");
	private By typeOfSongQuestions = By.cssSelector("div.QID18 table[role='presentation'] tr td label span");
	private By artistNameInputBox = By.xpath("//label[normalize-space()='Artist name']/../..//input");
	private By contentTitleInputBox = By.xpath("//label[normalize-space()='Content title']/../..//input");
	private By appleIdInputBox = By.xpath("//label[contains(text(),'Apple ID')]/../..//input");
	private By upcEanIdInputBox = By.xpath("//label[contains(text(),'UPC/EAN')]/../..//input");
	private By releaseDateInputBox = By.xpath("//label[contains(text(),'Release date')]/../..//input");
	private By promotionDateInputBox = By.xpath("//label[contains(text(),'Promotion date')]/../..//input");

	private By timedReleaseQuestions = By.cssSelector("div.QID64 table[role='presentation'] tr td label span");
	private By deliveredInDolbyAtmosQuestions = By.cssSelector("div.QID70 table[role='presentation'] tr td label span");
	private By deliveredWithMotionArtworkQuestions = By
			.cssSelector("div.QID109 table[role='presentation'] tr td label span");
	private By playbookPromotionQuestions = By.cssSelector("div#QID103 table[role='presentation'] tr td label span");
	private By labelInputBox = By.xpath("//label[contains(text(),'Label')]/../..//input");
	private By distributorDropDown = By.xpath("//select[@id='QR~QID12']");
	private By listenLinkInputBox = By.xpath("//label[contains(text(),'Listen link')]/../..//input");
	private By releaseDetailsInputBox = By.xpath("//label[contains(text(),'Release details')]/../..//textarea");
	private By pitchingForInputBox = By.xpath("//label[contains(text(),'Pitching for')]/../..//textarea");
	private By primaryGenreQuestions = By.cssSelector("div#QID10 table[role='presentation'] tr td label span");
	private By additionalGenreQuestions = By.cssSelector("div#QID102 table[role='presentation'] tr td label span");
	private By moodsQuestions = By.cssSelector("div#QID50 table[role='presentation'] tr td label span");

	// private By summaryPageheaderText = By.cssSelector("div#QID43");
	private By summaryPageheaderText = By.cssSelector("div#QID42");

	// 3. Page Actions: Features (behavior) of the page the form of methods:
	public String getLandingPageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isPasswordDispalyed() {
		return driver.findElement(password).isDisplayed();
	}

	public void enterPassword(String pwd) {
		elementUtil.explicitWait(password);
		if (driver.findElement(password).isDisplayed()) {
			driver.findElement(password).sendKeys(pwd);
		}
	}

	public void clickOnNextBtn() {
		elementUtil.explicitWait(nextBtn);
		if (driver.findElement(nextBtn).isDisplayed()) {
			driver.findElement(nextBtn).click();
		}
		elementUtil.waitForPageLoad();
	}

	public void clickOnSubmitBtn() {
		elementUtil.explicitWait(submitBtn);
		if (driver.findElement(submitBtn).isDisplayed()) {
			driver.findElement(submitBtn).click();
		}
		elementUtil.waitForPageLoad();
	}

	public String verifyHeaderText() throws InterruptedException {
		elementUtil.explicitWait(headerText);
		Thread.sleep(4000);
		String headerTextValue = driver.findElement(headerText).getText();
		System.out.println("Header Text :" + headerTextValue);
		return headerTextValue;
	}

	public String verifyContentDetailsPageHeaderText() throws InterruptedException {
		elementUtil.explicitWait(contentDetailsPageheaderText);
		Thread.sleep(4000);
		String contentDetailsPageheaderTextValue = driver.findElement(contentDetailsPageheaderText).getText();
		System.out.println("Header Text :" + contentDetailsPageheaderTextValue);
		return contentDetailsPageheaderTextValue;
	}

	public String verifySummaryPageHeaderText() throws InterruptedException {
		Thread.sleep(4000);
		elementUtil.waitForPageLoad();
		elementUtil.explicitWait(summaryPageheaderText);
		String headerText = driver.findElement(summaryPageheaderText).getText();
		System.out.println("Header Text :" + headerText);
		return headerText;
	}

	public void enterYourName(String yourName) {
		elementUtil.explicitWait(yourNameInputBox);
		if (driver.findElement(yourNameInputBox).isDisplayed()) {
			driver.findElement(yourNameInputBox).sendKeys(yourName);
		}
	}

	public void enterYourBusinessEmail(String businessEmail) {
		elementUtil.explicitWait(yourBusinessEmailInputBox);
		if (driver.findElement(yourBusinessEmailInputBox).isDisplayed()) {
			driver.findElement(yourBusinessEmailInputBox).sendKeys(businessEmail);
		}
	}

	public void enterCompany(String company) {
		elementUtil.explicitWait(yourCompanyInputBox);
		if (driver.findElement(yourCompanyInputBox).isDisplayed()) {
			driver.findElement(yourCompanyInputBox).sendKeys(company);
		}
	}

	public void selectYourTerritory(String value) {
		elementUtil.explicitWait(yourTerritoryDrpDown);
		if (driver.findElement(yourTerritoryDrpDown).isDisplayed()) {
			Select drop = new Select(driver.findElement(yourTerritoryDrpDown));
			drop.selectByVisibleText(value);
		}
	}

	public String getValueOfYourTerritoryDropDown() {
		elementUtil.explicitWait(yourTerritoryDrpDown);
		Select drop = new Select(driver.findElement(yourTerritoryDrpDown));
		String yourTerritoryDrpDownValue = drop.getFirstSelectedOption().getText();
		System.out.println("Your territory selected value :" + yourTerritoryDrpDownValue);
		return yourTerritoryDrpDownValue;
	}

	public void selectTerritoriesToPitchTo(String value) {
		elementUtil.waitForPageLoad();
		elementUtil.explicitWait(yourTerritoriesToPitchToQuestions);
		if (driver.findElement(yourTerritoriesToPitchToQuestions).isDisplayed()) {
			List<WebElement> allOptions = driver.findElements(yourTerritoriesToPitchToQuestions);
			System.out.println(allOptions.size() + " Size of list");
			for (WebElement e : allOptions) {
				if ((e.getText()).equalsIgnoreCase(value)) {
					elementUtil.waitUntilElementIsClicable(e);
					e.click();
					break;
				}
			}
		}
	}

	public void selectTypeOfSong(String value) {
		elementUtil.waitForPageLoad();
		elementUtil.explicitWait(typeOfSongQuestions);
		if (driver.findElement(typeOfSongQuestions).isDisplayed()) {
			List<WebElement> allOptions = driver.findElements(typeOfSongQuestions);
			System.out.println(allOptions.size() + " Size of type Of Song Questions list");
			for (WebElement e : allOptions) {
				if ((e.getText()).equalsIgnoreCase(value)) {
					elementUtil.waitUntilElementIsClicable(e);
					elementUtil.waitForPageLoad();
					e.click();
					break;
				}
			}
		}
	}

	public void enterArtistName(String artistName) {
		elementUtil.explicitWait(artistNameInputBox);
		if (driver.findElement(artistNameInputBox).isDisplayed()) {
			driver.findElement(artistNameInputBox).sendKeys(artistName);
		}
	}

	public void enterContentTitle(String contentTitle) {
		elementUtil.explicitWait(contentTitleInputBox);
		if (driver.findElement(contentTitleInputBox).isDisplayed()) {
			driver.findElement(contentTitleInputBox).sendKeys(contentTitle);
		}
	}

	public void enterAppleId(String appleID) {
		elementUtil.explicitWait(appleIdInputBox);
		if (driver.findElement(appleIdInputBox).isDisplayed()) {
			driver.findElement(appleIdInputBox).sendKeys(appleID);
		}
	}

	public void enterupcEanId(String upcEanId) {
		elementUtil.explicitWait(upcEanIdInputBox);
		if (driver.findElement(upcEanIdInputBox).isDisplayed()) {
			driver.findElement(upcEanIdInputBox).sendKeys(upcEanId);
		}
	}

	public void enterReleaseDate(String releaseDate, String dateFormat) {
		elementUtil.explicitWait(releaseDateInputBox);
		try {
			if (elementUtil.isValidDateFormat(dateFormat, releaseDate)) {
				if (driver.findElement(releaseDateInputBox).isDisplayed()) {
					driver.findElement(releaseDateInputBox).sendKeys(releaseDate);
				}
			} else {
				throw new IllegalArgumentException(
						"Release Date is not in the correct format. Please provide release date in " + dateFormat
								+ " format.");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Release Date is not in the correct format. Please provide release date in " + dateFormat
							+ " format.",
					e);
		}

	}

	public void enterPromotionDate(String releaseDate, String dateFormat) {
		elementUtil.explicitWait(promotionDateInputBox);

		if (elementUtil.isValidDateFormat(dateFormat, releaseDate)) {
			if (driver.findElement(promotionDateInputBox).isDisplayed()) {
				driver.findElement(promotionDateInputBox).sendKeys(releaseDate);
			}
		} else {
			throw new IllegalArgumentException(
					"Promotion Date is not in the correct format. Please provide release date in " + dateFormat
							+ " format.");
		}
	}

	public void selectTimedRelease(String value) {
		elementUtil.selectTypeOfValueFromTableOfAppleMusic(timedReleaseQuestions, value);
	}

	public void selectDeliveredInDolbyAtmos(String value) {
		elementUtil.selectTypeOfValueFromTableOfAppleMusic(deliveredInDolbyAtmosQuestions, value);
	}

	public void selectDeliveredWithMotionArtwork(String value) {
		elementUtil.selectTypeOfValueFromTableOfAppleMusic(deliveredWithMotionArtworkQuestions, value);
	}

	public void selectPrimaryGenre(String primaryGenre) {
		elementUtil.selectTypeOfValueFromTableOfAppleMusic(primaryGenreQuestions, primaryGenre);
	}

	public void selectAdditionalGenre(List<String> list) {
		elementUtil.waitForPageLoad();
		elementUtil.explicitWait(additionalGenreQuestions);
		//
		System.out.println("Additional genre size is : " + (list.size()));
		if (list.size() <= 2) {
			System.out.println("Size of Additional genre is less then or equal to 2, actual size is: " + (list.size()));
			for (String s : list) {
				System.out.println("Additional genre value : " + s);
				elementUtil.selectTypeOfValueFromTableOfAppleMusic(additionalGenreQuestions, s);
				selectedAdditionalGenreList.add(s);
			}

		} else {
			System.out.println("Size of Additional genre is more then 2, actual size is: " + (list.size()));
			System.out.println(
					"As Additional genre only allowing to enter 2 genre hence only considering first two values");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Additional genre value : " + list.get(i));
				elementUtil.selectTypeOfValueFromTableOfAppleMusic(additionalGenreQuestions, list.get(i));
				selectedAdditionalGenreList.add(list.get(i));
				if (i == 1) {
					break; // Stop the loop when i reaches 2
				}

			}
		}

	}

	public void selectMoodGenre(List<String> list) {
		elementUtil.waitForPageLoad();
		elementUtil.explicitWait(additionalGenreQuestions);
		if (driver.findElement(moodsQuestions).isDisplayed() == true) {
			System.out.println("Moods data size is : " + (list.size()));
			if (list.size() <= 3) {
				System.out.println("Size of Moods data is less then or equal to 3, actual size is: " + (list.size()));
				for (String s : list) {
					System.out.println("Moods data value : " + s);
					elementUtil.selectTypeOfValueFromTableOfAppleMusic(moodsQuestions, s);
					selectedMoodsList.add(s);
				}

			} else {
				System.out.println("Size of Moods data is more then 3, actual size is: " + (list.size()));
				System.out.println("As we are only accepting 3 Moods data, hence only considering first 3 values");
				for (int i = 0; i < list.size(); i++) {
					System.out.println("Moods data value : " + list.get(i));
					elementUtil.selectTypeOfValueFromTableOfAppleMusic(moodsQuestions, list.get(i));
					selectedMoodsList.add(list.get(i));
					if (i == 2) {
						break; // Stop the loop when i reaches 3
					}

				}
			}
		} else {
			System.out.println("Element is not displayed hence not selecting any values under Moods section");
		}

	}

	public void selectPlaybookPromotionQuestions(String questionValue) {
		elementUtil.selectTypeOfValueFromTableOfAppleMusic(playbookPromotionQuestions, questionValue);
	}

	public void enterLabel(String label) {
		elementUtil.explicitWait(labelInputBox);
		if (driver.findElement(labelInputBox).isDisplayed()) {
			driver.findElement(labelInputBox).sendKeys(label);
			elementUtil.waitForPageLoad();
		}
	}

	public void enterListenLink(String link) {
		elementUtil.explicitWait(listenLinkInputBox);
		if (driver.findElement(listenLinkInputBox).isDisplayed()) {
			driver.findElement(listenLinkInputBox).sendKeys(link);
		}
	}

	public void enterReleaseDetails(String releaseDetails) {
		elementUtil.explicitWait(releaseDetailsInputBox);
		if (driver.findElement(releaseDetailsInputBox).isDisplayed()) {
			driver.findElement(releaseDetailsInputBox).sendKeys(releaseDetails);
		}
	}

	public void enterPitchingFor(String pitchingForText) {
		elementUtil.explicitWait(pitchingForInputBox);
		if (driver.findElement(pitchingForInputBox).isDisplayed()) {
			driver.findElement(pitchingForInputBox).sendKeys(pitchingForText);
		}
	}

	public void selectDistributorFromDropDown(String distributorName) {
		elementUtil.explicitWait(distributorDropDown);
		if (driver.findElement(distributorDropDown).isDisplayed()) {
			Select drop = new Select(driver.findElement(distributorDropDown));
			drop.selectByVisibleText(distributorName);
		}
	}

	public String verifyTagNameAndTagValueOnSummaryPage(String tagName, String tagValue) {
		elementUtil.waitForPageLoad();
		WebElement tagElement = driver.findElement(By.xpath("//span[@class='pitch_name'][contains(text(),'" + tagName
				+ "')]/following-sibling::span[@class='pitch_content']"));
		String value = tagElement.getText().trim();
		return value;

	}

	public boolean verifyTagValueForGenre_MoodContainsSelectedMoodsListOnSummaryPage(String tagName) {
		boolean isPresent = false;
		elementUtil.waitForPageLoad();
		WebElement tagElement = driver.findElement(By.xpath("//span[@class='pitch_name'][contains(text(),'" + tagName
				+ "')]/following-sibling::span[@class='pitch_content']/following-sibling::div"));
		String value = tagElement.getText().trim();
		String[] genres = value.split("[,\\s]+");

		if (Arrays.asList(genres).containsAll(selectedMoodsList)) {
			isPresent = true;
			System.out.println("Sected Moods List value are: ");
			for (String gen : genres) {
				System.out.println(gen);
			}

		}
		return isPresent;

	}

	public boolean verifyTagValueForGenre_MoodContainsSelectedAdditionalGenreListOnSummaryPage(String tagName) {
		boolean isPresent = false;
		elementUtil.waitForPageLoad();
		WebElement tagElement = driver.findElement(By.xpath("//span[@class='pitch_name'][contains(text(),'" + tagName
				+ "')]/following-sibling::span[@class='pitch_content']"));
		String value = tagElement.getText().trim();
		String[] genres = value.split("[,\\s]+");

		if (Arrays.asList(genres).containsAll(selectedAdditionalGenreList)) {
			isPresent = true;

		}
		return isPresent;

	}

	public void selectAdditionalGenre(String listValue) {
		String[] list = listValue.split("[,\\s]+");
		elementUtil.waitForPageLoad();
		elementUtil.explicitWait(additionalGenreQuestions);
		//
		System.out.println("Additional genre size is : " + (list.length));
		if (list.length <= 2) {
			System.out.println("Size of Additional genre is less then or equal to 2, actual size is: " + (list.length));
			for (String s : list) {
				System.out.println("Additional genre value : " + s);
				elementUtil.selectTypeOfValueFromTableOfAppleMusic(additionalGenreQuestions, s);
				selectedAdditionalGenreList.add(s);
			}

		} else {
			System.out.println("Size of Additional genre is more then 2, actual size is: " + (list.length));
			System.out.println(
					"As Additional genre only allowing to enter 2 genre hence only considering first two values");
			for (int i = 0; i < list.length; i++) {
				System.out.println("Additional genre value : " + list[i]);
				elementUtil.selectTypeOfValueFromTableOfAppleMusic(additionalGenreQuestions, list[i]);
				selectedAdditionalGenreList.add(list[i]);
				if (i == 1) {
					break; // Stop the loop when i reaches 2
				}

			}
		}

	}

	public void SelectMoodValue(String moodValue) {
		String[] list = moodValue.split("[,\\s]+");
		elementUtil.waitForPageLoad();
		elementUtil.explicitWait(additionalGenreQuestions);
		if (driver.findElement(moodsQuestions).isDisplayed() == true) {
			System.out.println("Moods data size is : " + (list.length));
			if (list.length <= 3) {
				System.out.println("Size of Moods data is less then or equal to 3, actual size is: " + (list.length));
				for (String s : list) {
					System.out.println("Moods data value : " + s);
					elementUtil.selectTypeOfValueFromTableOfAppleMusic(moodsQuestions, s);
					selectedMoodsList.add(s);
				}

			} else {
				System.out.println("Size of Moods data is more then 3, actual size is: " + (list.length));
				System.out.println("As we are only accepting 3 Moods data, hence only considering first 3 values");
				for (int i = 0; i < list.length; i++) {
					System.out.println("Moods data value : " + list[i]);
					elementUtil.selectTypeOfValueFromTableOfAppleMusic(moodsQuestions, list[i]);
					selectedMoodsList.add(list[i]);
					if (i == 2) {
						break; // Stop the loop when i reaches 3
					}

				}
			}
		} else {
			System.out.println("Element is not displayed hence not selecting any values under Moods section");
		}

	}
	
	
}
