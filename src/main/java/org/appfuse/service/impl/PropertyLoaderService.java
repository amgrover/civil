package org.appfuse.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class PropertyLoaderService {
	public static Properties properties;
	static {
		String filePath = System.getProperty("configFile");
		properties = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(filePath);

			// load a properties file
			properties.load(input);

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

	}

}
