public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return "This Cylinder has radius: " + getRadius() + "\nheight: " + height + " and volume is: " + getVolume();
    }
}
