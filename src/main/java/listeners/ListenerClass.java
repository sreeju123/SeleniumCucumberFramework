package listeners;

import constants.FrameworkConstants;
import org.json.simple.parser.ParseException;
import org.testng.*;

import java.io.IOException;

import static reports.GenerateCucumberReport.generateReport;


/**
 * @author Sreej
 */
public class ListenerClass implements ITestListener, ISuiteListener {


    @Override
    public void onStart(ISuite suite) {
        System.out.println("onStart Suite");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("onFinish Suite");
        try {
            generateReport(FrameworkConstants.getCucumberJsonFilePath());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish");
    }

}
