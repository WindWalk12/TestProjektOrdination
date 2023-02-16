package ordination;
import controller.Controller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControllerTest {
    Controller controller;

    @Test
        void TC1_AnbefaletDosisPrDoegn_Vaegt0_EnhedPrKgPrDoegnLet2() {
            //Arrange
            Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 2,
                    0.15, 0.16, "Styk");
            Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 0);
            controller = Controller.getTestController();

            //Act
            double faktiskResult = controller.anbefaletDosisPrDoegn(patient,laegemiddel);

            //Assert
            double forventetResult = 0;
            assertEquals(forventetResult,faktiskResult);
            }

    @Test
    void TC2_AnbefaletDosisPrDoegn_Vaegt24_EnhedPrKgPrDoegnLet2() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 2,
                0.15, 0.16, "Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 24);
        controller = Controller.getTestController();

        //Act
        double faktiskResult = controller.anbefaletDosisPrDoegn(patient,laegemiddel);

        //Assert
        double forventetResult = 48;
        assertEquals(forventetResult,faktiskResult);
    }

    @Test
    void TC3_AnbefaletDosisPrDoegn_Vaegt25_EnhedPrKgPrDoegnLet2() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 2, 2, 2, "Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 25);
        controller = Controller.getTestController();

        //Act
        double faktiskResult = controller.anbefaletDosisPrDoegn(patient,laegemiddel);

        //Assert
        double forventetResult = 50;
        assertEquals(forventetResult,faktiskResult);
    }

    @Test
    void TC4_AnbefaletDosisPrDoegn_Vaegt26_EnhedPrKgPrDoegnLet2() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 2, 2, 2, "Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 26);
        controller = Controller.getTestController();

        //Act
        double faktiskResult = controller.anbefaletDosisPrDoegn(patient,laegemiddel);

        //Assert
        double forventetResult = 52;
        assertEquals(forventetResult,faktiskResult);
    }

    @Test
    void TC5_AnbefaletDosisPrDoegn_Vaegt120_EnhedPrKgPrDoegnLet2() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 2, 2, 2, "Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 120);
        controller = Controller.getTestController();

        //Act
        double faktiskResult = controller.anbefaletDosisPrDoegn(patient,laegemiddel);

        //Assert
        double forventetResult = 240;
        assertEquals(forventetResult,faktiskResult);
    }

    @Test
    void TC6_AnbefaletDosisPrDoegn_Vaegt121_EnhedPrKgPrDoegnLet2() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 2, 2, 2, "Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 121);
        controller = Controller.getTestController();

        //Act
        double faktiskResult = controller.anbefaletDosisPrDoegn(patient,laegemiddel);

        //Assert
        double forventetResult = 242;
        assertEquals(forventetResult,faktiskResult);
    }

    @Test
    void TC7_AntalOrdinationerPrVægtPrLægemiddel_medLaegemiddel() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 2, 2, 2, "Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 121);
        controller = Controller.getTestController();

        //Act

        int faktiskResult = controller.antalOrdinationerPrVægtPrLægemiddel(70,80,laegemiddel);

        //Assert
        int forventetResult = 0;
        assertEquals(forventetResult,faktiskResult);
    }

    @Test
    void TC8_AntalOrdinationerPrVægtPrLægemiddel_udenLaegemiddel() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 2, 2, 2, "Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 121);
        controller = Controller.getTestController();

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           int faktiskResult = controller.antalOrdinationerPrVægtPrLægemiddel(70,80,null);
        });

        //Assert
        assertEquals(exception.getMessage(),"Lægemiddel ikke valgt");
    }

    @Test
    void TC9_AntalOrdinationerPrVægtPrLægemiddel_StartvægtErUnder0() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 2, 2, 2, "Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 121);
        controller = Controller.getTestController();

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int faktiskResult = controller.antalOrdinationerPrVægtPrLægemiddel(-10,70,laegemiddel);
        });

        //Assert
        assertEquals(exception.getMessage(),"Startvægt eller slutvægt er under 0");
    }

    @Test
    void TC10_AntalOrdinationerPrVægtPrLægemiddel_StartvægtErStørreEndSlutvægt() {
        //Arrange
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 2, 2, 2, "Styk");
        Patient patient = new Patient("123456-7890", "Janne rhododendronpostkasse", 121);
        controller = Controller.getTestController();

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int faktiskResult = controller.antalOrdinationerPrVægtPrLægemiddel(70,60,laegemiddel);
        });

        //Assert
        assertEquals(exception.getMessage(),"Startvægt er større end slutvægt");
    }


}
