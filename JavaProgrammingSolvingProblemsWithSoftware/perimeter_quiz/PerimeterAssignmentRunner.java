import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int totalPoints = 0;
        for (Point curntPoint : s.getPoints()){
            totalPoints ++;
        }
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        
        double totalLength = getPerimeter(s);
        int numberOfPoints= getNumPoints(s);
        double averageLength = totalLength/numberOfPoints;
       
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = Double.MIN_VALUE;
        Point prevPoint = s.getLastPoint();
        
        for (Point currPoint : s.getPoints()){
            double currDist = currPoint.distance(prevPoint);
            largestSide = largestSide >= currDist ? largestSide : currDist;
            prevPoint = currPoint;
        }
        
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = Double.MIN_VALUE;
        
        for (Point currPoint : s.getPoints()) {
            double currX = currPoint.getX();
            largestX = largestX >= currX ? largestX: currX;
            
        }
        return largestX ;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = Double.MIN_VALUE;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()){
            
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            
            largestPerimeter = largestPerimeter >= currPerimeter ? largestPerimeter : currPerimeter;
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double largestPerimeter = Double.MIN_VALUE;
        DirectoryResource dr = new DirectoryResource();
        File temp = null;    // replace this code
        for (File f : dr.selectedFiles()){
            
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            
            if (largestPerimeter < currPerimeter){
                temp = f;
                largestPerimeter = currPerimeter;
            }
           
        }
        
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("num of points = " + getNumPoints(s));
        System.out.println("average length = " + getAverageLength(s));
        System.out.println("longest side = " + getLargestSide(s));
        System.out.println("largest x = " + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double length = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter inmultiple files = " + length);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File with Largest Perimeter is  = " + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        System.out.println("Assignment 1: Calculating information about shapes");
        System.out.println("==================================================");
        pr.testPerimeter();
        
        System.out.println("\n\nAssignment 2: Processing multiple Shape files");
        System.out.println("=============================================");
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
