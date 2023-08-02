Feature: Deezer music page

  @deezerMusic @dp-01
  Scenario Outline: Update data on Deezer music page using excel sheet
  Given user is on Google form singin Page
  When user gets the title of the Google form singin page
  Then verify form page title should be "Google Forms: Sign-in"
  When user fills the DeezerMusic Form from given sheetName "<SheetName>" and rowNumber <RowNumber>
  #And user click on Submit button
  Examples:
  | SheetName | RowNumber |
  | Sheet1 | 0 |
  
	@dp-02
  Scenario Outline: Update data on Deezer music page
  Given user is on Google form singin Page
  When user gets the title of the Google form singin page
  Then verify form page title should be "Google Forms: Sign-in"
  When user enter <gmailEmailAddress> gmail Email Address on google form
  And user click on next btn on gmail login page
  And user enter <gmailEmailPassword> on google form password page
  And user click on next btn on gmail password page
  And click on continue to google account link if displayed
  And user gets the title of the Google form page
  Then verify form page title should be "Deezer Label Pitching Form"
  When user enter <yourBusinessEmail> under Your email inputBox of Deeser Music Page
  And user click on next btn on Deezer music page
  And user enter <distributorName> under Distributor inputBox of Deeser Music Page
  And user enter <label> under Label name inputBox of Deeser Music Page
  And user enter <releaseDate> under Release date inputBox in "yyyy/mm/dd" format of Deeser Music Page
  And user enter <upcEan> under UPC inputBox of Deeser Music Page
  And user enter <artistName> under Name of the artist inputBox of Deeser Music Page
  And user enter <contentTitle> under Name of the release (track title as will be distributed) inputBox of Deeser Music Page
  And user select "Label submission priority" under Priority dropDown of Deeser Music Page
  And user select <kindOfContentInDeezer> under Kind of content checkbox of Deeser Music Page
  And user select <deezerPrimaryGenre> under Main genre dropDown of Deeser Music Page
  And user enter <listenLink> under Listen link inputBox of Deeser Music Page
  And user enter <timeOfRelease> under Time of release inputBox of Deeser Music Page
  And user select <genderOnDeezer> under Gender checkbox of Deeser Music Page
  And user click on next btn on Deezer music page
  And user upload file from path <filePath> by clicking Add file button of Press shot or the artist if provided
  And user enter <additionalGenres> under Secondary Genre dropDown of Deeser Music Page
  And user enter <subgenre> under Subgenre input box of Deeser Music Page
  And user enter <focusTrackOnDeezer> under Focus track inputBox of Deeser Music Page only if <kindOfContentInDeezer> release is an album or an EP.
  And user enter <artistInfoOnDeezer> under Artist info inputBox of Deeser Music Page
  And user enter <marketingDetailsOnDeezer> under Marketing details inputBox of Deeser Music Page
  #And user click on Submit button
  
  Examples:
  | SheetName | RowNumber | gmailEmailAddress 								| gmailEmailPassword 		| yourBusinessEmail 					| distributorName | label 		| releaseDate 	| upcEan 			| artistName 				| contentTitle | kindOfContentInDeezer 	| deezerPrimaryGenre 	| listenLink 										| timeOfRelease | genderOnDeezer 	| filePath | additionalGenres | subgenre |focusTrackOnDeezer |artistInfoOnDeezer | marketingDetailsOnDeezer |
  | Sheet1 		| 0 				| "pitching@weareinstrumental.com" 	| "InstrumentalPitch23" | "sarah.tassew@frtyfve.com" 	| "FUGA" 					| "FRTYFVE" | "2023/04/21" 	| "58879990" 	| "Sophie Simmons" 	| "If I Could" | "Album" 								| "Arabic Music" 			| "https://we.tl/t-wLcTn4g95P" 	| "00:00 AM" 		| "Male" 					| "C:\Users\ChandanThakur\OneDrive - Blenheim Chalcot LTF Ltd\BackNew\eclipse-workspace\cucumber\DSP\src\test\resources\testData\testDocument.docx" | "Rock" | "Trax" | "Test entry for foucs track" | "Testing artist info" | "Tesingmarketing deaails" |
  
  

  
