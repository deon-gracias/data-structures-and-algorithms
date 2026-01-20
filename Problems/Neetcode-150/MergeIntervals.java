class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(p -> p[0]));

        for (int i = 0; i < intervals.length; i++) {
            if (result.size() < 1) {
                result.add(intervals[i]);
                continue;
            }

            int n = result.size() - 1;
            int prevInterval[] = result.get(n);

            int start = intervals[i][0], end = intervals[i][1];
            int prevStart = prevInterval[0], prevEnd = prevInterval[1];

            if (prevEnd >= start) {
                result.get(n)[0] = Math.min(result.get(n)[0], intervals[i][0]);
                result.get(n)[1] = Math.max(result.get(n)[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.stream().toArray(int[][]::new);
    }
}
