package petClinic.controller;

import petClinic.entities.Clinic;
import petClinic.entities.Pet;
import petClinic.entities.Room;
import petClinic.utilities.RoomComparator;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClinicManager {
    private Map<String, Clinic> clinicMap;
    private Map<String, Pet> petMap;

    public ClinicManager() {
        this.clinicMap = new LinkedHashMap<>();
        this.petMap = new LinkedHashMap<>();
    }

    public void createClinic(String name, int rooms){
        try{
            Clinic currentClinic = new Clinic(name, rooms);
            clinicMap.put(name, currentClinic);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
    public void createPet(String name, int age, String type){
        try{
            Pet pet = new Pet(name, age, type);
            petMap.put(name, pet);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    public boolean addPet(String petName, String clinicName){
        return clinicMap.get(clinicName).addPet(petMap.get(petName));
    }

    public boolean hasEmptyRooms(String clinicName){
        Clinic clinic = clinicMap.get(clinicName);
        for (Room room : clinic) {
            if(room.isEmpty()){
                return true;
            }
        }
        return false;
    }

    public boolean releaseClinic(String clinicName){
        Clinic clinicToRelease = clinicMap.get(clinicName);
        for (Room room : clinicToRelease) {
            if(!room.isEmpty()){
                room.releasePet();
                return true;
            }
        }
        return false;
    }

    public void printClinic(String clinicName){
        List<Room> rooms = clinicMap.get(clinicName).getRooms().stream()
                .sorted(new RoomComparator()).collect(Collectors.toList());
        for (Room room : rooms) {
            if(room.isEmpty()){
                System.out.println("Room empty");
            }else{
                System.out.println(room.getPet().toString());
            }
        }
    }

    public void printRoom(String clinicName, int roomNumber){
        Room room = clinicMap.get(clinicName).getRooms()
                .stream().filter(r->r.getNumber()==roomNumber).findFirst().get();
        if(room.isEmpty()){
            System.out.println("Room empty");
        }else{
            System.out.println(room.getPet().toString());
        }
    }
}
