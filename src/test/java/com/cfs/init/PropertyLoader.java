package com.cfs.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Developed by Rahul R.
 */
public class PropertyLoader {

	public Properties loadPropertyFile() {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			File file = null;

			file = new File("build\\data.properties");

			input = new FileInputStream(file.getAbsoluteFile());

			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}

	public Object getValue(String key) {
		Properties prop = loadPropertyFile();
		return prop.get(key);
	}

}
