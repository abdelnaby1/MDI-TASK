# MDI_TASK
# Instructions to run the project
- clone the project through git clone ${url}
- After you clone the project you need to install dependencies (it may takes some time if you are not using shaft_engine before)
- if you are using intelliJ IDEA
    - go to maven icon and click refresh button to install all dependencies
- open your terminal in the specified project (MDI_TASK)
- you need yo run this command to execute the testes in mdi.xml file
    - mvn clean test -Pall
- all tests and classes will execute and 2 reports will be generated and open automatically after the tests are finished
    - Execution Summary Report
    - Allure Report which includes all steps and screenshots of all assertions even if the test pass or fail
      it takes screenshot from the page when doing the assertion and specifiy if the test is passed or failed 
