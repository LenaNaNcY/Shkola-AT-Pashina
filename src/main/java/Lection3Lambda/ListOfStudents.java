package Lection3Lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = true)
class Student {
    private int id;
    private String name;
    private int age;
    private int mark;
}

public class ListOfStudents {

    public static void main(String[] args) {

            // Создаём коллекцию студентов нашего потока АТ
        List<Student> students = List.of(
                new Student(1, "Elena", 17, 5),
                new Student(2, "Alexey", 28, 4),
                new Student(3, "Vika", 25, 3),
                new Student(4, "Timur", 8, 2),
                new Student(5, "Albina", 12, 4),
                new Student(6, "Ilya", 18, 5)
        );

        //1. Добавление студентов в общий список (+ 5 вывод информации о студентах в консоль)
        System.out.println("1. Common List Of Students");
        students.stream()
                .distinct().forEach(name -> System.out.println(name));

        //2. Фильтранция студентов по возрасту, только старше 18ти
        System.out.println();
          System.out.println("2. Adult Students");
            students.stream()
                .filter(s -> s.getAge() > 18)
                    .forEach(s -> System.out.println("IsEighteen: " + s.getName() + ", age: " + s.getAge()));

//        //3. Подсчет среднего значения оценок студентов
        System.out.println();
        System.out.println("3. Average mark of all students");
        double markAvg = students.stream()
                .mapToInt(Student::getMark)
                .average()
                .orElse(0.0);
        System.out.println(markAvg);

//                //4. Сортировка студентов по оценкам в порядке убывания
        System.out.println();
        System.out.println("4. List of success of study DESC");
        students.stream()
                .sorted(Comparator.comparing(Student::getMark).reversed())
                .forEach(System.out::println);

//
//
//

        //Примеры функциональных интерфейсов с 1м методом:

//        Runnable r = () -> System.out.println("Hello! "); //ничего не принимает и не возвращает, просто исполняет код
//        r.run();
//
//        Consumer<String> cons = (String name) -> System.out.println(String.format("Hi, %s", name)); //будет принимать name и ничего не возвращать
//        cons.accept("Lena");
//
//        Consumer<String> cons1 = (String name) -> System.out.println("Hi, " + name); //то же самое, только без стринг формата и плейсхолдера-заместителя значений
//        cons1.accept("Elena");
//
//        Supplier<Integer> dice = () -> new Random().nextInt(20); //кидаем d20 - интерфейсничего не принимает, возвращает число
//        System.out.println(dice.get());
//
//        Function<Integer, String> converter = (Integer number) -> String.valueOf(number);//принимает число, возвращает строку
//        System.out.println(converter.apply(100)); //это не видно, но это терь строка
//
//        Predicate<String> CheckTitle = (String title) -> title.startsWith("Science");//интерфейс чекТайтл принимает строку, возвращает boolean
//        System.out.println(CheckTitle.test("Science of Social"));

    }
}
