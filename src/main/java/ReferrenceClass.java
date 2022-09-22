import java.util.ArrayList;
import java.util.List;

public class ReferrenceClass {
    public ReferrenceClass() {
    }
    public void referenceAddress()
    {
        List<String> stringList = new ArrayList<>();
        List<String> reference = stringList;
        if(stringList == reference)
            System.out.println("check");

    }
}
