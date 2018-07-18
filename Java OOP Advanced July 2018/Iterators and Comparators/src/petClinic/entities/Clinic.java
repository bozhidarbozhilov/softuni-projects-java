package petClinic.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static petClinic.utilities.Constants.EXCEPTION_MESSAGE;
import static petClinic.utilities.Constants.NAME_VALIDATOR;

public class Clinic implements Iterable<Room>{
    private String name;
    private int roomsNumber;
    private List<Room> rooms;
    private Iterator<Room> accommodationIterator;

    public Clinic(String name, int roomsNumber) {
        this.setName(name);
        this.setRoomsNumber(roomsNumber);
        this.rooms = new ArrayList<>();
        this.setRooms();
        this.accommodationIterator = new AccommodationIterator();
    }

    @Override
    public Iterator<Room> iterator() {
        return new ClinicIterator();
    }

    private final class ClinicIterator implements Iterator<Room>{
        private int index;
        private boolean reachTheLastRoom;
        private boolean reachTheFinalRoom;

        private ClinicIterator() {
            this.index = roomsNumber/2;
            this.reachTheLastRoom = false;
            this.reachTheFinalRoom = this.index == roomsNumber/2;
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = this.index<roomsNumber;
            if(!hasNext){
                if(roomsNumber==1){
                    return false;
                }
                this.reachTheLastRoom = true;
                this.index = 0;
            }
            if(this.reachTheFinalRoom && this.reachTheLastRoom){
                return false;
            }
            return true;
        }

        @Override
        public Room next() {
            return rooms.get(this.index++);
        }
    }

    private final class AccommodationIterator implements Iterator<Room>{
        private int cursor;
        private int cursorMover;

        private AccommodationIterator() {
            this.cursor = rooms.size()/2;
            this.cursorMover = 0;
        }

        @Override
        public boolean hasNext() {
            return this.cursorMover<rooms.size();
        }

        @Override
        public Room next() {
            Room toReturn = null;
            if(this.cursorMover % 2 == 0){
                toReturn = rooms.get(this.cursor);
                this.cursor -= ++this.cursorMover;

            }else{
                toReturn = rooms.get(this.cursor);
                this.cursor += ++this.cursorMover;
            }
            return toReturn;
        }
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(!name.matches(NAME_VALIDATOR)){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public int getRoomsNumber() {
        return this.roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        if(roomsNumber<1 || roomsNumber>101 || roomsNumber%2==0){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.roomsNumber = roomsNumber;
    }

    public List<Room> getRooms() {

        return Collections.unmodifiableList(this.rooms);
    }

    private void setRooms(){
        for (int i = 1; i <= this.getRoomsNumber(); i++) {
            rooms.add(new Room(i));
        }
    }
    public boolean addPet(Pet pet){
        while(this.accommodationIterator.hasNext()){
            Room roomToAdd = this.accommodationIterator.next();
            if(roomToAdd.isEmpty()){
                roomToAdd.enterPet(pet);
                return true;
            }
        }
        return false;
    }

}
