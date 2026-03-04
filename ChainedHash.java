public class ChainedHash{
  private static class Node{
    String key, value;
    Node next;
    Node(String k, String v) {
      key = k;
      value = v;
      next = null;
    }
    
  }
}
