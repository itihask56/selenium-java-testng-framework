# 🚀 BD CRM & WMS Automation Framework

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![Selenium](https://img.shields.io/badge/Selenium-4.x-green.svg)](https://selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-red.svg)](https://testng.org/)
[![Rest Assured](https://img.shields.io/badge/RestAssured-API_Testing-brightgreen.svg)](https://rest-assured.io/)
[![Extent Reports](https://img.shields.io/badge/Reporting-ExtentReports-purple.svg)]()
[![Log4j2](https://img.shields.io/badge/Logging-Log4j2-blue.svg)]()
[![GitHub Actions](https://img.shields.io/badge/CI/CD-GitHub_Actions-black.svg)]()

A modern, scalable, enterprise-grade **UI & API Automation Framework** built using **Java, Selenium WebDriver, TestNG, Rest Assured, Maven, and Extent Reports**.

Designed with maintainability, reusability, and scalability in mind, this framework supports both **Web UI Automation** and **API Testing** while following industry-standard automation practices.

---

## ✨ Key Features

### 🌐 UI Automation
- Selenium WebDriver
- Cross-browser testing support
- Page Object Model (POM)
- Explicit wait utilities
- Screenshot capture on failures
- Thread-safe driver management

### 🔌 API Automation
- Rest Assured integration
- Reusable API Client layer
- Request Builder pattern
- Response validation utilities
- Dynamic header management
- Authentication support

### ⚡ Framework Capabilities
- Parallel execution support
- Config-driven execution
- Retry Analyzer implementation
- TestNG listeners
- Utility helpers
- Environment management

### 📊 Reporting & Logging
- Extent Reports
- Failure screenshots
- Execution logs
- Log4j2 integration
- Test execution summary

### 🚀 CI/CD Ready
- Maven integration
- GitHub Actions support
- Jenkins compatible
- Headless execution support

---

# 🏗️ Framework Architecture

```text
src
├── main
│
├── api
│   ├── client
│   ├── request
│   ├── response
│   ├── endpoints
│   └── validators
│
├── config
│
├── driver
│
├── pages
│
├── listeners
│
├── reports
│
├── utils
│
└── constants

├── test
│   ├── ui
│   ├── api
│   └── integration

└── resources
    ├── config.properties
    ├── testdata
    └── log4j2.xml
```

---

# 🛠️ Tech Stack

| Category | Technology |
|-----------|------------|
| Language | Java 21 |
| UI Automation | Selenium WebDriver |
| API Automation | Rest Assured |
| Test Framework | TestNG |
| Build Tool | Maven |
| Reporting | Extent Reports |
| Logging | Log4j2 |
| Version Control | Git & GitHub |
| CI/CD | GitHub Actions / Jenkins |

---

# 🚀 Getting Started

## Prerequisites

- Java 21+
- Maven 3.9+
- Chrome / Firefox / Edge Browser
- Git

---

## Clone Repository

```bash
git clone https://github.com/your-username/bd-crm-wms-automation.git

cd bd-crm-wms-automation
```

---

## Install Dependencies

```bash
mvn clean install
```

---

## Execute Tests

```bash
mvn test
```

---

# ⚙️ Configuration

Update your configuration file:

```properties
# Application URL
base.url=https://your-environment-url.com

# Browser Configuration
browser=chrome
headless=false

# API Configuration
api.base.url=https://api-url.com

# Credentials
username=testuser
password=testpassword
```

Location:

```text
src/test/resources/config.properties
```

---

# 🔌 API Automation Architecture

The framework follows a layered API design:

```text
Request Model
      │
      ▼
API Client
      │
      ▼
Rest Assured
      │
      ▼
Response Validator
      │
      ▼
Assertions
```

Supported HTTP Methods:

- GET
- POST
- PUT
- PATCH
- DELETE

---

# 🧪 Sample API Test

```java
LeadRequest request =
        LeadRequest.builder()
                .name("John Doe")
                .mobile("9876543210")
                .build();

Response response =
        ApiClient.post(
                Endpoints.CREATE_LEAD,
                request
        );

ResponseValidator.validateStatusCode(
        response,
        200
);
```

---

# 🌐 Sample UI Test

```java
@Test
public void verifyLogin() {

    LoginPage loginPage =
            new LoginPage(driver);

    loginPage.login(
            username,
            password
    );

    Assert.assertTrue(
            dashboardPage.isDisplayed()
    );
}
```

---

# ▶️ Running Tests

### Run All Tests

```bash
mvn test
```

### Run API Tests

```bash
mvn test -Dgroups=api
```

### Run UI Tests

```bash
mvn test -Dgroups=ui
```

### Run Smoke Suite

```bash
mvn test -DsuiteXmlFile=smoke.xml
```

### Run Headless

```bash
mvn test -Dheadless=true
```

### Run on Firefox

```bash
mvn test -Dbrowser=firefox
```

---

# 📊 Reporting

After execution, reports are generated automatically.

```text
test-output/
```

Features included:

✅ Execution Summary  
✅ Passed & Failed Tests  
✅ Screenshots on Failure  
✅ Environment Information  
✅ Detailed Logs

---

# 📁 Project Components

## UI Layer

- Page Object Model
- Driver Factory
- WebDriver Utilities
- Wait Utilities
- Screenshot Utilities

## API Layer

- API Client
- Request Builder
- Response Validator
- Endpoint Management
- Header Management

## Framework Layer

- Config Reader
- Retry Analyzer
- TestNG Listeners
- Report Manager
- Log4j2 Manager

---

# ✅ Implemented Features

- [x] Selenium WebDriver Framework
- [x] TestNG Integration
- [x] Page Object Model
- [x] Driver Factory
- [x] ThreadLocal Driver Management
- [x] Rest Assured Framework
- [x] API Client Layer
- [x] Request Builder Pattern
- [x] Response Validation
- [x] Extent Reports
- [x] Screenshot Capture
- [x] Retry Analyzer
- [x] Log4j2 Logging
- [x] Config Reader
- [x] GitHub Actions Pipeline

---

# 🎯 Future Enhancements

- [ ] Database Validation Layer
- [ ] Docker Support
- [ ] Selenium Grid Execution
- [ ] Allure Reporting
- [ ] Slack Notifications
- [ ] Email Reports
- [ ] Contract Testing
- [ ] Performance Testing Integration

---

# 🔄 Test Execution Flow

```text
Start Test
    │
    ▼
Load Configuration
    │
    ▼
Initialize Driver / API Client
    │
    ▼
Execute Test
    │
    ▼
Capture Logs & Screenshots
    │
    ▼
Generate Report
    │
    ▼
Publish Results
```

---

# 📌 Best Practices Followed

- Single Responsibility Principle (SRP)
- Reusable Components
- Separation of Concerns
- Config-Driven Execution
- Thread-Safe Design
- Clean Architecture
- Maintainable Test Design

---

# 🤝 Contribution Guidelines

1. Fork the repository

2. Create a feature branch

```bash
git checkout -b feature/your-feature
```

3. Commit changes

```bash
git commit -m "Add new feature"
```

4. Push changes

```bash
git push origin feature/your-feature
```

5. Create a Pull Request

---

# 👨‍💻 Author

**Itihas Verma**

QA Automation Engineer

### Connect With Me

- GitHub: https://github.com/itihask56
- LinkedIn: https://linkedin.com/in/itihasverma

---

## ⭐ If you find this project useful, don't forget to star the repository!
