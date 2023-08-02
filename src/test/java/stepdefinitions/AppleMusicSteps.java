package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.AppleMusicPage;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppleMusicSteps {
	private AppleMusicPage appleMusicPage = new AppleMusicPage(DriverFactory.getDriver());
	private static String title;
	private ConfigReader configReader;
	Properties prop;
	Properties appleProp;
	ExcelReader excelReader;
	private String excelPathAndName = "./src/test/resources/testData/SignUpTestData.xlsx";

	private String password;
	private String yourName;
	private String yourBusinessEmail;
	private String yourCompany;
	private String yourTerritory;
	private String territoriesToPitchTo;
	private String pitching;
	private String songType;
	private String artistName;
	private String contentTitle;
	private String appleID;
	private String upcEan;
	private String releaseDate;
	private String timedRelease;
	private String promotionDate;
	private String deliveredInDolbyAtmos;
	private String deliveredWithMotionArtwork;
	private String primaryGenre;
	private String additionalGenres;
	private String moods;
	private String label;
	private String distributorName;
	private String listenLink;
	private String releaseDetails;
	private String pitchingFor;
	private String playbookPromotion;


	private String headerText = "Keep our editorial teams up to date with your releases.";
	private String headerTextOfContentDetails = "Content Details";
	private String headerTextOfSummaryPage = "Summary";

	private String dateFormat = "yyyy/mm/dd";

	public AppleMusicSteps() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		appleProp = configReader.init_appleProp();
		excelReader = new ExcelReader();

	}

	private void getTestData(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelReader.getData(excelPathAndName, sheetName);
		password = appleProp.getProperty("password");
		yourName = prop.getProperty("yourName");
		yourBusinessEmail = prop.getProperty("yourBusinessEmail");
		yourCompany = prop.getProperty("yourCompany");
		label = prop.getProperty("label");
		distributorName = prop.getProperty("distributorName");
		
		
		yourTerritory = testData.get(rowNumber).get("yourTerritory");
		territoriesToPitchTo = testData.get(rowNumber).get("territoriesToPitchTo");
		pitching = testData.get(rowNumber).get("pitching");
		songType = testData.get(rowNumber).get("songType");

		artistName = testData.get(rowNumber).get("artistName");
		contentTitle = testData.get(rowNumber).get("contentTitle");
		appleID = testData.get(rowNumber).get("appleID");
		upcEan = testData.get(rowNumber).get("upcEan");
		releaseDate = testData.get(rowNumber).get("releaseDate");
		timedRelease = testData.get(rowNumber).get("timedRelease");
		promotionDate = testData.get(rowNumber).get("promotionDate");
		deliveredInDolbyAtmos = testData.get(rowNumber).get("deliveredInDolbyAtmos");

		deliveredWithMotionArtwork = testData.get(rowNumber).get("deliveredWithMotionArtwork");
		primaryGenre = testData.get(rowNumber).get("primaryGenre");

		additionalGenres = testData.get(rowNumber).get("additionalGenres");
		moods = testData.get(rowNumber).get("moods");


		
		listenLink = testData.get(rowNumber).get("listenLink");
		releaseDetails = testData.get(rowNumber).get("releaseDetails");
		pitchingFor = testData.get(rowNumber).get("pitchingFor");
		playbookPromotion = testData.get(rowNumber).get("playbookPromotion");

	}

	public void fillAppleMusicData(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, IOException {
		getTestData(sheetName, rowNumber);
		user_enters_password(password);
		user_click_on_next_button();
		verify_if_word_display(headerText);
		user_enter_under_your_name_input_box(yourName);
		user_enter_under_your_business_email_input_box(yourBusinessEmail);
		user_enter_under_your_company_input_box(yourCompany);
		user_select_under_your_territory_drop_down(yourTerritory);
		user_select_under_Territories_to_pitch_to_question_box(territoriesToPitchTo);
		user_select_under_Pitching_question_box(pitching);
		user_click_on_next_button();
		user_should_get_header_as_on_content_details_page(headerTextOfContentDetails);
		user_select_under_type_question_box(songType);
		user_enter_under_artist_name_input_box(artistName);
		user_enter_under_content_title_input_box(contentTitle);
		user_enter_under_apple_id_input_box(appleID);
		user_enter_under_upc_ean_input_box(upcEan);
		user_enter_under_release_date_input_box_in_format(releaseDate, dateFormat);
		user_select_under_timed_release_question_box(timedRelease);
		user_enter_under_promotion_date_input_box_in_format(promotionDate, dateFormat);
		user_select_under_delivered_in_dolby_atmos_question_box(deliveredInDolbyAtmos);
		user_select_under_delivered_with_motion_artwork_question_box(deliveredWithMotionArtwork);
		user_select_under_primary_genre_question_box(primaryGenre);
		user_selects_additional_genres_as_additional_genres_under_additional_genre_question_box(additionalGenres);
		user_select_moods_under_mood_question_box_if_available(moods);
		user_enter_under_label_input_box(label);
		user_select_under_distributor_dropdwonbox(distributorName);
		user_enter_under_listen_link_input_box(listenLink);
		user_enter_under_release_details_input_box(releaseDetails);
		user_enter_under_pitching_for_input_box(pitchingFor);
		user_select_under_do_you_also_want_to_pitch_this_release_for_a_playbook_promotion_question_box(
				playbookPromotion);

		user_click_on_next_button();
		user_should_get_header_as_on_summary_page(headerTextOfSummaryPage);
	}

	public void verifyDataOnSubmittionPage() {
		verify_if_value_is_for_tag_name(yourName, appleProp.getProperty("submittedByTag"));
		verify_if_value_is_for_tag_name(yourCompany, appleProp.getProperty("fromTag"));
		verify_if_value_is_for_tag_name(pitching, appleProp.getProperty("pitchingTag"));
		verify_if_value_is_for_tag_name(songType, appleProp.getProperty("songTypeTag"));
		verify_if_value_is_for_tag_name(contentTitle, appleProp.getProperty("contentTag"));
		verify_if_value_is_for_tag_name(artistName, appleProp.getProperty("contentTag"));
		verify_if_value_is_for_tag_name(releaseDate, appleProp.getProperty("releaseDateTag"));
		verify_if_value_is_for_tag_name(timedRelease, appleProp.getProperty("timedReleaseTag"));
		verify_if_value_is_for_tag_name(appleID, appleProp.getProperty("appleIdTag"));
		verify_if_value_is_for_tag_name(deliveredInDolbyAtmos, appleProp.getProperty("dolbyAtomsTag"));
		verify_if_value_is_for_tag_name(primaryGenre, appleProp.getProperty("genreMoodTag"));

		verify_if_value_for_additional_genre_question_box_matches_under_tag_name(appleProp.getProperty("genreMoodTag"));
		verify_if_value_for_moods_question_box_matches_under_tag_name(appleProp.getProperty("genreMoodTag"));
;
		verify_if_value_is_for_tag_name(label, appleProp.getProperty("labelTag"));
		verify_if_value_is_for_tag_name(distributorName, appleProp.getProperty("distributorTag"));

		verify_if_value_is_for_tag_name(releaseDetails, appleProp.getProperty("releaseDetailsTag"));
		verify_if_value_is_for_tag_name(pitchingFor, appleProp.getProperty("pitchingForTag"));
		verify_if_value_is_for_tag_name(promotionDate, appleProp.getProperty("promotionDateTag"));
		verify_if_value_is_for_tag_name(listenLink, appleProp.getProperty("listenLinkTag"));
		verify_if_value_is_for_tag_name(yourTerritory, appleProp.getProperty("pitchingFromTag"));
		verify_if_value_is_for_tag_name(territoriesToPitchTo, appleProp.getProperty("territoriesTag"));

	}

	public void user_selects_additional_genres_as_additional_genres_under_additional_genre_question_box(
			String additionalGenres2) {
		appleMusicPage.selectAdditionalGenre(additionalGenres2);

	}

	public void user_select_moods_under_mood_question_box_if_available(String moodValue) {
		appleMusicPage.SelectMoodValue(moodValue);
	}

	@Given("user is on Apple Music Page")
	public void user_is_on_apple_music_page() {
		DriverFactory.getDriver().get(prop.getProperty("appleMusicUrl"));
		title = appleMusicPage.getLandingPageTitle();
		System.out.println("User is on: " + title);
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() throws InterruptedException {
		Thread.sleep(2000);
		title = appleMusicPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("Password inputTextBox should be displayed")
	public void password_textbox_should_be_displayed() {
		Assert.assertTrue(appleMusicPage.isPasswordDispalyed());
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		appleMusicPage.enterPassword(password);
	}

	@When("user click on next button on appleMusic login page")
	public void user_click_on_next_button() {
		appleMusicPage.clickOnNextBtn();
	}

	@When("user click on Submit Pitch button on appleMusic login page")
	public void user_click_on_submit_pitch_button_on_apple_music_login_page() {
		appleMusicPage.clickOnSubmitBtn();
	}

	@Then("user should get header as {string}")
	public void verify_if_word_display(String headerText) throws InterruptedException {
		Assert.assertTrue(appleMusicPage.verifyHeaderText().contains(headerText));
	}

	@When("user enter {string} under your name inputBox")
	public void user_enter_under_your_name_input_box(String yourName) {
		appleMusicPage.enterYourName(yourName);
	}

	@When("user enter {string} under Your business email inputBox")
	public void user_enter_under_your_business_email_input_box(String businessName) {
		appleMusicPage.enterYourBusinessEmail(businessName);
	}

	@When("user enter {string} under Your company inputBox")
	public void user_enter_under_your_company_input_box(String companyName) {
		appleMusicPage.enterCompany(companyName);
	}

	@When("user select {string} under Your territory dropDown")
	public void user_select_under_your_territory_drop_down(String value) {
		appleMusicPage.selectYourTerritory(value);
	}

	@When("user select {string} under Territories to pitch to questionBox")
	public void user_select_under_Territories_to_pitch_to_question_box(String value) {
		appleMusicPage.selectTerritoriesToPitchTo(value);
	}

	@When("user select {string} under Pitching questionBox")
	public void user_select_under_Pitching_question_box(String value) {
		appleMusicPage.selectTerritoriesToPitchTo(value);
	}

	/*
	 * Content Details page
	 */

	@Then("user should get header as {string} on Content Details page")
	public void user_should_get_header_as_on_content_details_page(String headerText) throws InterruptedException {
		Assert.assertTrue(appleMusicPage.verifyContentDetailsPageHeaderText().contains(headerText));
	}

	@When("user select {string} under Type questionBox")
	public void user_select_under_type_question_box(String value) {
		appleMusicPage.selectTypeOfSong(value);
	}

	@When("user enter {string} under Artist name inputBox")
	public void user_enter_under_artist_name_input_box(String artistName) {
		appleMusicPage.enterArtistName(artistName);
	}

	@When("user enter {string} under Content title inputBox")
	public void user_enter_under_content_title_input_box(String contentTitle) {
		appleMusicPage.enterContentTitle(contentTitle);
	}

	@When("user enter {string} under Apple ID inputBox")
	public void user_enter_under_apple_id_input_box(String appleID) {
		appleMusicPage.enterAppleId(appleID);
	}

	@When("user enter {string} under UPC\\/EAN inputBox")
	public void user_enter_under_upc_ean_input_box(String upcEanId) {
		appleMusicPage.enterupcEanId(upcEanId);
	}

	@When("user enter {string} under Release date inputBox in {string} format")
	public void user_enter_under_release_date_input_box_in_format(String dateValue, String dateFormat) {
		appleMusicPage.enterReleaseDate(dateValue, dateFormat);
	}

	@When("user select {string} under Timed release questionBox")
	public void user_select_under_timed_release_question_box(String value) {
		appleMusicPage.selectTimedRelease(value);
	}

	@When("user enter {string} under Promotion date inputBox in {string} format")
	public void user_enter_under_promotion_date_input_box_in_format(String dateValue, String dateFormat) {
		appleMusicPage.enterPromotionDate(dateValue, dateFormat);
	}

	@When("user select {string} under Delivered in Dolby Atmos questionBox")
	public void user_select_under_delivered_in_dolby_atmos_question_box(String value) {
		appleMusicPage.selectDeliveredInDolbyAtmos(value);
	}

	@When("user select {string} under Delivered with Motion Artwork questionBox")
	public void user_select_under_delivered_with_motion_artwork_question_box(String value) {
		appleMusicPage.selectDeliveredWithMotionArtwork(value);
	}

	@When("user select {string} under Primary Genre questionBox")
	public void user_select_under_primary_genre_question_box(String primaryGenre) {
		appleMusicPage.selectPrimaryGenre(primaryGenre);
	}

	@When("User selects additional genres as additionalGenres under additional genre question box")
	public void user_selects_additional_genres_as_additional_genres_under_additional_genre_question_box(
			DataTable dataTable) {
		List<String> genres = dataTable.asList(String.class);
		appleMusicPage.selectAdditionalGenre(genres);
	}

	@Then("verify if value for additional genre question box matches under {string} tagName")
	public void verify_if_value_for_additional_genre_question_box_matches_under_tag_name(String tagName) {
		Assert.assertTrue(
				appleMusicPage.verifyTagValueForGenre_MoodContainsSelectedAdditionalGenreListOnSummaryPage(tagName));
	}

	@Then("verify if value for moods question box matches under {string} tagName")
	public void verify_if_value_for_moods_question_box_matches_under_tag_name(String tagName) {
		Assert.assertTrue(appleMusicPage.verifyTagValueForGenre_MoodContainsSelectedMoodsListOnSummaryPage(tagName));
	}

	@When("user select moods under Mood questionBox if available")
	public void user_select_moods_under_mood_question_box_if_available(DataTable dataTable) {
		List<String> mood = dataTable.asList(String.class);
		appleMusicPage.selectMoodGenre(mood);
	}

	@When("user enter {string} under Label inputBox")
	public void user_enter_under_label_input_box(String label) {
		appleMusicPage.enterLabel(label);
	}

	@When("user select {string} under Distributor dropdwonbox")
	public void user_select_under_distributor_dropdwonbox(String distributorName) {
		appleMusicPage.selectDistributorFromDropDown(distributorName);
	}

	@When("user enter {string} under Listen link inputBox")
	public void user_enter_under_listen_link_input_box(String link) {
		appleMusicPage.enterListenLink(link);
	}

	@When("user enter {string} under Release details inputBox")
	public void user_enter_under_release_details_input_box(String releaseDetails) {
		appleMusicPage.enterReleaseDetails(releaseDetails);
	}

	@When("user enter {string} under Pitching For inputBox")
	public void user_enter_under_pitching_for_input_box(String pitchingFor) {
		appleMusicPage.enterPitchingFor(pitchingFor);
	}

	@When("user select {string} under Do you also want to pitch this release for a Playbook promotion? questionBox")
	public void user_select_under_do_you_also_want_to_pitch_this_release_for_a_playbook_promotion_question_box(
			String questionValue) {
		appleMusicPage.selectPlaybookPromotionQuestions(questionValue);
	}

	@Then("user should get header as {string} on Summary page")
	public void user_should_get_header_as_on_summary_page(String headerText) throws InterruptedException {
		Assert.assertTrue(appleMusicPage.verifySummaryPageHeaderText().contains(headerText));
	}

	@Then("verify if value is {string} for {string} tagName")
	public void verify_if_value_is_for_tag_name(String tagValue, String tagName) {
		Assert.assertTrue(appleMusicPage.verifyTagNameAndTagValueOnSummaryPage(tagName, tagValue).contains(tagValue));
		System.out.println("verifing if "+tagName+ " have value "+tagValue);
	}

	// fills the AppleMusic using excel sheet
	@When("user fills the AppleMusic form from given sheetName {string} and rowNumber {int}")
	public void user_fills_the_apple_music_form_from_given_sheet_name_and_row_number(String sheetName,
			Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException, IOException {
		fillAppleMusicData(sheetName, rowNumber);
	}

	@Then("verify all updated data on Summary page")
	public void verify_all_updated_data_on_summary_page() {
		verifyDataOnSubmittionPage();
	}

}
