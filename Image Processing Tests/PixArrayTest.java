class PixArrayTest {
   public static void main(String[] args) {
      PixelArray abc = new PixelArray("abc.jpg");
      System.out.println( abc.getDimensions() );
     // System.out.println( abc.pixelToString(0, 0, "-simple") );
     int[] x = abc.getRGBAverageArray();
     System.out.println("R" + x[0] + " G " + x[1] + " B " + x[2] );  
     int[][] gg = new int[3][2];   
     gg[0] = (1,2);
   }
}