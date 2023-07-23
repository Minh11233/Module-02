public class QuadraticEquation {
    double a, b, c;
    private String name = "Minh";
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation() {

    }
    public String GetName() {
        return this.name;
    }

    public void SetName(String newName) {
        this.name = newName;
    }
    public double getDiscriminant() {
        double delta = b*2 - 4 * a * c;
        return delta;
    }
    public double getRoot1() {
        if (getDiscriminant() >= 0) {
            double r1 = (-b + Math.sqrt((Math.pow(b,2) - 4 * a * c))) / 2 * a;
            return r1;
        } else {
            return 0;
        }
    }
    public double getRoot2() {
        if (getDiscriminant() >= 0) {
            double r2 = (-b - Math.sqrt((Math.pow(b,2) - 4 * a * c))) / 2 * a;
            return r2;
        } else {
            return 0;
        }
    }
}
