UniversityAcceptance App

Overview

The UniversityAcceptance App is a Java-based desktop application designed to assist students in tracking university admissions criteria and predicting their acceptance likelihood. It combines a user-friendly GUI with robust backend functionality to store and analyze data. The app includes database management, document and image storage, and advanced validation techniques.

Features

Core Functionalities
Swing GUI: Interactive graphical user interface for seamless user interaction.
SQLite Integration: Stores data about universities, GPA, SAT scores, documents, and images using an SQLite database.
Data Prediction: Implements algorithms to predict university acceptance likelihood based on user input.
Document and Image Storage: Efficiently stores documents as BLOBs and image URLs in the database.
Validation: Ensures data integrity with presence, range, and type/format checkers.
Additional Features
Event Handling: Buttons and other GUI components trigger specific actions for smooth navigation.
Error/Exception Handling: Try-catch blocks and manage exceptions to prevent application crashes.
Data Visualization: Generates charts using JFreeChart to provide insights into the data.
Email Functionality: Allows users to send predictions to advisors via email using the JavaxMail library.
File Uploads: Enables users to upload documents like transcripts using JFileChooser.

Tools and Technologies

Language: Java
Database: SQLite (JDBC integration with DB Browser for SQLite)
IDE: Eclipse Neon.3 with Tomcat 7

Libraries:

JavaxMail for email handling
JFileChooser for file uploads
JFreeChart for data visualization
Installation

Prerequisites

Java Development Kit (JDK) 8 or higher
Eclipse IDE or any compatible Java IDE
SQLite and DB Browser for SQLite
Setup Steps
Clone the repository:
git clone <repository-url>
Open the project in Eclipse.

Install required libraries by adding the following JAR files:
JDBC Driver
JavaxMail
JFreeChart

Configure the SQLite database:

Use DB Browser to create tables (e.g., Universities, Minimum GPA, Average GPA, SAT scores).

Run the application:

Launch the main class UniversityAcceptanceApp.java from the IDE.

Usage

Sign Up and Log In:

Create an account using the SignUp page.
Log in with your credentials to access the dashboard.

Input Data:

Enter university information, including GPA and SAT requirements.
Upload documents using the file upload feature.

Predict Acceptance:

Use the Predictor module to calculate your likelihood of acceptance.

Visualize Data:

View graphical insights using the JFreeChart integration.

Send Results:

Share predictions with university advisors via email.

Project Structure

Main Classes:

DB: Manages database interactions.

Calculator: Contains logic for GPA and SAT calculations.

Predictor: Implements algorithms for acceptance predictions.

GUI Components:

Stage1JFrame, Stage2JFrame, etc.: Manage different stages of user interaction.

Key Techniques

Database Management
Designed tables for structured data storage.
Used SQL queries for efficient data retrieval and manipulation.
Error Handling
Implemented try-catch blocks to handle exceptions like IOException and SQLException.

Validation

Presence checker: Ensures mandatory fields are filled.
Range checker: Validates GPA and SAT score ranges.
Type/format checker: Ensures correct data types for input fields.
External Libraries
JavaxMail: Sends emails with predictions.
JFileChooser: Allows file selection for uploads.
JFreeChart: Creates visual representations of data.



This project is licensed under the MIT License. See the LICENSE file for details.

Contact

For any inquiries, please reach out to heidynaranjo@brandeis.edu
