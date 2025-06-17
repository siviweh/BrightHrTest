# Bright HR Playwright Demo Test (Java + Maven)

This project demonstrates automated UI testing for BrightHR using [Microsoft Playwright](https://playwright.dev/java/) with Java and Maven.

## 📦 Tech Stack

- Java 11+
- Maven
- Playwright for Java
- TestNG
- Git

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-siviweh/bright-hr-playwright.git
cd bright-hr-playwright
2. Install Dependencies
Ensure you have Java and Maven installed, then run:

bash
Copy
Edit
mvn clean install
This will download dependencies and install the Playwright drivers.

3. Install Playwright Browsers
Run the following command to install the required browsers:

bash
Copy
Edit
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
🧪 Running Tests
To run all tests using Maven:

bash
Copy
Edit
mvn test
To run a specific test class:

bash
Copy
Edit
mvn -Dtest=BrightHrTest test
📝 Project Structure
bash
Copy
Edit
src
├── main
│   └── java
│       └── pages         # Page Object Models
├── test
│   └── java
│       └── tests         # TestNG test classes
