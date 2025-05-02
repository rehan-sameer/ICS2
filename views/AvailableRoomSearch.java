package views;

import Objects.Reservation;
import Objects.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static views.MainApp.reservations;
import static views.MainApp.rooms;

public class AvailableRoomSearch {

    public static ArrayList<Room> getAvailableRooms(LocalDate date, LocalTime start, LocalTime end) {
        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : rooms) {
            boolean isFree = true;

            for (Reservation res : reservations) {
                if (res.getRoom().equals(room) && res.getDate().equals(date)) {
                    boolean overlaps = !(end.isBefore(res.getStartTime()) || start.isAfter(res.getEndTime()));
                    if (overlaps) {
                        isFree = false;
                        break;
                    }
                }
            }

            if (isFree) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }
}