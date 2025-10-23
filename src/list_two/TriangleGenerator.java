public class TriangleGenerator {
    public void createRightTriangle(int base) {
        String triangle = "";

        for(int i = 0; i < base; i++) {
            triangle += "*";
            System.out.println(triangle);
        }
    }

    public void createEquilateralTriangle(int base) {

    }

    public static void main(String[] args) {
        TriangleGenerator resolution = new TriangleGenerator();

        resolution.createRightTriangle(4);
    } 
}