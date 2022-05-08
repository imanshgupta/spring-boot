# spring-boot
SAMPLE SPRING BOOT REST API USING MYSQL DATABASE
@RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.

An EmployeeRepository is injected by constructor into the controller.

We have routes for each operation (@GetMapping, @PostMapping, @PutMapping and @DeleteMapping, corresponding to HTTP GET, POST, PUT, and DELETE calls). (NOTE: It’s useful to read each method and understand what they do.)

EmployeeNotFoundException is an exception used to indicate when an employee is looked up but not found.
