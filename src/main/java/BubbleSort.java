import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleSort implements CustomArray{
    @Override
    public List<Integer> ascSort(List<Integer> integerList) {
        Collections.sort(integerList);
        return integerList;
    }

    @Override
    public List<Integer> descSort(List<Integer> integerList) {

        Collections.sort(integerList, Collections.reverseOrder());
        return integerList;
    }

    @Override
    public void description() {
        System.out.println("Buble Description");
    }
}
