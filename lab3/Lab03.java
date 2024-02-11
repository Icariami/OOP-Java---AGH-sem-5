public class Lab03 {

    /**
     * Checks functionality of the Vector class
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Wykorzystanie konstruktorów (1 pkt + za toString: 1 pkt):");
        Vector v1 = new Vector(2.4, -3.5, 1.9);
        Vector v2 = new Vector(-4.7, 1.8, 3.7);
        System.out.println(v1); // [2.4, -3.5, 1.9]
        System.out.println(v2); // [-4.7, 1.8, 3.7]
        System.out.println(new Vector()); // [0.0, 0.0, 0.0]
        System.out.println(new Vector(-34.7)); // [-34.7, 0.0, 0.0]
        System.out.println(new Vector(-56.8, 2.2)); // [-56.8, 2.2, 0.0]
        System.out.println();

        System.out.println("Stałe typu Vector (1.5 pkt. za wszystkie pola klasy):");
        System.out.println(Vector.ZERO); // [0.0, 0.0, 0.0]
        System.out.println(Vector.VERSOR_X); // [1.0, 0.0, 0.0]
        System.out.println(Vector.VERSOR_Y); // [0.0, 1.0, 0.0]
        System.out.println(Vector.VERSOR_Z); // [0.0, 0.0, 1.0]
        System.out.println();

        System.out.println("Wykorzystanie metod-akcesorów, zwracających wynik obliczeń.");
        System.out.println("- Metody typu get (0.25 pkt):");
        System.out.println("v1.getX() = " + v1.getX()); // v1.getX() = 2.4
        System.out.println("v1.getY() = " + v1.getY()); // v1.getY() = -3.5
        System.out.println("v1.getZ() = " + v1.getZ()); // v1.getZ() = 1.9
        System.out.println("- Metody typu get (1 pkt):");
        System.out.println("v1 + v2 = " + v1.add(v2)); // v1 + v2 = [-2.3000000000000003, -1.7, 5.6]
        System.out.println("v1 - v2 = " + v1.subtract(v2)); // v1 - v2 = [7.1, -5.3, -1.8000000000000003]
        System.out.println("34.8 * v1 = " + v1.multiply(34.8)); // 34.8 * v1 = [83.52, -121.79999999999998, 66.11999999999999]
        System.out.println("|v1| = " + v1.length()); // |v1| = 4.649731175025067
        System.out.println("- Metody statyczne (1.5 pkt.):");
        System.out.println("v1 * v2 = " + Vector.dotProduct(v1, v2)); // v1 * v2 = -10.549999999999997
        System.out.println("v1 x v2 = " + Vector.crossProduct(v1, v2)); // v1 x v2 = [-16.37, -17.810000000000002, -12.129999999999999]
        Vector v3 = Vector.vectorOf(12.0, 13.0, 14.0); // Metoda vectorOf zwraca obiekt Vector o współrzędnych podanych jako argumenty.
        System.out.println(v3); // [12.0, 13.0, 14.0]
        System.out.println();

        System.out.println(" Wykorzystanie metod-mutatorów (ustawiają wartości pól, niczego nie zwracają).");
        System.out.println("- Metody: normalizująca i zamieniająca wektor na przeciwny (0.5 pkt.):");
        v1.normalize();
        System.out.println(v1); // [0.5161588723432083, -0.7527316888338456, 0.4086257739383733]
        v2.opposite();
        System.out.println(v2); // [4.7, -1.8, -3.7]
        System.out.println("- Metody typu set (0.25 pkt.):");
        v1.setX(12);
        v1.setY(13);
        v1.setZ(14);
        System.out.println(v1); // [12.0, 13.0, 14.0]
        System.out.println();

        System.out.println("Metoda equals + hashCode (1 pkt):");
        System.out.println("v1.equals(v1) = " + v1.equals(v1)); // v1.equals(v1) = true
        System.out.println("v1.equals(null) = " + v1.equals(null)); // v1.equals(null) = false
        System.out.println("v1.equals(\"błędny obiekt\") = " + v1.equals("błędny obiekt")); // v1.equals("błędny obiekt") = false
        System.out.println("v1.equals(v2) = " + v1.equals(v2)); // v1.equals(v2) = false
        System.out.println("v1.equals(v3) = " + v1.equals(v3)); // v1.equals(v3) = true
        v1.setY(Double.NaN);
        v3.setY(Double.NaN);
        System.out.println("NaN: v1.equals(v3) = " + v1.equals(v3)); // NaN: v1.equals(v3) = true
        System.out.println();


        // Druga czesc zadania
        Vector a = new Vector(1,2,5);
        Vector b = new Vector(-1,-2,16);
        Vector c = new Vector(4.5,7,1);

        Vector bxc = Vector.crossProduct(b,c);
        double abxc = Vector.dotProduct(a, bxc);
        Vector aa = a.multiply(abxc);

        Vector axc = Vector.crossProduct(a,c);
        double baxc = Vector.dotProduct(b, axc);
        Vector bb = b.multiply(baxc);
        Vector bbx = bb.add(Vector.VERSOR_X);

        Vector subs = aa.subtract(bbx);
        subs.opposite();
        Vector last = subs.subtract(Vector.VERSOR_Y);

        double len = last.length();
        System.out.println("Length = " + len);
    }
}
