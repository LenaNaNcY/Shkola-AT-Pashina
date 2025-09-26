import lombok.Generated;
import lombok.ToString;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ToString(includeFieldNames = true)

class Student {
    private int id;
    private String name;
    private int age;
    private int grade;

    public Student(int id, String name, int age, int grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }
}

public class Train {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(1, "Pashina Elena", 34, 5),
                new Student(2, "Pashina Alona", 12, 4),
                new Student(3, "Grishina Elena", 25, 3)
        );
        // Отфильтруем всех студентов старше 18 лет
        List<Student> filteredStudents = students.stream()
                .filter(student1 -> student1.getAge() > 18)
                .collect(Collectors.toList());

        // Выведем имена студентов старше 18 лет
        filteredStudents.forEach(student -> System.out.println(student.getName()));

//        for (Student s : students) {
//            System.out.println(s.getName()); // вывод имен студентов
        }
    }



//        // Отфильтруем всех студентов старше 18 лет
//        List<Student> filteredStudents = students.stream()
//                .filter(student -> student.getAge() > 18)
//                .collect(Collectors.toList());
//
//        // Выведем имена студентов старше 18 лет
//        filteredStudents.forEach(student -> System.out.println(student.getName()));
//    }
//}
//

//    public static void main(String[] args) {
//        List<String> names = List.of("Elena", "Vika", "Aleksey", "Timur", "Albina", "Ilya");
//        names.forEach(name -> System.out.println(name));
//    }
