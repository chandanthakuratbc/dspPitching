Feature: Spotify music Editorial Pitch

  @deezerMusic @sp-01
  Scenario Outline: Update data on Spotify music page using excel sheet
  Given user is on Spotify Music Page
  When user gets the title of the page
  Then page title should be "Login - Spotify" of Spotify Music Page
  When user fills the SpotifyMusic Form from given sheetName "<SheetName>" and rowNumber <RowNumber>
  Then verify all updated data on Review page
  #And user click on Pitch button to submit
  Examples:
  | SheetName | RowNumber |
  | Sheet1 | 0 |

  @SpotifyMusic @sp-02
  Scenario Outline: Update Spotify Music Editorial Pitch
  Given user is on Spotify Music Page
  When user gets the title of the page
  Then page title should be "Login - Spotify" of Spotify Music Page
  When user enters Email or username <spotifyEmailAddress> on SpotifyMusic login page
  And user enters password <spotifyEmailPassword> on SpotifyMusic login page
  And user click on Log In button on SpotifyMusic login page
  Then user should navigate to "Spotify for Artists" of Spotify Music Page
  When user search with <artistName> click on Pitch a song next to it.
  And check if Choose a song to pitch is selected if not then select
  And user click on Next Btn on Spotify Music Page
  And user update <hometown> for artist is from on Spotify Music Page
  And user click on Next Btn on Spotify Music Page
  And user select <3GeneresForSPotify> under Choose up to 3genres questionBox on Spotify Music Page
  And user select <spotifyPrimaryGenre> under Choose music cultures on Spotify Music Page
 	And user select <moods> under Choose moods questionBox on Spotify Music Page
 	And user select <songStyle> under Choose song styles questionBox on Spotify Music Page
 	And user select <whatInstumentsUsed> under Choose What instruments are on this song questionBox on Spotify Music Page
 	And user select <isThisACover> under Is this a cover checkbox on Spotify Music Page.
 	And user select <isThisARemix> under Is it a Remix  checkbox on Spotify Music Page.
 	And user select <howWasItRecorded> under How was it recorded checkbox on Spotify Music Page
  And user select <isItAnInstrumental> under Is it an instrumental checkbox on Spotify Music Page.
  And user select <languages> under What languages are the lyrics in? if dispalyed on Spotify Music Page.             
  And user click on Next Btn on Spotify Music Page 
  And user enter <marketingDetailsOnDeezer> under Description input box on Spotify Music Page.
  And user click on Next Btn on Spotify Music Page
  Then page title should be "Step 5 of 5 - Review" of Spotify Music Page
  #And verify if value is <title> for "Submitted by" tagName on SpotifyMusic page  
  And verify if value is <artistName> for "Artist info" tagName on SpotifyMusic page  
  And verify if value is <hometown> for "Hometown" tagName under Your responses on SpotifyMusic page
  And verify if value is <hometown> for "Currently based" tagName under Your responses on SpotifyMusic page
  And verify if value for Selected Genres and "Genres" tagName under Your responses on SpotifyMusic page  
	And verify if value for Music cultures and "Music cultures" tagName under Your responses on SpotifyMusic page  
	And verify if value for Moods and "Moods" tagName under Your responses on SpotifyMusic page  
	And verify if value for Song styles and "Song styles" tagName under Your responses on SpotifyMusic page
  And verify if value for Instruments and "Instruments" tagName under Your responses on SpotifyMusic page
  And verify if value is <isThisACover> for "Cover" tagName under Your responses on SpotifyMusic page
  And verify if value is <isThisARemix> for "Remix" tagName under Your responses on SpotifyMusic page
  And verify if value is <howWasItRecorded> for "Recording" tagName under Your responses on SpotifyMusic page
  And verify if value is <isItAnInstrumental> for "Instrumental" tagName under Your responses on SpotifyMusic page
  And verify if value for languages and "Language of lyrics" tagName under Your responses on SpotifyMusic page
  And verify if value is <marketingDetailsOnDeezer> for "Description" tagName under Your responses on SpotifyMusic page
  Examples:
  | spotifyEmailAddress 									| spotifyEmailPassword 	| artistName 	| title 					| hometown 													| 3GeneresForSPotify 		| spotifyPrimaryGenre	| moods 											| songStyle 			| whatInstumentsUsed 							| isThisACover 	| isThisARemix 	| howWasItRecorded 	| isItAnInstrumental 	| languages 												| marketingDetailsOnDeezer	|
  | "chandan.thakur@blenheimchalcot.com" 	| "Secure@12071989" 		| "Roofe" 		| "Call My Name" 	| "London, England, United Kingdom" | "Electronic, Ambient" | "African, Arabic"		| "Chill, Party, Motivation" 	| "Kids, Beats" 	| "Tabla, Bass Guitar, Drum Kit" 	| "No" 					| "No" 					| "Studio" 					| "No" 								| "English, Hindi, French, Spanish" | "Adding Description details for Spotify music"			|
  
  
  


 