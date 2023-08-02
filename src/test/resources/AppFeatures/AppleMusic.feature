Feature: Apple music Editorial Pitch

  @appleMusic @ap-01
  Scenario Outline: Update Apple Music Editorial Pitch
  Given user is on Apple Music Page
  When user gets the title of the page
  Then page title should be "Apple Music Editorial Pitch"
  And Password inputTextBox should be displayed
  When user fills the AppleMusic form from given sheetName "<SheetName>" and rowNumber <RowNumber>
  Then verify all updated data on Summary page
  #When user click on Submit Pitch button on appleMusic login page
  Examples:
  | SheetName | RowNumber |
  | Sheet1 | 0 |
  
  
  
  
  
  @appleMusic @ap-02
  Scenario Outline: Update Apple Music Editorial Pitch
  Given user is on Apple Music Page
  When user gets the title of the page
  Then page title should be "Apple Music Editorial Pitch"
  And Password inputTextBox should be displayed
  When user enters password <password>
  And user click on next button on appleMusic login page
  Then user should get header as "Keep our editorial teams up to date with your releases."
  When user enter <yourName> under your name inputBox
  And user enter <yourBusinessEmail> under Your business email inputBox
  And user enter <yourCompany> under Your company inputBox
  And user select <yourTerritory> under Your territory dropDown
  And user select <territoriesToPitchTo> under Territories to pitch to questionBox
  And user select <pitching> under Pitching questionBox
  And user click on next button on appleMusic login page
  Then user should get header as "Content Details" on Content Details page
  When user select <songType> under Type questionBox
  And user enter <artistName> under Artist name inputBox
  And user enter <contentTitle> under Content title inputBox
  And user enter <appleID> under Apple ID inputBox
  And user enter <upcEan> under UPC/EAN inputBox
  And user enter <releaseDate> under Release date inputBox in "yyyy/mm/dd" format
  And user select <timedRelease> under Timed release questionBox
  And user enter <promotionDate> under Promotion date inputBox in "yyyy/mm/dd" format
  And user select <deliveredInDolbyAtmos> under Delivered in Dolby Atmos questionBox
  And user select <deliveredWithMotionArtwork> under Delivered with Motion Artwork questionBox
  And user select <primaryGenre> under Primary Genre questionBox
  And User selects additional genres as additionalGenres under additional genre question box
  |Rock|
  |Classical|
  |Jazz|
  And user select moods under Mood questionBox if available
  |Chill|
  |Party|
  |Motivation|
  And user enter <label> under Label inputBox
  And user select <distributorName> under Distributor dropdwonbox
  And user enter <listenLink> under Listen link inputBox
  And user enter <releaseDetails> under Release details inputBox
  And user enter <pitchingFor> under Pitching For inputBox 
  And user select <playbookPromotion> under Do you also want to pitch this release for a Playbook promotion? questionBox
  And user click on next button on appleMusic login page   
  Then user should get header as <summary> on Summary page
  And verify if value is <yourName> for "Submitted by" tagName
  And verify if value is <yourCompany> for "From" tagName
  And verify if value is <pitching> for "Pitching" tagName  
  And verify if value is <songType> for "Type" tagName
  And verify if value is <contentTitle> for "Content" tagName
  And verify if value is <artistName> for "Content" tagName
  And verify if value is <releaseDate> for "Release Date" tagName
  And verify if value is <timedRelease> for "Timed Release" tagName
  And verify if value is <appleID> for "Apple ID" tagName
  And verify if value is <deliveredInDolbyAtmos> for "Dolby Atmos" tagName
  And verify if value is <primaryGenre> for "Genre/Mood" tagName
  And verify if value for additional genre question box matches under "Genre/Mood" tagName
  And verify if value for moods question box matches under "Genre/Mood" tagName
  And verify if value is <label> for "Label" tagName
  And verify if value is <distributorName> for "Distributor" tagName
  And verify if value is <releaseDetails> for "Release details" tagName
  And verify if value is <pitchingFor> for "Pitching for" tagName
  And verify if value is <promotionDate> for "Promotion Date" tagName
  And verify if value is <listenLink> for "Listen Link" tagName
  And verify if value is <yourTerritory> for "Pitching from" tagName
  And verify if value is <territoriesToPitchTo> for "Territories" tagName
  #When user click on Submit Pitch button on appleMusic login page
                 
    
  Examples:
  | password | yourName | yourBusinessEmail | yourCompany | yourTerritory | territoriesToPitchTo | pitching | songType | artistName | contentTitle | appleID | upcEan | releaseDate | timedRelease | promotionDate | deliveredInDolbyAtmos | deliveredWithMotionArtwork | primaryGenre |label | distributorName | listenLink | releaseDetails | pitchingFor | playbookPromotion | summary |
  | "Musicpitch2015" | "Sarah Tassew" | "sarah.tassew@frtyfve.com" | "FRTYFVE" | "UK & Ireland" | "All" | "New Release" | "Song" | "Sophie Simmons" | "If I Could" | "" | "58879990" | "2023/04/21" | "No" | "2023/04/21" | "No" | "No" | "Hip-Hop/Rap" | "FRTYFVE" | "FUGA" | "https://we.tl/t-wLcTn4g95P" | "Testing for release details for dummy text" | "Testing" | "No" | "Summary" |
  


 