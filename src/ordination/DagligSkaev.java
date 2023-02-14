package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    public LocalDate startdato;
    public LocalDate slutdato;
    ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDate, LocalDate slutDate) {
        super(startDate, slutDate);
    }


    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid,antal);

        doser.add(dosis);
    }

    @Override
    public double samletDosis() {
        return 0;
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
}
