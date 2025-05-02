package views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Objects.Room;
import java.util.List;

public class RoomListView {

    public void show(Stage stage, List<Room> roomList) {
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20));
        gp.setVgap(10);
        gp.setHgap(15);

        gp.add(new Label("Room Number"), 0, 0);
        gp.add(new Label("Capacity"), 1, 0);
        gp.add(new Label("Location"), 2, 0);
        gp.add(new Label("Occupied?"), 3, 0);

        int row = 1;
        for (Room room : roomList) {
            gp.add(new Label(room.getRoomNo()), 0, row);
            gp.add(new Label(String.valueOf(room.getCapacity())), 1, row);
            gp.add(new Label(room.getLocation()), 2, row);
            gp.add(new Label(room.isOccupied() ? "Yes" : "No"), 3, row);
            row++;
        }

        Scene scene = new Scene(gp, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Available Rooms");
        stage.show();
    }
}

