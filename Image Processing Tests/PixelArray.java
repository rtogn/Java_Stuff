import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
//import javax.swing.JFrame;

class PixelArray {
	private BufferedImage image; //mainly used to pass into a Color object to produce color values
	private int width;
	private int height;

	public PixelArray (String fileDir) {
	//constructor takes some of the nonsense out of importing a file. Just create the PixelArray Object with the files name/path string
      try { 
			File input = new File(fileDir);
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	} //end constructor
	
	public int getWidth() {
		return width;
	}
	
	public int getheight() {
		return height;
	}
   
   public int getTotalPixels() {
      return width*height;
   }
   
   public String getDimensions() {
   //String of image dimensions in sandard WxH format. Eg. 1920x1080
      return ( width + "x" + height );
   }
	
	public int[] getSinglePixelArray(int x, int y) {
		/*Returns RGB array using the Color class methods.
      ImageIo.getRGB() returns a binary value so it has to be passed into a color object to easily make sense of it*/
		Color colorProcessor = new Color(image.getRGB(x, y));	
		int[] RGBArray = new int[] {colorProcessor.getRed(), colorProcessor.getGreen(), colorProcessor.getBlue()};
		return RGBArray;
	} //end getSinglePixelArray
   
   public String pixelToString(String h) {
   //returns pixelToString Help when method is called with "-help" as the only argument.
   //Just playing around with method overloading 
      String pixelToStringHelpText = "********************************************************************************************"
                            + "\npixelToString() returns a string listing the RGB integer values at a pixel of a given x,y coordinant."
                            + "\nIt is called with the following syntax: pixelToString(x_value, y_value, optional_modifier)"
                            + "\nJust providing integers for X & Y will produce: R:215,G:215,B:217"
                            + "\nAdding the modifier string \"-verbose\" will produce: RGB values at X152,Y235: [Red:215][Green:215][Blue:217]"
                            + "\nAdding the modifier string \"-simple\" will produce a string with just the values separated by commas:  215,215,217"
                            + "\n********************************************************************************************";
      if ( h.toLowerCase() == "-help" || h.toLowerCase() == "-h")
         return pixelToStringHelpText;
      return pixelToString(0, 0, "-verbose"); //if its garbage text run a toString at 0,0
	}//end pixelToSTring -help method
 
	public String pixelToString(int x, int y) {
   //Passes to overloaded method below
      return pixelToString(x, y, "");
	}
   
   public String pixelToString(int x, int y, String mod) { 
   /* Method to return values at particular x,y coordinate of an image file.
   *Overload with "-simple" to produce just comma separated numbers, else the verbose version prints
   *Load "-verbose" to include a full string with clear markers
   *Anything else, or no string produces a regular string with R, G, B marks
   *It made sense at the time, but really should replace the array stuff with getColor() calls
   */  
      int[] RGBArray = this.getSinglePixelArray(x, y); 
      
      if (mod == "-simple"){
         return ( RGBArray[0] + "," + RGBArray[1] + "," + RGBArray[2] );
      } 
      else if (mod == "-verbose"){
		   return ( "RGB values at X" + x + ",Y" + y + ": [Red:" 
            + RGBArray[0] + "][Green:" 
            + RGBArray[1] + "][Blue:" 
            + RGBArray[2] + "]" );
      }
      return ( "[R:" + RGBArray[0] + "][G:" + RGBArray[1] + "][B:" + RGBArray[2] + "]" );
	} //end pixelToString
   
   public String toString() {
   //a useless method to run through and print each pixel in an image
   //Not implemented
   return super.toString();
   }
   
   public int[] getRGBAverageArray() {
	  
      long redCount = 0, greenCount = 0, blueCount = 0; //used long because if this was a 4000x4000 image it would reach over 2,147,483,647. Probably not really needed.
      //NB: images are indexed from 0
      for (int h = 0; h < height; h++) {
         for (int w = 0; w < width; w++) {
            Color colorProcessor = new Color(image.getRGB(w, h)); //the garbage collector will delete these efficiently right?...
            redCount +=  colorProcessor.getRed();
            greenCount += colorProcessor.getGreen();
            blueCount += colorProcessor.getBlue();
         }
      }
      int redAverage = (int)(redCount/this.getTotalPixels());
      int greenAverage = (int)(greenCount/this.getTotalPixels());
      int blueAvereage = (int)(blueCount/this.getTotalPixels());
      int[] RGBAverageArray = {redAverage, greenAverage, blueAvereage};
      return RGBAverageArray;
   }
   
   public int[][] createImageArray() {
	   //returns a giant array containing pixel data that can be manipulated by the user
	   int[][] imageArray = new int[getTotalPixels()][3];
	   for (int h = 0; h < height; h++) {
		   for (int w = 0; w < width; w++) {
			   imageArray[(w*h)] = getSinglePixelArray;
			}
		}
   
}


