import java.util.*;

class TimeMap {
  Map<String, List<AbstractMap.SimpleEntry<Integer, String>>> timestore;

  public TimeMap() {
    timestore = new HashMap<>();

  }

  public void set(String key, String value, int timestamp) {
    timestore.computeIfAbsent(
        key,
        v -> new ArrayList<>()).add(
            new AbstractMap.SimpleEntry<>(timestamp, value));
    timestore.get(key).sort(
        (p, q) -> p.getKey().compareTo(q.getKey()));
  }

  public String get(String key, int timestamp) {
    List<AbstractMap.SimpleEntry<Integer, String>> timeKeyStore = timestore.get(key);

    if (timeKeyStore.size() < 1)
      return "";

    int l = 0, r = timeKeyStore.size() - 1;

    while (l <= r) {
      int mid = (int) ((r - l) / 2);

      // <timestamp, key>
      AbstractMap.SimpleEntry<Integer, String> midEntry = timeKeyStore.get(mid);
      int foundTimestamp = midEntry.getKey();
      String foundKey = midEntry.getValue();

      if (foundTimestamp == timestamp)
        return foundKey;

      if (foundTimestamp < timestamp) {
        l = mid + 1;
      }

      if (foundTimestamp > timestamp) {
        r = mid - 1;
      }
    }

    if (l == -1 && l == r) {
      return "";
    }

    int resultIndex = Math.max(l, r);

    while (resultIndex >= 0 && resultIndex < timeKeyStore.size()
        && timeKeyStore.get(resultIndex).getKey() < timestamp) {
      resultIndex--;
    }

    if (resultIndex == -1 || resultIndex == timeKeyStore.size())
      return "";

    return timeKeyStore.get(resultIndex).getValue();
  }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
