public interface StackInterface {
   public boolean isEmpty();
   public void popAll();
   public void push(Object newItem) throws StackException;
   public Object pop();
   public Object peek() throws StackException;
}
