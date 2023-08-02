package com.qa.pages;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;

public class DeezerMusicPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	ExcelReader excelReader;
	private ConfigReader configReader;

	// 1. Constructor of page Class
	public DeezerMusicPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		excelReader = new ExcelReader();
		configReader = new ConfigReader();
	}

	// 2. By Locators
	private By clearFormButtonLocator = By.xpath("//span[normalize-space()='Clear form']");
	private By clearFormButtonOnConfirmationPageLocator = By
			.xpath("//div[normalize-space()='Clear form?']/../../div/div/span[normalize-space()='Clear form']");
	private By gmailUserNameLocator = By.cssSelector("#identifierId");
	private By userIDPageNextBtnLocator = By.cssSelector("#identifierNext");
	private By gmailPasswordLocator = By.cssSelector("input[type='password']");
	private By gmailLoginPasswordPageNextBtnLocator = By.cssSelector("#passwordNext");
	private By continueToYourGoogleAccountLinkLocator = By
			.cssSelector("a[aria-label='Continue to your Google Account']");
	private By emailOnPitchingFormPageLocator = By.xpath("//span[normalize-space()='Email']/../../../..//input");
	private By nextBtnOnDeezerPageLocator = By.xpath("//span[normalize-space()='Next']");
	private By browseBtnOnFileUploadPageLocator = By.cssSelector("span.VfPpkd-vQzf8d");
	private By addFileBtnOfPressShotLocator = By.cssSelector("div[aria-label='Add file']");
	private By selectedFileLocator = By.cssSelector("div[aria-label='Selected files']");
	private By distributorNameOnDeezerPageLocator = By
			.xpath("//span[normalize-space()='Distributor name']/../../../..//input");
	private By labelNameOnDeezerPageLocator = By.xpath("//span[normalize-space()='Label name']/../../../..//input");
	private By releaseDatePageLocator = By.cssSelector("input[type='date']");
	private By upcIdLocator = By.xpath("//span[normalize-space()='UPC']/../../../..//input");
	private By nameOfArtistLocator = By.xpath("//span[normalize-space()='Name of the artist']/../../../..//input");
	private By nameOfReleaseLocator = By.xpath(
			"//span[normalize-space()='Name of the release (track title as will be distributed)']/../../../..//input");
	private By priorityLocator = By.xpath("//span[normalize-space()='Priority']/../../../..//div[@role='listbox']");
	private By priorityLocatorList = By
			.xpath("(//span[normalize-space()='Priority']/../../../..//div[@role='presentation'])[5]//div/span");
	private By kindOfContentCheckBoxLocator = By
			.xpath("//span[normalize-space()='Kind of content ?']/../../../..//span[@role='presentation']//label");
	private By mainGenreLocator = By
			.xpath("//span[normalize-space()='Main genre (use only one genre)']/../../../..//div[@role='listbox']");
	private By mainGenreLocatorList = By.xpath(
			"(//span[normalize-space()='Main genre (use only one genre)']/../../../..//div[@role='presentation'])[5]//div/span");
	private By listeningLinkLocator = By.xpath("//span[normalize-space()='Listening link']/../../../..//input");
	private By genderCheckBoxLocator = By
			.xpath("//span[normalize-space()='Gender']/../../../..//span[@role='presentation']//label");

	private By hoursTagOfTimeOfRelease = By.cssSelector("input[aria-label='Hour']");
	private By minutesTagOfTimeRelease = By.cssSelector("input[aria-label='Minute']");
	private By amPmTagOfTimeReleaseList = By.xpath(
			"(//span[normalize-space()='Time of release (GMT format)']/../../../..//div[@role='presentation'])[4]//div/span");
	private By arrowBtnForAmPmTagOfTimeRelease = By
			.cssSelector("div[role='listbox'][aria-label='AM or PM'] .e2CuFe.eU809d");
	private By secondaryGenreLocator = By
			.xpath("//span[normalize-space()='Secondary genre']/../../../..//div[@role='listbox']");
	private By focusTrackLocator = By.xpath("//span[normalize-space()='Focus track']/../../../..//input");
	private By subgenreLocator = By.xpath("//span[normalize-space()='Subgenre']/../../../..//input");
	private By artistInfoLocator = By.xpath("//span[normalize-space()='Artist info']/../../../..//textarea");
	private By marketingDetailsLocator = By
			.xpath("//span[normalize-space()='Marketing details']/../../../..//textarea");
	private By submitBtnLocator = By.xpath("//span[normalize-space()='Submit']");

	// 3. Page Actions: Features (behavior) of the page the form of methods:
	public String getGoogleLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isGmailUserNamedDispalyed() {
		return driver.findElement(gmailUserNameLocator).isDisplayed();
	}

	public void enterGmailUserName(String emailID) {
		elementUtil.sendText(gmailUserNameLocator, emailID);
	}

	public void clickOnUserIDPageNextBtn() {
		elementUtil.clickOnElement(userIDPageNextBtnLocator);
		elementUtil.waitForPageLoad();
	}

	public void enterGmailUserPassword(String pwd) {
		elementUtil.sendText(gmailPasswordLocator, pwd);
	}

	public void clickOnPasswordPageNextBtn() throws InterruptedException {
		elementUtil.clickOnElement(gmailLoginPasswordPageNextBtnLocator);
		elementUtil.waitForPageLoad();
	}

	public void clickOnContinueToYourGoogleAccountLink() {
		try {
			elementUtil.waitForPageLoad();
			if (driver.findElement(continueToYourGoogleAccountLinkLocator).isDisplayed()) {
				driver.findElement(gmailLoginPasswordPageNextBtnLocator).click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("As 'Continue to your Google Account' link not displayed hence not clicking anywhere");
		}
	}

	public void enterEmailOnDeezerPitchingForm(String businessEmail) {
		elementUtil.clickOnElement(clearFormButtonLocator);
		elementUtil.clickOnElement(clearFormButtonOnConfirmationPageLocator);
		elementUtil.waitForPageLoad();
		elementUtil.sendText(emailOnPitchingFormPageLocator, businessEmail);
	}

	public void clickOnDeezerPageNextBtn() {
		elementUtil.clickOnElement(nextBtnOnDeezerPageLocator);
		elementUtil.waitForPageLoad();
	}

	public void UploadFileFromPressShotOrTheArtist(String documentPath) {
		if (!documentPath.isEmpty()) {
			elementUtil.clickOnElement(addFileBtnOfPressShotLocator);
			elementUtil.waitForPageLoad();
			elementUtil.uploadFileUsingSendKeysOnFrameElement(browseBtnOnFileUploadPageLocator, documentPath);
			// elementUtil.clickOnElement(browseBtnOnFileUploadPageLocator);
			elementUtil.waitForPageLoad();
			// String uploadedFileName = driver.findElement(selectedFileLocator).getText();
			File file = new File(documentPath);
			if (file.exists()) {
				System.out.println("File exists.");
			} else {
				System.out.println("File does not exist.");
			}
		} else {
			System.out.println("As no file path provided hence not uploading any document for Press shot or the artist section");
		}

	}

	public void enterDistributorNameOnDeezerPage(String distributorName) {
		elementUtil.waitForPageLoad();
		elementUtil.sendText(distributorNameOnDeezerPageLocator, distributorName);
		elementUtil.waitForPageLoad();
	}

	public void enterLabelNameOnDeezerPage(String labelName) {
		elementUtil.sendText(labelNameOnDeezerPageLocator, labelName);
	}

	public void enterReleaseDate(String releaseDate, String dateFormat) {
		elementUtil.explicitWait(releaseDatePageLocator);
		try {
			if (elementUtil.isValidDateFormat(dateFormat, releaseDate)) {
				if (driver.findElement(releaseDatePageLocator).isDisplayed()) {
					DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDate date = LocalDate.parse(releaseDate, inputFormatter);

					DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String outputDate = date.format(outputFormatter);
					driver.findElement(releaseDatePageLocator).sendKeys(outputDate);
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

	public void enterUpcId(String upcId) {
		elementUtil.sendText(upcIdLocator, upcId);
	}

	public void enterNameOfTheArtist(String artistName) {
		elementUtil.sendText(nameOfArtistLocator, artistName);
	}

	public void enterNameOfTheRelease(String nameOfRelease) {
		elementUtil.sendText(nameOfReleaseLocator, nameOfRelease);
	}

	public void selectPriorityFromDropDown(String priority) {
		elementUtil.explicitWait(priorityLocator);
		if (driver.findElement(priorityLocator).isDisplayed()) {
			driver.findElement(priorityLocator).click();
			elementUtil.selectOptionFromDropDown(priorityLocatorList, priority);

		}
	}

	public void selectContentTypeCheckbox(String contentType) {
		Map<String, String> checkboxValues = configReader.readCheckboxValuesFromDeezerConfig();
		String checkboxValue = checkboxValues.getOrDefault(contentType, contentType);
		elementUtil.selectTypeOfValueFromTableOfAppleMusic(kindOfContentCheckBoxLocator, checkboxValue);
	}

	public void selectMainGenreFromDropDown(String mainGenre) {
		elementUtil.explicitWait(mainGenreLocator);
		elementUtil.waitForPageLoad();
		if (driver.findElement(mainGenreLocator).isDisplayed()) {
			driver.findElement(mainGenreLocator).click();
			elementUtil.selectOptionFromDropDown(mainGenreLocatorList, mainGenre);
		}
	}

	public void enterListeningLink(String listeningLink) {
		elementUtil.sendText(listeningLinkLocator, listeningLink);
	}

	public void selectGenderFromCheckBox(String gender) {
		elementUtil.selectTypeOfValueFromTableOfAppleMusic(genderCheckBoxLocator, gender);
	}

	public void selectTimeOfRelease(String timeValue) {
		elementUtil.explicitWait(minutesTagOfTimeRelease);
		String[] timeParts = timeValue.split(":|\\s+");
		String hours = timeParts[0];
		String minutes = timeParts[1];
		String amPm = timeParts[2];
		driver.findElement(hoursTagOfTimeOfRelease).clear();
		driver.findElement(minutesTagOfTimeRelease).clear();
		driver.findElement(hoursTagOfTimeOfRelease).sendKeys(hours);
		driver.findElement(minutesTagOfTimeRelease).sendKeys(minutes);
		
		WebElement amPmArrowBtn = driver.findElement(arrowBtnForAmPmTagOfTimeRelease);
	    try {
			if (amPmArrowBtn.isDisplayed()) {
			    amPmArrowBtn.click();
			    elementUtil.selectOptionFromDropDown(amPmTagOfTimeReleaseList, amPm);
			}
		} catch (Exception e) {
		      // Handle the "no such element" error
	        // You can log the error, capture a screenshot, or perform any necessary recovery actions
	        // For example:
	        System.out.println("As no dropdown found hence not clicking on it");
		}

	}

	public void enterFocusTrackIfRelaseIsAnAlbum(String focusTrack, String kindOfContent) {
		if (kindOfContent.equalsIgnoreCase("ALB") || kindOfContent.equalsIgnoreCase("Album")
				|| kindOfContent.equalsIgnoreCase("EP")) {
			elementUtil.sendText(focusTrackLocator, focusTrack);
		} else {
			System.out.println("As kind of content is (" + kindOfContent
					+ ") not a Album or EP hence not updating details in Focus Track");
		}
	}

	public void selectSecondaryGenre(String listValue) {
		elementUtil.waitForPageLoad();
		String[] list = listValue.split("[,\\s]+");
		elementUtil.waitForPageLoad();
		elementUtil.explicitWait(secondaryGenreLocator);
		//
		System.out.println("Secondary genre data size is : " + (list.length));
		if (list.length <= 1) {
			System.out.println("Size of Secondary genre data is equal to 1: " + (list.length));
			for (String s : list) {
				System.out.println("Additional genre value : " + s);
				driver.findElement(secondaryGenreLocator).click();
				elementUtil.waitUntilElementIsClicable(By.xpath("//div[@role='option']"));
				elementUtil.selectOptionFromDropDown(By.xpath("//div[@role='option']"), s);
			}

		} else {
			System.out.println("Size of Secondary genre is more then 1, actual size is: " + (list.length));
			System.out
					.println("As Secondary genre only allowing to select 1 genre hence only considering first values");
			for (int i = 0; i < list.length; i++) {
				System.out.println("Secondary genre value : " + list[i]);
				driver.findElement(secondaryGenreLocator).click();
				elementUtil.selectOptionFromDropDown(secondaryGenreLocator, list[i]);
				if (i == 1) {
					break; // Stop the loop when i reaches 1
				}

			}
		}
	}

	public void enterSubGenre(String subGenre) {
		elementUtil.sendText(subgenreLocator, subGenre);
	}

	public void enterArtistInfo(String artistInfo) {
		elementUtil.sendText(artistInfoLocator, artistInfo);
	}

	public void enterMarketingDetails(String marketingDetails) {
		elementUtil.sendText(marketingDetailsLocator, marketingDetails);
	}

	public void clickOnSubmitButton() {
		elementUtil.clickOnElement(submitBtnLocator);
	}

}
