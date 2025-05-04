package views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import Objects.User;
import views.ReservationListView;
import views.RoomListView;
import views.AddNewRoomView;
import Objects.Room;
import views.userLoginView;
import views.MainApp;
import static views.MainApp.currentUser;
import static views.MainApp.Admin;

public class AdminDashboardView  {
    public static Scene AdminDashboardView (){
        currentUser = Admin;
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(15);
        gp.setPadding(new Insets(20, 20, 20, 20)); // top, right, bottom, left
        gp.setAlignment(Pos.CENTER);

        Label dashboardLabel = new Label("Welcome to the Admin Dashboard!");

        Button manageRoomsBtn = new Button("Rooms Management");
        Button viewRequestsBtn = new Button("Reservation Requests");
        Button logoutBtn = new Button("Logout");

        gp.add(dashboardLabel, 0, 0); // spans 2 columns
        gp.add(manageRoomsBtn, 0, 1);
        gp.add(viewRequestsBtn, 0, 2);
        gp.add(logoutBtn, 0, 3);

        manageRoomsBtn.setOnAction(e -> {
            Stage roomManagementStage = new Stage();
            RoomManagementView roomManagementView = new RoomManagementView();
            roomManagementView.start(roomManagementStage);
        });

        viewRequestsBtn.setOnAction(e -> {
            Stage reservationListStage = new Stage();
            ReservationListView reservationListView = new ReservationListView(currentUser);
            reservationListView.start(reservationListStage);
        });

        logoutBtn.setOnAction(e -> {
             // todo: Close the dashboard
        });
        Scene scene = new Scene(gp, 350, 220);
        return scene;
        //todo: .setTitle("ADMIN DASHBOARD");
    }
}
