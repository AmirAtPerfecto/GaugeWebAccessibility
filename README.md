## Gauge Web Accessibility Testing using AXE (Sponsored by Deque Technologies)
This simple project demonstrates how to test your web page accessibility with Gauge. Relevant accessibility standard is [WCAG](https://www.w3.org/WAI/standards-guidelines/wcag/).
You can read more about the [open source AXE project here](https://axe-core.org/docs/).

# Just running the example
Simply run example.spec with no changes.

# The report
You should see the HTML report in reports/specs/index.html
Also screenshots with highlighted accessibility violations at reports/html-report/images/AXE/ folder

The console will list all errors, their severity and details how to fix:
**Accessibility scan found 3 violations in 5 objects**

**Error 1**\
**Impact: serious**
**Rule ID: color-contrast**
**Summary: Fix any of the following:**
**Element has insufficient color contrast of 2.82 (foreground color: #777777, background color: #333333, font size: 12.0pt, font weight: normal)**
Selector:	.container > div.disclamer HTML:		<div class="disclamer">Gauge is an open source project, sponsored by ThoughtWorks Inc. under the GPL License, Version 3.0</div>
 help: Elements must have sufficient color contrast
 helpURL: https://dequeuniversity.com/rules/axe/2.3/color-contrast?application=axeAPI
 Tags: [cat.color, wcag2aa, wcag143]

# New step added
**I check window for accessibility "term"**


## About this template

This is a template to get started with a Gauge project that uses Selenium as the driver to interact with a web browser.

## Installing this template

    gauge --install java_maven_selenium

## Building on top of this template

### Defining Specifications

* This template includes a sample specification which opens up a browser and navigates to `Get Started` page of Gauge.
* Add more specifications on top of sample specification.

Read more about [Specifications](http://getgauge.io/documentation/user/current/specifications/README.html)

### Writing the implementations

This is where the java implementation of the steps would be implemented. Since this is a Selenium based project, the java implementation would invoke Selenium APIs as required.

_We recommend considering modelling your tests using the [Page Object](https://github.com/SeleniumHQ/selenium/wiki/PageObjects) pattern, and the [Webdriver support](https://github.com/SeleniumHQ/selenium/wiki/PageFactory) for creating them._

- Note that every Gauge step implementation is annotated with a `Step` attribute that takes the Step text pattern as a parameter.
Read more about [Step implementations in Java](http://getgauge.io/documentation/user/current/test_code/java/java.html)

### Execution

* You can execute the specification as:

```
mvn test
```
