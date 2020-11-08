package listeners;

import org.testng.*;
import utils.GlobalVariables;

public class TestAutomationListener implements ISuiteListener, ITestListener {

    @Override
    public void onFinish(ISuite suite) {}

    @Override
    public void onStart(ISuite suite) {
        GlobalVariables.apiHost = suite.getParameter("apiHost");
        GlobalVariables.seleniumHost = suite.getParameter("seleniumHost");
        GlobalVariables.rebuildUrls();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //sresult.getParameters();
    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }
}
