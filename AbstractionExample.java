// Abstract class คือแม่แบบรูปทรง
//ต่างกับ interface = can do; abstract = ต้นเเบบมันคืออะไรก็คือ class นั่นเเหละ ; 
abstract class Shape {
    protected String color;
    
    // Constructor กำหนดสี
    public Shape(String color) {
        this.color = color;
    }
    
    // Abstract method (ยังไม่มีเนื้อหา)
    public abstract double area();
    
    // Abstract method อีกตัว
    public abstract double perimeter();
    
    // Method ปกติที่ลูก class ได้ใช้ด้วย
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}

// ลูก class Rectangle ต้อง implement เมธอด abstract ทั้งหมด
class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double area() {
        return width * height;
    }
    
    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}

// ลูก class Circle ต้อง implement เมธอด abstract ทั้งหมด
class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        // Shape s = new Shape("red"); // ผิด! สร้าง instance abstract class ไม่ได้
        
        Rectangle rect = new Rectangle("Blue", 4, 5);
        Circle circle = new Circle("Red", 3);
        
        rect.displayColor();
        System.out.println("Rectangle area: " + rect.area());
        System.out.println("Rectangle perimeter: " + rect.perimeter());
        
        System.out.println();
        
        circle.displayColor();
        System.out.println("Circle area: " + circle.area());
        System.out.println("Circle perimeter: " + circle.perimeter());
    }
}
