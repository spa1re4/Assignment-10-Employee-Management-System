# Assignment-10-Employee-Management-System
This code represents a controller for a JavaFX application designed to manage employee data in a system where each employee has a specific type (Full-Time, Part-Time, or Contractor), and the salary is calculated based on this type.

Key elements of the code:

UI Components and Data Binding: The user interface includes several input fields: fieldname for the employee's name, fieldhoursworked for the number of hours worked, fieldhourlywage for the hourly wage, and fieldsalary for the salary. These fields are used to input data, which will later be processed and displayed in the table.

The table displays the following data:

Employee Name
Employee Type (Full-Time, Part-Time, Contractor)
Employee Salary
Each of these employee types is implemented in a separate class (FullTimeEmployee, PartTimeEmployee, Contractor), which inherits from a common abstract class Employee. Each of these classes implements a method to calculate the salary based on their own logic.

Selecting Employee Type: There are three radio buttons to select the employee type: radionbuttonfulltime, radiobuttonparttime, radiobuttoncontractor. Depending on the selected type, certain input fields are shown or hidden:

Full Time: Only the fieldsalary input field is displayed, as the salary for a full-time employee is a fixed value.
Part Time and Contractor: The fields for hourly wage and hours worked (fieldhourlywage and fieldhoursworked) are shown. For these types of employees, the salary is calculated based on these inputs.
Salary Calculation: When the "Calculate" button (onCalculate()) is clicked, the program calculates the salary depending on the selected employee type:

For Full-Time employees, the salary is directly taken from the fieldsalary field.
For Part-Time and Contractor employees, the salary is calculated as the product of the hourly wage and hours worked, or the maximum hours for the contractor.
The calculated salary is then displayed in the fieldsalary field.

Adding Employee to the Table: After the user fills in the necessary fields and selects the employee type, they can click the "Add" button (onAdd()) to add the employee to the table. Depending on the selected type, an instance of FullTimeEmployee, PartTimeEmployee, or Contractor is created, and the employee is added to the list of employees, which is displayed in the table.

After adding the employee, all the fields in the form are cleared, and the user can input data for the next employee.

Managing Field Visibility: A key part of this controller is managing the visibility of the input fields based on the selected employee type. If "Full-Time" is selected, the fields for hourly wage and hours worked are hidden, leaving only the salary field. For other employee types, all fields are shown.

Employee Classes: Each employee type (FullTimeEmployee, PartTimeEmployee, and Contractor) implements the getSalary() method, which calculates the salary for that specific type:

FullTimeEmployee: The salary is directly taken from the input field.
PartTimeEmployee: The salary is calculated as the product of the hourly wage and the number of hours worked.
Contractor: The salary is calculated as the product of the hourly rate and the maximum hours worked in a month.
These classes inherit from the abstract Employee class, which defines a common interface for all employee types. This makes it easy to manage all employee types in a unified way while adhering to object-oriented programming (OOP) principles.
![Снимок экрана 2024-11-30 231000](https://github.com/user-attachments/assets/fb6a1a24-3971-4276-8645-5cce6e623991)
![Снимок экрана 2024-11-30 231014](https://github.com/user-attachments/assets/f7ea2e32-5b35-45de-a4b5-8e91ce7c708f)
![Снимок экрана 2024-11-30 231019](https://github.com/user-attachments/assets/51653556-f650-4916-a00d-2ab8ad4214cf)
