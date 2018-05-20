import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p05_Boxes {
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);

        ArrayList<Box> boxes = new ArrayList<>();

        String inputStr= scanner.nextLine();

        while(!inputStr.equals("end")){
            String[] inputPoints = inputStr.split(" \\| ");
            Point upperLeft = Point.parsePoint(inputPoints[0]);
            Point upperRight = Point.parsePoint(inputPoints[1]);
            Point bottomLeft = Point.parsePoint(inputPoints[2]);
            Point bottomRight = Point.parsePoint(inputPoints[3]);

            Box currentBox = new Box(upperLeft, upperRight, bottomLeft,bottomRight);

            boxes.add(currentBox);
            inputStr = scanner.nextLine();
        }

        boxes.stream()
                .forEach(b->{
                    System.out.printf("Box: %d, %d%n",(int)b.getWidth(),(int)b.getHeight());
                    System.out.printf("Perimeter: %d%n",b.calcPerimeter((int)b.getHeight(),(int)b.getWidth()));
                    System.out.printf("Area: %d%n",b.calcArea((int)b.getHeight(),(int)b.getWidth()));
                });
    }

}
class Point {
    private int x;
    private int y;

    public Point(int xIn, int yIn){
        this.x = xIn;
        this.y = yIn;
    }
    public static double returnDistance(Point point1, Point point2) {
        return (int)Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }
    public static Point parsePoint(String input ){
        int[] coordinates = Arrays.stream(input.split(":")).mapToInt(Integer::parseInt).toArray();
        return new Point(coordinates[0],coordinates[1]);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}
class Box{
    private Point upperLeft;
    private Point upperRight;
    private Point bottomLeft;
    private Point bottomRight;

    public Box(Point upLeft, Point upRight, Point btLeft, Point btRight){
        this.upperLeft = upLeft;
        this.bottomLeft = btLeft;
        this.upperRight= upRight;
        this.bottomRight = btRight;
    }

    public Point getUpperLeft(){return upperLeft;}
    public Point getUpperRight() {return upperRight;}
    public Point getBottomLeft(){return bottomLeft;}
    public Point getBottomRight(){return bottomRight;}

    public double getHeight(){
        return Point.returnDistance(upperLeft,bottomLeft);
    }
    public double getWidth(){
        return Point.returnDistance(upperRight,upperLeft);
    }

    public int calcPerimeter(int height, int width){
        return 2*height+2*width;
    }
    public int calcArea(int height, int width){
        return height*width;
    }
}
