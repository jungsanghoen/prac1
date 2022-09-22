public class RepeatClass {
    public RepeatClass() {
    }
    public void sumWhile()
    {
        int result = 0;
        int i =0;
        while (true) {
            if(i>=100)
                break;
            result += i;
            i++;
        }
        System.out.println("result = " + result);
    }
    public void gugu()
    {
        int i = 1;
        int j = 1;
        for (;i<10;i++)
        {
            for(j=1;j<10;j++)
            {
                System.out.printf("현재 %d 의 * %d = %d\n", i,j,i*j);
            }
            System.out.println("");
        }

    }
}
