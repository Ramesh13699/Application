Feature: OrangeHrm logintest
Scenario Outline: validating login functionality
Given Open chrome and navigate to orange hrm application
When user enter "<UserName>" and "<Password>" and click on login button
Then user should be able to successfully login and close the application

Examples:
|UserName|Password|
|Admin   |admin  |
|Admin   |admin123|
|testing |admin   |

