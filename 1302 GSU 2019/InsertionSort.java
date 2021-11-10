
public class InsertionSort {
  public static void sort(int[] list) {
      int j;
      for (int i = 1; i <= list.length-1; i++){
         j = i;
         while ( j > 0 && list[j-1] > list[j] ){
            int temp = list[j];
            list[j] = list[j-1];
            list[j-1] = temp;
            j = j-1; 
                     for (int q = 0; q < list.length; q++)
            System.out.print(list[q] + " ");
            System.out.println();
         }
         
      }  
  }
 

  public static void main(String[] args) {
    int[] list = {20,15,12, 5,9};
    sort(list);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }
}