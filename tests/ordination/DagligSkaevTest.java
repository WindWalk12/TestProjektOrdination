package ordination;

import controller.Controller;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {


    @Test
    void TC11_beregndoegnDosis() {
        //Arrange
        Patient patient = new Patient("1234567890", "Hans", 20);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.5,2,3,"Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2023,2,16),LocalDate.of(2023, 2, 18),patient, laegemiddel);
        dagligSkaev.opretDosis(LocalTime.of(10, 0),2);
        dagligSkaev.opretDosis(LocalTime.of(15, 30), 4);
        dagligSkaev.opretDosis(LocalTime.of(20, 00), 3);

        //Act
        double faktiskDoegnDosis = dagligSkaev.doegnDosis();

        //Assert
        double forventetDoegnDosis = 3;
        assertEquals(forventetDoegnDosis, faktiskDoegnDosis);
    }

    @Test
    void TC12_beregndoegnDosisArithmeticException() {
        //Arrange
        Patient patient = new Patient("1234567890", "Hans", 20);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.5,2,3,"Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2023,2,16),LocalDate.of(2023, 2, 18),patient, laegemiddel);

        //Act & Assert
        //ASSERT ARITHMETICEXCEPTION!
        double faktiskDoegnDosis = dagligSkaev.doegnDosis();
    }

    @Test
    void TC13_beregnsamletDosis1() {

        //ARRANGE
        Patient patient = new Patient("1234567890", "Hans", 20);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.5,2,3,"Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2023,2,16),LocalDate.of(2023, 2, 18),patient, laegemiddel);
        dagligSkaev.opretDosis(LocalTime.of(10, 0),2);
        dagligSkaev.opretDosis(LocalTime.of(15, 30), 4);
        dagligSkaev.opretDosis(LocalTime.of(20, 00), 3);

        //ACT
        double faktiskSamletDosis = dagligSkaev.samletDosis();

        //ASSERT
        double forventetSamletDosis = 6;
        assertEquals(forventetSamletDosis, faktiskSamletDosis);
    }

    @Test
    void TC13_beregnsamletDosis2() {

        //ARRANGE
        Patient patient = new Patient("1234567890", "Hans", 20);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.5,2,3,"Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2023,2,16),LocalDate.of(2023, 2, 26),patient, laegemiddel);
        dagligSkaev.opretDosis(LocalTime.of(10, 0),2);
        dagligSkaev.opretDosis(LocalTime.of(15, 30), 4);
        dagligSkaev.opretDosis(LocalTime.of(20, 00), 3);

        //ACT
        double faktiskSamletDosis = dagligSkaev.samletDosis();

        //ASSERT
        double forventetSamletDosis = 30;
        assertEquals(forventetSamletDosis, faktiskSamletDosis);
    }


    @Test
    void TC14opretDosis() {

        //ARRANGE
        Patient patient = new Patient("1234567890", "Hans", 20);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.5,2,3,"Styk");
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2023,2,16),LocalDate.of(2023, 2, 26),patient, laegemiddel);
        dagligSkaev.opretDosis(LocalTime.of(15, 30), 2);

        //ACT
        LocalTime faktiskDosisTid = dagligSkaev.getDoser().get(0).getTid();


        //ASSERT
        //assertEquals(Lo, faktiskSamletDosis);

    }





}