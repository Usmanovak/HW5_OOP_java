
import java.util.Date;

import models.TableModel;
import presenters.BookingPresenter;
import views.BookingView;

public class Program {

    public static void main(String[] args) {

        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateTablesUI();

        view.reservationTable(new Date(), 1, "Иван");

        view.changeReservatoinTable(101, new Date(), 1, "Иван");

    }
}