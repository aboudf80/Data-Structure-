/**
 * Module: Point
 * Programmers: Ahmad Aboud, Nizar Jarayse
 * Purpose: Represents a point using two real-valued coordinates.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Creates a point with the given coordinates.
     * Parameters: x, y - coordinates of the new point.
     * Returns: A new Point object (constructor).
     * Complexity: O(1).
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates an independent copy of another point.
     * Parameter: p - point to copy; null creates a point at (0, 0).
     * Returns: A new Point object (constructor).
     * Complexity: O(1).
     */
    public Point(Point p) {
        // Use (0, 0) when no source point is supplied.
        if (p == null) {
            this.x = 0;
            this.y = 0;
        } else {
            this.x = p.x;
            this.y = p.y;
        }
    }

    /**
     * Gets the x coordinate.
     * Parameters: None. Returns: x coordinate.
     * Complexity: O(1).
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets the y coordinate.
     * Parameters: None. Returns: y coordinate.
     * Complexity: O(1).
     */
    public double getY() {
        return this.y;
    }

    /**
     * Updates the x coordinate.
     * Parameter: x - new x coordinate. Returns: Nothing.
     * Complexity: O(1).
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Updates the y coordinate.
     * Parameter: y - new y coordinate. Returns: Nothing.
     * Complexity: O(1).
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Describes the point as (x , y).
     * Parameters: None. Returns: String representation of the point.
     * Complexity: O(1).
     */
    public String toString() {
        return "(" + this.x + " , " + this.y + ")";
    }

    /**
     * Calculates the distance between this point and another point.
     * Parameter: p - other point; may be null.
     * Returns: Distance between the points, or -1 for null input.
     * Complexity: O(1).
     */
    public double distance(Point p) {
        // A distance cannot be negative, so -1 marks invalid input.
        if (p == null)
            return -1;

        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Compares two points by their x and y coordinates.
     * Parameter: p - point to compare (can be null).
     * Returns: true if both coordinates are equal; otherwise false.
     * Complexity: O(1).
     */
    public boolean equals(Point p) {
        if (p == null)
            return false;

        if (this.x == p.x && this.y == p.y)
            return true;
        return false;
    }
}
