# Employee Management (Java, Spring Boot)

Minimal Employee Management System.

Run:
- Requires Java 11 and Maven.
- Build: `mvn clean package`
- Run: `mvn spring-boot:run` or `java -jar target/employee-management-0.0.1-SNAPSHOT.jar`
- Access: http://localhost:8080/employees
- H2 Console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:employeedb)

Default users (in-memory):
- HR: hr / hrpass (ROLE_HR)
- Employee: employee / emppass (ROLE_EMPLOYEE)

This project includes basic employee CRUD, departments, login and role-based access.
