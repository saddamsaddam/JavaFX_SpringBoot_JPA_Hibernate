package org.example.spring;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavaFxController {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public JavaFxController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void initialize(Stage primaryStage) {
        primaryStage.setTitle("Registration Form");

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String email = emailField.getText();

            // Save registration data to the database
            Registration registration = new Registration();
            registration.setName(name);
            registration.setEmail(email);
            registrationRepository.save(registration);

            System.out.println("Name: " + name + ", Email: " + email + " saved to the database");
        });

        VBox root = new VBox(nameLabel, nameField, emailLabel, emailField, submitButton);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
