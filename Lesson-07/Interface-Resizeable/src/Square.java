public class Square extends Rectangle implements Resizeable, Colorable {
    private double side = 2;
    public Square() {
    }
    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side); // super.width = this.side
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
        //this.side = super.width
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        setSide(side * (1 + percent/ 100));
    }

    @Override
    public void howToColor() {
    }
}

