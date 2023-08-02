package com.qa.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;
	private WebDriverWait wait;
	private ConfigReader configReader;
	Properties prop;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	public void waitForPageLoad() {
		wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("explicitWait")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	public void scrollToElement(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToThePage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}

	public void explicitWait(By element) {
		try {
			int explicitWaitTime = Integer.parseInt(prop.getProperty("explicitWait"));
			WebDriverWait wait = new WebDriverWait(driver, explicitWaitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (NumberFormatException e) {
			System.err.println("Error: Invalid value for explicitWait property.");
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.err.println("Error: Timed out waiting for element: " + element.toString());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error: Exception occurred during explicit wait for element: " + element.toString());
			e.printStackTrace();
		}
	}

	public void explicitWait(WebElement element) {
		try {
			int explicitWaitTime = Integer.parseInt(prop.getProperty("explicitWait"));
			WebDriverWait wait = new WebDriverWait(driver, explicitWaitTime);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NumberFormatException e) {
			System.err.println("Error: Invalid value for explicitWait property.");
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.err.println("Error: Timed out waiting for element: " + element.toString());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error: Exception occurred during explicit wait for element: " + element.toString());
			e.printStackTrace();
		}
	}

	public void elementDisplayed(By element) {
		try {
			int explicitWaitTime = Integer.parseInt(prop.getProperty("explicitWait"));
			WebDriverWait wait = new WebDriverWait(driver, explicitWaitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (TimeoutException e) {
			System.out.println("Element " + element.toString() + " is not displayed.");
		} catch (Exception e) {
			System.err
					.println("Error: Exception occurred while checking if element is displayed: " + element.toString());
			e.printStackTrace();
		}
	}

	public void waitUntilElementIsClicable(By element) {
		wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("explicitWait")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
	}

	public void waitUntilElementIsClicable(WebElement element) {
		wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("explicitWait")));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void sendTextWithoutBreak(By locator, String text) {
		WebElement element = driver.findElement(locator);
		waitUntilElementIsClicable(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			element.sendKeys(text);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = 'Your text';", element);
		}

	}

	public void sendText(By locator, String text) {
		if (locator == null) {
			System.out.println("Locator cannot be null.");
			return;
		}
		if (text == null) {
			System.out.println("Text to send cannot be null.");
			return;
		}
		explicitWait(locator);
		try {
			WebElement element = driver.findElement(locator);
			if (element != null && element.isDisplayed()) {
				element.clear();
				element.sendKeys(text);
			} else {
				System.out.println("Element with locator: " + locator.toString() + " is not displayed.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element with locator: " + locator.toString() + " not found.");
		} catch (Exception e) {
			System.out.println("Error occurred while sending text to element with locator: " + locator.toString()
					+ ". Error message: " + e.getMessage());
		}
	}

	public void sendTextWithOutClear(By locator, String text) {
		if (locator == null) {
			System.out.println("Locator cannot be null.");
			return;
		}
		if (text == null) {
			System.out.println("Text to send cannot be null.");
			return;
		}
		explicitWait(locator);
		try {
			WebElement element = driver.findElement(locator);
			if (element != null && element.isDisplayed()) {
				element.sendKeys(text);
			} else {
				System.out.println("Element with locator: " + locator.toString() + " is not displayed.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element with locator: " + locator.toString() + " not found.");
		} catch (Exception e) {
			System.out.println("Error occurred while sending text to element with locator: " + locator.toString()
					+ ". Error message: " + e.getMessage());
		}
	}

	public void clickElementWithJavaScript(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void clickOnElement(By locator) {
		if (locator == null) {
			System.out.println("Locator cannot be null.");
			return;
		}
		explicitWait(locator);
		try {
			WebElement element = driver.findElement(locator);
			if (element.isDisplayed()) {
				element.click();
			} else {
				System.out.println("Element with locator: " + locator.toString() + " is not displayed.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element with locator: " + locator.toString() + " not found.");
		} catch (Exception e) {
			System.out.println("Error occurred while clicking on element with locator: " + locator.toString()
					+ ". Error message: " + e.getMessage());
		}
	}

	public void pressTabButton() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.RETURN).build().perform();
	}

	// Store the ID of the original window
	public String getCurrentWindwoHandlesId() {
		String originalWindow = driver.getWindowHandle();
		return originalWindow;
	}

	// Check we don't have other windows open already
	public void checkIfAnyNewWindowWindow() {
		int windowSize = driver.getWindowHandles().size();
		assert (windowSize == 1);
	}

	// Click the link which opens in a new window
	public void openNewWindow() {
		// driver.findElement(By.linkText("new window")).click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		waitForPageLoad();
		// driver.findElement(By.linkText("new window")).click();
	}

	// Loop through until we find a new window handle
	public void loopUntilNewWindowOpen(String originalWindow) {
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

	}

//	public void openAndNavigateToNewWindow() {
//		String currentWindowHandle = getCurrentWindwoHandlesId();
//		checkIfAnyNewWindowWindow(); // Check we don't have other windows open already
//		openNewWindow();
//		loopUntilNewWindowOpen(currentWindowHandle);
//
//	}

	public boolean uploadFileUsingSendKeysOnFrameElement(By locator, String documentPath) {
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int maxFrames = frames.size();
		System.out.println("Total frames on the page: " + maxFrames);
		WebElement targetElement = null;

		for (int i = 0; i < maxFrames; i++) {
			try {
				driver.switchTo().frame(i);
				targetElement = driver.findElement(locator);
				File file = new File(documentPath);
				String filePath = file.getAbsolutePath();
				// Create a new WebElement object to represent the file to be uploaded
				WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
				fileInput.sendKeys(filePath);

				driver.switchTo().defaultContent(); // switch back to default content

				return true; // exit the method if target element is found and file is uploaded
			} catch (NoSuchElementException e) {
				// continue to the next frame if target element is not found
				driver.switchTo().defaultContent();
			}
		}

		return false; // element not found, file not uploaded
	}

	public void loopUntillElementFoundOnFrameAndClick(By locator, String documentPath) {
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int maxFrames = frames.size();
		System.out.println("Total frames on the page: " + maxFrames);
		WebElement targetElement = null;

		for (int i = 0; i < maxFrames; i++) {
			try {
				driver.switchTo().frame(i);
				targetElement = driver.findElement(locator);
				targetElement.click();

				break; // exit the loop if target element is found
			} catch (NoSuchElementException e) {
				// continue to the next frame if target element is not found
				driver.switchTo().defaultContent();
			}
		}

		if (targetElement != null) {
			// check if the target element is clickable
			if (targetElement.isEnabled() && targetElement.isDisplayed()) {
				// if the target element is clickable, click on it
				targetElement.click();
			} else {
				// if the target element is not clickable, use JavaScript click method
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].click();", targetElement);
			}
		}

	}

	public List<String> getDataTableList(By locator) {
		List<String> elementTextList = new ArrayList<>();
		waitForPageLoad();
		List<WebElement> webElementList = driver.findElements(locator);
		for (WebElement e : webElementList) {
			String text = e.getText();
			System.out.println(text);
			elementTextList.add(text);
		}
		return elementTextList;
	}

	public void selectTypeOfValueFromTableOfAppleMusic(By locator, String value) {
		waitForPageLoad();
		explicitWait(locator);
		if (driver.findElement(locator).isDisplayed()) {
			List<WebElement> allOptions = driver.findElements(locator);
			System.out.println(allOptions.size() + " Size of type Of list");
			for (WebElement e : allOptions) {
				if ((e.getText()).equalsIgnoreCase(value)) {
					if (!e.isSelected()) {
						waitUntilElementIsClicable(e);
						e.click();
						break;
					} else {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].click();", e);
					}

				}
			}
		}
	}

	public void selectTypeOfValueFromTableAndScrollTillElement(By locator, String value) {
		waitForPageLoad();
		explicitWait(locator);

		List<WebElement> allOptions = driver.findElements(locator);
		System.out.println(allOptions.size() + " Size of type Of list");

		WebElement matchingElement = null;
		for (WebElement e : allOptions) {
			try {
				waitUntilElementIsClicable(e);
			} catch (Exception e1) {
				// Handle if element is not visible due to scroll issue
				waitForPageLoad();
				explicitWait(e);
			}
			if ((e.getText()).equalsIgnoreCase(value.trim())) {
				matchingElement = e;
				break;
			} else {
				scrollToElement(e);
			}
		}

		if (matchingElement != null) {
			if (!matchingElement.isSelected()) {
				try {
					waitUntilElementIsClicable(matchingElement);
					matchingElement.click();
				} catch (Exception e1) {
					// Handle if click is not successful, scroll and click using JavaScript
					scrollToElement(matchingElement);
					waitForPageLoad();
					waitUntilElementIsClicable(matchingElement);
					clickElementWithJavaScript(matchingElement);
				}
			} else {
				scrollToElement(matchingElement);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].click();", matchingElement);
			}
		} else {
			System.out.println("............Value not found in the dropdown: " + value);
		}
	}

	public boolean selectTypeOfValueFromTableSpotify(By locator, String value) {
	    waitForPageLoad();
	    explicitWait(locator);

	    List<WebElement> allOptions = driver.findElements(locator);
	    System.out.println(allOptions.size() + " Size of type Of list");

	    WebElement matchingElement = null;
	    for (WebElement option : allOptions) {
	        try {
	        	waitUntilElementIsClicable(option);
	        } catch (Exception e) {
	            // Handle if element is not visible due to scroll issue
	            waitForPageLoad();
	            explicitWait(option);
	        }
	        if (option.getText().equalsIgnoreCase(value.trim())) {
	            matchingElement = option;
	            break;
	        } else {
	            scrollToElement(option);
	        }
	    }

	    if (matchingElement != null) {
	        if (!matchingElement.isSelected()) {
	            try {
	            	waitUntilElementIsClicable(matchingElement);
	                matchingElement.click();
	                return true; // Value successfully selected
	            } catch (Exception e) {
	                // Handle if click is not successful, scroll and click using JavaScript
	                scrollToElement(matchingElement);
	                waitForPageLoad();
	                waitUntilElementIsClicable(matchingElement);
	                clickElementWithJavaScript(matchingElement);
	                return true; // Value successfully selected
	            }
	        } else {
	            scrollToElement(matchingElement);
	            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	            jsExecutor.executeScript("arguments[0].click();", matchingElement);
	            return true; // Value successfully selected
	        }
	    } else {
	        System.out.println("Value not found in the dropdown: " + value);
	        return false; // Value not selected
	    }
	}

	
	public void selectTypeOfValueFromTableWithOutScrollTillElement(By locator, String value) {
		waitForPageLoad();

		List<WebElement> allOptions = driver.findElements(locator);
		System.out.println(allOptions.size() + " Size of type Of list");

		WebElement matchingElement = null;
		for (WebElement e : allOptions) {
		    String innerHTML = e.getAttribute("innerHTML");
		    String text = e.getText();
		    if (innerHTML.equalsIgnoreCase(value.trim()) || text.equalsIgnoreCase(value.trim())) {
		        matchingElement = e;
		        break;
		    }
		    scrollToElement(e);
		}

		if (matchingElement != null) {
			if (!matchingElement.isSelected()) {
				try {
					matchingElement.click();
				} catch (Exception e1) {
					// Handle if click is not successful, scroll and click using JavaScript
					scrollToElement(matchingElement);
					waitForPageLoad();
					clickElementWithJavaScript(matchingElement);
				}
			} else {
				scrollToElement(matchingElement);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].click();", matchingElement);
			}
		} else {
			System.out.println("Value not found in the dropdown: " + value);
		}
	}

	public void selectTypeOfValueFromTableUsingTextWithOutScrollTillElement(By locator, String value) {
		waitForPageLoad();

		List<WebElement> allOptions = driver.findElements(locator);
		System.out.println(allOptions.size() + " Size of type Of list");

		WebElement matchingElement = null;
		for (WebElement e : allOptions) {
			if ((e.getAttribute("innerText")).equalsIgnoreCase(value)) {
				matchingElement = e;
				break;
			} else {
				scrollToElement(e);
			}
		}

		if (matchingElement != null) {
			if (!matchingElement.isSelected()) {
				try {
					// waitUntilElementIsClicable(matchingElement);
					matchingElement.click();
				} catch (Exception e1) {
					// Handle if click is not successful, scroll and click using JavaScript
					scrollToElement(matchingElement);
					waitForPageLoad();
					// waitUntilElementIsClicable(matchingElement);
					clickElementWithJavaScript(matchingElement);
				}
			} else {
				scrollToElement(matchingElement);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].click();", matchingElement);
			}
		} else {
			System.out.println("Value not found in the dropdown: " + value);
		}
	}

	public void selectOptionFromDropDown(By locator, String optionValue) {
		try {
			explicitWait(locator);
			List<WebElement> allOptions = driver.findElements(locator);
			System.out.println(allOptions.size() + " options found in dropdown.");
			for (WebElement e : allOptions) {
				if (e.getText().contains(optionValue)) {
					waitUntilElementIsClicable(e);
					e.click();
					System.out.println("Selected option: " + optionValue);
					break;
				}
			}
		} catch (NoSuchElementException e) {
			System.err.println("Error: Dropdown element not found: " + locator.toString());
			e.printStackTrace();
		} catch (ElementNotInteractableException e) {
			System.err.println("Error: Option not interactable: " + optionValue);
			e.printStackTrace();
		} catch (StaleElementReferenceException e) {
			System.err.println("Error: Option element no longer attached to DOM: " + optionValue);
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error: Exception occurred while selecting option: " + optionValue);
			e.printStackTrace();
		}
	}

	public void selectOptionFromDropDownWithEqualContains(By locator, String optionValue) {
		try {
			explicitWait(locator);
			List<WebElement> allOptions = driver.findElements(locator);
			System.out.println(allOptions.size() + " options found in dropdown.");
			for (WebElement e : allOptions) {
				if (e.getText().equalsIgnoreCase(optionValue)) {
					waitUntilElementIsClicable(e);
					e.click();
					System.out.println("Selected option: " + optionValue);
					break;
				}
			}
		} catch (NoSuchElementException e) {
			System.err.println("Error: Dropdown element not found: " + locator.toString());
			e.printStackTrace();
		} catch (ElementNotInteractableException e) {
			System.err.println("Error: Option not interactable: " + optionValue);
			e.printStackTrace();
		} catch (StaleElementReferenceException e) {
			System.err.println("Error: Option element no longer attached to DOM: " + optionValue);
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error: Exception occurred while selecting option: " + optionValue);
			e.printStackTrace();
		}
	}

	public boolean compareTwoList(List<String> list1, List<String> list2) {
		boolean flag = false;

		for (int i = 0; i < list2.size(); i++) {
			flag = false;
			int k = 0;
			for (int j = 0; j < list1.size(); j++) {
				if (list2.get(i).contains(list1.get(j))) {
					flag = true;
					break;
				} else if (k == list1.size() - 1 && flag == false) {
					return false;
				}
				k++;
			}
		}
		return flag;
	}

	public boolean acceptAlert(WebDriver driver) {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");
			} else {
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}

	public boolean isValidDateFormat(String format, String dateValue) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateValue);
			if (!dateValue.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date != null;

	}

	public void setZoom(WebDriver driver, String zoomLevel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='" + zoomLevel + "';");
	}

}
