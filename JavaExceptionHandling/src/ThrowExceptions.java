import java.util.Scanner;
import javax.naming.InvalidNameException;

public class ThrowExceptions {

    public static void main(String[] args) throws Exception {

        Scanner inputStudent = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String uname = inputStudent.next();

        System.out.print("Enter your GPA: ");
        float gpa = inputStudent.nextFloat();

        inputStudent.close();

//        validateStudent(uname, gpa);

//        try {
//            intermediateFunction(uname, gpa);
//        } catch (IllegalArgumentException | InvalidNameException e) {
//
//            System.out.println("An exception was thrown: " + e.getClass());
//            e.printStackTrace();
//        }

        intermediateFunction(uname, gpa);
    }

//    public static void intermediateFunction(String userId, float gpa)
//            throws InvalidNameException, IllegalArgumentException {
    public static void intermediateFunction(String userId, float gpa) {
        try {
            validateStudent(userId, gpa);
        } catch (IllegalArgumentException | InvalidNameException e) {

            System.out.println("An exception was thrown: " + e.getClass());
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
            System.out.println("Tha is a valid GPA. Processing eligibility...");
        }
        else {
            throw new IllegalArgumentException("Sorry. A GPA must have a value between 0 and 4.33.");
        }
    }
}
