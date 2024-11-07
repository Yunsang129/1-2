package week10;
import java.util.*;
class Student{
    int id;
    String tel;
    public Student(int id, String tel){
        this.id = id;
        this.tel = tel;
    }
    public int getId(){
        return this.id;
    }
    public String getTel(){
        return this.tel;
    }
}
public class HashMapStudentEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Student> map = new HashMap<String, Student>();
        while (true) {
            String name = scanner.next();
            int id = scanner.nextInt();
            String phoneNumber = scanner.next();
            if (name == null)
                break;
            Student student = new Student(id, phoneNumber);
            map.put(name, student);
        }
        scanner.nextLine();
        while (true) {
            System.out.println("검색할 이름?");
            String name = scanner.nextLine();
            Student student = map.get(name);
            if (name.equals("exit"))
                break;
            if (student == null)
                System.out.println(name + "은 없는 사람입니다.");
            else
                System.out.println("id:" + student.getId() + ", 전화: " + student.getTel());
        }
        scanner.close();
    }
}
