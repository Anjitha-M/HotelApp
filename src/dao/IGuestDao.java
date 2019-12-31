package dao;

import entity.Guest;

import java.util.Set;

public interface IGuestDao {
    void addGuest(Guest g);
    Guest fetchById(int id);
    Set<Guest> listGuest();
    Set<Guest> allGuestsInorder(boolean order);



}
