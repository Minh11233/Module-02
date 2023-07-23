public class Triangle extends Shape{
    private double side1,side2,side3;

    public Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getAre() {
        double p = getPerimeter() / 2;
        return Math.sqrt((p * (p - side1) * (p - side2) * (p - side3)));
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "The lengths of the three sides of the triangle are: " + side1 + " cm " + side2 + " cm " + side3
                + " cm and its Area: " + getAre() + " cm2 and its Perimeter: " + getPerimeter() + " cm";
    }
}
