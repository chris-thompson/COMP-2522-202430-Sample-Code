package geometry;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * GeometryDriver.
 *
 * @author BCIT
 * @version 2024
 */
public final class GeometryDriver {

    private GeometryDriver() {
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat format = new DecimalFormat("#.###");

        System.out.println("Enter the radius of a sphere:");
        double radius = scan.nextDouble();
        System.out.println("Enter the AnotherExceptionQuestion-coordinate of a sphere:");
        double x = scan.nextDouble();
        System.out.println("Enter the Y-coordinate of a sphere:");
        double y = scan.nextDouble();
        System.out.println("Enter the Z-coordinate of a sphere:");
        double z = scan.nextDouble();
        Sphere sphere = new Sphere(radius, x, y, z);
        System.out.println("The SA = "
                + format.format(sphere.getSurfaceArea()));
        System.out.println("The V = " + format.format(sphere.getVolume()));

        System.out.println("Enter the edge length of a cube:");
        double edgeLength = scan.nextDouble();
        System.out.println("Enter the AnotherExceptionQuestion-coordinate of a cube:");
        x = scan.nextDouble();
        System.out.println("Enter the Y-coordinate of a cube:");
        y = scan.nextDouble();
        System.out.println("Enter the Z-coordinate of a cube:");
        z = scan.nextDouble();
        Cube cube = new Cube(edgeLength, x, y, z);
        System.out.println("The SA = " + format.format(cube.getSurfaceArea()));
        System.out.println("The V = " + format.format(cube.getVolume()));
        System.out.println("The FD = " + format.format(cube.getFaceDiagonal()));
        System.out.println("The SD = "
                + format.format(cube.getSpaceDiagonal()));

        System.out.println("Enter the radius of a cone:");
        radius = scan.nextDouble();
        System.out.println("Enter the height of a cone:");
        double height = scan.nextDouble();
        Cone cone = new Cone(radius, height);
        System.out.println("The V = " + format.format(cone.getVolume()));
        System.out.println("The SA = "
                + format.format(cone.getSurfaceArea()));
        System.out.println("The SH = "
                + format.format(cone.getSlantHeight()));
    }

}
