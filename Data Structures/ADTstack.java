class ADTstack implements StackInterface {
   private int MAX_STACK = 50;
   private Object items[];
   private int top;
   
   public ADTstack() {
      items = new Object[MAX_STACK];
      top = -1;
   }
   
   public boolean isEmpty() {
      return top < 0;
   }
   public boolean isFull() {
      return top == MAX_STACK-1;
   }
   public void popAll() {
      items = new Object[MAX_STACK];
      top = -1;
   }
   public void push(Object newItem) throws StackException {
      
      if (!isFull())
         items[++top] = newItem;
      else {
         Object[] tempArray = new Object[MAX_STACK*2];
         System.arraycopy(items, 0, tempArray, 0, MAX_STACK);
         items = tempArray;
         items[++top] = newItem;
         MAX_STACK *= 2;
      }
   }
   public Object pop() {
      if (!isEmpty())
         return items[top--];
      else 
         throw new StackException("Stack exception on pop - stack empty");   
   }
   public Object peek() throws StackException {
      if (!isEmpty())
         return items[top];
      else 
         throw new StackException("Stack exception on peek - stack empty");
   }
   public void display() {
      ADTstack temp = new ADTstack();
      while( !this.isEmpty() ) {
         temp.push(this.peek());
         System.out.println(this.pop());
      }
      while( !temp.isEmpty() ) {
         this.push(temp.pop());
      }
   }
   public static void main (String[] args) {
      ADTstack aStack = new ADTstack();
      for(int i=1; i < 10; i++) {
         aStack.push(i);
      }    
   }
}