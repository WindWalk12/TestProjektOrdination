package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Ordination {
    private LocalDate startDen;
    private LocalDate slutDen;
    private Laegemiddel laegemiddel;

    // TODO Link til Laegemiddel
    // TODO constructor (med specifikation)

    public Ordination(LocalDate startDate, LocalDate slutDate, Patient patient, Laegemiddel laegemiddel) {
        this.startDen = startDate;
        this.slutDen = slutDate;
        setLaegemiddel(laegemiddel);
        patient.addOrdination(this);
    }

    public LocalDate getStartDen() {
        return startDen;
    }	

    public LocalDate getSlutDen() {
        return slutDen;
    }
    public void setLaegemiddel(Laegemiddel lm) {
        if (laegemiddel != lm) {
            laegemiddel = lm;
        }
    }

    public Laegemiddel getLaegemiddel() {
        return laegemiddel;
    }

    /**
     * Antal hele dage mellem startdato og slutdato. Begge dage inklusive.
     * @return antal dage ordinationen gælder for
     */
    public int antalDage() {
        return (int) ChronoUnit.DAYS.between(startDen, slutDen) + 1;
    }

    @Override
    public String toString() {
        return startDen.toString();
    }

    /**
     * Returnerer den totale dosis der er givet i den periode ordinationen er gyldig
     * @return
     */
    public abstract double samletDosis();

    /**
     * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     * @return
     */
    public abstract double doegnDosis();

    /**
     * Returnerer ordinationstypen som en String
     * @return
     */
    public abstract String getType();
}
