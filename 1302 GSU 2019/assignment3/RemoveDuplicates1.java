import java.util.*;
import java.util.Collections;
class RemoveDuplicates1{
   public static void main(String[] args){
     
     ArrayList<Integer> a = new ArrayList<Integer>( Arrays.asList(4, 7, 11, 4, 9, 5, 11, 7, 3, 5, 4) );
     ArrayList<Integer> b = new ArrayList<Integer>( Arrays.asList(4, 7, 11, 4, 9, 5, 11, 7, 3, 5, 4) );     
     
     removeDupes(a);
     System.out.println("output from algorithm from question 3");
	  for (int i :  a)
		System.out.print(i + ", ");
    
     removeDupesSorted(b);
     System.out.println("\noutput from algorithm from question 4");
	  for (int i :  b)
      System.out.print(i + ", ");      

	  
   }

   public static void removeDupes(ArrayList<Integer> a){
   		
		removeDupes(a, 0);
   }
  
   public static void removeDupes(ArrayList<Integer> a, int j){
      
      if (j <= a.size()-1){          
            
            int count = 0;             
      		for (int i = 0; i <= a.size()-1; i++){
      			if ( a.get(j) == a.get(i) && j != i )
                  a.remove(i);
      				//count++;
      		}
      	//	if (count > 1)
      	//		a.remove(j--);		
            
            removeDupes(a, ++j);
         }
   }

   public static void removeDupesSorted(ArrayList<Integer> a){
     
      Collections.sort(a);  //sort array before passing to rest of algorithm
      removeDupesSorted(a, 0);
   }
   
   public static void removeDupesSorted(ArrayList<Integer> a, int j){
      
      if ( j <= a.size()-2 ){
         if ( a.get(j) == a.get(j+1) )
            a.remove(j--); //move j cursor back so cases of 3+ duplicates covered
         removeDupesSorted(a, ++j);
      }
   }
}