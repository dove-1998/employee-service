# 👩‍💻 **Employee Service — Java Streams + Spring Boot Project**

A **Spring Boot application** that manages employees and demonstrates **extensive use of Java 8 Streams** for data filtering, grouping, and aggregation operations.  
Perfect for interview practice and backend learning.

---

## 🚀 Features

- CRUD operations for Employee entities  
- Department-wise and salary-wise analysis using Java Streams  
- REST APIs for employee operations  
- Filter, group, and map employee data using Streams  
- Compute salary statistics (max, min, average)  
- In-memory H2 database for quick testing  

---

## 🛠️ Tech Stack

| Layer | Technology |
|--------|-------------|
| Language | Java 17 |
| Framework | Spring Boot 3 |
| Persistence | Spring Data JPA |
| Database | H2 (or MySQL optional) |
| Build Tool | Maven |
| Others | Lombok, Java Streams API |

---
## 💡 Java Streams Operations Used

| No. | Operation | Description |
|-----|------------|-------------|
| 1 | `filter()` | Filter employees by salary or department |
| 2 | `map()` | Transform employee entities to DTOs |
| 3 | `sorted()` | Sort by salary or name |
| 4 | `collect(Collectors.groupingBy())` | Group employees by department |
| 5 | `reduce()` | Calculate total salaries |
| 6 | `Collectors.averagingDouble()` | Compute average salary |

---

| Endpoint                            | Description                        |
| ----------------------------------- | ---------------------------------- |
| `GET /api/employees`                | List all employees                 |
| `GET /api/employees/department/IT`  | Employees in IT dept               |
| `GET /api/employees/top-earners`    | Top 3 highest salaries             |
| `GET /api/employees/average-salary` | Average salary by department       |
| `GET /api/employees/senior`         | Employees older than 40            |
| `GET /api/employees/total-salary`   | Total salary payout                |
| `GET /api/employees/max-dept`       | Department with highest avg salary |
