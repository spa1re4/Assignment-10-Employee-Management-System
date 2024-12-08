package org.example.employeemanagementfx;

class FullTimeEmployee extends Employee {
    private double annualSalary;

    public FullTimeEmployee(String name, double annualSalary) {
        super(name, "Full Time");
        this.annualSalary = annualSalary;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        setSalary(annualSalary);
    }
}
