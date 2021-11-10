import java.util.Random;
class DeathRoll {
   public static void main (String[] args) {

         
         //******Adjust these params:*********
         int gameCount = 25;  //nuber of games to run
         int P1StartGold = 500; //starting gold
         //**********************************
         simulate(gameCount, P1StartGold, new ConservativeRoller());    
//          RollMethod q = new ConservativeRoller();
//          System.out.println( q.getBet(100) );
   }
   
   public static int deathRoll(int bet) {
      Random dice = new Random();
      int currentRoll = bet * 10; //eg bet of 10 -> roll from 100
      boolean isPlayer1 = true;
       
      while (currentRoll > 1) {
         String curPlayer = isPlayer1 ? "Player 1":"Player 2";
         currentRoll = dice.nextInt(currentRoll-1) +1;
         //System.out.println(curPlayer + " rolls a " + currentRoll);
         isPlayer1 = !isPlayer1;
      }
      int retPlayer = isPlayer1 ? 1:0;
      return retPlayer;
   }
     
   public static void simulate (int gameCount, int P1StartGold, RollMethod method) {
      int bet, tempCount;
      int P1WinCount = 0;
      int Initial_Cash = P1StartGold;

      for(int i = 0; i < gameCount; i++) {
            bet = method.getBet( Initial_Cash, P1StartGold);
            System.out.print("Starting game using bet of " + bet);
            if ( bet == 0 ) {
               System.out.println("; Player 1 went broke!");
               break;
            }
            tempCount = deathRoll(bet);
            P1WinCount += tempCount;
            String message;
            
            if (tempCount > 0) { 
               P1StartGold += bet *2;
               message = "; Player1 won " + bet + " gold";
            } else {
               P1StartGold -= bet;
               message = "; Player1 lost " + bet + " gold";
            } 
            System.out.print(message + "\n");
      }
      System.out.println( "P1 won " + P1WinCount + " of " + gameCount + " games" );
      double percent = (double)P1WinCount/gameCount;
      System.out.println( "P1 Win Percantage using lowRolls is: " + percent*100);
      System.out.println( "Remaining gold: " + P1StartGold );
   }
   
//    public static int betLow(int currentCash) {
//       Random d20 = new Random();
//       int roll = d20.nextInt(19);
//       
//       if (roll > 15) return (d20.nextInt(99)+(currentCash+1)/3); //bet anywhere between 100 and half of remaining cash
//       else return (d20.nextInt(9)+ 11); //else bet 10-20 
//    }
//    public static int highRoller(int currentCash) {
//       Random d20 = new Random();
//       int roll = d20.nextInt(19);
//       
//       if (roll < 15) return (d20.nextInt(currentCash/3)+1); //bet anywhere between 100 and half of remaining cash
//       else return (d20.nextInt(9)+ 11); //else bet 10-20 
//   }   
}

abstract class RollMethod {
   Random dice;
   
   public RollMethod() {
      dice = new Random();
   }
   
   abstract int getBet(int Initial_Cash, int currentCash);
}


class ConservativeRoller extends RollMethod {
   public ConservativeRoller() {
      super();
   }
   
   public int getBet( int Initial_Cash, int currentCash ) {
      if (currentCash <= Initial_Cash/4 ) return 0; //never dip below 1/2 gold
      return  currentCash/4; 
   }
}