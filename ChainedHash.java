public class ChainedHash{
  private static class Node{
    String key, value;
    Node next;
    Node(String k, String v) {
      key = k;
      value = v;
      next = null;
    }
    private Node[]table;
    private int m;

    public ChainedHash(int m) {
      this.m = m;
      table = new Node[m + 1];
    }
    private int hash(String key) {
      int x = Integer.parseInt(key);
      return (x % m) + 1;
    }
    
  }
}
