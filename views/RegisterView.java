package views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Objects.User;

public class RegisterView extends Application {

    @Override
    public void start(Stage stage) {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20));
        gp.setHgap(10);
        gp.setVgap(15);
        gp.setAlignment(Pos.CENTER);

        // Labels and Fields
        Label titleLabel = new Label("Hi! Welcome new user!\n Enter your credentials below");
        Label nameLabel = new Label("Full Name:");
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");

        TextField nameTF = new TextField();
        TextField usernameTF = new TextField();
        TextField passwordTF = new TextField();

        Button registerBtn = new Button("Register");

        // Add to GridPane
        gp.add(titleLabel, 0, 0, 2, 1); // span 2 columns
        gp.add(nameLabel, 0, 1);
        gp.add(nameTF, 1, 1);
        gp.add(usernameLabel, 0, 2);
        gp.add(usernameTF, 1, 2);
        gp.add(passwordLabel, 0, 3);
        gp.add(passwordTF, 1, 3);
        gp.add(registerBtn, 0, 4, 2, 1); // center button across 2



        //WHAT HAPPENS WHEN YOU CLICK REGISTER--------------
        registerBtn.setOnAction(e -> {
            String fullName = nameTF.getText();
            String username = usernameTF.getText();
            String password = passwordTF.getText();

            if (fullName.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Label enterValues = new Label("PLEASE ENTER YOUR CREDENTIALS!!");
                gp.add(enterValues, 5, 1);

            } else {
                // Call UserManager to register the user
                MainApp.users.add(new User(fullName, username, password));
                Label status = new Label("Registration complete");
                gp.add(status, 5, 2);


                Button userLoginBtn = new Button("User Login");
                userLoginBtn.setOnAction(e1 -> {
                    Stage loginStage = new Stage();
                    userLoginView userLogin = new userLoginView();
                    userLogin.start(loginStage);
                    stage.close(); // close registration window
                });
                gp.add(userLoginBtn, 5, 3);

            }

        });


        // Set up scene and stage
        Scene scene = new Scene(gp, 600, 300);
        stage.setScene(scene);
        stage.setTitle("User Registration");
        stage.show();
    }
}