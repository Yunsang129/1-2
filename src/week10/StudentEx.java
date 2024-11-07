package week10;

import java.util.*;

class Stuent implements Comparable<Stuent> {
    String name;
    int ban, no, kor, eng, math;

    Stuent(String name, int ban, int no, int kor, int eng, int math) {
        // your code here
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {

        return getTotal() / 3;
    }

    public String toString() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + ","
                + "Total:" + getTotal() + ", " + "Average:" + getAverage();
    }

    @Override
    public int compareTo(Stuent o) {
        if(o instanceof Stuent) {
            Stuent tmp = (Stuent) o;
            return this.name.compareTo(tmp.name);
        }
        return -1;
    }
}

class StudentEx {
    public static void main(String[] args) {
        ArrayList<Stuent> list = new ArrayList<Stuent>();
        list.add(new Stuent("하자바", 1, 1, 100, 100, 100));
        list.add(new Stuent("나자바", 1, 2, 90, 70, 80));
        list.add(new Stuent("성자바", 1, 5, 60, 100, 80));
        list.add(new Stuent("이자바", 1, 3, 80, 80, 90));
        list.add(new Stuent("가자바", 1, 4, 70, 90, 70));

        Collections.sort(list);
        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
