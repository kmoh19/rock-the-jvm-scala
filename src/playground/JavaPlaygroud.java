package playground;

public class JavaPlaygroud {
    public static void main(String args[]){
        System.out.println(Person.N_EYES);//class level action not instance based
    }
}

class Person{
    public static final int N_EYES =2;
}
