module org.example.employeemanagementfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.employeemanagementfx to javafx.fxml;
    exports org.example.employeemanagementfx;
}