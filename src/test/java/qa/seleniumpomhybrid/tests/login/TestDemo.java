package qa.seleniumpomhybrid.tests.login;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.testng.annotations.Test;

import qa.seleniumpomhybrid.utils.FileUtils;

public class TestDemo {
	
	@Test
	public void demoA() {
		  String envPropertiesPath = FileUtils.getEnvPropertiesPath();
	        System.out.println(envPropertiesPath.toString());
	}
}
