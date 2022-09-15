public class QuadraticEquation {
    private double NumberA;
    private double NumberB;
    private double NumberC;

    public QuadraticEquation(double numberA, double numberB, double numberC) {
        this.NumberA = numberA;
        this.NumberB = numberB;
        this.NumberC = numberC;
    }

    public double getNumberA() {
        return NumberA;
    }

    public double getNumberB() {
        return NumberB;
    }

    public double getNumberC() {
        return NumberC;
    }

    public double getDiscriminant() {
        double delta = (NumberB * 2) - (4 * NumberA * NumberC);
        return delta;
    }

    public double getRoot1() {
        double root1 = ((-NumberB) + (Math.sqrt(Math.pow(NumberB, 2) - (4 * NumberA * NumberC))))/(2*NumberA);
return root1;
    }
    public double getRoot2() {
        double root2 = ((-NumberB) - (Math.sqrt(Math.pow(NumberB, 2) - (4 * NumberA * NumberC))))/(2*NumberA);
        return root2;
    }
}
