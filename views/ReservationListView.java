package views;

import Objects.Reservation;
import Objects.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static views.MainApp.Admin;
import static views.MainApp.reservations;

public class ReservationListView extends Application {
    private User currentUser;

    // Constructor to accept User
    public ReservationListView(User user) {
        this.currentUser = user;
    }
    @Override
    public void start(Stage stage) {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20));
        gp.setVgap(10);
        gp.setHgap(15);

        ArrayList<Reservation> reservationList;
        if (currentUser == Admin) {
            reservationList = reservations;
        } else {
            reservationList = new ArrayList<>();
            for (Reservation reservation : reservations) {
                if (reservation.getUser().getUsername().equals(currentUser.getUsername())) {
                    reservationList.add(reservation);
                }
            }
        }

        gp.add(new Label("Room Number"), 0, 0);
        gp.add(new Label("Username"), 1, 0);
        gp.add(new Label("Date(yyyy-mm-dd)"), 2, 0);
        gp.add(new Label("starting time"), 3, 0);
        gp.add(new Label("ending time"), 4, 0);
        if (currentUser == Admin) {
            gp.add(new Label("Action"), 5, 0);
        }
        List<Button> allAcceptButtons = new ArrayList<>();
        List<Button> allDenyButtons = new ArrayList<>();
        int row = 1;
        for (Reservation reservation : reservationList) {
            gp.add(new Label(reservation.getRoom().getRoomNo()), 0, row);
            gp.add(new Label(reservation.getUser().getName()), 1, row);
            gp.add(new Label(reservation.getDate().toString()), 2, row);
            gp.add(new Label(reservation.getStartTime().toString()), 3, row);
            gp.add(new Label(reservation.getEndTime().toString()), 4, row);
            if (currentUser == Admin) {
                Button acceptBtn = new Button("Accept");
                allAcceptButtons.add(acceptBtn);
                int finalRow = row; // save the current row value for each button
                acceptBtn.setOnAction(e -> {
                    reservation.getRoom().setOccupancy(true);
                    reservation.setStatus("Accepted");
                    for (Button b : allAcceptButtons) {
                        b.setDisable(true);
                    }
                    Label confirmation = new Label("Reservation accepted!");
                    gp.add(confirmation, 7, finalRow);
                });
                gp.add(acceptBtn, 5, row);

                Button denyBtn = new Button("Deny");
                allDenyButtons.add(denyBtn);
                denyBtn.setOnAction(e -> {
                    reservation.getRoom().setOccupancy(false);
                    reservation.setStatus("Denied");
                    for (Button b : allDenyButtons) {
                        b.setDisable(true);
                    }
                    Label confirmation = new Label("Reservation denied!");
                    gp.add(confirmation, 7, finalRow);
                });
                gp.add(denyBtn, 6, row);
            }
            row++;
        }

        Scene scene = new Scene(gp, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Reservation List");
        stage.show();
    }
}
