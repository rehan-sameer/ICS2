package views;

import Objects.Reservation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ReservationListView extends Application {
    @Override
    public void start(Stage stage) {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20));
        gp.setVgap(10);
        gp.setHgap(15);

        ArrayList<Reservation> reservationList = MainApp.reservations;

        gp.add(new Label("Room Number"), 0, 0);
        gp.add(new Label("Username"), 1, 0);
        gp.add(new Label("Date(yyyy-mm-dd)"), 2, 0);
        gp.add(new Label("starting time"), 3, 0);
        gp.add(new Label("ending time"), 4, 0);

        int row = 1;
        for (Reservation reservation : reservationList) {
            gp.add(new Label(reservation.getRoom().getRoomNo()), 0, row);
            gp.add(new Label(reservation.getUser().getName()), 1, row);
            gp.add(new Label(reservation.getDate().toString()), 2, row);
            gp.add(new Label(reservation.getStartTime().toString()), 3, row);
            gp.add(new Label(reservation.getEndTime().toString()), 4, row);
            row++;
        }

        Scene scene = new Scene(gp, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Reservation List");
        stage.show();
    }
}
