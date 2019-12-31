package dao;

import entity.Guest;
import exceptions.GuestNotFoundException;
import util.GuestKeyComparatorAsc;
import util.GuestKeyComparatorDesc;

import java.util.*;

public class GuestDaoImpl implements IGuestDao{
private Map<Integer, Guest> storage = new HashMap<>();

    @Override
    public void addGuest(Guest g) {
        storage.put(g.getId(), g);
    }

    @Override
    public Guest fetchById(int id) {
        Guest g = storage.get(id);
        if(g == null){
            throw new GuestNotFoundException("No guest found with id: " + id);
        }
        return g;
    }

    @Override
    public Set<Guest> listGuest() {
        Collection<Guest> guests = storage.values();
        Set<Guest> guestSet = new HashSet<>(guests);
         return guestSet;
    }

    @Override
    public Set<Guest> allGuestsInorder(boolean order) {
        if(order){
            Collection<Guest> col = storage.values();
            GuestKeyComparatorAsc g = new GuestKeyComparatorAsc();
            Set<Guest> set1 = new TreeSet<Guest>(g);
            set1.addAll(col);
            return set1;

        }
        else{
            Collection<Guest> col = storage.values();
            GuestKeyComparatorDesc g = new GuestKeyComparatorDesc();
            Set<Guest> set1 = new TreeSet<Guest>(g);
            set1.addAll(col);
            return set1;
        }
    }
}
