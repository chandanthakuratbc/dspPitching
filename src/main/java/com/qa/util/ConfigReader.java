package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {

	public Properties prop;
	public Properties appleProp;
	public Properties deezerProp;
	public Properties spotifyProp;

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public Properties init_appleProp() {
		appleProp = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/appleConfig.properties");
			appleProp.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appleProp;
	}

	
	/**
	 * This method is used to load the properties from deezerConfig.properties file
	 * @return it returns Properties prop object
	 */
	public Properties init_deezerProp() {
		deezerProp = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/deezerConfig.properties");
			deezerProp.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return deezerProp;
	}
	
	
	/**
	 * This method is used to load the properties from spotifyConfig.properties file
	 * @return it returns Properties prop object
	 */
	public Properties init_spotifyProp() {
		spotifyProp = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/spotifyConfig.properties");
			spotifyProp.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return spotifyProp;
	}
	public Map<String, String>readCheckboxValuesFromDeezerConfig() {
	    try {
			// Read the mapping from a properties file
			Properties properties = init_deezerProp();
			// Convert the properties to a map
			Map<String, String> checkboxValues = new HashMap<>();
			for (String key : properties.stringPropertyNames()) {
				String value = properties.getProperty(key);
			    checkboxValues.put(key, value);
			    }
			return checkboxValues;
		} catch (RuntimeException e) {
			throw new RuntimeException("Failed to read checkbox values", e);
		}
	    
	}

}
