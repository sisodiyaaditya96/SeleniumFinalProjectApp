package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertiesFile {
	@Test
	public void readData() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Aadi\\eclipse-workspace\\FinalProjectApp\\src\\test\\java\\utilities\\data.properties");
		Properties pro = new Properties();
		pro.load(file);
		System.out.println("username : "+pro.getProperty("username"));
		System.out.println("password : "+pro.getProperty("password"));
		System.out.println("URL : "+pro.getProperty("url"));
	}
}
