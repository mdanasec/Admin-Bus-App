# Admin Bus Management System

## Overview
The **Admin Bus Management System** is a powerful and scalable web application designed to streamline the administration of bus schedules, management, and verification. Built with Java, Spring Boot, and React.js, this system allows administrators to efficiently manage bus information, including adding, updating, and verifying bus details, as well as managing admin user accounts. The system ensures smooth operation with secure login, easy-to-use interfaces, and a robust API.

## Features
- **Admin Management**: Create, update, and manage admin user accounts.
- **Bus Management**: Add, update, and view bus schedules and details.
- **Search Functionality**: Search buses by ID, number, date of departure, and location.
- **User Authentication**: Secure admin login using phone or email verification with OTP.
- **Responsive UI**: Intuitive, user-friendly interface built with React.js for seamless interactions.
- **API Integration**: RESTful APIs for smooth communication between the backend and frontend.
- **Cross-Origin Support**: CORS support for local development with React frontend.

## Technologies Used
- **Backend**: 
  - Java
  - Spring Boot
  - Spring Framework
  - Spring Data JPA
  - MySQL
- **Frontend**: 
  - React.js
  - CSS
- **Authentication**: OTP-based login
- **API Testing**: Postman for testing REST APIs

## RESTful API Endpoints

### Admin Management
1. **Create Admin**
   - **Endpoint**: `POST /admin`
   - **Description**: Register a new admin user.
   - **Request Body**: `Admin` object.
   - **Response**: Returns the created admin details.

2. **Update Admin**
   - **Endpoint**: `PUT /admin`
   - **Description**: Update an existing admin's details.
   - **Request Body**: `Admin` object.
   - **Response**: Returns the updated admin details.

3. **Get Admin by ID**
   - **Endpoint**: `GET /admin/id/{id}`
   - **Description**: Retrieve an admin by their ID.
   - **Response**: Returns the admin details.

4. **Verify Admin by Phone**
   - **Endpoint**: `GET /admin/phone`
   - **Description**: Verify admin login using phone number and password.
   - **Request Parameters**: `phone`, `password`.
   - **Response**: Returns admin details upon successful verification.

5. **Verify Admin by Email**
   - **Endpoint**: `GET /admin/email`
   - **Description**: Verify admin login using email and password.
   - **Request Parameters**: `email`, `password`.
   - **Response**: Returns admin details upon successful verification.

### Bus Management
1. **Create Bus**
   - **Endpoint**: `POST /bus/{admin_id}`
   - **Description**: Add a new bus to the system.
   - **Request Body**: `Bus` object.
   - **Response**: Returns the created bus details.

2. **Update Bus**
   - **Endpoint**: `PUT /bus/{admin_id}`
   - **Description**: Update an existing bus’s details.
   - **Request Body**: `Bus` object.
   - **Response**: Returns the updated bus details.

3. **Get Bus by ID**
   - **Endpoint**: `GET /bus/findById/{id}`
   - **Description**: Retrieve bus details by bus ID.
   - **Response**: Returns bus details.

4. **Find Bus by Departure Date**
   - **Endpoint**: `GET /bus/dateOfDep`
   - **Description**: Find buses by their date of departure.
   - **Request Parameters**: `dateOfDeparture`
   - **Response**: Returns a list of buses that match the departure date.

5. **Get Bus by Bus Number**
   - **Endpoint**: `GET /bus/busNum/{busNumber}`
   - **Description**: Find bus details by bus number.
   - **Response**: Returns bus details.

6. **Find Bus by Location**
   - **Endpoint**: `GET /bus/busLoc`
   - **Description**: Find buses based on departure date, origin, and destination.
   - **Request Parameters**: `dateOfDeparture`, `fromLocation`, `toLocation`
   - **Response**: Returns a list of buses matching the specified criteria.

## Setup Instructions

### Prerequisites
- JDK 11 or higher
- MySQL database
- Node.js (for React frontend)

### Backend Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/mdanasec/Admin-Bus-App.git
