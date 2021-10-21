package laboratory3.task3;

import laboratory3.task3.task3_package.*;
import laboratory3.task3.task4_package.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<SimpleStudent> transformToSimpleStudent(final List<StudentV2> list){
        return list.stream()
                .distinct()
                .map(student -> new SimpleStudent(student.getId(),student.getName(),student.getSurname()))
                .collect(Collectors.toList());
    }
    public static List<StudentV2> deleteWithMarkLessThanThree(final List<StudentV2> list){
        return list.stream()
                .distinct()
                .filter(student -> student.getSubjects().getSubject().values().stream().mapToInt(Mark::getMark)
                        .average().getAsDouble() >= 3.0)
                .collect(Collectors.toList());
    }
    public static void printAllStudents(final List<StudentV2> studentsList){
        for(StudentV2 i : studentsList)
            System.out.println(i.toString());
        System.out.println();
    }
    public static void printEnglishMarks(final List<StudentV2> list){
//        System.out.println("English marks: " + (list.stream()
//                .filter(student -> student.getSubjects().getSubject().keySet().contains(Subject.English))
//                .map(student-> student.getSubjects().getSubject().get(Subject.English).getMark())
//                .collect(Collectors.toSet()))+"\n");
        System.out.println("English marks: " + (list.stream()
                .distinct()
                .flatMap(subjectMarkMap -> subjectMarkMap.getSubjects().getSubject().entrySet().stream())
                .filter(entry -> entry.getKey().equals(Subject.English))
                .map(entry -> entry.getValue().getMark())
                .collect(Collectors.toSet()))+"\n");
    }
    public static List<StudentV2> sort(final List<StudentV2> list){
        return list.stream().sorted(Comparator.comparing(Student::getName)
                .thenComparing(Student::getSurname))
                .collect(Collectors.toList());
    }
    public static StudentV2 findBestStudent(final List<StudentV2> list){
        return list.stream()
                .distinct()
                .max(Comparator.comparingDouble(student -> student.getSubjects().getSubject().values().stream().
                        mapToInt(Mark::getMark).average().getAsDouble()))
        .get();
    }
    public static String printSurnames(final List<SimpleStudent> list){
        return list.stream()
                .map(e -> e.getSurname())
                .distinct()
                .reduce((s1,s2)->s1+"-"+s2).get();
    }

    public static void main(String[] args) {
        List<StudentV2> list = new ArrayList<>();
        StudentV2 s1 = new StudentV2("Ivan", "Nepupkin");
        StudentV2 s2 = new StudentV2("Ivan", "Pupkin");
        StudentV2 s3 = new StudentV2("Mykola", "Lazarenko");
        StudentV2 s4 = new StudentV2("Bohdan", "Lazarenko");

        s1.getSubjects().addSubject(Subject.Ukranian, new Mark(1));
        s1.getSubjects().addSubject(Subject.English, new Mark(3));
        s2.getSubjects().addSubject(Subject.Programming, new Mark(4));
        s2.getSubjects().addSubject(Subject.English, new Mark(3));
        s3.getSubjects().addSubject(Subject.Literature, new Mark(5));
        s3.getSubjects().addSubject(Subject.English, new Mark(5));
        s4.getSubjects().addSubject(Subject.Literature, new Mark(5));
        s4.getSubjects().addSubject(Subject.English, new Mark(5));

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        printAllStudents(list);  // функція виводу студентів з 2 лаб.роботи

        // Створити клас StudentSimple з основними даними про студента.
        //Написати метод для перетворення List вхідних даних (List<Student>)
        //у List<StudentSimple>;
        List<SimpleStudent> list2 = transformToSimpleStudent(list);
        System.out.println((list2.stream().map(simpleStudent -> simpleStudent.getID() + " " + simpleStudent.getName() +
                " " + simpleStudent.getSurname()).
                collect(Collectors.toList())) + "\n");

        // Написати метод для видалення усіх студентів з середнім балом < 3;
        list = deleteWithMarkLessThanThree(list);
        printAllStudents(list);

        // Написати метод для виведення усіх оцінок з Англійської Мови без
        //повторень;
        printEnglishMarks(list);

        // Написати метод для сортування списку студентів за прізвищем,
        //іменем та по-батькові;
        list = sort(list);
        printAllStudents(list);

        // Написати метод для знаходження студента з найвищим середнім
        //балом;
        System.out.println("The best student: " + findBestStudent(list) + "\n");

        // Написати метод який буде повертати прізвища усіх студентів через
        //дефіс.
        System.out.println(printSurnames(list2));
    }
}
