package MergeOverlappingIntervals;

import java.util.*;

class Intervals  {
    private ArrayList<Interval> intervals;

    Intervals() {}

    Intervals(ArrayList<Interval> intervals) {
        this.intervals = intervals;
    }

    public ArrayList<Interval> getIntervals() {
        return intervals;
    }

    public void printIntervals() {
        System.out.print("[");
        Boolean start = false;
        for(Interval obj : intervals) {
            if(start) System.out.print(", ");
            obj.printInterval();
            start = true;
        }
        System.out.println("]");
    }
}

class Interval implements Comparable<Interval> {
    private int start;
    private int end;

    Interval() {
        this.start = -1;
        this.end = -1;
    }

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Boolean isOverlapping(Interval prev) {
        return this.start >= prev.start && this.start <= prev.end;
    }

    public Interval mergeInterval(Interval prev) {
        int start = Math.min(this.start, prev.start);
        int end = Math.max(this.end, prev.end);
        this.start = start;
        this.end = end;
        return new Interval(start, end);
    }

    public void printInterval() {
        System.out.print("{" + this.start + ", " + this.end + "}");
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int compareTo(Interval inter) {
        return this.start - inter.start;
    }
}

class Main {

    static ArrayList<Interval> mergeIntervals(Intervals intervalsWrap) {
        ArrayList<Interval> intervals = intervalsWrap.getIntervals();
        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(0, intervals.get(0));
        for(int i = 1 ; i < intervals.size() ; i++) {
            if(intervals.get(i).isOverlapping(intervals.get(i - 1))) {
                Interval merge = intervals.get(i).mergeInterval(intervals.get(i - 1));
                mergedIntervals.set(mergedIntervals.size() - 1,merge);
            } else {
                mergedIntervals.add(intervals.get(i));
            }
        }
        return mergedIntervals;
    }

    static void printIntervals(ArrayList<Interval> intervals) {
        System.out.print("[");
        Boolean start = false;
        for(Interval obj : intervals) {
            if(start) System.out.print(", ");
            obj.printInterval();
            start = true;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>(n);
            for(int i = 0 ; i < n ; i++) {
                int start = sc.nextInt(), end = sc.nextInt();
                intervals.add(i, new Interval(start, end));
            }
            Collections.sort(intervals);
            intervals = mergeIntervals(new Intervals(intervals));
            printIntervals(intervals);
        }
    }
}