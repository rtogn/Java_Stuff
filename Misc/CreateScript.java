import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;

class CreateScript {
   public static void main(String[] args) {
   
      LinkedList<String> cmdQueue = new LinkedList<String>();
      
      try{
         FileWriter write = new FileWriter("Test.py");
         cmdQueue.add("import pyautogui\n");
         cmdQueue.add("import time, signal, sys\n");
        // cmdQueue.add("while True:\n");
         //cmdQueue.add("\tprint(\"cat\")\n");
         
         while ( !cmdQueue.isEmpty() ) {
            write.write( cmdQueue.remove() );
         }
         write.write( repeat(3, repeatQueue()) );
         write.close();
         
      } catch(IOException e) {
         e.printStackTrace();
      }
      
      AutoCommand basicC = new AutoCommand("rightClick");
      KeyCommand keyC = new KeyCommand("keyDown", "w");
      System.out.print(basicC.toString());
      System.out.print(keyC.toString());
   }
   public static LinkedList repeatQueue(){
   //temporary stand in for sub queue.
      LinkedList<String> toRepeat = new LinkedList<String>();
      toRepeat.add("print(\"cat\")");
      toRepeat.add("print(\"dog\")");      
      return toRepeat;
   }
   
   public static String repeat(int reps, LinkedList<String> internalCmd) {
      String repeatCmd = "for i in range(0, " + reps + "):\n";
      while (!internalCmd.isEmpty()) {
         repeatCmd += ("\t" + (String)internalCmd.remove() + "\n");
      }
      return repeatCmd;
   }
}

class Command {
    private String command;
    public Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    
    public String toString() {
        return command + "()\n";
    }    
}

class AutoCommand extends Command{
    //Command with no arguments from the autoGUI class
    private static final String AUTO = "auto.";
    public AutoCommand(String command) {
        super(AUTO + command);
    }

    @Override
    public void setCommand(String command) {
        super.setCommand(AUTO + command);
    }
}

class AutoKeyCommand extends AutoCommand {
    //autoGUI command with key argument
    private String key;

    public AutoKeyCommand (String command, String key) {
        super(command);
        this.key = "\"" + key + "\"";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public String toString() {
        //command :  "auto.keyDown(+ key + ")\n"
        return super.getCommand() + "(" + key + ")\n";
    }
}


class RepeatCommand {
    LinkedList<Command> toRepeatQueue;
    int reps;
    String repeatCmd;
    
    public RepeatCommand(int reps) {
        toRepeatQueue = new LinkedList<Command>();
        this.reps = reps;
        this.repeatCmd = "for i in range(0, " + reps + "):\n";
    }
    
    public RepeatCommand() {
        toRepeatQueue = new LinkedList<Command>();
        this.repeatCmd = "while True:\n";
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
    
    public void enqueue(Command command) {
        toRepeatQueue.add(command);
    }
    
    public Command dequeue() {
        return toRepeatQueue.remove();
    }
    
    public String toString() {
       while (!toRepeatQueue.isEmpty()) {
         repeatCmd += ("\t" + (String)toRepeatQueue.remove().toString() + "\n");
        } 
       
       return repeatCmd;
    }
}

