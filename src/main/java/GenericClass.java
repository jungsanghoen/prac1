public class GenericClass {
    public void genericMethod()
    {
        ClassName<Integer> studentClassName = new ClassName<Integer>();
        studentClassName.setTypeElement(1);
        System.out.println(studentClassName.getTypeElement() + studentClassName.getTypeElement().getClass().getName());
    }
}

class Student
{
    private String name;

    public Student() {
    }
}

class ClassName<T>
{
    private T typeElement;

    public void setTypeElement(T typeElement) {
        this.typeElement = typeElement;
    }

    public T getTypeElement() {
        return typeElement;
    }
}