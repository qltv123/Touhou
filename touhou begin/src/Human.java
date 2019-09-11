import java.util.ArrayList;

public class Human {
    public static void main(String[] args) {
        ArrayList<String> arrString = new ArrayList<>();
        // arrString ~ size = 0
        // .add()
        // .get()
        // .size()
        // .remove()
        System.out.println("Array size: " + arrString.size());
        System.out.println(arrString);
        arrString.add("H");
        arrString.add("e");
        arrString.add("l");
        arrString.add("l");
        arrString.add("o");
        System.out.println("Array size: " + arrString.size());
        System.out.println(arrString);
        for(int i = 0; i < arrString.size(); i++) {
            String arrItem = arrString.get(i);
            System.out.println(arrItem);
        }
    }











    // thuoc tinh
    String name;
    int age;
    String address;

    //ham tao
    public Human(){
        name = "Nguyen van a";
        age = 20;
        address = "Ha Noi";
    }
    public Human(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
    //  phuong thuc
    public void eat(){
        System.out.println("Eating..");
    }

    public void sleep(){
        System.out.println("Sleeping..");
    }
}
