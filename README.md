# Library Management System
This project is designed to manage library items, authors, and patrons efficiently. This application allows librarians to handle basic library functions, such as adding and managing items, authors, and patrons, as well as borrowing and returning items.
## Features
- **Library Item Management**
  - Manage different types of library items, including **Books** and **Periodicals**
  - Support for different formats: printed, electronic, and audio.
  - Search functionality for items by title, author, or ISBN.

- **Author Management**
  - Add, edit, and delete author information.
  - Manage a list of items written by each author.

- **Patron Management**
  - Add, edit, and delete patrons (e.g., **Students** and **Employees**).
  - Each patron can borrow and return items, with a record of currently borrowed items.

- **Borrowing and Returning Library Items**
  - Patrons can borrow items if available, and the system will update the status and inventory accordingly.
  - Items can be returned and added back to the library’s available collection.

## Class Structure
The system is organized into the following main classes:

- **Library**: Manages the entire collection of items, authors, and patrons.
- **LibraryItem**: Represents any item in the library, with subclasses for **Book** and **Periodical**
- **Author**: Holds author details and a list of authors items.
- **Patron**: Represents library users and the items they have borrowed

## Installation
1. **Clone the Repository:**
   git clone <repository-url>

2. **Open in IDE:**
Open the project in an IDE like Visual Studio Code

3. **Run the Demo Class:**
The LibraryDemo class contains a menu interface to test the project functionality. Run it to interact with the system.

## Usage
Follow the menu options in the console to add, edit, delete, borrow, or return items.
Search items by title, author, or ISBN and see the available status.
