package praktikum.sesi13;
import java.util.*;

class SetExample {
    void contoh() {
        Set<String> set = new HashSet<>();
        set.add("Bernadine");
        set.add("Elizabeth");
        set.add("Gene");
        set.add("Elizabeth");
        set.add("Clara");
        System.out.println(set);
    }

    void FindDups(String[] args) {
        Set<String> s = new HashSet<>();
        for (String a : args)
            if (!s.add(a))
                System.out.println("Duplicate detected: " + a);
        System.out.println(s.size() + " distinct words: " + s);
    }

    public static void main(String[] x) {
        SetExample se = new SetExample();
        se.contoh();
        String[] words = {"Bernadine", "Elizabeth", "Gene", "Elizabeth", "Clara"};
        se.FindDups(words);
    }
}
