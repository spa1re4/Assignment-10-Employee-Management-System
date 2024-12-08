package org.example.employeemanagementfx;

class PartTimeEmployee extends Employee {
    private double hourlyWage;
    private double hoursWorked;

    public PartTimeEmployee(String name, double hourlyWage, double hoursWorked) {
        super(name, "Part Time");
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        double salary = hourlyWage * hoursWorked;
        setSalary(salary);
    }
}
