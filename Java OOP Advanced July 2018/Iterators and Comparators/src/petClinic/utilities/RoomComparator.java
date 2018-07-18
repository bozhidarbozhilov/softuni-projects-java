package petClinic.utilities;

import petClinic.entities.Room;

import java.util.Comparator;

public class RoomComparator implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        return o1.getNumber() - o2.getNumber();
    }
}
