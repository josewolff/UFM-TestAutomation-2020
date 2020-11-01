package listeners;

import org.testng.*;
import utils.GlobalVariables;

public class TestAutomationListener implements ISuiteListener {

    @Override
    public void onFinish(ISuite suite) {}

    @Override
    public void onStart(ISuite suite) {
        GlobalVariables.apiHost = suite.getParameter("apiHost");
        GlobalVariables.seleniumHost = suite.getParameter("seleniumHost");
        GlobalVariables.rebuildUrls();
    }
}
