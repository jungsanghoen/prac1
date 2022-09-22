import java.util.HashSet;
import java.util.Set;

public class ArrayClass {
    public ArrayClass() {

    }
    public void setArray()
    {
        Set<Integer> setint = new HashSet<Integer>();
        setint.add(5);
        setint.add(2);
        setint.add(100);
        setint.add(-8);

        System.out.println(setint);
        int t = 5;
        String strt = "adfa";
        System.out.println(strt.hashCode());


    }
}
