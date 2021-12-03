# WebTestFramework_Westpac
This is the solution set for Westpac Technical Exam - Buggy Cars Website.

OBJECTIVES
__________

	1. To be able to develop a test approach for Buggy Cars Website
	2. To be able to document most critical bugs for Buggy Cars Website
	3. To be able to automate the top 5 critical functionalities of BuggyCars

TEST SCENARIO TO COVER FOR TEST AUTOMATION
__________________________________________

	Test 1 - Validate that user can register successfully.
	Test 2 - Validate that user can login and logout successfully.
	Test 3 - Validate that user can edit his profile information.
	Test 4 - Validate that user can vote for car ratings.
	Test 5 - Validate that user can view the Overall Car Ratings Page.

INSTALLATION & SETUP (PRE-REQUISITE)
___________________________________

	1. Download and install IntelliJ into your computer.

		- https://www.jetbrains.com/idea/download/#section=windows

	2. Download and install Java into your computer.

	3. Download and install Maven into your computer.
	
	4. To set up Allure Reporting, go to CMD and key in --> npm install -g allure-commandline --save-dev.

TECHNOLOGY STACK
________________

	Automation Tool - Selenium WebDriver(Java library)
	Reporting - Allure
	Design Pattern - Page Object Model
	Programming Language - Java
	Test Framework / Runner - TestNG
	Project Lifecycle - Maven
	
RUNNING THE AUTOMATION FRAMEWORK
________________________________

	1. Import the project using the GitHub repositories below.

		https://github.com/KatherineGrospe/WebTestFramework_Westpac.git

	2. To run the Web Test Framework Test one by one,

	Go to the Test Pages, right click and choose Run <<TestPage Name>>
	e.g., C:/Users/<username>/<path>/WebTestFramework_Westpac/src/test/java/westpac/suite/tests/editProfileInformationTest.java

	You can also navigate to Run > then click on the Run <<TestPage Name>>.

	3. To run the Web Test Framework Test by suite, locate 'TestNG.xml' from this sample path C:/Users/<username>/<path>/WebTestFramework_Westpac/TestNG.xml
	Right click on the 'TestNG.xml', then select Run 'TestNG.xml'.


Thank you for the opportunity to take this practical test!





