create database hrms;
use hrms;

CREATE TABLE department (
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(50)
);

CREATE TABLE employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    dept_id INT,
    salary DOUBLE,
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

CREATE TABLE payroll (
    payroll_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT,
    basic_salary DOUBLE,
    deductions DOUBLE,
    net_salary DOUBLE,
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);

CREATE TABLE leave_requests (
    leave_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT,
    leave_days INT,
    status VARCHAR(20),  -- Pending, Approved, Rejected
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);

select * from employee;
