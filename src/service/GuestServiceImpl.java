package service;

import dao.IGuestDao;
import entity.Guest;
import exceptions.InvalidIdException;

import java.util.Set;

public class GuestServiceImpl implements IGuestService {
    private IGuestDao dao;

    public GuestServiceImpl(IGuestDao dao) {
        this.dao = dao;
    }

    @Override
    public void addGuest(Guest g) {
        dao.addGuest(g);
    }

    @Override
    public Guest fetchById(int id) {
        if (id < 0) {
            throw new InvalidIdException("Invalid ID!!!");
        }
        return dao.fetchById(id);
    }

    @Override
    public Set<Guest> listGuest() {
        Set<Guest> guests = dao.listGuest();
        return guests;
    }

    @Override
    public Set<Guest> allGuestsInorder(boolean order) {
       return dao.allGuestsInorder(order);

    }
}
