package com.bookmyfurniture.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadData {
	

	

		private ReadData() {
		}

		public static String getDataValue(String key,String dataType) {
			
			Properties properties = new Properties();
			InputStream inputStream = null;
			try {
				if(dataType.equalsIgnoreCase("config")) {
					inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
				}
				else {
				inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Data.properties");
				}
				properties.load(inputStream);
				return properties.getProperty(key);
			} catch (IOException ex) {
				ex.printStackTrace();
				return "Sorry " + key + " not found:";
			}
			}
		}
