public class OPenHash {
  
  private static class Entry{
    String key;
    String value;
    Entry(String k, String v) {
      key = k;
      value = v;
    }
  }

  private Entry[] table;
  private int size, m;

  public OpenHash(int m) {
    this.m = m;
    table = new Entry[m + 1];
    size = 0;
  }

  private int hash(String key) {
    int x = Integer.parseInt(key);
    return (x % m) + 1;
  }
  public void insert(String key, String value) {
    int i = hash(key);
    int r = 1;
    while (table[i] != null && !table[i].key.equals(key)) {
      i = ((i - 1 + r) % m) + 1;
      r++;
    }
    table[i] = new Entry(key, value);
    size++;
  }
  
}
