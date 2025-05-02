package views;

import Objects.Room;
import Objects.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static views.AvailableRoomSearch.getAvailableRooms;

public class ReservationManagementView extends Application {
    private User currentUser;

    // Constructor to accept User
    public ReservationManagementView(User user) {
        this.currentUser = user;
    }

    @Override
    public void start(Stage stage) {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20));
        gp.setHgap(10);
        gp.setVgap(15);
        gp.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Search for available rooms");
        Label ReservationDate = new Label("Date of reservation(yyyy-mm-dd):");
        Label ReservationStart = new Label("start of reservation(HH:mm):");
        Label ReservationEnd = new Label("end of reservation(HH:mm):");

        TextField DateTF = new TextField();
        TextField StartTF = new TextField();
        TextField EndTF = new TextField();

        Button SearchBtn = new Button("Search");
        Label messageLabel = new Label();

        gp.add(titleLabel, 0, 0, 2, 1);
        gp.add(ReservationDate, 0, 1);
        gp.add(DateTF, 1, 1);
        gp.add(ReservationStart, 0, 2);
        gp.add(StartTF, 1, 2);
        gp.add(ReservationEnd, 0, 3);
        gp.add(EndTF, 1, 3);
        gp.add(SearchBtn, 0, 4, 2, 1);
        gp.add(messageLabel, 0, 5, 2, 1);

        SearchBtn.setOnAction(e -> {
            LocalDate date;
            LocalTime start;
            LocalTime end;

            try {
                date = LocalDate.parse(DateTF.getText());
                start = LocalTime.parse(StartTF.getText());
                end = LocalTime.parse(EndTF.getText());

                if (start.isAfter(end)) {
                    messageLabel.setText("Start time must be before end time.");
                    return;
                }

                if (date.isBefore(LocalDate.now())) {
                    messageLabel.setText("Date must be today or in the future.");
                    return;
                }

                if (date.isEqual(LocalDate.now()) && start.isBefore(LocalTime.now())) {
                    messageLabel.setText("Start time must be in the future.");
                    return;
                }

            } catch (Exception ex) {
                messageLabel.setText("Please enter date and time in correct format (yyyy-MM-dd, HH:mm).");
                return;
            }

            // Get available rooms for the given date/time
            ArrayList<Room> availableRooms = getAvailableRooms(date, start, end);

            // Open a new window with the available rooms
            Stage resultsStage = new Stage();
            new RoomListView().show(resultsStage, availableRooms, currentUser, date, start, end);

            // Close the current window
            ((Stage) SearchBtn.getScene().getWindow()).close();
        });

        Scene scene = new Scene(gp, 400, 350);
        stage.setScene(scene);
        stage.setTitle("booking management");
        stage.show();
    }
}

