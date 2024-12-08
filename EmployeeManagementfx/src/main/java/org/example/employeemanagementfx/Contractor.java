package org.example.employeemanagementfx;

class Contractor extends Employee {
    private double hourlyRate;
    private double maxHours;

    public Contractor(String name, double hourlyRate, double maxHours) {
        super(name, "Contractor");
        this.hourlyRate = hourlyRate;
        this.maxHours = maxHours;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        double salary = hourlyRate * maxHours;
        setSalary(salary);
    }
}
