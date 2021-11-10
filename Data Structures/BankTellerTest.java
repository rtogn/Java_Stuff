import java.io.*;

class Customer {
   //simple class that creates objects to hold arrival time and transactiontimes (passed into queue/nodes)
   private int arrivalTime;
   private int transactionTime;
     
   public Customer(int arrivalTime, int transactionTime) {
      this.arrivalTime = arrivalTime;
      this.transactionTime = transactionTime;
   }
   
   public int arrivalTime() {
      return arrivalTime;
   }
   
   public int transactionTime() {
      return transactionTime;
   }
    
   public String toString(){
      return "ArrivalTime=" + arrivalTime + ", transactionTime= " + transactionTime;
   }
}

class BankQueue {
/*MEOTHOD SUMMARY 
 void simulate1() - simulates a bank with only 1 queue
 void simulate3() - above, but using 3 queues. Each queue relies on an individual integer nextDepart to calculate when the current
                     node in queue will depart. Hence, the arrivalCheck() and deQueueCheck() return that value.
 int arrivalCheck() - Used in sim methods to process an arrival event from the cvs file
 int deQueueCheck() - used in sim methods to process departure events. 
 void depart() - Individually dequeues a node from a queue. Run in deQueueCheck() and on its own after while loop to handle leftover final Node
 */
   private String filePath;
   private EventList eventList;   
   private int currentTime, peopleCount,averageTally, maxWaited, queueSize;

   public BankQueue (String filePath) {
      this.filePath = filePath;
      eventList = new EventList();
   } //end constructor
   
   
   public void simulate1() {

      QueueLinkedList<Customer> queue = new QueueLinkedList<Customer>();
      BufferedReader b;
      int nextDepart = 0;
      try{
         //split lines of csv into individual Customers and queue up using QueueLinkedListClass
         b = new BufferedReader(new FileReader(filePath));    
         String line = "";
         String cvsSplitBy = ",";
         
         while ((line = b.readLine()) != null) {
            String[] split = line.split(cvsSplitBy);
            Customer current = new Customer(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            currentTime = current.arrivalTime(); //current time is whatever the next events time is     
            nextDepart = deQueueCheck(queue, nextDepart);            
            nextDepart = arrivalCheck(queue, current, nextDepart);         
         } 
         depart(queue, nextDepart);
         eventList.addEvent("Total number of people processed: " + peopleCount);
         eventList.addEvent("Average wait time: " + ((double)averageTally / peopleCount));
         eventList.addEvent("Maximum wait time: " + maxWaited);
         b.close();
         eventList.eventTrace();      
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); 
      }          
   }
   
   public void simulate3() {

      QueueLinkedList<Customer> queue1 = new QueueLinkedList<Customer>();
      QueueLinkedList<Customer> queue2 = new QueueLinkedList<Customer>();
      QueueLinkedList<Customer> queue3 = new QueueLinkedList<Customer>();
      int dequeue1 = 0, dequeue2 = 0, dequeue3 = 0, iCounter = 0;
      //since my prior code relied on a static departure time, had to create a dequeue for each list
      int[] deq = {dequeue1, dequeue2, dequeue3};
      QueueLinkedList[] allQueues = {queue1, queue2, queue3};
      BufferedReader b;
      try{
         //split lines of csv into individual Customers and queue up using QueueLinkedListClass
         b = new BufferedReader(new FileReader(filePath));    
         String line = "";
         String cvsSplitBy = ",";
         
         while ((line = b.readLine()) != null) {
            String[] split = line.split(cvsSplitBy);
            Customer current = new Customer(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            currentTime = current.arrivalTime(); //current time is whatever the next events time is  
            QueueLinkedList target = QueueLinkedList.minSize( QueueLinkedList.minSize(queue1, queue2), queue3);  
            System.out.println("Queues filling: [" + queue1.size() + "][" + queue2.size() + "]["  + queue3.size() + "] ");   
            for (int i = 0; i < 3; i++) {
            //process dequeue events for each queue
               deq[i] = deQueueCheck(allQueues[i], deq[i]);
               
               if (target.equals(allQueues[i])){
                  //System.out.println("Target queue: " + i);
                  iCounter = i;
               } 
            } //end for
            //process arrival check for the currnet member in line, apply it to the empty queue past from the dequeue check
            deq[iCounter] = arrivalCheck(target, current, deq[iCounter]);                                  
         } //end while
         //clear final node, since I dont necissarily know where it will end up check each queue and clear it
         for (int i = 0; i < 3; i++) {
            if(!allQueues[i].isEmpty())
               depart(allQueues[i], deq[i]);
         }             
         //depart(queue1);
         eventList.addEvent("Total number of people processed: " + peopleCount);
         eventList.addEvent("Average wait time: " + ((float)averageTally / peopleCount));
         eventList.addEvent("Maximum wait time: " + maxWaited);
         b.close();
         eventList.eventTrace(); 
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); 
      }          
   } //end simulate3      
   
   private int arrivalCheck(QueueLinkedList queue, Customer current, int nextDepart) {
   
      eventList.addEvent("Processing Arrival event at time: " + currentTime);
      if (queue.isEmpty()) {
      //if queue is empty immediately start departure for next client
         nextDepart = current.transactionTime() + currentTime;
      }   
      queue.enQueue(current);
      peopleCount++;
      return nextDepart;
   } //end arrivalCheck
   
   private int deQueueCheck(QueueLinkedList queue, int nextDepart) {
      //evaluates if current arrival time has allowed for any customers to be processed during that period and removes them
      while (!queue.isEmpty() && (currentTime > nextDepart)) {
         //System.out.println("CurrentTime, nextDepart:" + currentTime + " " + nextDepart)
         depart(queue, nextDepart);
         try {
            //next in line starts at current departure time + its transaction time  
            Customer temp = (Customer)queue.peak().data;
            nextDepart += temp.transactionTime();

            } catch(Exception e){}
                  
      } return nextDepart;
   } //end deQueueCheck

   public void depart(QueueLinkedList queue, int nextDepart) {
         Customer removed = (Customer)queue.deQueue().data;
         int timeWaited = (nextDepart - removed.arrivalTime() - removed.transactionTime());
         averageTally+= timeWaited;    
         eventList.addEvent("Processed a departure event at time: " + nextDepart + ", Time waited: " +  timeWaited);
         if (timeWaited > maxWaited)
            maxWaited = timeWaited;
   }
}

class EventList {
//method for storing and printing events. Really just a wrapped up QueuedLinkedList as <String>, no new methods ended up being written.
//sould have just inherited...
   QueueLinkedList<String> eventQueue;
   
   public EventList() {
      eventQueue = new QueueLinkedList<String>();   
   } //end constructor
   
   public void addEvent(String data) {
      eventQueue.enQueue(data);
   }
   
   public void eventTrace() {
      eventQueue.printAll();
   }
   
   public void FirstEvent() {
      eventQueue.peak();
   }
}

class BankTellerTest {
//test class
   public static void main(String[] args) throws IOException {
      BankQueue b = new BankQueue("bankData.csv");
      BankQueue c = new BankQueue("bankData.csv");	 
      System.out.println("Simulate 1 results:");      
      b.simulate1();
      System.out.println("\n\nSimulate 3 results:");
      c.simulate3();
   }
}
