package coreComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void createInstance(String filePath) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static ExtentTest startTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static ExtentTest createNode(String nodeName) {
        return test.createNode(nodeName);
    }

    public static ExtentTest createNodeWithMessage(String nodeName, String message) {
        ExtentTest node = test.createNode(nodeName);
        node.pass(message);
        return node;
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logPass(ExtentTest node, String message) {
        node.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void logFail(ExtentTest node, String message) {
        node.fail(message);
    }

    public static void flush() {
        extent.flush();
    }
}