package org.example.employeemanagementfx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

abstract class Employee {
    private StringProperty name;
    private StringProperty type;
    private DoubleProperty salary;

    public Employee(String name, String type) {
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.salary = new SimpleDoubleProperty(0.0);
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public StringProperty getTypeProperty() {
        return type;
    }

    public DoubleProperty getSalaryProperty() {
        return salary;
    }

    protected void setSalary(double salary) {
        this.salary.set(salary);
    }

    public double getSalary() {
        return salary.get();
    }

    public abstract void calculateSalary();
}
