# Existing Observations <br>

1) Trying to fetch any customer detail with Id starting with leading 0's results in 400 Bad Request even is if ID exists in DB.  <br>



# Software Pre-Requisites:

1) Java 11
2) Apache Maven 3.9.0 (https://maven.apache.org/download.cgi) --> Build Tool Used
3) Allure Reports (https://docs.qameta.io/allure/) --> For reporting of the test reports

# Steps To Follow before triggering the tests

Step 1: Start the service locally before executing the test cases. <br>
Step 2: Set the below two global properties under "config.properties" file in the solution ( /src/main/resources ).

1) api.basePath=http://localhost:8080 <br>
2) database.Path=$YOUR_LOCAL_PATH_TO_CUSTOMERS.DB FILE (e.g : /Users/ashish/Desktop/sdet-assignment/customers.db) <br>

![image](https://github.com/ashish2801/TechAssignment/assets/59378181/0c70e84c-eb44-405c-afdb-82cd9345d3e5)


# To run the automation Suite from terminal via the Maven Commands

Step 1: Open terminal and navigate inside the project root directory <br>

(e.g: /Users/ashish/Documents/Code/PingsafeTechAssignment) <br>

Step 2: Run the command in the terminal to trigger Regression Suite <br> 

**mvn clean test -DsuiteFile=regressionSuite** <br>

# To run the automation Suite directly from the solution explorer inside IDE

Step 1: Open Solution in the IDE <br>
Step 2: Navigate inside the path : **/src/test/resources/runners** <br>
Step 3: Right click on regression suite file and select "Run" <br>

![Screenshot 2023-06-15 at 9 24 45 PM](https://github.com/ashish2801/TechAssignment/assets/59378181/d56452ba-afb4-452b-965c-13a8d3c78083)


# To view the reports:

Reports are generated post the automation runs under the path --> **/target/allure-results** <br>
To view the report in the HTML format run the command terminal : <br>

 **allure serve target/allure-results** <br>
 



# Implementations:

1) Regression Suite to trigger all test cases. <br>
2) Retrial of the failed test cases via retry listener <br>
3) Segregation of Constants <br>
4) Usage of Builder and Singleton design patterns <br>
5) Usage of Custom Enums & Listeners <br>
6) Usage of Lombok Plugins to create setters and getters in POJO classes <br>
7) Serialization and Deserialization of POJO classes <br>
8) Reporing via the Allure Reports <br>
9) Validation of API Response with the Database <br>


## Test Cases:

1) Verify if able to Add A Customer <br>
2) Verify If able to fetch Customer Details <br>
3) Verify error when creating customer with invalid phoneNumber <br>
4) Verify error When trying to create duplicate customer entries <br>
5) Verify error with invalid Access Token <br>
6) Verify that the CustomerID field is mandatory <br>
7) Verify that the PhoneNumber field is mandatory <br>


# Test Summary Screenshot

![Screenshot 2023-06-15 at 8 56 28 PM](https://github.com/ashish2801/TechAssignment/assets/59378181/c80f6fbe-4c04-4978-8822-809753609f6f)


# Test Sample Report for POST Call


![Screenshot 2023-06-15 at 8 57 32 PM](https://github.com/ashish2801/TechAssignment/assets/59378181/4d3bedf2-8b89-4439-b6be-57d5f77edf2b)


# Test Sample Report for GET Call

![Screenshot 2023-06-15 at 8 57 49 PM](https://github.com/ashish2801/TechAssignment/assets/59378181/07adaa8a-0fb5-4abc-85cd-b32ac563795a)



