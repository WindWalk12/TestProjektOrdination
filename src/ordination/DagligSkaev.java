package ordination;

import gui.TypeOrdination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    ArrayList<Dosis> doser;
    LocalDate startDato;
    LocalDate slutDato;
    private TypeOrdination typeOrdination;
    LocalTime


    //ved oprettelse: vælg forskellige klokkeslæt og antal (vilkårligt antal)

    public DagligSkaev(LocalDate startDate, LocalDate slutDate, TypeOrdination type) {
        super(startDate, slutDate, type);
         doser = new ArrayList<>();
        this.startDato = startDate; //ved ikke om jeg behøver at sætte datoer her, eller om man får dem fra superklassen :-)
        this.slutDato = slutDate;
        this.typeOrdination = type;
    }


    public void opretDosis(LocalTime tid, double antal) {
      Dosis dosis = new Dosis(tid,antal);
      doser.add(dosis);
    }

    @Override
    public double samletDosis() {
        long daysBetween = ChronoUnit.DAYS.between(startDato, slutDato) + 1;
        return daysBetween * doegnDosis();
    }


    //for hver dosis
    //tag antallet og læg det til double
    //divider med size
    @Override
    public double doegnDosis() {
        double doegnDosisGennemsnit = 0;
        for (Dosis dosis : doser) {
            doegnDosisGennemsnit += dosis.getAntal();
        }
        return doegnDosisGennemsnit / doser.size();
    }

    @Override
    public String getType() {
        return typeOrdination.toString();
    }

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }
}
