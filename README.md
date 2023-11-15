# Library Management System

## Objective

The aim of this project is to create a Library Management System using Java that allows users to manage a collection of books. This system will utilize Object-Oriented Programming (OOP) concepts, Java's Graphical User Interface (GUI) capabilities, and Exception Handling.

## Team Information

Team Name: Toshi Fan Club
Team Members: Talal El Zeini, Parth Chouksay, Tyler Biesemeyer

## Pages & Features

### Sign Up Page

- Account Info
    - First Name and Last Name
    - Email (with Requirements not done yet)
    - Role (with Requirements not done yet)
        - Acceptable inputs are:
            - Author, Librarian, Member
            - author, librarian, member
    - Password with Requirements

- Successful Sign Up
    - Library Card ID Generated
    - Library Card ID added to role file
    - You have to go to Sign In Page to get access

- Option to Go to Sign In Page

### Sign In Page

- Sign In with Library Card ID and Password
- Password Requirements
- Option to Go to Sign Up Page

- Successfully Sign In
    - Takes you to the Home Page

### Home Page

- Go to Profile Page
- Go to a specific’s Genre page
- Go to Search Page
- Go to Borrow Page
- Go to Return Page

### Profile Page

- Displays First Name and Last Name
- Displays Email (requirements needed)
- Displays Role (not done yet)
- Option to Change Password (Tyler worked on requirements)
- Option to Log Out
- Option to go back to the HomePage

### Search Page

- Search by ISBN (if textfield is a number)
    - Number detection
    - Has to be exact
    - Spaces are allowed (number will be trimmed)

- Search by Title (if textfield is not a number)
    - Has to be the exact title


### Borrow Page

- Borrow by ISBN (if textfield is not a number)
    - Number detection
    - Has to be exact
    - Spaces are allowed (number will be trimmed)

- If Book in the files has true for “availability”
    - You’re allowed to borrow

- If Book in the files has false for “availability”
    - You will be given an error message not allowing you to borrow

- If not a number
    - Will give invalid input error

### Return Page

- Return by ISBN (if textfield is not a number)
    - Number detection
    - Has to be exact
    - Spaces are allowed (number will be trimmed)

- If Book in the files has false for “availability”
    - You’re allowed to return

- If Book in the files has true for “availability”
    - You will be given an error message not allowing you to return considering you never borrowed it

- If not a number
    - Will give invalid input error

### Genre Page

- There are 9 genres of books in this Library
    - Action and Adventure
    - Fantasy
    - Graphic Novels
    - Mystery
    - Narrative
    - Non fiction
    - Romance
    - Science Fiction
    - Thriller

- In the files/books folder, you’ll see where the Genre Pages are retrieving data from

- You can display the books of a certain genre by clicking on the buttons in the HomePage