import java.util.Scanner;
import javax.naming.InvalidNameException;
import java.util.InputMismatchException;
import java.security.InvalidParameterException;

public class ThrowExceptions {

    public static void main(String[] args) throws Exception {

        Scanner inputStudent = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String uname = inputStudent.next();

//        System.out.print("Enter your GPA: ");
//        float gpa = inputStudent.nextFloat();

        float gpa = 0f;

        try {
            System.out.print("Enter your GPA: ");
            gpa = inputStudent.nextFloat(); // java.util.InputMismatchException
        }
        catch (InputMismatchException ex) {
            gpa = 1.0f;

            ex.initCause(new IllegalArgumentException("The GPA needs to be a number between 0 and 4.33."));

            System.out.println("What is the cause of the Exception? \n" + ex.getCause());
        }
//        catch (InputMismatchException ex) {
//            throw new IllegalArgumentException("A GPA must have a numeric value between 0 and 4.33.");
//        }

        inputStudent.close();

        try {
            intermediateFunction(uname, gpa); // javax.naming.InvalidNameException
        }
        catch (InvalidNameException e) {
            System.out.println(e.getClass() + ": The username is invalid");
            e.printStackTrace();
        }
    }

    public static void intermediateFunction(String userId, float gpa)
            throws InvalidNameException {
        try {
            validateStudent(userId, gpa); // java.lang.IllegalArgumentException
        } catch (IllegalArgumentException e) {

            System.out.println(e.getClass() + ": The GPA is invalid");
            e.printStackTrace();
        }
    }

    public static void validateStudent(String userId, float gpa)
            throws InvalidNameException, IllegalArgumentException {

        if (userId.startsWith("loony_")) {
            System.out.println("The username checks out...");
        }
        else {
            throw new InvalidNameException("The username is not in the correct format");
        }

        if (gpa > 0 && gpa <= 4.33) {
            System.out.println("That is a valid GPA. Processing eligibility...");
        }
        else {
            throw new IllegalArgumentException("Sorry. A GPA must have a value between 0 and 4.33.");
        }
    }
}
