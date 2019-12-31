package service;

import entity.Guest;

import java.util.Set;

public interface IGuestService {
    void addGuest(Guest g);
    Guest fetchById(int id);
    Set<Guest> listGuest();
    Set<Guest> allGuestsInorder(boolean order);
}
