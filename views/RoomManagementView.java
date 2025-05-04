package views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import views.RoomListView;
import views.AddNewRoomView;
import views.MainApp;
import views.AdminDashboardView;
import static views.MainApp.Admin;

// This class is responsible for managing the room management view
// It will include methods to add, remove, and update rooms
// as well as to display the list of rooms
public class RoomManagementView extends Application {
    private Objects.User currentUser;

    @Override
    public void start(Stage stage) {
        currentUser = Admin;
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(15);
        gp.setPadding(new Insets(20, 20, 20, 20)); // top, right, bottom, left
        gp.setAlignment(Pos.CENTER);

        Label dashboardLabel = new Label("Welcome to the Room Management!");

        Button AddRoomBtn = new Button("Add a New Room");
        Button editRoomBtn = new Button("edit/delete a Room");
        Button viewRoomsBtn = new Button("View Rooms & Availability");
        Button logoutBtn = new Button("Logout");

        gp.add(dashboardLabel, 0, 0); // spans 2 columns
        gp.add(AddRoomBtn, 0, 1);
        gp.add(editRoomBtn, 0, 2);
        gp.add(viewRoomsBtn, 0, 3);
        gp.add(logoutBtn, 0, 4);


        AddRoomBtn.setOnAction(e -> {
            Stage addRoomStage = new Stage();
            AddNewRoomView addNewRoomView = new AddNewRoomView();
            addNewRoomView.start(addRoomStage);
        });

        editRoomBtn.setOnAction(e -> {
            // Logic to edit a room
            // This can be implemented later
        });
        viewRoomsBtn.setOnAction(e -> {
            Stage roomListStage = new Stage();
            RoomListView roomListView = new RoomListView();
            roomListView.show(roomListStage, MainApp.rooms, Admin, null, null, null);
        });

        logoutBtn.setOnAction(e -> {
            stage.close();
            // Open the login view
            Stage loginStage = new Stage();
            AdminDashboardView adminLogin = new AdminDashboardView();
            adminLogin.start(loginStage);
        });
    }
}
