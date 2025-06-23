//คุณสมบัติต้องครบ
interface Playable {
    //spec ที่ต้อง implement
    void playSound();
    void stopSound();
}
interface Recordable{
    void playSound();
    void stopSound();
    void startRecord();
    void stopRecord();
}
class Mp3Player implements Playable {
    public void playSound() {
        System.out.println("Playing mp3 music ...");
    }
    public void stopSound() {
        System.out.println("Mp3 music stopped.");
    }
}

class VoiceRecorder implements Recordable {
    public void playSound() {
        System.out.println("Playing Record ...");
    }
    public void stopSound() {
        System.out.println("Record stopped.");
    }
    public void startRecord() {
        System.out.println("Start Record ...");
    }
    public void stopRecord() {
        System.out.println("Record stopped.");
    }
    public void getRecordFormat(){
        System.out.println("Get Record Format !!");
    }
}

class Dog {
    //Least Privileged Access (Security)
    //encapsulation เพิ่มคุณค่าของ getter setter เพื่อเพิ่มความปลอดภ้ย
    private String name;
    private int age;
    static int population = 0;
    Dog(String name , int age){
        this.name = name ;
        this.age = age ;
        // เก็บค่าไว้ใน static เเละพอrun constructor อีกทีก็บวกๆ
        population++;
        System.out.println("Create totoal things : " + population);
    }
    //setter
    public void editName(String name){
        this.name = name;
        System.out.println("Name has setted");
    }

    String bark(){
        return (this.name + " say Hong Hong !!");
    }

    public void bark(int round){
        for (int i = 0; i < round; i++) {
            System.out.println("Bark");
        }
    }

    String age(){
        return ("He is "+ age + " Years Old");
    }

    String countName(String greetingWord,String name){
        return (greetingWord + name.length());
    }
}

public class Main{
    public static void main(String[] args) {
        Dog mydog = new Dog("fluffy",18);
        // mydog.age = 3 cant because its encapsulation
        //วิธีจะเเก้ไขข้อมูล
        System.out.println(mydog.bark());
        mydog.bark(5);
        System.out.println(mydog.age());
        System.out.println(mydog.countName("My name length is ", "Phakaphol"));
        //Playable เป็นต้นเเบบ เเต่มันต้อง instance ของตัวเอง
        Playable mp3player = new Mp3Player();
        mp3player.playSound();
        Recordable voicerec = new VoiceRecorder();
        voicerec.startRecord();
        Dog mydog1 = new Dog("fluffy",18);
        mydog1.editName("Finle");
        System.out.println(mydog1.bark());
        
    }
}
