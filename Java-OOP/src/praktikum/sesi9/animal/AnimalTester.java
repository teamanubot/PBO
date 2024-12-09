package praktikum.sesi9.animal;

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + " says Woof");
    }
}

public class AnimalTester {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        dog.speak();
    }
}
