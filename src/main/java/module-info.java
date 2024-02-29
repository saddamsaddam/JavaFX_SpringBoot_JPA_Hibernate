open module Spring{
    requires javafx.fxml;
    requires javafx.controls;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires javafx.graphics;
    requires java.base;
    requires jakarta.persistence;
    requires spring.data.jpa;
    requires spring.beans;
    exports org.example.spring;
}
