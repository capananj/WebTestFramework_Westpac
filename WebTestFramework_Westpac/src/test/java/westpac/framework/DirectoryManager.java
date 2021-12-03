package westpac.framework;

public class DirectoryManager {
    public static String projectWorkingDirectory = System.getProperty("user.dir");
    public static String testResourcesDirectory = projectWorkingDirectory + "/src/test/resources/";
    public static String outputDirectory = projectWorkingDirectory + "/test-output/";
    public static String screenshotDirectory = outputDirectory + "screenshot/";
    public static String logsDirectory = outputDirectory + "log/";
}
