package views;

import java.util.Collection;
import java.util.Date;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

public class BookingView implements View {

    
    private ViewObserver observer;

    /**
     * Установить наблюдателя отслеживающего действия пользователя
     * @param observer  наблюдатель
     */
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    public void showTables(Collection<Table> tables) {
        for (Table table: tables) {
            System.out.println(table);
        }
    }


    @Override
    public void showReservationResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик забронирован. Номер вашей брони: №%d\n", reservationNo);
        } else {
            System.out.println("Не удалось забронировать столик. Попробуйте повторить операцию позже.");
        }

    }

    @Override
    public void showChangeReservationResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Бронирование столика №%d отменено.\n", reservationNo);
        } else {
            System.out.println("Не удалось отменить бронирование. Попробуйте повторить операцию позже.");
        }
        
    }


    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя клиента
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){
        if (observer != null) {
            observer.onReservationTable(reservationDate, tableNo,  name);
        }
    }


     /**
     * Действие клиента (пользователь нажал на кнопку отмены бронирования), бронирование столика
     * @param oldReservation номер старого резерва
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя клиента
     */
    public void changeReservatoinTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        if (observer != null) {
            observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
        }

    }


}
