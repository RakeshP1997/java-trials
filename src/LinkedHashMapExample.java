import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lh = new LinkedHashMap<>();
        lh.put("rakesh", 1);
        lh.put("phalak", 2);
        lh.put("user1", 31);
        lh.put("user2", 3);
        System.out.println(lh);
        Map<String, Integer> h = new HashMap<>();
        h.put("rakesh", 1);
        h.put("phalak", 2);
        h.put("user1", 31);
        h.put("user2", 3);
        System.out.println(h);
    }
}
