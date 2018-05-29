## Gauge Web Accessibility Testing using AXE (Sponsored by Deque Technologies)
This simple project demonstrates how to test your web page accessibility with [Gauge](https://gauge.org/).\
 Relevant accessibility standard is [WCAG](https://www.w3.org/WAI/standards-guidelines/wcag/).\
You can read more about the [open source AXE project here](https://axe-core.org/docs/).

# Just running the example
Simply run example.spec with no changes.

# The report
You should see the HTML report in reports/specs/index.html\
Also screenshots with highlighted accessibility violations at reports/html-report/images/AXE/ folder

The console will list all errors, their severity and details how to fix:
**Accessibility scan found 3 violations in 5 objects**

**Error 1**\
**Impact: serious**\
**Rule ID: color-contrast**\
**Summary: Fix any of the following:**\
**Element has insufficient color contrast of 2.82 (foreground color: #777777, background color: #333333, font size: 12.0pt, font weight: normal)**\
Selector:	.container > div.disclamer HTML:		<div class="disclamer">Gauge is an open source project, sponsored by ThoughtWorks Inc. under the GPL License, Version 3.0</div>\
 help: Elements must have sufficient color contrast\
 helpURL: https://dequeuniversity.com/rules/axe/2.3/color-contrast?application=axeAPI\
 Tags: [cat.color, wcag2aa, wcag143]

# New step added
**I check window for accessibility "term"**


