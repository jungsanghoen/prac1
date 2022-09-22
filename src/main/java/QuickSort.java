import java.util.Comparator;
import java.util.List;

public class QuickSort implements CustomArray{
    @Override
    public List<Integer> ascSort(List<Integer> integerList) {
        integerList.sort(Comparator.naturalOrder());
        return integerList;
    }

    @Override
    public List<Integer> descSort(List<Integer> integerList) {
        integerList.sort(Comparator.reverseOrder());
        return integerList;
    }

    @Override
    public void description() {
        System.out.println("Quick Sort");
        this.privateMethod();
    }

    private void privateMethod()
    {
        System.out.println("privateMethod");
    }
}
