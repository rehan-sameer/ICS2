package views;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Objects.Room;
import java.util.ArrayList;

public class RoomManagementView extends Application {

    @Override
    public void start(Stage stage) {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20));
        gp.setHgap(10);
        gp.setVgap(15);
        gp.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Add New Room");
        Label roomNumberLabel = new Label("Room Number:");
        Label capacityLabel = new Label("Capacity:");
        Label locationLabel = new Label("Location:");

        TextField roomNumberTF = new TextField();
        TextField capacityTF = new TextField();
        TextField locationTF = new TextField();

        Button addRoomBtn = new Button("Add Room");
        Label messageLabel = new Label();

        gp.add(titleLabel, 0, 0, 2, 1);
        gp.add(roomNumberLabel, 0, 1);
        gp.add(roomNumberTF, 1, 1);
        gp.add(capacityLabel, 0, 2);
        gp.add(capacityTF, 1, 2);
        gp.add(locationLabel, 0, 3);
        gp.add(locationTF, 1, 3);
        gp.add(addRoomBtn, 0, 4, 2, 1);
        gp.add(messageLabel, 0, 5, 2, 1);

        addRoomBtn.setOnAction(e -> {
            String roomNumber = roomNumberTF.getText();
            String location = locationTF.getText();
            int capacity;

            try {
                capacity = Integer.parseInt(capacityTF.getText());
            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid number for capacity.");
                return;
            }

            Room newRoom = new Room(roomNumber, capacity, location);
            MainApp.rooms.add(newRoom);
            messageLabel.setText("Room added: " + roomNumber);

            roomNumberTF.clear();
            capacityTF.clear();
            locationTF.clear();
        });

        Scene scene = new Scene(gp, 400, 350);
        stage.setScene(scene);
        stage.setTitle("Room Management");
        stage.show();
    }
}
