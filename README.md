# ATM Interface

This project simulates an ATM system in Java. The application is console-based and allows users to perform various banking operations after successful authentication. The system supports multiple users, each with their own account balance and transaction history.

## Features

1. **Transactions History**: View a list of all transactions performed by the user.
2. **Withdraw**: Withdraw a specified amount from the user's account.
3. **Deposit**: Deposit a specified amount into the user's account.
4. **Transfer**: Transfer a specified amount from the user's account to another user's account.
5. **Check Balance**: Display the current balance of the user's account.
6. **Quit**: Exit the ATM system.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code).

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/gulam1288/OIBSIP-03.git
    ```
2. Navigate to the project directory:
    ```sh
    cd OIBSIP-03
    ```

## Usage

1. Compile the Java files:
    ```sh
    javac ATMInterface.java
    ```
2. Run the application:
    ```sh
    java ATMInterface
    ```

3. Follow the on-screen instructions to use the ATM functionalities.

## Code Structure

The project is divided into the following classes:

- `Account`: Represents a user's account, containing user ID, PIN, balance, and transaction history.
- `ATM`: Manages the ATM operations including authentication and menu-driven functionalities.
- `ATMInterface`: The main class to run the ATM system.

## Example

Here's a simple example of how to interact with the ATM Interface:

1. **Start System:**

    ```
    ---------------------------------------------------
                   Welcome to the ATM!
    ---------------------------------------------------
    Enter user ID: 
    Enter user PIN: 
    ```

2. **Main Menu:**

    ```
    ATM Menu:
    1. Transactions History
    2. Withdraw
    3. Deposit
    4. Transfer
    5. Check Balance
    6. Quit
    Enter your choice: 
    ```

3. **Perform Operation:**

    ```
    Enter amount to withdraw: 
    Withdrawal successful. Current balance: 

## Acknowledgements

This project is part of my Java Development Internship at Oasis.
