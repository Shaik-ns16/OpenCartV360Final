🚀 OpenCart Automation Framework

A robust end-to-end test automation framework built using Selenium WebDriver, Java, TestNG, Maven, Jenkins, Docker, and Selenium Grid.
This framework follows Page Object Model (POM) design pattern, supports parallel execution, and provides detailed reporting with Extent Reports including screenshots on test failure.

📌 Project Overview

This project automates the OpenCart e-commerce application to validate core functionalities such as:

User Registration

Login

Product Search

Product Purchase Flow

UI Validations

The framework is designed with industry-standard automation architecture that supports:

Scalable test execution

Cross-browser testing

CI/CD pipeline integration

Containerized test execution using Docker

🏗 Framework Architecture

The framework is structured using Page Object Model (POM) for better maintainability and reusability.

                    +---------------------+
                    |      TestNG         |
                    |   Test Execution    |
                    +----------+----------+
                               |
                               v
                    +---------------------+
                    |     Test Classes    |
                    | (Test Cases Layer)  |
                    +----------+----------+
                               |
                               v
                    +---------------------+
                    |    Page Objects     |
                    |   (POM Classes)     |
                    +----------+----------+
                               |
                               v
                    +---------------------+
                    |    Base Classes     |
                    |  DriverFactory      |
                    +----------+----------+
                               |
                               v
                    +---------------------+
                    | Selenium WebDriver  |
                    +----------+----------+
                               |
                               v
                    +---------------------+
                    | Selenium Grid       |
                    | Docker Containers   |
                    +----------+----------+
                               |
                               v
                    +---------------------+
                    | Jenkins CI/CD       |
                    +---------------------+

🛠 Tech Stack
Tool	Purpose
Java	Programming Language
Selenium WebDriver	Browser Automation
TestNG	Test Execution Framework
Maven	Build Management
Page Object Model	Design Pattern
Extent Reports	Reporting
Jenkins	CI/CD
Docker	Containerization
Selenium Grid	Parallel & Remote Execution
GitHub	Version Control


⚡ Key Features

✅ Page Object Model (POM) architecture
✅ Thread-safe WebDriver using ThreadLocal
✅ Parallel test execution with TestNG
✅ Cross-browser testing support
✅ Selenium Grid integration
✅ Docker-based grid execution
✅ Jenkins CI/CD pipeline
✅ Extent Reports integration
✅ Automatic screenshots on test failure
✅ Logging support for debugging
✅ Configurable environment setup

📊 Reporting

The framework generates rich HTML reports using Extent Reports.

Features include:

Step-level logging

Screenshot capture on test failure

Test execution summary

Pass/Fail status

Timestamped reports

Example report location:

/reports/ExtentReport.html

🐳 Docker Execution

This framework supports Selenium Grid execution using Docker containers.

Start Grid:

docker-compose up

This will start:

Selenium Hub

Chrome Node

Firefox Node

![image alt](https://github.com/Shaik-ns16/OpenCartV360Final/blob/514084d4c91bba7fe686d4e2302ba5c968604ef4/docker_linux_grid.png)

🔁 Jenkins CI/CD Integration

The project supports automated execution through Jenkins pipeline.

Pipeline workflow:

GitHub → Jenkins → Build → Execute Tests → Generate Reports

Steps:

Jenkins pulls latest code from GitHub

Maven build is triggered

Tests execute on Selenium Grid

Extent Reports are generated

▶️ How to Run the Project

Clone the repository

git clone https://github.com/Shaik-ns16/OpenCartV360Final.git

Navigate to project directory

cd OpenCartV360Final

Run tests using Maven

mvn clean test

Run tests on Selenium Grid

docker-compose up

Run tests via Jenkins pipeline.

📸 Screenshot on Failure

If any test fails, the framework automatically:

Captures screenshot

Attaches it to Extent Report

Logs failure details

🔄 Parallel Execution

Parallel execution is enabled using:

TestNG + ThreadLocal WebDriver

This allows running tests simultaneously across multiple browsers.

👨‍💻 Author

Shaik Noordeen

Automation Test Engineer | Selenium | Java | TestNG | Jenkins | Docker

GitHub:
https://github.com/Shaik-ns16
