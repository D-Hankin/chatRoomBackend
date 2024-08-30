# Chat Application Backend

This README provides instructions for setting up and running the backend server for the chat application. The backend uses Spring Boot and MongoDB Atlas for managing chat rooms and messages. The corresponding client can be found at https://github.com/D-Hankin/chatRoomFrontend.

## Prerequisites

1. **Java Development Kit (JDK)**: Ensure JDK 11 or higher is installed.
2. **Maven**: Apache Maven is required for building the project.
3. **MongoDB Atlas Account**: Required for managing your database.

## Setup

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Set Up Environment Variables**

Create a `.env` file in the root directory of the project with the following content:

```env
MONGODB_URI=<your-mongodb-atlas-connection-uri>
```
Replace <your-mongodb-atlas-connection-uri> with the connection URI provided by MongoDB Atlas.

3. **Run the Application**

1. **Build the Project:**

   Run the built-in compiler to start the server or if you prefer to use maven:

   Navigate to the root directory of the project and run the following command to build the project:

   ```bash
   ./mvnw clean package
   ```
  Run the application using the following command:

  ```bash
  ./mvnw spring-boot:run
  ```

   

   
