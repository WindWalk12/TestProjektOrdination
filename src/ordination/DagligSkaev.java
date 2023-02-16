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

    public DagligSkaev(LocalDate startDate, LocalDate slutDate, Patient patient, Laegemiddel laegemiddel) {
        super(startDate, slutDate, patient, laegemiddel);
         doser = new ArrayList<>();
        this.startDato = startDate;
        this.slutDato = slutDate;
    }


    public void opretDosis(LocalTime tid, double antal) {
      Dosis dosis = new Dosis(tid,antal);
      doser.add(dosis);
    }


    @Override
    public double samletDosis() {
        long daysBetween = ChronoUnit.DAYS.between(startDato, slutDato);
        return daysBetween * doegnDosis();
    }

    @Override
    public double doegnDosis() {
        double doegnDosisGennemsnit = 0;
        if (doser.size() == 0) {
            throw new ArithmeticException("Arraylist doser må ikke være størrelsen 0");
        }
        for (Dosis dosis : doser) {
            doegnDosisGennemsnit += dosis.getAntal();
        }
        return doegnDosisGennemsnit / doser.size();
    }

    @Override
    public String getType() {
        return typeOrdination.toString();
    }

    public void setTypeOrdination(TypeOrdination typeOrdination) {
        this.typeOrdination = typeOrdination;
    }

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }
}
