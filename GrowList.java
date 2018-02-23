import java.util.*;
//  GrowList is a mutable list that only gets longer.
public class GrowList <E> {

  private Map<Integer,E> values;

  public GrowList() { values = new HashMap<Integer,E>();}
 
  // add to the end of the list
  public GrowList add(E o) {
	  GrowList result = new GrowList(); //make new instance
	  result.values.putAll(values); //copy old values into new instance values
	  result.values.put(size(), o); //adjust new values accordingly
	  return result;
  }

  // number of values in list
  public int size() { return values.size(); }

  // get ith value in list
  public E get(int i) { 
     if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
     return values.get(i);
  }

  // update ith value in list;  return previous value or null if none
  public GrowList set(int i, E o) {
	 GrowList result = new GrowList(); //make new instance
	 result.values.putAll(values); //copy old values into new instance values
	 result.values.put(i, o); //adjust new values accordingly
     if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
     return result;
  }
  
  // private helper method
  private boolean inRange(int i) { return (i >= 0) && (i < size()); }

  public String toString() {
      if (size() == 0) return "[]";
      String result = "[";
      for (int i = 0; i < size()-1; i++) {
          result += values.get(i) + ",";
      }
      return result + values.get(size() - 1) + "]";
  }

  public static void main(String[] args) {
     GrowList<String> list = new GrowList<String>();
 
     System.out.println("list is:" + list);
     list.add("cat");
     System.out.println("list is" + list.add("cat"));
     list.add("dog");
     System.out.println("list is" + list.add("dog"));
     list.set(0,"bat");
     System.out.println("list is" + list.set(0,"bat"));

  }
}

