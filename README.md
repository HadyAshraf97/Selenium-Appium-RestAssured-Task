Test Automation Framework
Overview
This project is a test automation framework designed to perform UI and API testing using Selenium, Cucumber, and REST Assured. The framework supports parallel execution, cross-browser testing (Chrome and Firefox), and includes a Page Object Model design pattern. It also provides detailed reporting for all test runs.

Features
UI Test Cases:

Scenario One:
Visit SauceDemo
Login with invalid credentials and verify error messages.
Login with valid credentials, add products to the cart, and complete the checkout process.
Cross-Browser Support: Chrome and Firefox, configurable via a configuration file.
Page Object Model: Implemented for better maintainability and scalability.
Mobile Test Case:

Android Application:
Prepare and execute positive and negative login scenarios for the provided APK.
Assert successful login.

API Test Case:
API Requests: Using REST Assured to perform GET, POST, PATCH, and DELETE requests on the provided demo API.
Setup and Configuration
Prerequisites
Java 11 or higher
Maven
WebDriver binaries for Chrome and Firefox
Configuration

Configuration File:

The browser and URL are configured in src/main/resources/config.properties.
Example config.properties:

properties
Copy code

url=https://www.saucedemo.com/
Test Data:

Test data is stored in src/test/resources/testdata.json for UI test cases.
Project Structure
src/main/java/ - Contains the main source code for the framework.
DriverManager/ - Manages WebDriver instances.
browser/ - Contains classes for browser and page objects.
pages/ - Page object classes.
src/test/java/ - Contains test cases and step definitions.
UITestCase/ - UI test cases and hooks.
tests/ - Step definitions for Cucumber tests.
src/test/resources/ - Contains configuration files and test data.
pom.xml - Maven configuration file.
Running the Tests
UI Tests:
Run UI tests using TestRunner:
src/test/java/UITestCase/tests/LoginWithInValidData.feature(choose the feature file)

API Tests:

API tests can be run with:

run the method in APITestCase Pcakage
Reporting
Test results and reports are generated using ExtentReports.
Reports are available in the project sturcture after test execution.
README and Documentation
This README provides an overview of the project and instructions for setup and execution.
For additional documentation, refer to the provided docs folder.
Repository
The code is hosted on GitHub. You can access it at Your Repository URL.
