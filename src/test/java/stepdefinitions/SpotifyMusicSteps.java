package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.SpotifyMusicPage;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpotifyMusicSteps {
	private SpotifyMusicPage spotifyMusicPage = new SpotifyMusicPage(DriverFactory.getDriver());
	private static String title;

	private ConfigReader configReader;
	Properties prop;
	Properties appleProp;
	Properties spotifyProp;
	ExcelReader excelReader;
	private String excelPathAndName = "./src/test/resources/testData/SignUpTestData.xlsx";
	String spotifyPressShotOrTheArtistDoc = "./src/test/resources/testData/testDocument.docx";

	private String expectedTitleOfspotifyPage = "Spotify for Artists";
	private String expectedTitleOfspotifyFinalPage = "Step 5 of 5 - Review";
	private String songTaskString = "Pitch a song";

	private String hometownOnSpotify;
	
	private String artistName;

	private String threeGeneresForSPotify;

	private String spotifyPrimaryGenre;
	private String moodsForSpotify;
	private String songStyle;
	private String whatInstumentsUsed;

	private String spotifyIsThisACover;
	private String spotifyIsThisARemix;
	private String spotifyHowWasItRecorded;
	private String spotifyIsItAnInstrumental;
	private String spotifyLanguages;
	private String marketingDetailsOnDeezer;

	public SpotifyMusicSteps() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		appleProp = configReader.init_appleProp();
		spotifyProp = configReader.init_spotifyProp();
		excelReader = new ExcelReader();

	}

	@Given("user is on Spotify Music Page")
	public void user_is_on_Spotify_music_page() {
		DriverFactory.getDriver().get(prop.getProperty("spotifyMusicURl"));
		title = spotifyMusicPage.getLandingPageTitle();
		System.out.println("User is on: " + title);
	}

	@Then("page title should be {string} of Spotify Music Page")
	public void page_title_should_be_of_spotify_music_page(String string) throws InterruptedException {
		Thread.sleep(2000);
		title = spotifyMusicPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@When("user enters Email or username {string} on SpotifyMusic login page")
	public void user_enters_email_or_username_on_spotify_music_login_page(String emailAddress) {
		spotifyMusicPage.enterSpotifyEmailOrUserName(emailAddress);
	}

	@When("user enters password {string} on SpotifyMusic login page")
	public void user_enters_password_on_spotify_music_login_page(String password) {
		spotifyMusicPage.enterSpotifyUserPassword(password);
	}

	@When("user click on Log In button on SpotifyMusic login page")
	public void user_click_on_log_in_button_on_spotify_music_login_page() {
		spotifyMusicPage.clickOnLoginBtn();
	}

	@Then("user should navigate to {string} of Spotify Music Page")
	public void user_should_navigate_to_of_spotify_music_page(String expectedTitleName) throws InterruptedException {
		String pagetitle = spotifyMusicPage.getLandingPageTitle();
		System.out.println("User is on: " + pagetitle);
		Thread.sleep(1000);
		Assert.assertTrue(pagetitle.contains(expectedTitleName));
	}

	@When("user search with {string} click on Pitch a song next to it.")
	public void user_search_with_click_on_pitch_a_song_next_to_it(String artistName) {
		spotifyMusicPage.searchForArtistAndClickOnPitchAsPerStatus(artistName, songTaskString);
	}

	@When("check if Choose a song to pitch is selected if not then select")
	public void check_if_choose_a_song_to_pitch_is_selected_if_not_then_select() {
		spotifyMusicPage.checkChooseA_SongToPitchIsSelected();
	}

	@When("user click on Next Btn on Spotify Music Page")
	public void user_click_on_next_btn_on_spotify_music_page() throws InterruptedException {
		spotifyMusicPage.clickOnNextBtn();
	}

	@When("user update {string} for artist is from on Spotify Music Page")
	public void user_update_for_artist_is_from_on_spotify_music_page(String homeTown) {
		spotifyMusicPage.selectHomeTownOfArtist(homeTown);
	}

	@When("user select {string} under Choose up to 3genres questionBox on Spotify Music Page")
	public void user_select_under_choose_up_to_3genres_question_box_on_spotify_music_page(String generes) {
		spotifyMusicPage.selectGeneresUnderChooseUpToThreeGenres(generes);
	}

	@When("user select {string} under Choose music cultures on Spotify Music Page")
	public void user_select_under_choose_music_cultures_on_spotify_music_page(String musicCulture) {
		spotifyMusicPage.selectTypeOfMusicCulturelGenre(musicCulture);
	}

	@When("user select {string} under Choose moods questionBox on Spotify Music Page")
	public void user_select_under_choose_moods_question_box_on_spotify_music_page(String moodValue) {
		spotifyMusicPage.selectMoodValue(moodValue);
	}

	@When("user select {string} under Choose song styles questionBox on Spotify Music Page")
	public void user_select_under_choose_song_styles_question_box_on_spotify_music_page(String songStyle) {
		spotifyMusicPage.selectSongStyle(songStyle);
	}

	@When("user select {string} under Choose What instruments are on this song questionBox on Spotify Music Page")
	public void user_select_under_choose_what_instruments_are_on_this_song_question_box_on_spotify_music_page(
			String instrumentsUsed) {
		spotifyMusicPage.selectInsturmentsUsedOnSong(instrumentsUsed);
	}

	@When("user select {string} under Is this a cover checkbox on Spotify Music Page.")
	public void user_select_under_is_this_a_cover_checkbox_on_spotify_music_page(String checkBoxValue) {
		spotifyMusicPage.selectCheckBoxForIsThisACover(checkBoxValue);
	}

	@When("user select {string} under Is it a Remix  checkbox on Spotify Music Page.")
	public void user_select_under_is_it_a_remix_checkbox_on_spotify_music_page(String checkBoxValue) {
		spotifyMusicPage.selectCheckBoxForIsItRemix(checkBoxValue);
	}

	@When("user select {string} under How was it recorded checkbox on Spotify Music Page")
	public void user_select_under_how_was_it_recorded_checkbox_on_spotify_music_page(String checkBoxValue) {
		spotifyMusicPage.selectCheckBoxForHowWasItRecorded(checkBoxValue);
	}

	@When("user select {string} under Is it an instrumental checkbox on Spotify Music Page.")
	public void user_select_under_is_it_an_instrumental_checkbox_on_spotify_music_page(String checkBoxValue) {
		spotifyMusicPage.selectCheckBoxForIsItAnInstrumental(checkBoxValue);
	}

	@When("user select {string} under What languages are the lyrics in? if dispalyed on Spotify Music Page.")
	public void user_select_under_what_languages_are_the_lyrics_in_if_dispalyed_on_spotify_music_page(
			String languageListValue) {
		spotifyMusicPage.selectLanguages(languageListValue);
	}

	@When("user enter {string} under Description input box on Spotify Music Page.")
	public void user_enter_under_description_input_box_on_spotify_music_page(String descriptionValue) {
		spotifyMusicPage.enterDescriptionValue(descriptionValue);
	}

	@Then("verify if value is {string} for {string} tagName under Your responses on SpotifyMusic page")
	public void verifyTagValueUnderYourResponsesOnSpotifyMusicPage(String tagValue, String tagName) {
		boolean isValueMatching = spotifyMusicPage.verifyTagNameAndTagValueOfYourResponsesSection(tagName, tagValue);
		Assert.assertTrue(isValueMatching);

		System.out.println("Verifying if " + tagName + " has the value " + tagValue);
	}

//	@Then("verify if value is languages for {string} tagName under Your responses on SpotifyMusic page")
//	public void verify_if_value_is_languages_for_tag_name_under_your_responses_on_spotify_music_page(String tagName) {
//		Assert.assertTrue(spotifyMusicPage.verifyLanguageOfLyrics(tagName));
//		System.out.println("verify if value of languages maching with " + tagName);
//
//	}

	@Then("verify if value for languages and {string} tagName under Your responses on SpotifyMusic page")
	public void verify_if_value_for_languages_and_tag_name_under_your_responses_on_spotify_music_page(String tagName) {
		Assert.assertTrue(spotifyMusicPage.verifyLanguageOfLyrics(tagName));
		System.out.println("verify if value of languages maching with " + tagName);
	}

//	@Then("verify if value is languages for {string} tagName under Your responses on SpotifyMusic page")
//	public void verify_if_value_is_languages_for_tag_name_under_your_responses_on_spotify_music_page(String tagName) {
//		Assert.assertTrue(spotifyMusicPage.verifyLanguageOfLyrics(tagName));
//		System.out.println("verify if value of languages maching with " + tagName);
//
//	}
//	
	@Then("verify if value for Instruments and {string} tagName under Your responses on SpotifyMusic page")
	public void verify_if_value_for_instruments_and_tag_name_under_your_responses_on_spotify_music_page(
			String tagName) {
		Assert.assertTrue(spotifyMusicPage.verifyInsturmentUsedInSong(tagName));
		System.out.println("verify if selected value  maching with " + tagName);
	}

	@Then("verify if value for Selected Genres and {string} tagName under Your responses on SpotifyMusic page")
	public void verify_if_value_for_selected_genres_and_tag_name_under_your_responses_on_spotify_music_page(
			String tagName) {
		Assert.assertTrue(spotifyMusicPage.verifySelectedGenreList(tagName));
		System.out.println("verify if selected value  maching with " + tagName);
	}

	@Then("verify if value for Music cultures and {string} tagName under Your responses on SpotifyMusic page")
	public void verify_if_value_for_music_cultures_and_tag_name_under_your_responses_on_spotify_music_page(
			String tagName) {
		Assert.assertTrue(spotifyMusicPage.verifySelectedMusicCultureList(tagName));
		System.out.println("verify if selected value  maching with " + tagName);
	}

	@Then("verify if value for Moods and {string} tagName under Your responses on SpotifyMusic page")
	public void verify_if_value_for_moods_and_tag_name_under_your_responses_on_spotify_music_page(String tagName) {
		Assert.assertTrue(spotifyMusicPage.verifySelectedMoodsList(tagName));
		System.out.println("verify if selected value  maching with " + tagName);
	}

	@Then("verify if value for Song styles and {string} tagName under Your responses on SpotifyMusic page")
	public void verify_if_value_for_song_styles_and_tag_name_under_your_responses_on_spotify_music_page(
			String tagName) {
		Assert.assertTrue(spotifyMusicPage.verifySelectedSongStyle(tagName));
		System.out.println("verify if selected value  maching with " + tagName);
	}

	@When("verify if value is {string} for {string} tagName on SpotifyMusic page")
	public void verifyArtistInfoTagValue(String artistName, String tagName) {
		// this.artistName = artistName;
		boolean isValueMatching = spotifyMusicPage.verifyArtistTagNameAndTagValue(tagName, artistName);
		Assert.assertTrue(isValueMatching);
	}

	@When("user fills the SpotifyMusic Form from given sheetName {string} and rowNumber {int}")
	public void user_fills_the_deezer_music_form_from_given_sheet_name_and_row_number(String sheetName,
			Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		fillDeezerMusicData(sheetName, rowNumber);
	}

	public void fillDeezerMusicData(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, IOException {
		getTestData(sheetName, rowNumber);
		user_enters_email_or_username_on_spotify_music_login_page(spotifyProp.getProperty("spotifyEmailAddress"));
		user_enters_password_on_spotify_music_login_page(spotifyProp.getProperty("spotifyEmailPassword"));
		user_click_on_log_in_button_on_spotify_music_login_page();
		user_should_navigate_to_of_spotify_music_page(expectedTitleOfspotifyPage);
		user_search_with_click_on_pitch_a_song_next_to_it(artistName);
		check_if_choose_a_song_to_pitch_is_selected_if_not_then_select();
		user_click_on_next_btn_on_spotify_music_page();
		user_update_for_artist_is_from_on_spotify_music_page(hometownOnSpotify);
		user_click_on_next_btn_on_spotify_music_page();
		user_select_under_choose_up_to_3genres_question_box_on_spotify_music_page(threeGeneresForSPotify);
		user_select_under_choose_music_cultures_on_spotify_music_page(spotifyPrimaryGenre);
		user_select_under_choose_moods_question_box_on_spotify_music_page(moodsForSpotify);
		user_select_under_choose_song_styles_question_box_on_spotify_music_page(songStyle);
		user_select_under_choose_what_instruments_are_on_this_song_question_box_on_spotify_music_page(
				whatInstumentsUsed);
		user_select_under_is_this_a_cover_checkbox_on_spotify_music_page(spotifyIsThisACover);
		user_select_under_is_it_a_remix_checkbox_on_spotify_music_page(spotifyIsThisARemix);
		user_select_under_how_was_it_recorded_checkbox_on_spotify_music_page(spotifyHowWasItRecorded);
		user_select_under_is_it_an_instrumental_checkbox_on_spotify_music_page(spotifyIsItAnInstrumental);
		user_select_under_what_languages_are_the_lyrics_in_if_dispalyed_on_spotify_music_page(spotifyLanguages);
		user_click_on_next_btn_on_spotify_music_page();
		user_enter_under_description_input_box_on_spotify_music_page(marketingDetailsOnDeezer);
		spotifyMusicPage.clickOnNextBtn();
		page_title_should_be_of_spotify_music_page(expectedTitleOfspotifyFinalPage);

	}

	public void verifyDataOnSubmittionPage() {
		verifyArtistInfoTagValue(artistName, spotifyProp.getProperty("artistInfoTag"));
		verifyTagValueUnderYourResponsesOnSpotifyMusicPage(hometownOnSpotify, spotifyProp.getProperty("hometownTag"));
		verifyTagValueUnderYourResponsesOnSpotifyMusicPage(hometownOnSpotify,
				spotifyProp.getProperty("currentlyBasedTag"));
		verify_if_value_for_selected_genres_and_tag_name_under_your_responses_on_spotify_music_page(
				spotifyProp.getProperty("genresTag"));
		verify_if_value_for_music_cultures_and_tag_name_under_your_responses_on_spotify_music_page(
				spotifyProp.getProperty("musicCulturesTag"));
		verify_if_value_for_moods_and_tag_name_under_your_responses_on_spotify_music_page(
				spotifyProp.getProperty("moodsTag"));
		verify_if_value_for_song_styles_and_tag_name_under_your_responses_on_spotify_music_page(
				spotifyProp.getProperty("songStylesTag"));
		verify_if_value_for_instruments_and_tag_name_under_your_responses_on_spotify_music_page(
				spotifyProp.getProperty("instrumentsTag"));

		verifyTagValueUnderYourResponsesOnSpotifyMusicPage(spotifyIsThisACover, spotifyProp.getProperty("coverTag"));
		verifyTagValueUnderYourResponsesOnSpotifyMusicPage(spotifyIsThisARemix, spotifyProp.getProperty("remixTag"));
		verifyTagValueUnderYourResponsesOnSpotifyMusicPage(spotifyHowWasItRecorded,
				spotifyProp.getProperty("recodingTag"));
		verifyTagValueUnderYourResponsesOnSpotifyMusicPage(spotifyIsItAnInstrumental,
				spotifyProp.getProperty("instrumental"));
		verify_if_value_for_languages_and_tag_name_under_your_responses_on_spotify_music_page(
				spotifyProp.getProperty("languageOfLyricsTag"));
		verifyTagValueUnderYourResponsesOnSpotifyMusicPage(marketingDetailsOnDeezer,
				spotifyProp.getProperty("descriptionTag"));
	}

	@Then("verify all updated data on Review page")
	public void verify_all_updated_data_on_review_page() {
		verifyDataOnSubmittionPage();
	}

	private void getTestData(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelReader.getData(excelPathAndName, sheetName);
		artistName = testData.get(rowNumber).get("artistName");
		hometownOnSpotify = testData.get(rowNumber).get("hometownOnSpotify");
		threeGeneresForSPotify = testData.get(rowNumber).get("3GeneresForSPotify");
		spotifyPrimaryGenre = testData.get(rowNumber).get("spotifyPrimaryGenre");
		moodsForSpotify = testData.get(rowNumber).get("moods");
		songStyle = testData.get(rowNumber).get("songStyle");
		whatInstumentsUsed = testData.get(rowNumber).get("whatInstumentsUsed");
		spotifyIsThisACover = testData.get(rowNumber).get("spotifyIsThisACover");
		spotifyIsThisARemix = testData.get(rowNumber).get("spotifyIsThisARemix");
		spotifyHowWasItRecorded = testData.get(rowNumber).get("spotifyHowWasItRecorded");
		spotifyIsItAnInstrumental = testData.get(rowNumber).get("spotifyIsItAnInstrumental");
		spotifyLanguages = testData.get(rowNumber).get("spotifyLanguages");
		marketingDetailsOnDeezer = testData.get(rowNumber).get("marketingDetailsOnDeezer");

	}
}
