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

public class adminLoginView extends Application {

    @Override
    public void start(Stage stage) {
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

        gp.add(loginLabel, 0, 0);
        gp.add(usernameLabel, 0, 1);
        gp.add(usernameTF, 1, 1);
        gp.add(passwordLabel, 0, 2);
        gp.add(passwordTF, 1, 2);
        gp.add(loginBtn, 2, 3);

        loginBtn.setOnAction(e -> {
            Stage loginStage = new Stage();
            AdminDashboardView userLogin = new AdminDashboardView();
            userLogin.start(loginStage);
        });


        Scene scene = new Scene(gp, 400, 220);
        stage.setScene(scene);
        stage.setTitle("Admin Login");
        stage.show();
    }
}