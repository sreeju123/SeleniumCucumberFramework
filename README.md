# SeleniumCucumberFramework


# About

This project shows Adding new customers and few negative scenarios in nopCommerce Website

# Libraries Used:

Selenium
Cucumber
TestNG
WebDriverManager

# Capabilities:
    1. This framework has the capability to run the tests in local and remote selenium grid.
    2. It can also be extended to run on clouds like browserstack.
    3. Web Tests can be run on chrome, firefox & edge browsers.
    4. Configuration can be changed from config.properties inside src/test/resources

# Running Tests :
    1. Right click the testng.xml file and run
    2. mvn test -Dcucumber.options="src/test/resources/features/Login.feature" -Dbrowser=chrome ===>(browsers=firefox, chrome)
![image](https://user-images.githubusercontent.com/62211370/159868917-8d40b29c-2d74-4ee3-8fd7-0b0c03682fa7.png)



# Report :
    Reports will be generated on location => "target/cucumberReport"

![image](https://user-images.githubusercontent.com/62211370/160762922-dacd765b-a0ff-453b-9d88-c821420fe078.png)

# ElasticSearch Live Dashboard
1. Change sendresulttoelk=yes in config.properties
2. Run docker compose up
3. Launch the url http://localhost:5601/app/dashboards and configure the dashboard based on our need
    ![image](https://user-images.githubusercontent.com/62211370/164709500-7e23db48-e6b8-41d7-84ff-e2a7798569a9.png)


