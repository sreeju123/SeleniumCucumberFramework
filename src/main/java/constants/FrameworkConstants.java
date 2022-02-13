package constants;

/**
 * @author Sreej
 */
public class FrameworkConstants {

    private static final int explicitWait = 30;
    private static final String dashboardUrl = "https://admin-demo.nopcommerce.com/admin/";
    private static final String cucumberJsonFilePath = "src/test/resources/cucumberReport/cucumberReport.json";

    public static String getDashboardUrl() {
        return dashboardUrl;
    }

    public static int getExplicitWait() {
        return explicitWait;
    }

    public static String getCucumberJsonFilePath() {
        return cucumberJsonFilePath;
    }
}
