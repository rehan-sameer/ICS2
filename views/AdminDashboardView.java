package views;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import Objects.User;

public class AdminDashboardView extends Application {
    @Override
    public void start (Stage stage){
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(15);
        gp.setPadding(new Insets(20, 20, 20, 20)); // top, right, bottom, left
        gp.setAlignment(Pos.CENTER);

        Label dashboardLabel = new Label("Welcome to the Admin Dashboard!");

        Button manageRoomsBtn = new Button("Manage Rooms");
        Button viewRequestsBtn = new Button("View Reservation Requests");
        Button logoutBtn = new Button("Logout");
        Button viewRoomsBtn = new Button("View Rooms & Availability");
//        viewRoomsBtn.setMinWidth(200);


        gp.add(dashboardLabel, 0, 0); // spans 2 columns
        gp.add(manageRoomsBtn, 0, 1);
        gp.add(viewRoomsBtn, 0, 2);
        gp.add(viewRequestsBtn, 0, 3);
        gp.add(logoutBtn, 0, 4);


        viewRoomsBtn.setOnAction(e -> {
            Stage roomListStage = new Stage();
            RoomListView roomListView = new RoomListView();
            roomListView.show(roomListStage, MainApp.rooms, true);
        });


        manageRoomsBtn.setOnAction(e -> {

            Stage managingRooms = new Stage();
            RoomManagementView manageRoom = new RoomManagementView();
            manageRoom.start(managingRooms);

        });



        Scene scene = new Scene(gp, 350, 220);
        stage.setScene(scene);
        stage.setTitle("ADMIN DASHBOARD");
        stage.show();

        viewRequestsBtn.setOnAction(e -> {
            Stage reservationListStage = new Stage();
            ReservationListView reservationListView = new ReservationListView();
            reservationListView.start(reservationListStage);
        });

        logoutBtn.setOnAction(e -> {
            stage.close(); // Close the dashboard
        });

    }

}
