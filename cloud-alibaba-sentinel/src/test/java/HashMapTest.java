import java.util.HashMap;
import java.util.Map;

/**
 * @author sunbaojin
 * @date 2020/4/25 22:08
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,String> testMap =new HashMap<>();
        testMap.put("1","zhang1");
        testMap.put("2","zhang2");
        System.out.println("zhang1".hashCode());
        System.out.println(testMap.get("1"));

    }
}
