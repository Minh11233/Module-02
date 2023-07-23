import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class Fan {
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = 1;
        this.on = false;
        this.radius = 5d;
        this.color = "blue";
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        if (isOn()) {
            return "speed is " + getSpeed() + ", color is " + getColor() + ", radius is " + getRadius() + ", fan is on.";
        } else {
            return "color is " + getColor() + ", radius is " + getRadius() + ", fan is off.";
        }
    }
}