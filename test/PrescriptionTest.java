import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class PrescriptionTest {

    @Test
    public void testAddPrescriptionValid() {
        Prescription prescription = new Prescription(
            1, "John", "Smith", "1234 Elm Street, City, State, Zip, Country",
            -2.5f, 1.25f, 90, new Date(), "Dr. Alex Johnson"
        );
        assertTrue(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalid() {
        Prescription prescription = new Prescription(
            1, "Jo", "Sm", "Short Address", -25.0f, 5.0f, 190, new Date(), "Dr"
        );
        assertFalse(prescription.addPrescription());
    }

    @Test
    public void testAddRemarkValid() {
        Prescription prescription = new Prescription(
            1, "John", "Smith", "1234 Elm Street, City, State, Zip, Country",
            -2.5f, 1.25f, 90, new Date(), "Dr. Alex Johnson"
        );
        assertTrue(prescription.addRemark("Client is very satisfied with the service.", "client"));
    }

    @Test
    public void testAddRemarkInvalid() {
        Prescription prescription = new Prescription(
            1, "John", "Smith", "1234 Elm Street, City, State, Zip, Country",
            -2.5f, 1.25f, 90, new Date(), "Dr. Alex Johnson"
        );
        assertFalse(prescription.addRemark("too short", "client"));
    }
}
