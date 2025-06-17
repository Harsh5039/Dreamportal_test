# 🌙 Dream Portal Selenium Test Automation

This project automates the UI functional testing of the Dream Portal web application using Java, JUnit 5, Selenium WebDriver, and Maven. It follows the Page Object Model design pattern to enhance maintainability and readability.

The project structure includes `HomePage.java`, `DiaryPage.java`, and `SummaryPage.java` under `com.example.dreamportaltests.pages`, and a test class `DreamPortalTest.java` under `com.example.dreamportaltests.tests`. The `pom.xml` manages dependencies such as `selenium-java`, `junit-jupiter`, and `webdrivermanager`.

To get started, ensure you have Java 11 or higher, Maven, the latest version of Google Chrome, and an internet connection (required by WebDriverManager). First, clone the repository using `https://github.com/Harsh5039/Dreamportal_test` and navigate into the folder. You can run the tests via Maven using `mvn test`, or directly from your IDE like IntelliJ IDEA or Eclipse by right-clicking `DreamPortalTest.java` and selecting Run.

Test coverage includes the Home Page (`index.html`), where a loading animation disappears after ~3 seconds and the main content with the "My Dreams" button becomes visible. Clicking the button opens the Diary and Summary pages in new tabs. On the Diary Page (`dreams-diary.html`), the test ensures exactly 10 dream entries, each categorized as either "Good" or "Bad", with all columns filled and recurring dream names detected. On the Summary Page (`dreams-total.html`), it validates the counts of "Good" and "Bad" dreams and ensures summary statistics match the Diary data.

Page Object classes handle functionality modularly: `HomePage.java` manages homepage interactions and tab switching, `DiaryPage.java` validates table entries and categories, and `SummaryPage.java` verifies dream statistics.

Common issues include `NoSuchElementException` (usually caused by incorrect selectors or inactive tabs), `TimeoutException` (possibly requiring increased wait times), and `IndexOutOfBoundsException` (when row structures are unexpected). Chrome’s pop-up blocker should be disabled as the app opens new tabs during navigation.

This project is meant for educational or demonstration purposes only. Contributions are welcome—feel free to fork, open issues, or create pull requests. Happy testing! 🚀
