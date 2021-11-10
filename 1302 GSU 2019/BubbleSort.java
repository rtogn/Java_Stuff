public class BubbleSort {
  public static void sort(int[] list) {
    int low=0;
    int high=list.length-1;
    for( int pass=1; pass<=high;pass++)
    {
    System.out.println("Pass: " + pass);
      //Move the largest element towards the end of list
      for (int i = low; i <=high-pass; i++)
      {
        if (list[i] > list[i+1])
        {
          //Swap the elements
          int temp=list[i];
          list[i]=list[i+1];
          list[i+1]=temp;
          
          for (int x : list)
            System.out.print(x + " ");
          System.out.println();
          
         }
       }
      }
  }

  public static void main(String[] args) {
    int[] list = {15, 8, 30, 16, 10};
    sort(list);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }
}