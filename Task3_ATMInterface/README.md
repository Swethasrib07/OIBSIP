# Task 3 - ATM Interface

## Project Overview
The ATM Interface is a console-based Java application that simulates
basic ATM banking operations. It demonstrates Object-Oriented Programming
(OOP) concepts and allows users to perform banking transactions securely.

## Features
- User ID and PIN authentication
- Access denied after three incorrect login attempts
- Transaction history using ArrayList
- Withdraw money with balance validation
- Deposit money
- Transfer money between accounts
- Check account balance
- Input validation for amounts and menu choices
- Quit option with a goodbye message

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Scanner
- Switch-case

## Project Structure
- Main.java - Starts the application and handles login
- ATM.java - Handles the ATM menu and transactions
- Account.java - Stores account details and balance
- Bank.java - Manages accounts and authentication
- Transaction.java - Stores transaction details

## Demo Credentials

| User ID | PIN  | Account ID | Initial Balance |
|---------|------|------------|-----------------|
| user1   | 1234 | 1001       | Rs. 10,000      |
| user2   | 5678 | 1002       | Rs. 5,000       |
| user3   | 9999 | 1003       | Rs. 7,500       |

These credentials are for demonstration purposes only.

## How to Run
1. Open the project in IntelliJ IDEA.
2. Ensure all five Java classes are present.
3. Run Main.java.
4. Enter a valid User ID and PIN.
5. Select an option from the ATM menu.

## Limitations
- Account details are stored in memory.
- Transactions are not saved after the program exits.
- This is an educational simulation, not a real banking application.

## Author
Java Internship Project - OIBSIP
