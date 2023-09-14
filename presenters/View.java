package presenters;

import java.util.Collection;

import models.Table;

public interface View {
    
    void setObserver(ViewObserver observer); 
    void showTables(Collection<Table> tables);
    void showReservationResult(int reservationNo);
    void showChangeReservationResult(int reservationNo);
}
