import java.util.Scanner;

public class Polygon {
    private Point[] points;

    private Polygon(int numVert) {
        points = new Point[numVert];
    }

    private Polygon(float[] coords) {
        this(coords.length / 2);

        for (int i = 0; i < coords.length; i+= 2) {
            points[i / 2] = new Point(coords[i], coords[i + 1]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numVert = in.nextInt();
        float[] pts = new float[2 * numVert];

        for (int i = 0; i < numVert; ++i) {
            pts[2 * i] = in.nextFloat();
            pts[2 * i + 1] = in.nextFloat();
        }

        Polygon polyg = new Polygon(pts);

        for (Point p : polyg.points) {
            System.out.println(p.toString());
        }
    }
}
