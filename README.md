# peeba-automation-test

This project is built for testing Peeba web application. It is built on top of :
  - Spring Boot: Core to mangage WebDriver bean, Faker bean, etc...
  - Maven: Dependencies management & Test runner
  - TestNG: Test framework to manage test cases
  - Allure: Reporting
  - AssertJ: assertion
  - Jackson : To serialize/deserialize data to/from json file
  
1. Introduction: 
   - Requirement: We need to have Maven and Java 11 installed and configured properly + any IDE(but preferred IntelliJ IDEA)
   - Clone the repo
  
2. Test run command line:
   - We support several test command line for properly custom the test execution:
   2.1. Run with Firefox driver:
   - Use: mvn clean test -Dbrowser=firefox
   - Note: Chrome is run by default so no need to pass -Dbrowser=chrome
   2.2. Run with specific test suite:
   - User: mvn clean test -DsuiteXMLFile=/path/to/testng.xml
   2.3. Run with different env:
   - To do so, please create the application-{env}.properties file inside resources folder, and define all the necessary properties like application.url, etc...
   - For running the test, user: mvn clean test -Dspring.profiles.active={env} with {env} is the name of env that we have binded application properties file.
   2.4. Generate report:
   - Use: mvn allure:report
   2.5. Visualize the report:
   - Use: mvn allure:serve
   
