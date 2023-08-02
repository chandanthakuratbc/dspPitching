package com.qa.pages;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;

public class SpotifyMusicPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	ExcelReader excelReader;
	private ConfigReader configReader;

	// Declare variable
	List<String> selectedGenreList = new ArrayList<>();
	List<String> selectedMusicCultureList = new ArrayList<>();
	List<String> selectedMoodsList = new ArrayList<>();
	List<String> selectedSongStyle = new ArrayList<>();
	List<String> selectedInsturmentUsedInSong = new ArrayList<>();
	List<String> selectedLanguage = new ArrayList<>();

	// 1. Constructor of page Class
	public SpotifyMusicPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		excelReader = new ExcelReader();
		configReader = new ConfigReader();
	}

	// 2. By Locators
	private By emailOrUserNameLocator = By.cssSelector("#login-username");
	private By spotifyPasswordLocator = By.cssSelector("#login-password");
	private By loginBtnLocator = By.cssSelector("#login-button");
	private By searchByArtistInputBoxLocator = By.cssSelector("[placeholder=\"Search roster\"]");
	private By rosterArtistTablePitchBtnLocator = By.xpath("//table/tbody/tr/td[2]//button");
	private By rosterArtistTablePitchDropDownBtnLocator = By.xpath("//table/tbody/tr//td//button/span");
	private By rosterArtistTablePitchBrnFromDropDwon = By.cssSelector("button[data-encore-id='popoverNavigationLink']");
	private By songSelectedCheckBoxLocator = By
			.xpath("//h2[normalize-space()='Choose a song to pitch']/..//div[@role='radio']//*[@role='img']");
	private By nextBtnOnSpotifyPageLocator = By.xpath("//button[@data-slo-id='pitch-next-btn']");

	private By homeTownForAtistInputLocator = By.cssSelector("div#entity-search input");
	// private By clearBtnOfHomeTownSearcBoxLocator =
	// By.cssSelector("button[data-testid='clear-button']");
	private By locationSuggestionLocator = By.cssSelector("li[role='option']");

	private By addSongText = By.xpath("//h2[normalize-space()='Add song details']");
	private By chooseGeneresText = By.xpath("//span[@id='genres-label']");
	private By chooseGeneresInputLocator = By.cssSelector("input#genre-select");
	private By generesnSuggestionLocator = By.cssSelector("div[id*='react-select-2-option']");

	private By typeOfMusicCultureQuestionsLocator = By
			.xpath("//span[normalize-space()='Choose up to 2 music cultures.']/../../div/button");
	private By typeOfMoodQuestionLocator = By
			.xpath("//span[normalize-space()='Choose up to 2 moods.']/../../div/button");
	private By typeOfSongStyleQuestionLocator = By
			.xpath("//span[normalize-space()='Choose up to 2 song styles.']/../../div/button");
	private By typeOfInstrumentsUsedInSongLocator = By
			.xpath("//span[normalize-space()='What instruments are on this song?']/../../div/button");
//	private By typeOfInstrumentsUsedInSongTextLocator = By
//			.xpath("//span[normalize-space()='What instruments are on this song?']");

	private By isThisACoverChecBoxLocator = By.cssSelector(
			"fieldset[data-encore-id=\"formGroup\"] div[data-encore-id=\"formRadio\"] label[for^=\"is-cover\"]");
	private By isItRemixChecBoxLocator = By
			.cssSelector("fieldset[data-encore-id='formGroup'] div[data-encore-id='formRadio'] label[for^='is-remix']");
	private By howWasItRecorededChecBoxLocator = By.cssSelector(
			"fieldset[data-encore-id='formGroup'] div[data-encore-id='formRadio'] label[for^='recording-type']");
	private By isItAnInstrumentalChecBoxLocator = By.cssSelector(
			"fieldset[data-encore-id='formGroup'] div[data-encore-id='formRadio'] label[for^='is-instrumental']");
	private By chooseLanguagesInputLocator = By.cssSelector("div#entity-search input");
	private By whatLanguagesAreTheLyricsInTextLocator = By
			.xpath("//span[normalize-space()='What languages are the lyrics in?']");

	private By descriptionTextAreaLocator = By.cssSelector("textarea#song-info");
	private By artistInfoExpandArrowButtonLocator = By.cssSelector("button[aria-label=\"Toggle seeing artist info\"]");

	// 3. Page Actions: Features (behavior) of the page the form of methods:
	public String getLandingPageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterSpotifyEmailOrUserName(String emailID) {
		elementUtil.sendText(emailOrUserNameLocator, emailID);
	}

	public void enterSpotifyUserPassword(String pwd) {
		elementUtil.sendText(spotifyPasswordLocator, pwd);
	}

	public void clickOnLoginBtn() {
		elementUtil.waitForPageLoad();
		elementUtil.clickOnElement(loginBtnLocator);
		elementUtil.waitForPageLoad();
	}

	public void searchForArtistAndClickOnPitchAsPerStatus(String artistName, String pitchValue) {
		elementUtil.sendText(searchByArtistInputBoxLocator, artistName);
		elementUtil.waitForPageLoad();
		try {
			//elementUtil.selectTypeOfValueFromTableOfAppleMusic(rosterArtistTablePitchBtnLocator, pitchValue);
			elementUtil.clickOnElement(rosterArtistTablePitchDropDownBtnLocator);
			elementUtil.selectOptionFromDropDown(rosterArtistTablePitchBrnFromDropDwon, pitchValue);
		} catch (Exception e) {
			System.err.println("Error: PitchValue is not avilable for click: " + pitchValue);
			e.printStackTrace();
		}
		elementUtil.waitForPageLoad();

	}

	public void checkChooseA_SongToPitchIsSelected() {
		if (isChooseASongToPitchSelected()) {
			System.out.println("Song is already selected, no changes will be made.");
		} else {
			elementUtil.clickOnElement(songSelectedCheckBoxLocator);
		}
	}

	public boolean isChooseASongToPitchSelected() {
//		elementUtil.scrollToElement(driver, songSelectedCheckBoxLocator);
//	    return driver.findElement(songSelectedCheckBoxLocator).isSelected();
		return driver.findElement(songSelectedCheckBoxLocator).isDisplayed();
	}

	public void clickOnNextBtn() throws InterruptedException {
		elementUtil.clickOnElement(nextBtnOnSpotifyPageLocator);
		elementUtil.waitForPageLoad();
	}

	public void selectHomeTownOfArtist(String homeTown) {
		elementUtil.sendText(homeTownForAtistInputLocator, homeTown);
		// Click on the desired location suggestion
		elementUtil.selectOptionFromDropDown(locationSuggestionLocator, homeTown);
	}

	public void selectGeneresUnderChooseUpToThreeGenres(String listValue) {
		String[] list = listValue.split("[,\\s]+");
		elementUtil.waitForPageLoad();
		elementUtil.explicitWait(chooseGeneresInputLocator);
		elementUtil.setZoom(driver, "55%");
		elementUtil.scrollToElement(driver, addSongText);

		//
		System.out.println("Genre size is : " + (list.length));
		if (list.length <= 3) {
			System.out.println("Size of genre is less then or equal to 3, actual size is: " + (list.length));
			for (String s : list) {
				System.out.println("Genre value : " + s);
				elementUtil.waitForPageLoad();
				// elementUtil.clickOnElement(chooseGeneresInputLocator);
				elementUtil.sendText(chooseGeneresInputLocator, s);
				elementUtil.waitForPageLoad();
				elementUtil.selectTypeOfValueFromTableAndScrollTillElement(generesnSuggestionLocator, s);
				selectedGenreList.add(s);
			}

		} else {
			System.out.println("Size of Genre list is more then 3, actual size is: " + (list.length));
			System.out.println("As Genre only allowing to enter 3 genre hence only considering first three values");
			for (int i = 0; i < list.length; i++) {
				System.out.println("Genre list value : " + list[i]);
				elementUtil.waitForPageLoad();
				elementUtil.sendText(chooseGeneresInputLocator, list[i]);
				elementUtil.selectTypeOfValueFromTableAndScrollTillElement(generesnSuggestionLocator, list[i]);
				selectedGenreList.add(list[i]);
				if (i == 2) {
					break; // Stop the loop when i reaches 3
				}

			}
		}
		elementUtil.setZoom(driver, "100%");
	}

//	public void selectTypeOfMusicCulturelGenre(String listValue) {
//		String[] list = listValue.split(",");
//		elementUtil.waitForPageLoad();
//		elementUtil.explicitWait(typeOfMusicCultureQuestionsLocator);
//		elementUtil.setZoom(driver, "55%");
//		elementUtil.scrollToElement(driver, chooseGeneresText);
//		//
//		System.out.println("List of Music Culture size is : " + (list.length));
//		if (list.length <= 2) {
//			elementUtil.waitForPageLoad();
//			System.out.println(
//					"Size for List of Music Culture is less then or equal to 2, actual size is: " + (list.length));
//			for (String s : list) {
//				System.out.println("Music Culture value : " + s);
//				elementUtil.selectTypeOfValueFromTableAndScrollTillElement(typeOfMusicCultureQuestionsLocator, s);
//				selectedMusicCultureList.add(s);
//			}
//
//		} else {
//			System.out.println("Size for List of Music Culture is more then 2, actual size is: " + (list.length));
//			System.out
//					.println("As Music Culture only allowing to enter 2 genre hence only considering first two values");
//			for (int i = 0; i < list.length; i++) {
//				System.out.println("Music Culture value : " + list[i]);
//				elementUtil.selectTypeOfValueFromTableAndScrollTillElement(typeOfMusicCultureQuestionsLocator, list[i]);
//				selectedMusicCultureList.add(list[i]);
//				if (i == 1) {
//					break; // Stop the loop when i reaches 2
//				}
//
//			}
//		}
//		elementUtil.setZoom(driver, "100%");
//	}

	public void selectTypeOfMusicCulturelGenre(String listValue) {
	    String[] list = listValue.split(",");
	    elementUtil.waitForPageLoad();
	    elementUtil.explicitWait(typeOfMusicCultureQuestionsLocator);
	    elementUtil.setZoom(driver, "55%");
	    elementUtil.scrollToElement(driver, chooseGeneresText);

	    System.out.println("List of Music Culture size is: " + list.length);
	    int selectedCount = 0;
	    for (String genre : list) {
	        genre = genre.trim();
	        System.out.println("Music Culture value: " + genre);
	        boolean valueSelected = elementUtil.selectTypeOfValueFromTableSpotify(typeOfMusicCultureQuestionsLocator, genre);
	        if (valueSelected) {
	            selectedMusicCultureList.add(genre);
	            selectedCount++;
	            if (selectedCount >= 2) {
	                break;
	            }
	        }
	    }

	    elementUtil.setZoom(driver, "100%");
	}

//	public void selectMoodValue(String moodValue) {
//		String[] list = moodValue.split("[,\\s]+");
//		elementUtil.waitForPageLoad();
//		elementUtil.explicitWait(typeOfMoodQuestionLocator);
//		elementUtil.setZoom(driver, "55%");
//		elementUtil.scrollToElement(driver, chooseGeneresInputLocator);
//		//
//		System.out.println("Moods data size is : " + (list.length));
//		if (list.length <= 2) {
//			System.out.println("Size of Moods data is less then or equal to 2, actual size is: " + (list.length));
//			for (String s : list) {
//				System.out.println("Moods data value : " + s);
//				elementUtil.selectTypeOfValueFromTableAndScrollTillElement(typeOfMoodQuestionLocator, s);
//				selectedMoodsList.add(s);
//			}
//
//		} else {
//			System.out.println("Size of Moods data is more then 2, actual size is: " + (list.length));
//			System.out.println("As we are only accepting 2 Moods data, hence only considering first 2 values");
//			for (int i = 0; i < list.length; i++) {
//				System.out.println("Moods data value : " + list[i]);
//				elementUtil.selectTypeOfValueFromTableAndScrollTillElement(typeOfMoodQuestionLocator, list[i]);
//				selectedMoodsList.add(list[i]);
//				if (i == 1) {
//					break; // Stop the loop when i reaches 2
//				}
//
//			}
//
//		}
//		elementUtil.setZoom(driver, "100%");
//	}
	
	public void selectMoodValue(String listValue) {
	    String[] list = listValue.split(",");
	    elementUtil.waitForPageLoad();
	    elementUtil.explicitWait(typeOfMoodQuestionLocator);
	    elementUtil.setZoom(driver, "55%");
	    elementUtil.scrollToElement(driver, chooseGeneresInputLocator);

	    System.out.println("Moods data size is : " + (list.length));
	    int selectedCount = 0;
	    for (String mood : list) {
	        mood = mood.trim();
	        System.out.println("Mood value: " + mood);
	        boolean valueSelected = elementUtil.selectTypeOfValueFromTableSpotify(typeOfMoodQuestionLocator, mood);
	        if (valueSelected) {
	            selectedMoodsList.add(mood);
	            selectedCount++;
	            if (selectedCount >= 2) {
	                break;
	            }
	        }
	    }

	    elementUtil.setZoom(driver, "100%");
	}

//	public void selectSongStyle(String songStyleValue) {
//		String[] list = songStyleValue.split("[,\\s]+");
//		elementUtil.waitForPageLoad();
//		elementUtil.explicitWait(typeOfSongStyleQuestionLocator);
//		elementUtil.setZoom(driver, "55%");
//		elementUtil.scrollToElement(driver, typeOfMoodQuestionLocator);
//		//
//		System.out.println("SongStyle size is : " + (list.length));
//		if (list.length <= 2) {
//			System.out.println("Size of song Style is less then or equal to 2, actual size is: " + (list.length));
//			for (String s : list) {
//				System.out.println("Song style data value : " + s);
//				elementUtil.selectTypeOfValueFromTableAndScrollTillElement(typeOfSongStyleQuestionLocator, s);
//				selectedSongStyle.add(s);
//			}
//
//		} else {
//			System.out.println("Size of list of song style is more then 2, actual size is: " + (list.length));
//			System.out.println("As we are only accepting 2 song style, hence only considering first 2 values");
//			for (int i = 0; i < list.length; i++) {
//				System.out.println("Song Style data value : " + list[i]);
//				elementUtil.selectTypeOfValueFromTableAndScrollTillElement(typeOfSongStyleQuestionLocator, list[i]);
//				selectedSongStyle.add(list[i]);
//				if (i == 1) {
//					break; // Stop the loop when i reaches 2
//				}
//
//			}
//
//		}
//		elementUtil.setZoom(driver, "100%");
//	}

	public void selectSongStyle(String listValue) {
	    String[] list = listValue.split(",");
	    elementUtil.waitForPageLoad();
	    elementUtil.explicitWait(typeOfSongStyleQuestionLocator);
	    elementUtil.setZoom(driver, "55%");
	    elementUtil.scrollToElement(driver, typeOfMoodQuestionLocator);

	    System.out.println("SongStyle size is : " + (list.length));
	    int selectedCount = 0;
	    for (String style : list) {
	        style = style.trim();
	        System.out.println("SongStyle value: " + style);
	        boolean valueSelected = elementUtil.selectTypeOfValueFromTableSpotify(typeOfSongStyleQuestionLocator, style);
	        if (valueSelected) {
	            selectedSongStyle.add(style);
	            selectedCount++;
	            if (selectedCount >= 2) {
	                break;
	            }
	        }
	    }

	    elementUtil.setZoom(driver, "100%");
	}
	public void selectInsturmentsUsedOnSong(String listValue) {
		String[] list = listValue.split(",");
		elementUtil.waitForPageLoad();
		elementUtil.explicitWait(typeOfInstrumentsUsedInSongLocator);
		elementUtil.setZoom(driver, "40%");
		elementUtil.scrollToElement(driver, isThisACoverChecBoxLocator);
		//
		for (int i = 0; i < list.length; i++) {
			System.out.println("Instruments used data value : " + list[i]);
			elementUtil.waitForPageLoad();
			elementUtil.selectTypeOfValueFromTableWithOutScrollTillElement(typeOfInstrumentsUsedInSongLocator, list[i]);
			selectedInsturmentUsedInSong.add(list[i].trim());

		}
		elementUtil.setZoom(driver, "100%");
	}

	public void selectCheckBoxForIsThisACover(String checkBoxValue) {
		elementUtil.setZoom(driver, "40%");
		elementUtil.scrollToElement(driver, isThisACoverChecBoxLocator);
		elementUtil.selectTypeOfValueFromTableUsingTextWithOutScrollTillElement(isThisACoverChecBoxLocator,
				checkBoxValue);
		elementUtil.setZoom(driver, "100%");
	}

	public void selectCheckBoxForIsItRemix(String checkBoxValue) {
		elementUtil.setZoom(driver, "55%");
		elementUtil.scrollToElement(driver, isThisACoverChecBoxLocator);
		elementUtil.selectTypeOfValueFromTableUsingTextWithOutScrollTillElement(isItRemixChecBoxLocator, checkBoxValue);
		elementUtil.setZoom(driver, "100%");
	}

	public void selectCheckBoxForHowWasItRecorded(String checkBoxValue) {
		elementUtil.setZoom(driver, "55%");
		elementUtil.waitForPageLoad();
		elementUtil.scrollToElement(driver, isThisACoverChecBoxLocator);
		elementUtil.selectTypeOfValueFromTableUsingTextWithOutScrollTillElement(howWasItRecorededChecBoxLocator,
				checkBoxValue);
		elementUtil.setZoom(driver, "100%");
	}

	public void selectCheckBoxForIsItAnInstrumental(String checkBoxValue) {
		elementUtil.setZoom(driver, "55%");
		elementUtil.scrollToElement(driver, isThisACoverChecBoxLocator);
		elementUtil.selectTypeOfValueFromTableUsingTextWithOutScrollTillElement(isItAnInstrumentalChecBoxLocator,
				checkBoxValue);
		elementUtil.setZoom(driver, "100%");
	}

	public void selectLanguages(String languageListValue) {
		try {
			WebElement languagesElement = driver.findElement(whatLanguagesAreTheLyricsInTextLocator);
			if (!languagesElement.isDisplayed()) {
				System.out.println(
						"*********Option to select language (element) is not found, so not selecting any value");
				return;
			}

			String[] list = languageListValue.split("[,\\s]+");
			elementUtil.waitForPageLoad();
			elementUtil.scrollToElement(driver, chooseGeneresInputLocator);

			System.out.println("language value size is : " + list.length);

			for (String language : list) {
				System.out.println("language value: " + language);
				elementUtil.waitForPageLoad();
				elementUtil.sendText(chooseLanguagesInputLocator, language);
				elementUtil.selectTypeOfValueFromTableUsingTextWithOutScrollTillElement(locationSuggestionLocator,
						language);
				selectedLanguage.add(language);

				if (selectedLanguage.size() == 3) {
					System.out.println("We can Choose up to 3 language only hence only selecting 3 language");
					break; // Stop the loop when 3 languages are selected
				}
			}

			elementUtil.setZoom(driver, "100%");
		} catch (NoSuchElementException e) {
			System.out.println("*********Option to select language (element) is not found, so not selecting any value");
		}
	}

	public void enterDescriptionValue(String descriptionValue) {
		elementUtil.sendText(descriptionTextAreaLocator, descriptionValue);
	}

	public boolean verifyTagNameAndTagValueOfYourResponsesSection(String tagName, String tagValue) {
		elementUtil.setZoom(driver, "55%");
		elementUtil.waitForPageLoad();

		WebElement tagElement = driver
				.findElement(By.xpath("//table//th[contains(text(),'" + tagName + "')]/following-sibling::td/span"));
		elementUtil.scrollToElement(tagElement);

		String actualTagValue = tagElement.getText().trim();
		if (actualTagValue.isEmpty()) {
			actualTagValue = tagElement.getAttribute("innerHTML").trim();
		}
		elementUtil.setZoom(driver, "100%");
		System.out.println("Value feched from website for tagName:" + actualTagValue);
		return actualTagValue.equals(tagValue);

	}

//	public boolean verifyLanguageOfLyrics(String tagName) {
//		elementUtil.setZoom(driver, "55%");
//		boolean isPresent = false;
//		elementUtil.waitForPageLoad();
//		WebElement tagElement = driver
//				.findElement(By.xpath("//table//th[contains(text(),'" + tagName + "')]/following-sibling::td"));
//		elementUtil.scrollToElement(tagElement);
//		String value = tagElement.getText().trim();
//		String[] genres = value.split("[,\\s]+");
//
//		if (Arrays.asList(genres).containsAll(selectedLanguage)) {
//			isPresent = true;
//			System.out.println("Language of lyrics value is matching with the data enterd");
//
//		}
//		elementUtil.setZoom(driver, "55%");
//		return isPresent;
//
//	}
//	
//	public boolean verifyInsturmentUsedInSong(String tagName) {
//		elementUtil.setZoom(driver, "55%");
//		boolean isPresent = false;
//		elementUtil.waitForPageLoad();
//		WebElement tagElement = driver
//				.findElement(By.xpath("//table//th[contains(text(),'" + tagName + "')]/following-sibling::td"));
//		elementUtil.scrollToElement(tagElement);
//		String value = tagElement.getText().trim();
//		String[] genres = value.split("[,\\s]+");
//
//		if (Arrays.asList(genres).containsAll(selectedInsturmentUsedInSong)) {
//			isPresent = true;
//			System.out.println("Language of lyrics value is matching with the data enterd");
//
//		}
//		elementUtil.setZoom(driver, "55%");
//		return isPresent;
//
//	}

	private boolean verifyTagValues(String tagName, List<String> selectedValues) {
		elementUtil.setZoom(driver, "55%");
		elementUtil.waitForPageLoad();

		WebElement tagElement = driver
				.findElement(By.xpath("//table//th[contains(text(),'" + tagName + "')]/following-sibling::td"));
		elementUtil.scrollToElement(tagElement);

		String value = tagElement.getText().trim();
		String[] tagValues = value.split(",\\s*");


		boolean isPresent = Arrays.asList(tagValues).containsAll(selectedValues);

		if (isPresent) {
			 System.out.println(tagName + " values matches with the entered data: " + selectedValues);
		}

		elementUtil.setZoom(driver, "100%");

		return isPresent;
	}

	public boolean verifyLanguageOfLyrics(String tagName) {
		return verifyTagValues(tagName, selectedLanguage);
	}

	public boolean verifyInsturmentUsedInSong(String tagName) {
		return verifyTagValues(tagName, selectedInsturmentUsedInSong);
	}

	public boolean verifySelectedGenreList(String tagName) {
		return verifyTagValues(tagName, selectedGenreList);
	}

	public boolean verifySelectedMusicCultureList(String tagName) {
		return verifyTagValues(tagName, selectedMusicCultureList);
	}

	public boolean verifySelectedMoodsList(String tagName) {
		return verifyTagValues(tagName, selectedMoodsList);
	}

	public boolean verifySelectedSongStyle(String tagName) {
		return verifyTagValues(tagName, selectedSongStyle);
	}

	public boolean verifyArtistTagNameAndTagValue(String tagName, String tagValue) {
		elementUtil.setZoom(driver, "55%");
		elementUtil.waitForPageLoad();

		elementUtil.clickElementWithJavaScript(driver.findElement(artistInfoExpandArrowButtonLocator));

//		WebElement artistNameElement = driver.findElement(By
//				.cssSelector("div.sc-cd263b9-0.bXFeGc p[data-encore-id='type'].Type__TypeElement-sc-goli3j-0.eXwACM"));
		WebElement artistNameElement = driver.findElement(By
				.cssSelector("div.sc-cd263b9-0 p[data-encore-id='type'].Type__TypeElement-sc-goli3j-0"));
		elementUtil.scrollToElement(artistNameElement);

		String artistName = artistNameElement.getText().trim();
		String actualTagValue = artistName.isEmpty() ? artistNameElement.getAttribute("innerHTML").trim() : artistName;

		System.out.println("Artist Name: " + artistName);
		System.out.println("Value fetched from website for tagName: " + actualTagValue);

		elementUtil.setZoom(driver, "100%");

		return actualTagValue.equals(tagValue);
	}

}
