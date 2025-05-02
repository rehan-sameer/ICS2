package Objects;

import static views.MainApp.rooms;

public class Room {
    private String roomNo;
    private int capacity;
    private String location;
    private boolean occupancy;

    public Room(String roomNo, int capacity, String location) {
        rooms.add(this);
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.location = location;
        this.occupancy = false; // default: not occupied
    }

    public String getRoomNo() {return roomNo;}

    public int getCapacity() {return capacity;}

    public String getLocation() {return location;}

    public boolean isOccupied() {return occupancy;}

    public void setOccupancy(boolean occupancy) {this.occupancy = occupancy;}
}
