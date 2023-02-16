package ordination;

import ordination.DagligFast;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDagligFast {

    @Test
    void TC15_doegnDosis_1_0_2_1() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1,0.15,0.16,"Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 66.9);
        DagligFast dagligFast = new DagligFast(LocalDate.of(2023,2,16), LocalDate.of(2023,2,18), patient, laegemiddel, 1,0,2,1);

        //Act
        double faktiskDoegnDosis = dagligFast.doegnDosis();

        //Assert
        double forventetDoegnDosis = 4;
        assertEquals(forventetDoegnDosis, faktiskDoegnDosis);
    }

    @Test
    void TC16_doegnDosis_0_0_0_0() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1,0.15,0.16,"Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 66.9);
        DagligFast dagligFast = new DagligFast(LocalDate.of(2023,2,16), LocalDate.of(2023,2,18), patient, laegemiddel, 0,0,0,0);

        //Act
        double faktiskDoegnDosis = dagligFast.doegnDosis();

        //Assert
        double forventetDoegnDosis = 0;
        assertEquals(forventetDoegnDosis, faktiskDoegnDosis);
    }

    @Test
    void TC17_doegnDosis_1_1_0_0() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1,0.15,0.16,"Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 66.9);
        DagligFast dagligFast = new DagligFast(LocalDate.of(2023,2,16), LocalDate.of(2023,2,18), patient, laegemiddel, 1,1,0,0);

        //Act
        double faktiskDoegnDosis = dagligFast.doegnDosis();

        //Assert
        double forventetDoegnDosis = 2;
        assertEquals(forventetDoegnDosis, faktiskDoegnDosis);
    }

    @Test
    void TC18_doegnDosis_1_1_2_1() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1,0.15,0.16,"Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 66.9);
        DagligFast dagligFast = new DagligFast(LocalDate.of(2023,2,16), LocalDate.of(2023,2,18), patient, laegemiddel, 1,1,2,1);

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            double faktiskDoegnDosis = dagligFast.doegnDosis();
        });

        //Assert
        assertEquals(exception.getMessage(),"Samlet antal dosis må højest være 4");
    }

    @Test
    void TC19_samletDosis_1_0_0_0() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.1,0.15,0.16,"Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 66.9);
        DagligFast dagligFast = new DagligFast(LocalDate.of(2023,2,16), LocalDate.of(2023,2,18), patient, laegemiddel, 1,1,0,0);

        //Act
        double faktiskDoegnDosis = dagligFast.doegnDosis();

        //Assert
        double forventetDoegnDosis = 2;
        assertEquals(forventetDoegnDosis, faktiskDoegnDosis);
    }
}
