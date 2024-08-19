# Lecturer Information Management System
This project is a web application for managing lecturer information, built using ReactJS for the frontend and Spring Boot for the backend. The application allows users to add, update, reset, search, and filter a list of lecturers with detailed information.

## Features
- Add Lecturer: A form to add new lecturers with details such as name, education level, type, and more.
- Update Lecturer: Update existing lecturer details.
- Reset Form: Clear all form fields to their default values.
- View Lecturer List: A table that lists all lecturers with pagination and filtering by education level.
- Search Lecturers: Search for lecturers by keyword across various fields (e.g., name, ID).
- Filter by Education Level: Filter the lecturer list by selected education level to narrow down the results.

## Technologies Used
- Frontend: ReactJS, Material-UI
- Backend: Spring Boot, Maven, API
- Database: MySQL

## Installation Steps
1. Clone the repository

```
git clone https://github.com/your-username/lecturer-information-management.git
```

2. Navigate to the frontend directory and install dependencies

```
cd lecturer-information-management/frontend/lecturerfrontend
```

3. Navigate to the backend directory and build the project

```
cd ../backend
```

4. Configure the database
- Update the application.properties file with your database connection details.
5. Run the backend server
6. Run the frontend development server

```
cd lecturer-information-management/frontend/lecturerfrontend
npm start
```

## Running the Application
Run on http://localhost:3000.
