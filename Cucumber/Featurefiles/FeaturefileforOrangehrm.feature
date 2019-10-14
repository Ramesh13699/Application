Feature: OrangeHRM Login test
Scenario Outline: Validating login functionality
Given: open chrome browser and navigate to orange hrm application
When: user enters "<UseName>" and "<Password>" and click on login button
Then: user should be able to successfully login and close the application.

Examples:
|UserName    | Password   |
|admin       |password    |
|Admin       |admin123    |
|testing     |admin       |