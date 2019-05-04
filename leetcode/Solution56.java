package cn.xiaojiaqi.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
 
public class Solution56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals==null||intervals.size()==0)return list;
        Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				
				return o1.start-o2.start;
			}
		});
        Interval p = intervals.get(0);
        for(int i=1;i<intervals.size();i++) {
        	Interval t = intervals.get(i);
        	if(t.start<=p.end) {
        		p.end = p.end>t.end ? p.end : t.end;
        	}else {
        		list.add(p);
        		p = t;
        	}
        }
        list.add(p);
        return list;
        
    }
}