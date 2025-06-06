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
import views.ReservationManagementView;
import views.userLoginView;
import Objects.Room;

import static views.MainApp.currentUser;

public class UserDashboardView{
    public static Scene UserDashboardView() {

        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(15);
        gp.setPadding(new Insets(20, 20, 20, 20)); // top, right, bottom, left
        gp.setAlignment(Pos.CENTER);

        // Personalized welcome message
        Label dashboardLabel = new Label("Welcome " + currentUser.getUsername() + " to the User Dashboard!");

        Button searchRoomsBtn = new Button("Search Available Rooms");
        Button myBookingsBtn = new Button("My Requests");
        Button logoutBtn = new Button("Logout");

        // Add components to grid
        gp.add(dashboardLabel, 0, 0, 2, 1);
        gp.add(searchRoomsBtn, 0, 1);
        gp.add(myBookingsBtn, 0, 2);
        gp.add(logoutBtn, 0, 3);



        // Button actions
        searchRoomsBtn.setOnAction(e -> {
            Stage reservationStage = new Stage();
            ReservationManagementView reservationManagementView = new ReservationManagementView(currentUser);
            reservationManagementView.start(reservationStage);
        });

        myBookingsBtn.setOnAction(e -> {
            Stage reservationListStage = new Stage();
            ReservationListView reservationListView = new ReservationListView(currentUser);
            reservationListView.start(reservationListStage);
        });

        logoutBtn.setOnAction(e -> {
            // todo: Open the login view
        });
        Scene scene = new Scene(gp, 350, 220);
        return scene;
    }
}