package ordination;

import gui.TypeOrdination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination {

    private double antalEnheder;
    private ArrayList<LocalDate> givetDosis = new ArrayList<>();
    private int antalGivet = 0;

    public PN(LocalDate startDate, LocalDate slutDate, Patient patient, double antalEnheder) {
        super(startDate, slutDate, patient);
        this.antalEnheder = antalEnheder;
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        if (givesDen.isAfter(super.getStartDen()) && givesDen.isBefore(super.getSlutDen())) {
            givetDosis.add(givesDen);
            antalGivet++;
            return true;
        }
        return false;   
    }

    public double doegnDosis() {
        LocalDate foersteDag = null;
        LocalDate sidsteDag = null;
        for (LocalDate ld : givetDosis) {
            if (foersteDag == null) {
                foersteDag = ld;
            }
            if (ld.isBefore(foersteDag)) {
                foersteDag = ld;
            }
        }
        for (LocalDate ld : givetDosis) {
            if (sidsteDag == null) {
                sidsteDag = ld;
            }
            if (ld.isAfter(sidsteDag)) {
                sidsteDag = ld;
            }
        }
        if (foersteDag != null && sidsteDag != null) {
            double dageImellem = ChronoUnit.DAYS.between(foersteDag, sidsteDag) + 1;
            return (antalGivet*antalEnheder)/dageImellem;
        }
        return 0.0;
    }

    public double samletDosis() {
        return antalGivet*antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return antalGivet;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    @Override
    public String getType() {
        return null;
    }

    public Laegemiddel getLaegemiddel() {
        return super.getLaegemiddel();
    }
}
