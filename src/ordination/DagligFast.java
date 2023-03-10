package ordination;

import gui.TypeOrdination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DagligFast extends Ordination {
    //TODO

    private Dosis[] dosisArray = new Dosis[4];
    private TypeOrdination typeOrdination;


    public DagligFast(LocalDate startDate, LocalDate slutDate, Patient patient, Laegemiddel laegemiddel, double morgenAntal, double middagAntal,
                      double aftenAntal, double natAntal) {
        super(startDate, slutDate, patient, laegemiddel);
        if (morgenAntal>=0) {
            dosisArray[0] = new Dosis(LocalTime.of(9,0), morgenAntal);
        }
        if (middagAntal>=0) {
            dosisArray[1] = new Dosis(LocalTime.of(12,0), middagAntal);
        }
        if (aftenAntal>=0) {
            dosisArray[2] = new Dosis(LocalTime.of(18,0), aftenAntal);
        }
        if (natAntal>=0) {
            dosisArray[3] = new Dosis(LocalTime.of(21,0), natAntal);
        }
    }

    @Override
    public double samletDosis() {
        if ((dosisArray[0].getAntal() + dosisArray[1].getAntal() +
                dosisArray[2].getAntal() + dosisArray[3].getAntal()) > 4) {
            throw new IllegalArgumentException("Samlet antal dosis må højest være 4 pr døgn");
        }
        if (super.getStartDen().isAfter(super.getSlutDen())) {
            throw new IllegalArgumentException("Slut datoen er før start datoen");
        }
        double antalDosis = dosisArray[0].getAntal() + dosisArray[1].getAntal() +
                dosisArray[2].getAntal() + dosisArray[3].getAntal();
        long daysBetween = ChronoUnit.DAYS.between(getStartDen(), getSlutDen()) + 1;
        return daysBetween * antalDosis;
    }

    @Override
    public double doegnDosis() {
        if ((dosisArray[0].getAntal() + dosisArray[1].getAntal() +
                dosisArray[2].getAntal() + dosisArray[3].getAntal()) > 4) {
            throw new IllegalArgumentException("Samlet antal dosis må højest være 4");
        }
        return dosisArray[0].getAntal() + dosisArray[1].getAntal() + dosisArray[2].getAntal() + dosisArray[3].getAntal();
    }

    @Override
    public String getType() {
        return typeOrdination.toString();
    }
    public void setTypeOrdination(TypeOrdination typeOrdination) {
        this.typeOrdination = typeOrdination;
    }


    public Dosis[] getDoser() {
        return dosisArray;
    }

}