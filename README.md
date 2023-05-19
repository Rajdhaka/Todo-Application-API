# TODO API APPLICATION


## Built With
* `Java 17`
* `Maven 4.0.0`
* `Spring Boot 3.0.5`
* `IntelliJ IDEA 2023.1 (Community Edition)`

## Data Flow

### 1. Model:
* It consists of **Todo** entity class along with their data members and member functions
* Used **_@Table_** and **_@Entity_** annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like _**@Data,**_ **@_NoArgsConstructor_**, **_@AllArgsConstructor_** getters and setters for those object generate automatically.

### 2. Controller:
* It consists of  **TodoController**  class in which used the annotations like **@RestController** to annotate the class as Controller.
* Used annotation **_@GetMapping_** , **_@PostMapping_** , **_@PutMapping_** , **_@DeleteMapping_** to map the HTTP web requests to the specific handler methods.

<br>

### API Reference:

<br>

>Todo's API References

<br>

* Add Todos:
```*.sh-session
  http://localhost:8080/todos
```

* Get All Todos:
```*.sh-session
  http://localhost:8080/todos
```

* Get Todo By Id:
```*.sh-session
  http://localhost:8080/todo/{todoId}
```
* Get Todos By status:
```*.sh-session
  http://localhost:8080/todos/status/{status}
```

* Update Todo Status By Id:
```*.sh-session
  http://localhost:8080/todos/{todoId}/{status}
```

* Delete Todo By Id:
```*.sh-session
  http://localhost:8080/todos/{todoId}
```

<br>


### 3. Service:
* It consists of **TodoService** class in which provide some business functionalities of every handler methods.
* Used _**@Service**_ annotation to indicate that a class belongs to the service layer.

### 4. Repository:
* It consists of **TodoDao** class for CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used **Iterable** to manage the data of entity classes by performing CRUD operations.
* Used _**@Repository**_ annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.


## Project Summary
* The aim of this project to create a Todo App by performing CRUD operation like add,get,delete and update
