import java.util.HashMap;
import java.util.Scanner;

class Student {
  int age, roll_no, marks;
  String name;

  public Student(String name, int age, int roll_no, int marks) {
    this.age = age;
    this.roll_no = roll_no;
    this.name = name;
    this.marks = marks;
  }

  public void printData() {
    System.out.println("––––––––––––––––––––––––––––––––––––––––––");
    System.out.println("Name: " + name);
    System.out.println("Roll no: " + roll_no);
    System.out.println("Age: " + age);
    System.out.println("Marks: " + marks);
  }
}

public class DBMS {
  private static HashMap<Integer, Student> DataBase = new HashMap<>();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      System.out.println("1. Add Student");
      System.out.println("2. View Students");
      System.out.println("3. Search Student");
      System.out.println("4. Calculate Average Marks");
      System.out.println("5. Exit");
      System.out.print("Enter You Choice: ");

      try {
        int input = Integer.parseInt(sc.nextLine());
        switch (input) {
          case 1: AddStudent(sc);
            break;
          case 2: ViewStudent(sc);
            break;
          case 3: SearchStudent(sc);
            break;
          case 4: CalcAverage(sc);
            break;
          case 5: System.exit(0);
          default: System.out.println("Invalid Choice!");
        }
      } catch (Exception e) {
        System.out.println("––––––––––––––––––––––––––––––––––––––––––");
        System.out.println("Enter The Valid Roll No!");
        System.out.println("––––––––––––––––––––––––––––––––––––––––––");
      }

    }
  }

  public static void AddStudent(Scanner sc) {
    System.out.print("Enter Student's Name: ");
    String name = sc.nextLine();
    System.out.print("Enter Student's Roll Number: ");
    int roll_no = Integer.parseInt(sc.nextLine());

    if(DataBase.get(roll_no) != null) {
      System.out.println("This Roll Number Already Exists In DataBase, Roll Number Must Be Unique.");
      return;
    }
    System.out.print("Enter Student's Age: ");
    int age = sc.nextInt();
    System.out.print("Enter Student's Marks: ");
    int marks = sc.nextInt();

    Student newStudent = new Student(name, age, roll_no, marks);
    DataBase.put(roll_no, newStudent);

    System.out.println("––––––––––––––––––––––––––––––––––––––––––");
    System.out.println("Student Added Successfully");
    System.out.println("––––––––––––––––––––––––––––––––––––––––––");

  }

  public static void ViewStudent(Scanner sc) {
    for(Student st: DataBase.values()) {
      st.printData();
      System.out.println("––––––––––––––––––––––––––––––––––––––––––");
    }
  }

  public static void SearchStudent(Scanner sc) {
    try {
      System.out.print("Enter The Roll Number of Student: ");
      int roll_no = Integer.parseInt(sc.nextLine());

      System.out.println("––––––––––––––––––––––––––––––––––––––––––");
      Student st = DataBase.get(roll_no);
      if(st != null) {
        st.printData();
      } else {
        System.out.println("There is No Student With Roll Number "+ roll_no);
      }
      System.out.println("––––––––––––––––––––––––––––––––––––––––––");
    } catch (Exception e) {
      System.out.println("––––––––––––––––––––––––––––––––––––––––––");
      System.out.println("Enter The Valid Roll No!");
      System.out.println("––––––––––––––––––––––––––––––––––––––––––");
    }
  }

  public static void CalcAverage(Scanner sc) {
    int total = 0;
    for(Student st: DataBase.values()) total += st.marks;

    int size = DataBase.size();
    System.out.println("––––––––––––––––––––––––––––––––––––––––––");
    if(size == 0) {
      System.out.println("DataBase Is Empty!");
    } else {
      System.out.println("The Average is: " + total/DataBase.size());
    }
    System.out.println("––––––––––––––––––––––––––––––––––––––––––");
  }
}