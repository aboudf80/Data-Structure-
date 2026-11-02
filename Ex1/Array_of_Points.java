/**
 * Module: Array_of_Points
 * Programmers: Ahmad Aboud, Nizar Jarayse
 * Purpose: Stores up to 10 points and supports adding, removing, and copying them.
 */
public class Array_of_Points {
    private Point[] arr;
    final private int max = 10;
    private int quantity;

    /**
     * Creates an empty array of points with the maximum capacity.
     * Parameters: None. Returns: A new Array_of_Points object (constructor).
     * Complexity: O(1).
     */
    public Array_of_Points() {
        this.quantity = 0;
        this.arr = new Point[max];
    }

    /**
     * Creates an independent copy of another point array.
     * Parameter: other - array to copy; null creates an empty array.
     * Returns: A new Array_of_Points object (constructor).
     * Complexity: O(n), where n is the number of stored points.
     */
    public Array_of_Points(Array_of_Points other) {
        this.arr = new Point[max];
        this.quantity = 0;

        // Copy points only when a valid source array is supplied.
        if (other != null) {
            this.quantity = other.quantity;
            for (int i = 0; i < this.quantity; i++) {
                this.arr[i] = new Point(other.arr[i]);
            }
        }
    }

    /**
     * Adds a copy of a point to the first free position.
     * Parameter: other - point to add (must not be null).
     * Returns: true if added; false if null or the array is full.
     * Complexity: O(1).
     */
    public boolean addPoint(Point other) {
        // Reject invalid input and attempts to exceed capacity.
        if (other == null || this.quantity >= max)
            return false;
        else {
            this.arr[this.quantity] = new Point(other);
            this.quantity++;
            return true;
        }
    }

    /**
     * Describes all stored points using their x and y coordinates.
     * Parameters: None. Returns: String containing the points.
     * Complexity: O(n^2) in general due to String concatenation.
     */
    public String toString() {
        String info = "[ ";

        // Add each occupied point, with commas between points.
        for (int i = 0; i < this.quantity; i++) {
            double x = this.arr[i].getX();
            double y = this.arr[i].getY();
            info += "(" + x + " , " + y + ")";

            if (i < this.quantity - 1) {
                info += ", ";
            }
        }

        info += " ]";
        return info;
    }

    /**
     * Gets the underlying point array.
     * Parameters: None. Returns: Reference to the internal array.
     * Complexity: O(1). Note: the returned array can be modified.
     */
    public Point[] getArr() {
        return this.arr;
    }

    /**
     * Gets the maximum capacity of the array.
     * Parameters: None. Returns: Maximum number of points.
     * Complexity: O(1).
     */
    public int getMax() {
        return this.max;
    }

    /**
     * Gets the number of stored points.
     * Parameters: None. Returns: Current number of points.
     * Complexity: O(1).
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Removes the point at an occupied index and closes the gap.
     * Parameter: n - index to remove; invalid indices are ignored.
     * Returns: Nothing.
     * Complexity: O(n) in the worst case.
     */
    public void removePoint(int n) {
        if (n >= 0 && n < this.quantity) {
            // Shift points left without reading beyond the array boundary.
            for (int i = n; i < this.quantity - 1; i++) {
                this.arr[i] = this.arr[i + 1];
            }
            this.arr[this.quantity - 1] = null;
            this.quantity--;
        }
    }

    /**
     * Searches for and removes the first point with matching coordinates.
     * Parameter: p - point to find; null or a missing point is ignored.
     * Returns: Nothing.
     * Complexity: O(n) in the worst case.
     */
    public void searchAndRemovePoint(Point p) {
        if (p == null)
            return;

        // Stop after removing the first matching point.
        for (int i = 0; i < this.quantity; i++) {
            if (this.arr[i].equals(p)) {
                removePoint(i);
                return;
            }
        }
    }
}
