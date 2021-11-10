import java.util.*;
class Question{
   private String answer;
   private String question;
   
   Question(){
      question = "";
      answer = "";
   }
   
   Question(String q){
      question = q;
   }
   
   Question(String q, String a){
      question = q;
      answer = a;
   }   
   void setQuestion(String q){
      question = q;
   }
   String getQuestion(){
      return question;
   }
   void setAnswer(String a){
      answer = a;
   }
   String getAnswer(){
      return answer;
   }
   boolean checkAnswer(String r){
      return answer.equals(r);
   }
}
class choiceQuestion extends Question{

   private ArrayList<String> choices = new ArrayList<String>();
   
   choiceQuestion(String q){
      setQuestion(q);         
   }

   void setOption(String choice, boolean correct){
      choices.add(choice);
      if (correct == true){
         String choiceString = "" + choices.size();
         setAnswer(choiceString);
      }   
   }

    String getQuestion(){
       
      System.out.println(super.getQuestion());
      for (int i = 0; i < choices.size(); i++){
         int choiceNumber = i + 1;
         System.out.println(choiceNumber+": "+choices.get(i));
      }
      String a = "Your answer? ";
      return a;
   }
}

class FillQuestion extends Question{
	
	private char[] masked;
	private String maskedToString = "";
   private String fillIn = "";
   
	public FillQuestion(String statement){
     super(statement);
     
     //check for start and end of answer based on '_'    
     int start = statement.indexOf('_');   
     int end = statement.indexOf('_', (start + 1));
     
     //retreive answer into temp string, set to answer using setAnswer. 
     for (int i = (start + 1); i < end; i++){
         fillIn += statement.charAt(i);
     }
     super.setAnswer(fillIn);
     
     
     //create a masked version of the given question where the answer is covered by ________	  
	  masked = statement.toCharArray();
	  for (int i = 1; i <= super.getAnswer().length(); i++){
		  masked[start + i] = '_';
	  }
	  //make masked back into a regular string	  
	  for(char c : masked){
		  maskedToString += c;
	  }
	}
    
	
	String getQuestion(){
		return maskedToString;
	}	
	
	boolean checkAnswer(String r){
		return super.getAnswer().equalsIgnoreCase(r);
	}
}

class QuestionTest{
   public static void main(String [] args){
      Scanner input = new Scanner(System.in);
      Question q1 = new FillQuestion("_Thomas Edison_ is the inventor of the lightbulb");
      System.out.println(q1.getQuestion());
      String response = input.nextLine();
      System.out.println(q1.checkAnswer(response));
      
      Question q2 = new FillQuestion("The color of a _stop sign_ is red");
      System.out.println(q2.getQuestion());
      response = input.nextLine();
      System.out.println(q2.checkAnswer(response));
   }
}
   
   
