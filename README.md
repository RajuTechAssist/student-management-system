# Student Management System (Servlet-based)

This project is a simple student management system built using Java Servlets, JSP, and a MySQL database. It allows basic operations like adding, searching, updating, and deleting student records.

## Features

*   **Add Student:** Allows adding new student records, including personal details, marks for various subjects, and a photo.
*   **Search Student:** Allows searching for a student by their ID and displaying their details, marks, and photo.
*   **Update Student:** Allows updating existing student records.
*   **Delete Student:** Allows deleting a student record by their ID.
*   **Basic Layout and Styling**: Provides a user-friendly layout with a header, navigation, and footer using CSS.
*   **Database Persistence**: Uses MySQL database for data storage and retrieval.

## Technologies Used

*   **Java Servlets:** For handling the application's logic and processing user requests.
*   **JSP (JavaServer Pages):** For creating dynamic web pages and user interfaces.
*   **MySQL:** For the database to store student information.
*   **JDBC (Java Database Connectivity):** For interaction with the database.
*   **HTML/CSS:** For structuring and styling web pages.
*   **JSTL (JSP Standard Tag Library):** For use of tags in JSP pages.

## Setup and Installation

1.  **Clone Repository:**
    ```bash
    git clone <your-repository-url>
    ```
2.  **Import to Eclipse IDE:**
    *   Open Eclipse IDE.
    *   Go to `File -> Import -> Existing Projects into Workspace`
    *   Select the project folder which contains project source code.
3.  **MySQL Database Setup:**
    *   Ensure that you have MySQL installed and running.
    *   Create a database named `student_management`.
    *   Run the `CREATE TABLE` queries that was provided in the previous response to create necessary tables (`students` and `marks`).
4.  **Configure JDBC Connection:**
     *  Update the database URL, username, and password in `com.example.dao.StudentDao.java` to match your MySQL configuration.
5.  **Add MySQL Driver:**
    *  Download MySQL JDBC driver (`.jar`) file from the official website and then add to project classpath using `Project -> Properties -> Java Build Path -> Libraries -> Add External JARs`.
6.  **Tomcat server setup**:
    * Make sure that you have Tomcat server configured in Eclipse.
7. **Run the project:** Right click on the project and click `Run As -> Run On Server`.

## How to Use

1.  **Access the Application:** Once the Tomcat server is started, access the application through your web browser using URL like `http://localhost:8080/StudentManagement`.
2.  **Navigate:** Use the links on the main page to perform various operations (add, search, update, delete).
3.  **Follow the On-Screen Prompts:** Provide the necessary details and submit the forms.

## Future Upgrades

This project is a foundational step towards a more robust application. I plan to keep upgrading it in future by:

*   **Migrating to Spring Boot Microservices:**  To handle backend functionality and provide API endpoints.
*   **Developing the Front-end with React.js:** For creating a rich and interactive user experience.
*  **Implementing advanced features:** Like adding user authentication and authorization, creating pagination, filtering, sorting and other advanced features in both frontend and backend.

## Contributions

Feel free to fork this repository and contribute to this project. Any contributions or suggestions are welcome.

## Contact

If you have any questions or suggestions feel free to create an issue or send me a message.

## License

This project is open source and available under the [MIT License](https://opensource.org/licenses/MIT).
