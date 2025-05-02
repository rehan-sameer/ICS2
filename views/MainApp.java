package views;

import Objects.Reservation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import Objects.Room;
import Objects.User;

import java.util.ArrayList;

public class MainApp extends Application {

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static ArrayList<Reservation> reservations = new ArrayList<>();
    public static User Admin = new User ("admin", "admin", "admin");
    @Override
    public void start(Stage applicationStage) {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(30, 30, 30, 30));
        gp.setHgap(20);
        gp.setVgap(20);
        gp.setAlignment(Pos.CENTER);

        Label welcomeMessage = new Label("Welcome to the Reservation System!");
        gp.add(welcomeMessage, 0, 0, 2, 1);

        Button userLoginBtn = new Button("User Login");
        userLoginBtn.setMinWidth(150);
        userLoginBtn.setOnAction(e -> {
            Stage loginStage = new Stage();
            userLoginView userLogin = new userLoginView();
            userLogin.start(loginStage);
        });

        Button adminLoginBtn = new Button("Admin Login");
        adminLoginBtn.setMinWidth(150);
        adminLoginBtn.setOnAction(e -> {
            Stage loginStage = new Stage();
            adminLoginView adminLogin = new adminLoginView();
            adminLogin.start(loginStage);
        });

        Button registerBtn = new Button("Register");
        registerBtn.setMinWidth(150);
        registerBtn.setOnAction(e -> {
            Stage loginStage = new Stage();
            RegisterView register = new RegisterView();
            register.start(loginStage);
        });

        gp.add(userLoginBtn, 0, 1);
        gp.add(adminLoginBtn, 0, 2);
        gp.add(registerBtn, 0, 3);

        Scene scene = new Scene(gp, 400, 350);
        applicationStage.setScene(scene);
        applicationStage.setTitle("Welcome Screen");
        applicationStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
