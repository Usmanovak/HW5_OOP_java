package presenters;

import java.util.Collection;
import java.util.Date;
import models.Table;

public class BookingPresenter implements ViewObserver{
    

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получить список всех столиков
     */
    public Collection<Table>  loadTables() {
        return model.loadTables();
    }

    public void updateTablesUI() {
        view.showTables(loadTables());
    }

    public void updateReservationResultUI(int reservationNo) {
        view.showReservationResult(reservationNo);
    } 


    public void updateChangeReservationResultUI(int reservationNo){
        view.showChangeReservationResult(reservationNo);
    }

    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        int reservationNo = model.reservationTable(reservationDate, tableNo, name);
        updateReservationResultUI(reservationNo);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int reservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        updateChangeReservationResultUI(reservationNo);
    }

}
