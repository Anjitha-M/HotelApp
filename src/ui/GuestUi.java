package ui;

import dao.GuestDaoImpl;
import entity.Guest;
import service.GuestServiceImpl;
import service.IGuestService;

import java.util.Set;
import java.util.TreeSet;

public class GuestUi {
    private IGuestService gs = new GuestServiceImpl(new GuestDaoImpl());
    public static void main(String[] args ){
        GuestUi gui = new GuestUi();
        gui.execute();
    }
    public void execute(){

        Guest g4 = new Guest(10, "Tanu");
        Guest g1 = new Guest(3, "Raj");
        Guest g2 = new Guest(2, "Ram");
        Guest g3 = new Guest(1, "Sid");

        gs.addGuest(g4);
        gs.addGuest(g1);
        gs.addGuest(g2);
        gs.addGuest(g3);


        Guest fetched = gs.fetchById(2);
        System.out.println("The guest found with given id: " + fetched.getName());
//        System.out.println(" -----------------Printing all guests-----------------------");
//
//        Set<Guest> guest = gs.listGuest();
//        print(guest);

        System.out.println(" ----------------- Printing all guests in order -----------------------");

        Set<Guest> guest1 = gs.allGuestsInorder(false);
        print(guest1);



    }

    public void print (Set<Guest> guest){
        for (Guest g: guest ) {
            System.out.println("Guests [ ID: " + g.getId() + " Name: " + g.getName() + " ]");
        }
    }
}
