package task;

public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public boolean isValid() {
        return this.a + this.b > this.c && this.a + this.c > this.b && this.b + this.c > this.a && this.a > 0.0D && this.b > 0.0D && this.c > 0.0D;
    }

    public double square() {
        double p = (this.a + this.b + this.c) / 2.0D;
        return this.isValid() ? Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c)) : -1.0D;
    }

    public double perimeter() {
        return this.isValid() ? this.a + this.b + this.c : -1.0D;
    }
}
