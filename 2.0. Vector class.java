public class Vector {
    
    private double x;
    private double y;
    private double z;

    // Constructor to initialize vector components
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Calculate vector length (magnitude)
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Calculate scalar (dot) product
    public double scalarProduct(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    // Calculate vector (cross) product
    public Vector vectorProduct(Vector vector) {
        return new Vector(
            y * vector.z - z * vector.y,
            z * vector.x - x * vector.z,
            x * vector.y - y * vector.x
        );
    }

    // Calculate cosine of the angle between two vectors
    public double cos(Vector vector) {
        return this.scalarProduct(vector) / (this.length() * vector.length());
    }

    // Add two vectors
    public Vector add(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    // Subtract two vectors
    public Vector subtract(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    // Normalize vector (convert to unit vector)
    public Vector normalize() {
        double len = length();
        if (len == 0) throw new ArithmeticException("Cannot normalize zero vector");
        return new Vector(x / len, y / len, z / len);
    }

    // Getters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    // Convert vector to string
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    // Testing and output
    public static void main(String[] args) {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);

        System.out.println("=== VECTOR OPERATIONS ===");
        System.out.println("Vector 1: " + v1);
        System.out.println("Vector 2: " + v2);

        System.out.println("\nLength of v1: " + v1.length());
        System.out.println("Length of v2: " + v2.length());

        System.out.println("\nDot product v1 · v2: " + v1.scalarProduct(v2));
        System.out.println("Cross product v1 × v2: " + v1.vectorProduct(v2));

        System.out.println("\nVector addition v1 + v2: " + v1.add(v2));
        System.out.println("Vector subtraction v1 - v2: " + v1.subtract(v2));

        System.out.println("\nCosine of angle between v1 and v2: " + v1.cos(v2));

        System.out.println("\nNormalized v1: " + v1.normalize());
        System.out.println("Normalized v2: " + v2.normalize());

        System.out.println("\n=== END OF PROGRAM ===");
    }
}
