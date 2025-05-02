package views;

import Objects.Reservation;
import Objects.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Objects.Room;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static views.MainApp.Admin;

public class RoomListView {

    public void show(Stage stage, List<Room> roomList, User currentUser, LocalDate date, LocalTime startTime, LocalTime endTime) {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20));
        gp.setVgap(10);
        gp.setHgap(15);

        gp.add(new Label("Room Number"), 0, 0);
        gp.add(new Label("Capacity"), 1, 0);
        gp.add(new Label("Location"), 2, 0);

        if (currentUser == Admin) {
            gp.add(new Label("Occupied?"), 3, 0);
        } else {
            gp.add(new Label("Action"), 3, 0);
        }
        List<Button> allBookingButtons = new ArrayList<>();
        int row = 1;
        for (Room room : roomList) {
            gp.add(new Label(room.getRoomNo()), 0, row);
            gp.add(new Label(String.valueOf(room.getCapacity())), 1, row);
            gp.add(new Label(room.getLocation()), 2, row);
            if (currentUser == Admin) {
                gp.add(new Label(room.isOccupied() ? "Yes" : "No"), 3, row);
            } else {
                Button bookBtn = new Button("Book");
                allBookingButtons.add(bookBtn);
                int finalRow = row; // save the current row value for each button
                bookBtn.setOnAction(e -> {
                    // ToDo: define booking behavior here (open reservation form, etc.)
                    new Reservation(room, currentUser, date, startTime, endTime);
                    for (Button b : allBookingButtons) {
                        b.setDisable(true);
                    }

                    Label confirmation = new Label("Room " + room.getRoomNo() + " booked!");
                    gp.add(confirmation, 4, finalRow);
                });
                gp.add(bookBtn, 3, row);
            }
            row++;
        }

        Scene scene = new Scene(gp, 600, 400);
        stage.setScene(scene);
        stage.setTitle(currentUser==Admin ? "All Rooms (Admin View)" : "Available Rooms");
        stage.show();
    }
}