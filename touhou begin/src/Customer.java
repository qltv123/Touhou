public class Customer extends Human {
    double salary;
    //ham tao
    public Customer(String name, int age, String address, double salary){
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }
    // phuong thuc
    public void buy(){
        System.out.println("Buying something..");
    }

    @Override
    public void eat(){
        super.eat(); //Human.eat()
        System.out.println("Eating done..");
    }

}
