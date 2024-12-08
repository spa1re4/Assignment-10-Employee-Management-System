package org.example.employeemanagementfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;

public class EmployeeController {

    @FXML
    private TextField fieldname, fieldhoursworked, fieldhourlywage, fieldsalary;

    @FXML
    private RadioButton radionbuttonfulltime, radiobuttonparttime, radiobuttoncontractor;

    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, String> column1, column2;

    @FXML
    private TableColumn<Employee, Double> column3;

    @FXML
    private Text texthoursworked, texthourlywage, textsalary;

    private ObservableList<Employee> employees = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Настроим таблицу
        column1.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        column2.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
        column3.setCellValueFactory(cellData -> cellData.getValue().getSalaryProperty().asObject());

        table.setItems(employees);
    }

    // Обработчик для выбора "Full Time"
    @FXML
    public void handleFullTimeSelection() {
        if (radionbuttonfulltime.isSelected()) {
            texthoursworked.setVisible(false);
            texthourlywage.setVisible(false);
            fieldhoursworked.setVisible(false);
            fieldhourlywage.setVisible(false);
            fieldsalary.setDisable(false);  // Разрешаем ввод зарплаты
        }
    }

    // Обработчик для выбора "Part Time"
    @FXML
    public void handlePartTimeSelection() {
        if (radiobuttonparttime.isSelected()) {
            texthoursworked.setVisible(true);
            texthourlywage.setVisible(true);
            fieldhoursworked.setVisible(true);
            fieldhourlywage.setVisible(true);
            fieldsalary.setDisable(true);  // Отключаем ввод зарплаты
        }
    }

    // Обработчик для выбора "Contractor"
    @FXML
    public void handleContractorSelection() {
        if (radiobuttoncontractor.isSelected()) {
            texthoursworked.setVisible(true);
            texthourlywage.setVisible(true);
            fieldhoursworked.setVisible(true);
            fieldhourlywage.setVisible(true);
            fieldsalary.setDisable(true);  // Отключаем ввод зарплаты
        }
    }

    // Обработчик для кнопки "Calculate"
    @FXML
    public void onCalculate() {
        String name = fieldname.getText();
        double salary = 0.0;

        // Проверяем, какой тип сотрудника выбран
        if (radionbuttonfulltime.isSelected()) {
            salary = Double.parseDouble(fieldsalary.getText()); // Для FullTimeSalary можно сразу передавать число
        } else if (radiobuttonparttime.isSelected()) {
            double hourlyWage = Double.parseDouble(fieldhourlywage.getText());
            double hoursWorked = Double.parseDouble(fieldhoursworked.getText());
            PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, hourlyWage, hoursWorked);
            salary = partTimeEmployee.getSalary();
        } else if (radiobuttoncontractor.isSelected()) {
            double hourlyRate = Double.parseDouble(fieldhourlywage.getText());
            double maxHours = Double.parseDouble(fieldhoursworked.getText()); // Для Contractor maxHours = max hours per month
            Contractor contractor = new Contractor(name, hourlyRate, maxHours);
            salary = contractor.getSalary();
        }

        // Выводим зарплату в поле
        fieldsalary.setText(String.valueOf(salary));
    }

    // Обработчик для кнопки "Add"
    @FXML
    public void onAdd() {
        String name = fieldname.getText();
        double salary = Double.parseDouble(fieldsalary.getText());
        String type = "";

        if (radionbuttonfulltime.isSelected()) {
            type = "Full Time";
            FullTimeEmployee employee = new FullTimeEmployee(name, salary);
            employees.add(employee);
        } else if (radiobuttonparttime.isSelected()) {
            double hourlyWage = Double.parseDouble(fieldhourlywage.getText());
            double hoursWorked = Double.parseDouble(fieldhoursworked.getText());
            PartTimeEmployee employee = new PartTimeEmployee(name, hourlyWage, hoursWorked);
            employees.add(employee);
        } else if (radiobuttoncontractor.isSelected()) {
            double hourlyRate = Double.parseDouble(fieldhourlywage.getText());
            double maxHours = Double.parseDouble(fieldhoursworked.getText());
            Contractor employee = new Contractor(name, hourlyRate, maxHours);
            employees.add(employee);
        }

        // Обновляем таблицу
        table.refresh();

        // Очищаем поля
        fieldname.clear();
        fieldhoursworked.clear();
        fieldhourlywage.clear();
        fieldsalary.clear();
        radionbuttonfulltime.setSelected(false);
        radiobuttonparttime.setSelected(false);
        radiobuttoncontractor.setSelected(false);
    }
}
