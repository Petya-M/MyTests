Selenium Java POM Framework
Overview
This is a Page Object Model (POM) test automation framework using Selenium + Java.

src/
├── main/java/org/petya/
│   ├── pages/                          # Classic POM pages (By locators)
│       ├── BasePage.java
│       ├── HeaderPage.java
│       ├── HomePage.java
│       ├── LoginPage.java
│       └── LoginService.java
│   
├── test/java/org/petya/
│   ├── BaseTest.java                   # Shared setup / teardown
│   ├── CreateNewPostTest.java                  # Basic POM test
│   ├── DislikeButtonTest.java
│   ├── HomePageTest.java
│   ├── LoginTest.java
│   └── ScreenShotTest.java
│       
testng.xml                              # TestNG suite configuration
pom.xml

Features
Page Object Design Pattern
Explicit waits
Clean test structure


Test Coverage
Login flow
Screenshot of login form
Create post with file upload
Dislike second post
Verify post count and author



Run Tests
mvn clean test

