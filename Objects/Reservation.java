package Objects;

import java.time.LocalDate;
import java.time.LocalTime;
import Objects.Room;
import Objects.User;

import static views.MainApp.reservations;

public class Reservation {

    private Room room;
    private User user;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;

    public Reservation(Room room, User user, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.room = room;
        this.user = user;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = "Pending";
        reservations.add(this);
    }

    // Getters
    public Room getRoom() {return room;}
    public User getUser() {return user;}
    public LocalDate getDate() {return date;}
    public LocalTime getStartTime() {return startTime;}
    public LocalTime getEndTime() {return endTime;}
    public String getStatus() {return status;}

    // Setters
    public void setRoom(Room room) {this.room = room;}
    public void setUser(User user) {this.user = user;}
    public void setDate(LocalDate date) {this.date = date;}
    public void setStartTime(LocalTime startTime) {this.startTime = startTime;}
    public void setEndTime(LocalTime endTime) {this.endTime = endTime;}
    public void setStatus(String status) {this.status = status;}

    // method to update status
    public void updateStatus(boolean decision) {
        if (decision) {
            this.status = "Approved";
            room.setOccupancy(true);
        }
        else {this.status = "Rejected";}
    }
}

