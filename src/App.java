import java.io.*;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {

        Prescription prescription = new Prescription();
        boolean result = prescription.addPrescription(
            1, "John", "Doe", "123 Elm Street, City, Zip, Country", 
            -2.5f, 1.5f, 120, new Date(), "Dr. Smith"
        );
        
        if(result) {
            System.out.println("Prescription added successfully.");
        } else {
            System.out.println("Prescription failed to add.");
        }
        

        boolean remarkResult = prescription.addRemark("Client is happy with the service.", "client");
        
        if(remarkResult) {
            System.out.println("Remark added successfully.");
        } else {
            System.out.println("Remark failed to add.");
        }
    }
}

class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private int axis;
    private Date examinationDate;
    private String optometrist;

    // Constructor and Getters/Setters

    public boolean addPrescription(int prescID, String firstName, String lastName, String address, float sphere, 
                                   float cylinder, int axis, Date examinationDate, String optometrist) {
        if (firstName.length() >= 4 && firstName.length() <= 15 &&
            lastName.length() >= 4 && lastName.length() <= 15 &&
            address.length() >= 20 &&
            sphere >= -20.00f && sphere <= 20.00f &&
            cylinder >= -4.00f && cylinder <= 4.00f &&
            axis >= 0 && axis <= 180 &&
            optometrist.length() >= 8 && optometrist.length() <= 25) {
            
            // Add prescription to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("presc.txt", true))) {
                writer.write("Prescription ID: " + prescID + ", First Name: " + firstName + ", Last Name: " + lastName +
                             ", Address: " + address + ", Sphere: " + sphere + ", Cylinder: " + cylinder + 
                             ", Axis: " + axis + ", Date: " + examinationDate.toString() + ", Optometrist: " + optometrist);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("An error occurred while writing the prescription.");
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean addRemark(String remark, String category) {
        if (category.equals("client") || category.equals("optometrist")) {
            String[] words = remark.split("\\s+");
            if (words.length >= 6 && words.length <= 20 && Character.isUpperCase(remark.charAt(0))) {
                // Add remark to a file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("remark.txt", true))) {
                    writer.write("Remark: " + remark + ", Category: " + category);
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing the remark.");
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
