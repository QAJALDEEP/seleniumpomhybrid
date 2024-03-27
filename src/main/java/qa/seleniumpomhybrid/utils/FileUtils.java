package qa.seleniumpomhybrid.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

	private static final String ROOT_PATH = System.getProperty("user.dir");
	private static final Path ENV_PROPERTIES_PATH = Paths.get(ROOT_PATH, "src", "test", "resources", "com",
			"seleniumpomhybrid", "properties", "env.properties");

	public static String getEnvPropertiesPath() {
		return ENV_PROPERTIES_PATH.toString();
	}
}
