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

public class adminLoginView {
    public static Scene adminLoginView() {
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(15);
        gp.setPadding(new Insets(20, 20, 20, 20)); // top, right, bottom, left
        gp.setAlignment(Pos.CENTER);


        Label loginLabel = new Label("Admin Login Screen");
        Label usernameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");
        TextField usernameTF = new TextField();
        TextField passwordTF = new TextField();
        Button loginBtn = new Button("Login");
        Button cancelBtn = new Button("Cancel");

        gp.add(loginLabel, 0, 0);
        gp.add(usernameLabel, 0, 1);
        gp.add(usernameTF, 1, 1);
        gp.add(passwordLabel, 0, 2);
        gp.add(passwordTF, 1, 2);
        gp.add(loginBtn, 2, 3);
        gp.add(cancelBtn, 1, 3);

        loginBtn.setOnAction(e -> {
            String inputUsername = usernameTF.getText();
            String inputPassword = passwordTF.getText();

            if (inputUsername.equals("admin") && inputPassword.equals("admin")) {
                Stage loginStage = new Stage();
                views.AdminDashboardView userLogin = new views.AdminDashboardView();
                userLogin.start(loginStage);
            } else {
                Label messageLabel = new Label("Invalid username or password");
                gp.add(messageLabel, 1, 4);
            }
        });
        cancelBtn.setOnAction(e -> {

        });


        Scene scene = new Scene(gp, 400, 220);
        return scene;
    }
}