# Spring Boot Application Development Instructions

## Project Setup
- Use Maven as the build tool
- Create a Spring Boot application with Java 11 or higher
- Add Spring Data JPA for database operations
- Configure PostgreSQL as the primary database

## Dependencies
Add the following to `pom.xml`:
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- postgresql driver
- spring-boot-starter-test
- junit4 or junit5
- mockito
- mockito-junit-jupiter (for JUnit 5)

## Database Configuration
- Configure `application.properties` or `application.yml` with PostgreSQL connection details
- Set up Hibernate dialect for PostgreSQL

## Clean Code and Naming Conventions
- Follow PascalCase for class names (e.g., `EmployeeService`, `UserRepository`)
- Use camelCase for method and variable names (e.g., `getEmployeeById()`, `employeeCount`)
- Use UPPER_SNAKE_CASE for constants (e.g., `MAX_RETRY_ATTEMPTS`)
- Package names should be lowercase and follow reverse domain notation (e.g., `com.example.ems.service`)
- Keep classes and methods focused with single responsibility principle
- Avoid magic numbers; use named constants instead
- Write self-documenting code with clear, descriptive names
- Keep methods small and focused (ideally under 20 lines)
- Use meaningful comments for complex logic, not obvious code
- Remove unused imports and dead code
- Use Java naming conventions from Oracle guidelines consistently
- Enable JPA repository auto-configuration

## Testing Framework
- Use JUnit 5 as the testing framework
- Integrate Mockito for unit testing and mocking dependencies
- Use `@Mock` and `@InjectMocks` annotations for dependency injection in tests
- Annotate test classes with `@ExtendWith(MockitoExtension.class)`

## Project Structure