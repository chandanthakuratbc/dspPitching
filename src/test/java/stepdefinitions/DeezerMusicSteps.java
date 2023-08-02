package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.DeezerMusicPage;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeezerMusicSteps {
	private DeezerMusicPage deezerMusicPage = new DeezerMusicPage(DriverFactory.getDriver());
	private static String title;
	private ConfigReader configReader;
	Properties prop;
	Properties appleProp;
	Properties deezerProp;
	ExcelReader excelReader;
	private String excelPathAndName = "./src/test/resources/testData/SignUpTestData.xlsx";
	String deezerPressShotOrTheArtistDoc = "./src/test/resources/testData/testDocument.docx";

	private String expectedTitleOfDeezerPage = "Deezer Label Pitching Form";
	private String labelSubmissionPriority = "Label submission priority";

	private String dateFormat = "yyyy/mm/dd";
	private String timeOfRelease = "00:00 AM";

	private String releaseDate;
	private String upcEan;
	private String artistName;
	private String contentTitle;
	private String kindOfContent;
	private String deezerPrimaryGenre;
	private String deezerAdditionalGenres;
	private String deezerSubGenres;
	private String listenLink;
	private String genderOnDeezer;
	private String filePathForPressShotOrTheArtistOnDeezer;
	private String focusTrackOnDeezer;
	private String artistInfoOnDeezer;
	private String marketingDetailsOnDeezer;

	public DeezerMusicSteps() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		appleProp = configReader.init_appleProp();
		deezerProp = configReader.init_deezerProp();
		excelReader = new ExcelReader();

	}

	@Given("user is on Google form singin Page")
	public void user_is_on_google_form_singin_page() {
		DriverFactory.getDriver().get(prop.getProperty("deezerMusicUrl"));
		title = deezerMusicPage.getGoogleLoginPageTitle();
		System.out.println("User is on: " + title);
	}

	@When("user gets the title of the Google form singin page")
	public void user_gets_the_title_of_the_google_form_singin_page() throws InterruptedException {
		Thread.sleep(2000);
		title = deezerMusicPage.getGoogleLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("verify form page title should be {string}")
	public void verify_form_page_title_should_be(String expectedTitleName) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@When("user enter {string} gmail Email Address on google form")
	public void user_enter_gmail_email_address_on_google_form(String emailID) throws InterruptedException {
		Thread.sleep(2000);
		deezerMusicPage.enterGmailUserName(emailID);
		Thread.sleep(1000);
	}

	@When("user click on next btn on gmail login page")
	public void user_click_on_next_btn_on_gmail_login_page() {
		deezerMusicPage.clickOnUserIDPageNextBtn();
	}

	@When("user enter {string} on google form password page")
	public void user_enter_on_google_form_password_page(String gmailPassword) throws InterruptedException {
		Thread.sleep(3000);
		deezerMusicPage.enterGmailUserPassword(gmailPassword);
		Thread.sleep(3000);
	}

	@When("user click on next btn on gmail password page")
	public void user_click_on_next_btn_on_gmail_password_page() throws InterruptedException {
		deezerMusicPage.clickOnPasswordPageNextBtn();
	}

	@When("click on continue to google account link if displayed")
	public void click_on_continue_to_google_account_link_if_displayed() {
		deezerMusicPage.clickOnContinueToYourGoogleAccountLink();
	}

	@When("user gets the title of the Google form page")
	public void user_gets_the_title_of_the_google_form_page() {
		title = deezerMusicPage.getGoogleLoginPageTitle();
		System.out.println("User is on: " + title);
	}

	@When("user enter {string} under Your email inputBox of Deeser Music Page")
	public void user_enter_under_your_email_input_box_of_deeser_music_page(String emailAddress) {
		deezerMusicPage.enterEmailOnDeezerPitchingForm(emailAddress);
	}

	@When("user click on next btn on Deezer music page")
	public void user_click_on_next_btn_on_deezer_music_page() {
		deezerMusicPage.clickOnDeezerPageNextBtn();
	}

	@When("user enter {string} under Distributor inputBox of Deeser Music Page")
	public void user_enter_under_distributor_input_box_of_deeser_music_page(String distributorName) {
		deezerMusicPage.enterDistributorNameOnDeezerPage(distributorName);
	}

	@When("user enter {string} under Label name inputBox of Deeser Music Page")
	public void user_enter_under_label_name_input_box_of_deeser_music_page(String labelName) {
		deezerMusicPage.enterLabelNameOnDeezerPage(labelName);
	}

	@When("user enter {string} under Release date inputBox in {string} format of Deeser Music Page")
	public void user_enter_under_release_date_input_box_in_format_of_deeser_music_page(String dateValue,
			String dateFormat) {
		deezerMusicPage.enterReleaseDate(dateValue, dateFormat);
	}

	@When("user enter {string} under UPC inputBox of Deeser Music Page")
	public void user_enter_under_upc_input_box_of_deeser_music_page(String upcID) {
		deezerMusicPage.enterUpcId(upcID);
	}

	@When("user enter {string} under Name of the artist inputBox of Deeser Music Page")
	public void user_enter_under_name_of_the_artist_input_box_of_deeser_music_page(String artistName) {
		deezerMusicPage.enterNameOfTheArtist(artistName);
	}

	@When("user enter {string} under Name of the release \\(track title as will be distributed) inputBox of Deeser Music Page")
	public void user_enter_under_name_of_the_release_track_title_as_will_be_distributed_input_box_of_deeser_music_page(
			String nameOfRelease) {
		deezerMusicPage.enterNameOfTheRelease(nameOfRelease);
	}

	@When("user select {string} under Priority dropDown of Deeser Music Page")
	public void user_select_under_priority_drop_down_of_deeser_music_page(String priority) {
		deezerMusicPage.selectPriorityFromDropDown(priority);
	}

	@When("user select {string} under Kind of content checkbox of Deeser Music Page")
	public void user_select_under_kind_of_content_checkbox_of_deeser_music_page(String contentType) {
		deezerMusicPage.selectContentTypeCheckbox(contentType);
	}

	@When("user select {string} under Main genre dropDown of Deeser Music Page")
	public void user_select_under_main_genre_drop_down_of_deeser_music_page(String mainGenre) {
		deezerMusicPage.selectMainGenreFromDropDown(mainGenre);
	}

	@When("user enter {string} under Listen link inputBox of Deeser Music Page")
	public void user_enter_under_listen_link_input_box_of_deeser_music_page(String listeningLink) {
		deezerMusicPage.enterListeningLink(listeningLink);
	}

	@When("user enter {string} under Time of release inputBox of Deeser Music Page")
	public void user_enter_under_time_of_release_input_box_of_deeser_music_page(String timeValue) {
		deezerMusicPage.selectTimeOfRelease(timeValue);
	}

	@When("user select {string} under Gender checkbox of Deeser Music Page")
	public void user_select_under_gender_checkbox_of_deeser_music_page(String gender) {
		deezerMusicPage.selectGenderFromCheckBox(gender);
	}

	@When("user upload file from path {string} by clicking Add file button of Press shot or the artist if provided")
	public void user_upload_file_from_path_by_clicking_add_file_button_of_press_shot_or_the_artist_if_provided(
			String filePath) {
		deezerMusicPage.UploadFileFromPressShotOrTheArtist(filePath);
	}

	@When("user enter {string} under Secondary Genre dropDown of Deeser Music Page")
	public void user_enter_under_secondary_genre_drop_down_of_deeser_music_page(String additionalGenres) {
		deezerMusicPage.selectSecondaryGenre(additionalGenres);
	}

	@When("user enter {string} under Subgenre input box of Deeser Music Page")
	public void user_enter_under_subgenre_input_box_of_deeser_music_page(String subGenre) {
		deezerMusicPage.enterSubGenre(subGenre);
	}

	@When("user enter {string} under Focus track inputBox of Deeser Music Page only if {string} release is an album or an EP.")
	public void user_enter_under_focus_track_input_box_of_deeser_music_page_only_if_release_is_an_album_or_an_ep(
			String focusTrack, String kindOfContent) {
		deezerMusicPage.enterFocusTrackIfRelaseIsAnAlbum(focusTrack, kindOfContent);
	}

	@When("user enter {string} under Artist info inputBox of Deeser Music Page")
	public void user_enter_under_artist_info_input_box_of_deeser_music_page(String artistInfo) {
		deezerMusicPage.enterArtistInfo(artistInfo);
	}

	@When("user enter {string} under Marketing details inputBox of Deeser Music Page")
	public void user_enter_under_marketing_details_input_box_of_deeser_music_page(String marketingDetails) {
		deezerMusicPage.enterMarketingDetails(marketingDetails);
	}

	@When("user click on Submit button")
	public void user_click_on_submit_button() {
		deezerMusicPage.clickOnSubmitButton();
	}

	@When("user fills the DeezerMusic Form from given sheetName {string} and rowNumber {int}")
	public void user_fills_the_deezer_music_form_from_given_sheet_name_and_row_number(String sheetName,
			Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		fillDeezerMusicData(sheetName, rowNumber);
	}

	public void fillDeezerMusicData(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, IOException {
		getTestData(sheetName, rowNumber);
		user_enter_gmail_email_address_on_google_form(deezerProp.getProperty("gmailEmailId"));
		user_click_on_next_btn_on_gmail_login_page();
		user_enter_on_google_form_password_page(deezerProp.getProperty("gmailEmailPassword"));
		user_click_on_next_btn_on_gmail_password_page();
		click_on_continue_to_google_account_link_if_displayed();
		user_gets_the_title_of_the_google_form_page();
		verify_form_page_title_should_be(expectedTitleOfDeezerPage);
		user_enter_under_your_email_input_box_of_deeser_music_page(prop.getProperty("yourBusinessEmail"));
		user_click_on_next_btn_on_deezer_music_page();
		user_enter_under_distributor_input_box_of_deeser_music_page(prop.getProperty("distributorName"));
		user_enter_under_label_name_input_box_of_deeser_music_page(prop.getProperty("label"));
		user_enter_under_release_date_input_box_in_format_of_deeser_music_page(releaseDate, dateFormat);
		user_enter_under_upc_input_box_of_deeser_music_page(upcEan);
		user_enter_under_name_of_the_artist_input_box_of_deeser_music_page(artistName);
		user_enter_under_name_of_the_release_track_title_as_will_be_distributed_input_box_of_deeser_music_page(
				contentTitle);
		user_select_under_priority_drop_down_of_deeser_music_page(labelSubmissionPriority);
		user_select_under_kind_of_content_checkbox_of_deeser_music_page(kindOfContent);
		user_select_under_main_genre_drop_down_of_deeser_music_page(deezerPrimaryGenre);
		user_enter_under_listen_link_input_box_of_deeser_music_page(listenLink);
		user_enter_under_time_of_release_input_box_of_deeser_music_page(timeOfRelease);
		user_select_under_gender_checkbox_of_deeser_music_page(genderOnDeezer);
		user_click_on_next_btn_on_deezer_music_page();
		user_upload_file_from_path_by_clicking_add_file_button_of_press_shot_or_the_artist_if_provided(
				filePathForPressShotOrTheArtistOnDeezer);
		user_enter_under_secondary_genre_drop_down_of_deeser_music_page(deezerAdditionalGenres);
		user_enter_under_subgenre_input_box_of_deeser_music_page(deezerSubGenres);
		user_enter_under_focus_track_input_box_of_deeser_music_page_only_if_release_is_an_album_or_an_ep(focusTrackOnDeezer, kindOfContent);
		user_enter_under_artist_info_input_box_of_deeser_music_page(artistInfoOnDeezer);
		user_enter_under_marketing_details_input_box_of_deeser_music_page(marketingDetailsOnDeezer);
	}

	private void getTestData(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		List<Map<String, String>> testData = excelReader.getData(excelPathAndName, sheetName);

		releaseDate = testData.get(rowNumber).get("releaseDate");
		upcEan = testData.get(rowNumber).get("upcEan");
		artistName = testData.get(rowNumber).get("artistName");
		contentTitle = testData.get(rowNumber).get("contentTitle");
		kindOfContent = testData.get(rowNumber).get("kindOfContentInDeezer");
		deezerPrimaryGenre = testData.get(rowNumber).get("deezerPrimaryGenre");
		deezerAdditionalGenres = testData.get(rowNumber).get("deezerAdditionalGenres");
		deezerSubGenres = testData.get(rowNumber).get("deezerSubGenres");
		listenLink = testData.get(rowNumber).get("listenLink");
		genderOnDeezer = testData.get(rowNumber).get("genderOnDeezer");
		filePathForPressShotOrTheArtistOnDeezer = testData.get(rowNumber)
				.get("filePathForPressShotOrTheArtistOnDeezer");
		focusTrackOnDeezer = testData.get(rowNumber).get("focusTrackOnDeezer");
		artistInfoOnDeezer = testData.get(rowNumber).get("artistInfoOnDeezer");
		marketingDetailsOnDeezer = testData.get(rowNumber).get("marketingDetailsOnDeezer");

	}

}
