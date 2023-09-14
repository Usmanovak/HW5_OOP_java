package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import presenters.Model;

public class TableModel implements Model{
    
    private Collection<Table> tables;

    /* 
    * Получить список столиков
    */
    public Collection<Table> loadTables() {
        
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());

        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate дата пробирования
     * @param tableNo   номер столика
     * @param name  имя клиента 
     * @return номер резерва(брони)
     */

    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table t : tables) {
            if (t.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                t.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
    }

    /**
     * Отмена бронирования 
     * @param oldReservation    номер бронирования
     * @param resetvationDate   дата бронирования 
     * @param tableNo   номер столика 
     * @param name  имя клиента
     * @return  номер прежнего бронирования
     */

    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if(table.getNo() == tableNo) {
                Collection<Reservation> reservations = table.getReservations();
                for (Reservation reservation : reservations) {
                    if (reservation.getId() == oldReservation) {
                        reservations.remove(reservation);
                        return oldReservation;
                    }
                }
            }
        }
        return -1;
    }

}
