package AXE;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AXEImplementation {

    @Step("I check window for accessibility <term>")
    public void axe_scan(String pageName){
        // clean screenshot folder
        try {
            FileUtils.deleteDirectory(new File("reports//html-report//images//AXE"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriver driver  = Driver.webDriver;
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        AxeHelper axe = new AxeHelper(driver);
        axe.runAxe();

        axe.startHighlighter("violations");
        List<AxeTestResult> violations = null;
        try {
            violations = axe.axeEverything().violations;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (null != violations && 0 < violations.size()){
            int objects = 0;
            for (AxeTestResult t:violations) { objects = objects + t.nodes.size();}
            String s = System.lineSeparator() + "Accessibility scan found "+ violations.size() + " violations in " + objects + " objects";
            System.out.println(s);
        }
        final StringBuilder errors = new StringBuilder();
        int violationsCount = 0;
        int errorCount = 0;
        while (true) {
            final Map<String, ?> violation = axe.nextHighlight();
            if (violation == null) {
                break;
            }
            errorCount++;
            final String ruleId = (String) violation.get("issue");
            if (0 != ruleId.compareToIgnoreCase(violations.get(violationsCount).id))
                violationsCount++;

            final Map<String, String> node = (Map<String, String>) violation.get("node");

            final String impact = node.get("impact");
            final String summary = node.get("failureSummary");
            final String html = node.get("html");
            final String selector = (String) violation.get("target");

            final String message = String.format("%s - %s%n %s%n Selector:\t%s%n HTML:\t\t%s%n%n",
                    impact, ruleId, summary, selector, html);
            final String reportMessage = String.format("Impact: %s;;; Rule ID: %s;;; Summary: %s;;; Selector:\t%s HTML:\t\t%s",
                    impact, ruleId, summary, selector, html);
            try {
                final String reportMessageComplete = String.format("%s;;; help: %s;;; helpURL: %s;;; Tags: %s",
                        reportMessage,
                        violations.get(violationsCount).help,
                        violations.get(violationsCount).helpUrl,
                        violations.get(violationsCount).tags.toString());

                System.out.println("Error "+ errorCount +System.lineSeparator()+reportMessageComplete.replace(";;;",System.lineSeparator()));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(reportMessage);
            }

            ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
            try {
                FileUtils.copyFile(scrFile, new File("reports//html-report//images//AXE//AXE_Scan_Error_"+errorCount+" .png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            errors.append(message);

        }
    }

}
