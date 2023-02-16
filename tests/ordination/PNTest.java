package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PNTest {
    PN pn;
    @BeforeEach
    public void opsaetning() {
        Patient p = new Patient("123456-7890", "Janne rhododendronpostkasse", 66.9);
        Laegemiddel lm = new Laegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        LocalDate startdato = LocalDate.of(2023, 02, 16);
        LocalDate slutdato = LocalDate.of(2023, 02, 18);
        pn = new PN(startdato, slutdato, p, lm, 5);
    }

    @Test
    void TC25_givDosis() {
        assertTrue(pn.givDosis(LocalDate.of(2023, 02, 16)));
    }

    @Test
    void TC26_givDosis() {
        assertTrue(pn.givDosis(LocalDate.of(2023, 02, 17)));
    }

    @Test
    void TC27_givDosis() {
        assertTrue(pn.givDosis(LocalDate.of(2023, 02, 18)));
    }

    @Test
    void TC28_givDosis() {
        assertFalse(pn.givDosis(LocalDate.of(2023, 02, 15)));
    }

    @Test
    void TC29_givDosis() {
        assertFalse(pn.givDosis(LocalDate.of(2023, 02, 19)));
    }

    @Test
    void TC30_doegnDosis() {
        //Act
        double actual = pn.doegnDosis();

        //Assert
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void TC31_doegnDosis() {
        //Arrange
        pn.givDosis(LocalDate.of(2023, 02, 16));
        pn.givDosis(LocalDate.of(2023, 02, 17));

        //Act
        double actual = pn.doegnDosis();

        //Assert
        double expected = 10.0;
        assertEquals(expected, actual);
    }

    @Test
    void TC32_doegnDosis() {
        //Arrange
        pn.givDosis(LocalDate.of(2023, 02, 16));
        pn.givDosis(LocalDate.of(2023, 02, 17));
        pn.setAntalEnheder(0.0);

        //Act
        double actual = pn.doegnDosis();

        //Assert
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void TC33_doegnDosis() {
        //Arrange
        pn.givDosis(LocalDate.of(2023, 02, 16));
        pn.givDosis(LocalDate.of(2023, 02, 17));
        pn.setAntalEnheder(-1.0);

        //Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            pn.doegnDosis();
        });
        assertEquals(exception.getMessage(), "antalEnheder eller antalGivet må ikke være under 0");
    }

    @Test
    void TC34_doegnDosis() {
        //Arrange
        pn.givDosis(LocalDate.of(2023, 02, 16));
        pn.givDosis(LocalDate.of(2023, 02, 17));
        pn.setAntalGivet(-1);

        //Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            pn.doegnDosis();
        });
        assertEquals(exception.getMessage(), "antalEnheder eller antalGivet må ikke være under 0");
    }

    @Test
    void TC35_samletDosis() {
        //Arrange
        pn.setAntalGivet(1);
        pn.setAntalEnheder(0.0);

        //Act
        double actual = pn.samletDosis();

        //Assert
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void TC36_samletDosis() {
        //Arrange
        pn.setAntalGivet(0);
        pn.setAntalEnheder(1.0);

        //Act
        double actual = pn.samletDosis();

        //Assert
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    void TC37_samletDosis() {
        //Arrange
        pn.setAntalGivet(2);
        pn.setAntalEnheder(2.0);

        //Act
        double actual = pn.samletDosis();

        //Assert
        double expected = 4.0;
        assertEquals(expected, actual);
    }

    @Test
    void TC38_samletDosis() {
        //Arrange
        pn.setAntalGivet(0);
        pn.setAntalEnheder(-1.0);

        //Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            pn.samletDosis();
        });
        assertEquals(exception.getMessage(), "antalEnheder eller antalGivet må ikke være under 0");
    }

    @Test
    void TC39_samletDosis() {
        //Arrange
        pn.setAntalGivet(-1);
        pn.setAntalEnheder(0.0);

        //Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            pn.samletDosis();
        });
        assertEquals(exception.getMessage(), "antalEnheder eller antalGivet må ikke være under 0");
    }
}