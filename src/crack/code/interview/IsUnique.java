package crack.code.interview;

/**
 * Is Unique:
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    public static void main(String args[]) {
        String value = "abcdea";
        System.out.println("Check if the following String is unique: " + value + "-" + isUnique(value));
    }

    public static boolean isUnique(String value){

        boolean result = true;
        boolean[] charactes = new boolean[128];

        for(int i=0; i < value.length(); i++) {

            if(charactes[value.charAt(i)] == true) {
                return false;
            }
            charactes[value.charAt(i)] = true;
        }
        return result;
    }
}
