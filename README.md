# Library Management System

## Objective

The aim of this project is to create a Library Management System using Java that allows users to manage a collection of books. This system will utilize Object-Oriented Programming (OOP) concepts, Java's Graphical User Interface (GUI) capabilities, and Exception Handling.

## Team Information

Team Name: Toshi Fan Club
Team Members: Talal El Zeini, Parth Chouksay, Tyler Biesemeyer

## Run Project

- By running Main.java
- Opening App.jar file
    - If any issues are encountered attempting to run "java --enable-preview -jar App.jar" in the terminal would potentially help

## Contributions

## Project proposal contributions:

- Everyone contributed to the proposal/README.md file. Ideas were discussed over Discord before any commits.
- Everyone also contributed to this README.md file, and verified the accuracy of their contributions.
- There were no specific roles, everyone contributed to a lot of the features and fixed any bugs needed. The following is just a general idea of what every person focuses on.

## Talal’s contributions

- UI Design & Frontend
- Panels Management & Switching between them
- Borrow & Return Functionality (Updating file)
- Buttons to switch between pages (and back buttons)
- Genre screens showing all books
- Added some comments
- Sign Up & Sign In Feature and password requirement handling
- Started the search functionality and made it somewhat work which Tyler later improved 
- Filled readme with all features
- Participated project presentation
- Worked on proposal
- Created jar file

## Tyler's contributions

- Making search feature work and more efficient
- Removed any issues with the search
- Fixed bugs in search and publish functions
- Created add and remove book feature
- Adding comments
- Participated in project presentation
- Worked on proposal

## Parth’s contributions
- Email requirements and handling with sign-up and sign-in
- User role requirements and handling
- Created/Designed all of the diagrams, and created the corresponding directory
- Finding Books 
- Worked on a lot of backend functions and classes, declared backend files
- Fixed bugs related to Sign In/Log In, Exceptions, and Formatting
- Adding comments and edited code for readability
- Worked on proposal
- Participated in project presentation

## Pages & Features

### Sign Up Page

- Account Info
    - First Name and Last Name
    - Email (with Requirements)
    - Role (with Requirements)
        - Acceptable inputs are:
            - Author, Librarian, Member
            - author, librarian, member
    - Password (with Requirements)

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
- Displays Role
- Option to Change Password
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