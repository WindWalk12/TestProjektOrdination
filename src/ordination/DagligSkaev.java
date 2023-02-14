package ordination;

import gui.TypeOrdination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    ArrayList<Dosis> doser = new ArrayList<>();
    private TypeOrdination typeOrdination;

    public DagligSkaev(LocalDate startDate, LocalDate slutDate, TypeOrdination type) {
        super(startDate, slutDate, type);
        this.typeOrdination = type;
    }


    public void opretDosis(LocalTime tid, double antal) {
      Dosis dosis = new Dosis(tid,antal);
      doser.add(dosis);
    }

    @Override
    public double samletDosis() {
        //star
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return typeOrdination.toString();
    }
}
