package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {
    
    private static int counter;
    private final int no;

    private final Collection<Reservation> reservations = new ArrayList<>();

    public int getNo() {
        return no;
    }

    {
        no = ++counter;
    }


    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Столик №%d", no);
    }


}
