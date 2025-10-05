package ua.opnu.java.inheritance.point;

public class Point3D extends Point {
    private int z;

    public Point3D() {
        super(0, 0);
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(Point3D p) {
        super(p.getX(), p.getY());
        this.z = p.getZ();
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public int getZ() {
        return z;
    }
    
    public double distance(Point3D p) {
        int dx = this.getX() - p.getX();
        int dy = this.getY() - p.getY();
        int dz = this.z - p.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceFromOrigin() {
        return Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY() + this.z * this.z);
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")";
    }
}