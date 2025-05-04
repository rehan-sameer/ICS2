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
import views.adminLoginView;
import views.RegisterView;
import views.userLoginView;
import views.AddNewRoomView;


import java.util.ArrayList;

public class MainApp extends Application {

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static ArrayList<Reservation> reservations = new ArrayList<>();
    public static User Admin = new User ("admin", "admin", "admin");
    public static User currentUser;

    @Override
    public void start(Stage stage) {
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
            stage.setScene(adminLoginView.adminLoginView());
            stage.setTitle("User Login");
            stage.show();
        });

        Button adminLoginBtn = new Button("Admin Login");
        adminLoginBtn.setMinWidth(150);
        adminLoginBtn.setOnAction(e -> {

            stage.setScene(adminLoginView.adminLoginView());
            stage.setTitle("Admin Login");
            stage.show();
        });

        Button registerBtn = new Button("Register");
        registerBtn.setMinWidth(150);
        registerBtn.setOnAction(e -> {
            stage.setScene(RegisterView.RegisterView());
            stage.setTitle("User Registration");
            stage.show();
        });

        gp.add(userLoginBtn, 0, 1);
        gp.add(adminLoginBtn, 0, 2);
        gp.add(registerBtn, 0, 3);

        Scene scene = new Scene(gp, 400, 350);
        stage.setScene(scene);
        stage.setTitle("Welcome Screen");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
