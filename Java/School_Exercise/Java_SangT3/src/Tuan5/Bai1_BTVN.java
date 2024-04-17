package Tuan5;
import java.util.Scanner;
import java.util.Arrays;

// Interface Ishape
interface IShape {
    double getArea();
    double getPerimeter();
}

// Lớp Rectangle kế thừa từ Interface IShape
class Rectangle implements IShape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Getter & Setter
    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }

    // Override methods from IShape interface
    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }
}

// Lớp Circle kế thừa từ Interface IShape
class Circle implements IShape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter & Setter
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    // Override methods from IShape interface
    @Override
    public double getArea() { return Math.PI * radius * radius; }

    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }
}

public class Bai1_BTVN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input info rectangles
        System.out.print("Nhập số hình chữ nhật: ");
        int n = Integer.parseInt(sc.next());
        Rectangle[] rectangles = new Rectangle[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập kích thước hình " + (i+1));
            System.out.print("Nhập chiều dài: ");
            double length = Double.parseDouble(sc.next());
            System.out.print("Nhập chiều rộng: ");
            double width = Double.parseDouble(sc.next());
            rectangles[i] = new Rectangle(length, width);
        }
        
        // Find min_area & max_perimeter
        Rectangle minPerimeterRect = rectangles[0];
        Rectangle maxAreaRect = rectangles[0];
        for (int i = 1; i < n; i++) {
        	if (rectangles[i].getArea() > maxAreaRect.getArea()) {
        		maxAreaRect = rectangles[i];
        	}
        	if (rectangles[i].getPerimeter() < minPerimeterRect.getPerimeter()) {
        		minPerimeterRect = rectangles[i];
        	}
        }
        
        // Show min_area & max_perimeter
        System.out.println("Hình chữ nhật có chu vi nhỏ nhất");
        System.out.println("- Chiều dài: " + minPerimeterRect.getLength());
        System.out.println("- Chiều rộng: " + minPerimeterRect.getWidth());
        
        System.out.println("Hình chữ nhật có diện tích lớn nhất");
        System.out.println("- Chiều dài: " + maxAreaRect.getLength());
        System.out.println("- Chiều rộng: " + maxAreaRect.getWidth());
        System.out.println();
        
        // input info circle
        System.out.print("Nhập số hình tròn: ");
        int m = Integer.parseInt(sc.next());
        
        Circle[] circles = new Circle[m];
        for (int i = 0; i < m; i++) {
            System.out.println("Nhập kích thước hình " + (i+1));
            System.out.print("Nhập bán kính: ");
            double r = Double.parseDouble(sc.next());
            circles[i] = new Circle(r);
        }
        
        // Count difference circle
        double[] areas = new double[m];
        int uniqueAreaCount = 0;
        for (int i = 0; i < m; i++) {
        	areas[i] = circles[i].getArea();
        }
        Arrays.sort(areas);
        for (int i = 0; i < m-1; i++) {
        	if (areas[i] != areas[i+1]) {
        		uniqueAreaCount += 1;
        	}
        }
        if (uniqueAreaCount == 0) {
        	System.out.println("Không có hình tròn nào có diện tích khác nhau.");
        }
        else {
        	System.out.println("Số lượng hình tròn có diện tích khác nhau: " + (uniqueAreaCount + 1));
        }
        
        // Question
        System.out.print("Bạn có muốn sắp xếp không? (y/n): ");
        char answ = sc.next().charAt(0);
        if (answ == 'y' || answ == 'Y') {
        	// Arrange the circle in a direction that does not increase in radius
        	Arrays.sort(circles, (c1, c2) -> Double.compare(c2.getRadius(), c1.getRadius()));
        	System.out.println("Danh sách các hình tròn sau khi đã sắp xếp: ");
        	for (int i = 0; i < m; i++) {
        		System.out.println("Hình tròn " + (i+1) + " - Bán kính: " + circles[i].getRadius());
        	}
        }
    }
}
