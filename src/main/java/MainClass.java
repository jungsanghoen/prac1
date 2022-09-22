import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args)
    {
        TestClass testClass = new TestClass();
        //testClass.charToString();
        //testClass.rememberStarPrint();
        RepeatClass repeatClass = new RepeatClass();
        //repeatClass.sumWhile();;
        //repeatClass.gugu();
        ReferrenceClass referrenceClass = new ReferrenceClass();
        //referrenceClass.referenceAddress();
        ArrayClass arrayClass = new ArrayClass();
        arrayClass.setArray();

        CustomArray bubble = new BubbleSort();
        CustomArray quick = new QuickSort();

        bubble.description();
        quick.description();
        List<Integer> integerList = new ArrayList<>(Arrays.asList(10,5,2,7,1));

        integerList = bubble.ascSort(integerList);
        System.out.println(integerList);
        integerList = bubble.descSort(integerList);
        System.out.println(integerList);
        integerList = quick.ascSort(integerList);
        System.out.println(integerList);
        integerList = quick.descSort(integerList);
        System.out.println(integerList);

        GenericClass genericClass = new GenericClass();
        genericClass.genericMethod();
    }
}
