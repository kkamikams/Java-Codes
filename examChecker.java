public class examChecker {
    public static void main(String[] args) {

        // change variables into true or false
        boolean isLoggedin = true;
        boolean hasStableinternet = true;
        boolean isExamtime = true;

        if (isLoggedin) {
            if (hasStableinternet) {
                if (isExamtime) {
                        System.out.println("You may now start your exam.");
                    } else {
                    System.out.println("Please wait, the exam hasn’t started yet.");
                    }
                } else {
                System.out.println("You cannot take the exam. Check your internet connection.");
                }
            } else {
                System.out.println("Please log-in first.");
            }
        }
    }

