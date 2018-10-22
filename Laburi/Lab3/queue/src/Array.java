public class Array {
    private int[] actualArray;

    public Array() {
        this(10);
    }

    Array(final int n) {
        actualArray = new int[n];
    }

    final int get(final int pos) throws Exception {
        if (pos < 0 || pos >= actualArray.length) {
            throw new Exception("dutu sef");
        }

        return actualArray[pos];
    }

    final int set(final int pos, final int val) throws Exception {

        if (pos < 0 || pos >= actualArray.length) {
            throw new Exception("dutu boss");
        }

        actualArray[pos] = val;

        return 0;
    }

    public String toString() {
        StringBuilder s = new StringBuilder("[");

        for (int i = 0; i < actualArray.length; i++) {
            s.append(actualArray[i]).append(" ");
        }

        return s + "]";
    }

    public static void main(final String[] args) {
        Array array = new Array(10);

        //*********** EXEMPLE DE ADAUGARE ******************

        // adaugare corecta
        try {
            array.set(4, 99);
            System.out.println(array);
        } catch(Exception e) {
            System.out.println("Error adding value" + e);
        }

        // adaugare incorecta
        try {
            array.set(11, 99);
            System.out.println(array);
        } catch (Exception e) {
            System.out.println("Error adding value" + e);
        }

        //*********** EXEMPLE DE OBTINERE ******************

        // obtinere corecta
        try {
            int val = array.get(4);
            System.out.println(val);
        } catch (Exception e){
            System.out.println("Error retrieving value" + e);
        }

        // obtinere incorecta
        try {
            int val = array.get(11);
            System.out.println(val);
        } catch (Exception e){
            System.out.println("Error retrieving value" + e);
        }
    }
}