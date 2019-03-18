package sri.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class MergeOverlappingInterval {
    public static class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

    }

    public static Interval[] merge(Interval[] overlapping) {
        Arrays.sort(overlapping, Comparator.comparing(Interval::getStart));

        Deque<Interval> stack = new LinkedList<>();
        stack.push(overlapping[0]);

        for(int i=0; i<overlapping.length; i++) {
            Interval top = stack.peek();
            if(overlapping[i].getStart() < top.getEnd() &&
                    overlapping[i].getEnd() > top.getEnd()) {
                top.setEnd(overlapping[i].getEnd());
            }
            if(overlapping[i].getStart() > top.getEnd()) {
                stack.push(overlapping[i]);
            }
        }

        Interval[] res = new Interval[stack.size()];
        int j=0;
        while (!stack.isEmpty()) {
            res[j++] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        Arrays.stream(merge(arr)).forEach(System.out::println);
    }
}
