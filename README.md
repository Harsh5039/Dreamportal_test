Dream Portal Selenium Test Automation
Automated UI functional tests for the Dream Portal web application using Java, JUnit 5, Selenium WebDriver, and Maven.

Project Structure
text
src/
  main/
    java/
      com.example.dreamportaltests.pages/
        HomePage.java
        DiaryPage.java
        SummaryPage.java
  test/
    java/
      com.example.dreamportaltests.tests/
        DreamPortalTest.java
pom.xml


Prerequisites
Java 11 or higher
Maven
Chrome browser (latest recommended)
Internet connection (for WebDriverManager)


Setup & Running Tests
Clone the repository
git clone <your-repo-url>
cd <your-repo-folder>
Run the tests with Maven
mvn test
Or run from your IDE
Open the project in IntelliJ IDEA or Eclipse.
Right-click on DreamPortalTest.java and select Run.


Test Coverage
Home Page (index.html)
Loading animation disappears after ~3 seconds.
Main content and "My Dreams" button become visible.
"My Dreams" button opens both diary and summary pages in new tabs.
Diary Page (dreams-diary.html)
Exactly 10 dream entries.
All dream types are "Good" or "Bad".
All columns are filled and non-empty.
Recurring dream names are detected.
Summary Page (dreams-total.html)
Validates Good and Bad dream counts.


Page Objects
HomePage.java – For home page interactions.
DiaryPage.java – For diary table validations.
SummaryPage.java – For summary table statistics extraction.


Dependencies
Key dependencies in pom.xml:
selenium-java
junit-jupiter
webdrivermanager


Happy Testing! 🚀
