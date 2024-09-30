# E-commerce-Automation-Project
Automation maven project using Selenium + Java + TestNG along with framework

# Automation Testing with Page Object Model

## Project Overview
This project contains automated test cases for the search functionality and product details of an e-commerce website. The tests are written using Selenium WebDriver with Java, TestNG as the testing framework, and Maven for project management. The project follows the Page Object Model (POM) design pattern with Page Factory, focusing on the SearchResultsPage and ProductDetailsPage.

## Tools and Technologies
- Java
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver
- Page Object Model (POM)
- Page Factory

## Project Structure
```
src/
├── main/
│   └── java/
│       └── dataProviders/
│           └── ConfigFileReader.java
│       └── pages/
│           ├── ProductDetailsPage.java
│           └── SearchResultsPage.java
│       └── utilities/
│           └── TestUtils.java
└── test/
    └── java/
        └── tests/
            └── SearchPageTests.java
```

## Test Cases
1. **Search Functionality**: Verifies that the search function returns relevant results for "tshirt".
2. **Product Filtering**: Tests the ability to filter search results by size.
3. **Sorting Functionality**: Checks if the sorting option (Price High to Low) works correctly.
4. **Product Details Page**: Ensures that clicking on a product opens its details page and displays the product title.
5. **Add to Cart**: Verifies that a product can be added to the cart successfully.

## Reasoning for Tool Selection
- **Selenium WebDriver**: Chosen for its robust support for web browser automation and wide adoption in the industry.
- **Java**: Selected due to its strong typing, extensive libraries, and widespread use in enterprise applications.
- **TestNG**: Preferred over JUnit for its more advanced functionality, particularly for parallel test execution and better reporting.
- **Maven**: Used for its excellent dependency management and project structure standardization.
- **Page Object Model**: Implemented to improve test maintenance and reduce code duplication.
- **Page Factory**: Utilized to simplify the initialization of Page Objects.

## Reasoning for Test Case Selection
These test cases were selected to cover the main user journey on an e-commerce website:
1. Searching for a product
2. Filtering results
3. Sorting results
4. Viewing product details
5. Adding a product to the cart

These actions represent the core functionality that needs to work correctly for users to have a smooth shopping experience.

## Setup Instructions
1. Ensure you have Java JDK installed (version 8 or higher).
2. Install Maven.
3. Download ChromeDriver and add its location to your system PATH.
4. Clone this repository.
5. Navigate to the project directory and run `mvn clean install` to install dependencies.

## Running the Tests
Execute the following command in the project root directory:
```
mvn clean test
```

## Potential Challenges and Solutions
- **Dynamic Elements**: This website might use dynamic IDs or classes. XPath or CSS selectors are used where necessary to locate elements reliably.
- **Page Load Times**: Explicit waits are implemented to handle varying page load times.
- **Pop-ups**: The code includes handling for potential pop-ups or overlays that might interfere with test execution.
- **Multiple Windows**: The tests handle scenarios where new windows are opened, such as when viewing product details.

## Areas for Improvement
- Implement more comprehensive error handling and logging.
- Add more edge cases and negative testing scenarios.
- Enhance the project to support multiple browsers.
- Implement a BaseTest class to handle common setup and teardown operations.

## Conclusion
This test suite provides a solid foundation for automating key user using the Page Object Model pattern. It demonstrates good practices in test automation and can be easily extended to cover more functionality of the website.
