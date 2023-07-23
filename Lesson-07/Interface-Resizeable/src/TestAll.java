public class TestAll{
    public static void main(String[] args) {
        double randomNumber = Math.round(Math.random() * 100);
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Square();
        shapes[2] = new Rectangle();

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(((Circle) shape).getArea());
                ((Circle) shape).resize(randomNumber);
                System.out.println(((Circle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println(((Square) shape).getArea());
                ((Square) shape).resize(randomNumber);
                ((Square) shape).howToColor();
                System.out.println(((Square) shape).getArea());
            } else {
                System.out.println(((Rectangle) shape).getArea());
                ((Rectangle) shape).resize(randomNumber);
                System.out.println(((Rectangle) shape).getArea());
            }
        }
    }
}
