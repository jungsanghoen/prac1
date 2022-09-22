public class TestClass {
    public TestClass(){
        return;
    }
    public void charToString()
    {
        String temp = "캐릭터 변환";
        char[] chars = temp.toCharArray();
        String change = "";

        System.out.printf("string to char = %s",chars);

        String targetString = String.valueOf(chars);

        System.out.println("char to string = " + targetString);
    }

    public void rememberStarPrint()
    {
        int i = 0;
        for(i=0;i<66;i++)
        {
            for(int j=i; j<6; j++)
            {
                System.out.print("*");
            }
            System.out.print("*\n");
        }

    }
}
