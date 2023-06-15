package org.pingsafe.tests;

import org.pingsafe.utils.FileUtils;
import org.testng.annotations.BeforeSuite;

public class BaseTest {



    @BeforeSuite(alwaysRun = true)
    public void deleteAllureReports() {
        /** To clean the reports generated from the previous runs **/
        FileUtils.deletePastAllureReports();

    }
}
