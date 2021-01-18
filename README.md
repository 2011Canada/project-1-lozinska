# ERS-Base
## Description
The Expense Reimbursement System (ERS) is to manage the process of expense reimbursement. It is required different functionalities by Finance Managers and Employees.

## Technology Used
### FrontEnd
- JavaScript
- HTML
- Bootstrap
- Fetch API

### BackEnd
- JAVA
- JDBC
- PostgreSQL database
- Tomcat Server (Servlet)
- FrontController
- CORS

## Development Tools
- Eclipse
- Visual Studio Code
- Postman
- Amazon Web Service(AWS)
- DBeaver

## Features
### Employees
- can login
- can submit requests for reimbursement
- can view past tickets
- can view pending lists

### Finance Managers
- can login
- can view all reimbursements
- can view reimbursements by status (pending, approved, rejected)
- can approve and reject reimbursement requests

### To-do list
- Add additional styling to make the webpage responsive 

## Getting Started
- ##### Windows/Mac git clone command:
`git clone 2011Canada/project-1-lozinska.git`
- ##### Java version 8:
https://www.oracle.com/ca-en/java/technologies/javase-downloads.html 
- ##### DBeaver for DDL
https://dbeaver.io/download/
- ##### RDS setup on AWS
https://aws.amazon.com/

#### Steps
- Open Dbeaver and connect to the RDS created on AWS
- Run the database script to create the database and tables
- Start the application on tomcat server
- Navigate to http://localhost:8080/project1/login.html
- login as an employee or a finance manager
### Usage
- Employee can login
- Employee can view pending all requests 
- Employee can create a new request with a given amount, type of reimbursement and a short description
- Finance manager can login
- Finance manager can view all pending/approved/denied requests 
- Finance manager can approve or deny a reimbursement request

### License
- The project is under the GNU General Public License
