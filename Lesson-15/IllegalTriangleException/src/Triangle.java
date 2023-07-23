public class Triangle {
    private int sideA,sideB,sideC;

    public Triangle(int sideA, int sideB, int sideC) throws IllegalTriangleException {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalTriangleException("Cạnh tam giác phải lớn hơn 0");
        } else
            if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
                throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại");
            } else {
                this.sideA = this.sideA;
                this.sideB = this.sideB;
                this.sideC = this.sideC;
            }
    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }
}
