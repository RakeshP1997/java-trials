import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Input: 5asdbd
 * output: abds
*/

public class sortAlphabetsInString {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, Integer> charArr = new HashMap<>();
        System.out.print("Enter input string:");
        String ip = scanner.next().trim();
         ip = ip.replaceAll("/[0-9]/","");
        for (char c :
                ip.toCharArray()) {
            charArr.put((int) c, charArr.getOrDefault((int) c,0));
        }
        for(int  i = 'a'; i<= (int)'z';i++) {
            System.out.print(charArr.containsKey(i) ? (char)i : "");
        }
    }
}
