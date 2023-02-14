package ordination;

import gui.TypeOrdination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DagligFast extends Ordination {
    //TODO

    private Dosis[] dosisArray = new Dosis[4];


    public DagligFast(LocalDate startDate, LocalDate slutDate, TypeOrdination type, Dosis[] dosisArray) {
        super(startDate, slutDate, type);
        this.dosisArray = dosisArray;
    }

    @Override
    public double samletDosis() {
        double antalDosis = dosisArray[0].getAntal() + dosisArray[1].getAntal() +
                dosisArray[2].getAntal() + dosisArray[3].getAntal();
        long daysBetween = ChronoUnit.DAYS.between(getSlutDen(), getStartDen());
        return daysBetween * antalDosis;
    }

    @Override
    public double doegnDosis() {
        return dosisArray[0].getAntal() + dosisArray[1].getAntal() + dosisArray[2].getAntal() + dosisArray[3].getAntal();
    }

    @Override
    public String getType() {
        return null;
    }


    public Dosis[] getDosisArray() {
        return dosisArray;
    }

}
