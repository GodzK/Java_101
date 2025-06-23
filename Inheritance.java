// Parent class
class Animal {
    // ห้ามเข้าถึงของเเม่ เช่น .name ไม่ได้ ต้องเอา getterมาดึง
    private String name;
    private int age;
    Animal(String name , int age){
        //instance ของตัวเอง
        this.name = name ;
        this.age = age;
    }
    void sound() {
        System.out.println("Animal makes a sound");
    }
    //protected inheritance = ป้องกันระหว่าง package cons:  เเต่มันยัง .name โดยตรงได้
    protected void setName(String newName){
        this.name = newName;
    }
    protected String getName(){
        return this.name;
    }
     protected int getAge() {
        return this.age;
    }
}   

// Child class 1
class Dog extends Animal {
    Dog(String name ,int age){
        // ขออันเเม่
        super(name,age);
        
    }
    @Override
    void sound() {
        System.out.println(getName() + " barks");
    }
}

// Child class 2
class Cat extends Animal {
    Cat(String name , int age){
        super(name,age);
    }
    @Override // เพื่อบอกmethodที่เหมือนกันเเต่เรา inheriมาเเละเปลี่ยน
    void sound() {
        System.out.println(getName() +" meows");
    }
}

// Main class to test inheritance
public class Inheritance {
    public static void main(String[] args) {
        Animal myAnimal = new Animal("Joey" , 18);
        myAnimal.sound();  // Animal makes a sound

        Dog myDog = new Dog("Puppy" , 19);
        myDog.sound();     // Dog barks

        Cat myCat = new Cat("Pussy" , 3);
        myCat.sound();     // Cat meows
    }
}
