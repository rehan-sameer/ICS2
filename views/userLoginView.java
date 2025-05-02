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

public class userLoginView extends Application {

    @Override
    public void start(Stage stage) {
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(15);
        gp.setPadding(new Insets(20, 20, 20, 20)); // top, right, bottom, left
        gp.setAlignment(Pos.CENTER);


        Label loginLabel = new Label("User Login Screen");
        Label usernameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");
        TextField usernameTF = new TextField();
        TextField passwordTF = new TextField();
        Button loginBtn = new Button("Login");

        gp.add(loginLabel, 0, 0);
        gp.add(usernameLabel, 0, 1);
        gp.add(usernameTF, 1, 1);
        gp.add(passwordLabel, 0, 2);
        gp.add(passwordTF, 1, 2);
        gp.add(loginBtn, 2, 3);

//        loginBtn.setOnAction(e -> {
//            Stage loginStage = new Stage();
//            UserDashboardView userLogin = new UserDashboardView();
//            userLogin.start(loginStage);
//        });
        Label messageLabel = new Label(""); // starts empty
        gp.add(messageLabel, 1,4);

        loginBtn.setOnAction(e -> {
            String inputUsername = usernameTF.getText();
            String inputPassword = passwordTF.getText();

            boolean valid = false;

            for (User user : MainApp.users) {
                if (user.getUsername().equals(inputUsername) &&
                        user.getPassword().equals(inputPassword)) {
                    valid = true;
                    break;
                }
            }

            if (valid) {
                messageLabel.setText(""); // clear any previous error
                // open user dashboard
                UserDashboardView dashboard = new UserDashboardView();
                Stage dashboardStage = new Stage();
                dashboard.start(dashboardStage);
                stage.close(); // optional: close login window
            } else {
                messageLabel.setText("Invalid username or password. \nRegister if new user");
                Button registerBtn = new Button("Register");
                registerBtn.setMinWidth(150);
                registerBtn.setOnAction(e1 -> {
                    Stage loginStage = new Stage();
                    RegisterView register = new RegisterView();
                    register.start(loginStage);
                    stage.close(); // close login window
                });
                gp.add(registerBtn,1,6);

            }
        });


        Scene scene = new Scene(gp, 600, 400);
        stage.setScene(scene);
        stage.setTitle("User Login");
        stage.show();
    }
}