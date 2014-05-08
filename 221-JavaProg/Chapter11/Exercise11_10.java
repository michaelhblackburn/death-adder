/*Michael Blackburn
  CSCI 221
  Exercise11_10.java*/
  
import java.util.ArrayList;
  
public class Exercise11_10 {
  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push("Tom");
    stack.push("George");
    stack.push("Peter");
    System.out.println(stack.getSize());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.peek());    
  }
}
  
class MyStack extends java.util.ArrayList{
  private ArrayList list = new ArrayList();
  
  MyStack(){
  	this.list = new ArrayList();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public int getSize() {
    return list.size();
  }

  public Object peek() {
    return list.get(getSize() - 1);
  }

  public Object pop() {
    Object o = list.get(getSize() - 1);
    list.remove(getSize() - 1);
    return o;
  }

  public void push(Object o) {
    list.add(o);
  }

  @Override /** Override the toString in the Object class */
  public String toString() {
    return "stack: " + list.toString();
  }
}