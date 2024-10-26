import java.io.*;
import java.util.Date;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private int axis;
    private Date examinationDate;
    private String optometrist;

    // Constructor
    public Prescription(int prescID, String firstName, String lastName, String address, float sphere, 
                        float cylinder, int axis, Date examinationDate, String optometrist) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
    }

    // Getters and Setters (Optional, based on usage)

    public boolean addPrescription() {
        // Check if the conditions are met
        if (firstName.length() >= 4 && firstName.length() <= 15 &&
            lastName.length() >= 4 && lastName.length() <= 15 &&
            address.length() >= 20 &&
            sphere >= -20.00f && sphere <= 20.00f &&
            cylinder >= -4.00f && cylinder <= 4.00f &&
            axis >= 0 && axis <= 180 &&
            optometrist.length() >= 8 && optometrist.length() <= 25) {
            
            // Write to file (presc.txt)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("presc.txt", true))) {
                writer.write("Prescription ID: " + prescID + ", First Name: " + firstName + ", Last Name: " + lastName +
                             ", Address: " + address + ", Sphere: " + sphere + ", Cylinder: " + cylinder + 
                             ", Axis: " + axis + ", Date: " + examinationDate.toString() + ", Optometrist: " + optometrist);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
                return false;
            }
            return true;
        } else {
            return false;  // Conditions not met
        }
    }

    public boolean addRemark(String remark, String category) {
        // Check if the remark meets the criteria
        if (category.equals("client") || category.equals("optometrist")) {
            String[] words = remark.split("\\s+");
            if (words.length >= 6 && words.length <= 20 && Character.isUpperCase(remark.charAt(0))) {
                // Write to file (remark.txt)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("remark.txt", true))) {
                    writer.write("Remark: " + remark + ", Category: " + category);
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
