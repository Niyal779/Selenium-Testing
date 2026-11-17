# Travel Guide Testing

Java, Selenium WebDriver, and JUnit 5 browser automation tests for the Travel
Guide web application.

## Prerequisites

- Java JDK 17 or later
- Apache Maven
- Google Chrome
- The Travel Guide PHP web application and its required database running locally

Selenium 4.27.0's Selenium Manager can generally manage ChromeDriver
automatically. Google Chrome must be installed.

## Prepare the web application

The tests use the PHP application under
`http://localhost/Travel-Guide%20-%20Copy/`. Start the application on your local
server and make sure its database and test accounts are ready.

If your local application URL is different, update the URLs used in the test
files under `src/test/java/com/niyal/`.

## Run the tests

Open a terminal in the project directory and run:

```powershell
cd C:\path\to\TravelGuideTesting
mvn test
```

To run only the login and registration page smoke tests:

```powershell
mvn "-Dtest=LoginPageSmokeTest,RegistrationPageSmokeTest,DestinationBrowsePageSmokeTest" test
```

These tests use Chrome and check that the expected page fields are visible.

The tests open Chrome and exercise features such as login, registration,
logout, the home page, search, comments, and the travel cost calculator. Some
tests save screenshots in the project directory. A test may fail to save a
screenshot if a file with the same name already exists.

## Project structure

```text
src/
  main/java/com/niyal/       # Main Java source
  test/java/com/niyal/       # Selenium/JUnit tests
pom.xml                      # Maven and dependency configuration
```

Main test classes:

- `LoginPageSmokeTest`
- `RegistrationPageSmokeTest`
- `DestinationBrowsePageSmokeTest`
- `HomePageTest`
- `LoginTest`
- `LogoutTest`
- `RegistrationTest`
- `SearchTest`
- `CommentTest`
- `CalculatorTest`

## Commit and push with Git

Review your changes, then commit the README and push it to the remote
repository:

```powershell
git status
git add README.md
git commit -m "docs: add project README"
git push
```

To include other changes, review `git status` and stage the appropriate files
separately.
