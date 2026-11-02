/**
 * Module: Test_Array_of_Points
 * Programmers: Ahmad Aboud, Nizar Jarayse
 * Purpose: Tests the Point and Array_of_Points classes, including edge cases.
 */
public class Test_Array_of_Points {

    /**
     * Checks whether an array contains a point with matching coordinates.
     * Parameters: arrP - array to search; p - point to find.
     * Returns: true if found; false otherwise. Complexity: O(n).
     */
    public static boolean isHere(Array_of_Points arrP, Point p) {
        if (arrP == null || p == null)
            return false;
        for (int i = 0; i < arrP.getQuantity(); i++) {
            if (arrP.getArr()[i].equals(p))
                return true;
        }
        return false;
    }

    
    public static void main(String[] args) {

        // Initialization, getters, insertion and display
        Array_of_Points a = new Array_of_Points();
        boolean basic = a.getMax() == 10 && a.getQuantity() == 0 && a.getArr().length == 10;
        boolean added = a.addPoint(new Point(1, 2));
        added = a.addPoint(new Point(3, 4)) && added;
        added = a.addPoint(new Point(5, 6)) && added;
        basic = basic && added && !a.addPoint(null) && a.getQuantity() == 3
                && a.toString().equals("[ (1.0 , 2.0), (3.0 , 4.0), (5.0 , 6.0) ]");

        // Copy constructor and independent objects
        Array_of_Points b = new Array_of_Points(a);
        a.getArr()[0].setX(100);
        boolean copy = b.getQuantity() == 3 && b.getArr()[0].getX() == 1;

        // Search and removal, including invalid inputs
        boolean search = isHere(a, new Point(3, 4)) && !isHere(a, new Point(9, 9));
        a.removePoint(1);
        a.removePoint(-1);
        a.removePoint(20);
        a.searchAndRemovePoint(new Point(5, 6));
        a.searchAndRemovePoint(new Point(9, 9));
        a.searchAndRemovePoint(null);
        search = search && a.getQuantity() == 1 && isHere(a, new Point(100, 2))
                && !isHere(a, new Point(5, 6)) && !isHere(a, null)
                && !isHere(null, new Point(1, 2));

        // Full array and removing the first and last positions
        for (int i = a.getQuantity(); i < a.getMax(); i++)
            a.addPoint(new Point(i, i + 1));
        boolean capacity = a.getQuantity() == 10 && !a.addPoint(new Point(50, 60));
        a.removePoint(0);
        capacity = capacity && a.getQuantity() == 9 && a.getArr()[9] == null
                && !isHere(a, new Point(100, 2)) && a.addPoint(new Point(50, 60));
        a.removePoint(a.getQuantity() - 1);
        capacity = capacity && a.getQuantity() == 9 && a.getArr()[9] == null;

        // Empty arrays, null copying and duplicate points
        Array_of_Points empty = new Array_of_Points();
        empty.removePoint(0);
        empty.searchAndRemovePoint(new Point(1, 2));
        Array_of_Points duplicate = new Array_of_Points();
        duplicate.addPoint(new Point(2, 2));
        duplicate.addPoint(new Point(2, 2));
        duplicate.searchAndRemovePoint(new Point(2, 2));
        boolean edges = empty.getQuantity() == 0 && !isHere(empty, new Point(1, 2))
                && new Array_of_Points(empty).getQuantity() == 0
                && new Array_of_Points(null).getQuantity() == 0
                && duplicate.getQuantity() == 1 && isHere(duplicate, new Point(2, 2));

        // Point constructors, getters, setters, equality and distance
        Point p = new Point(0, 0), q = new Point(3, 4), r = new Point(q);
        p.setX(1);
        p.setY(1);
        q.setX(4);
        boolean point = p.getX() == 1 && p.getY() == 1
                && p.toString().equals("(1.0 , 1.0)")
                && r.equals(new Point(3, 4)) && !r.equals(q) && !p.equals(null)
                && new Point(0, 0).distance(r) == 5 && p.distance(null) == -1
                && new Point((Point) null).equals(new Point(0, 0));

        System.out.println("Initialization, add, getters, display: " + basic);
        System.out.println("Copy constructor: " + copy);
        System.out.println("isHere and removal: " + search);
        System.out.println("Capacity and indexes: " + capacity);
        System.out.println("Empty, null and duplicates: " + edges);
        System.out.println("Point methods: " + point);
    }
}
