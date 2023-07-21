public class CustomExceptions {

    public static void main(String[] args) {

//        userRequests("loony_corn", "login");
//        userRequests("corn_loony", "login");
//        userRequests("loony_admin_alice", "delete");
        userRequests("loony_dev_bob", "delete");

    }

    public static void userRequests(String userId, String operation) {

        if (userId.startsWith("loony_")) {
            System.out.println("The username checks out...");
        }
        else {
            throw new InvalidUsernameException("The username is not in the correct format");
        }

        if (operation.equals("edit") || operation.equals("delete")) {
            if (!userId.startsWith("loony_admin")) {
                throw new IllegalAccessError("The user does not have the required permissions.");
            }
        }

        System.out.format("\nThe user %s has requested the %s operation.",
                    userId, operation);
    }
}
