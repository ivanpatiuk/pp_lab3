package laboratory3.task3.task4_package;

import laboratory3.task3.task3_package.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4 {
    public static void addSubjectToAll(List<StudentV2> studentsList, final Subject subject, final Mark mark){
        for(StudentV2 i: studentsList){
            i.getSubjects().addSubject(subject, mark);
        }
    }
    public static void printAllStudents(final List<StudentV2> studentsList){
        for(StudentV2 i : studentsList){
            System.out.println(i.toString());
        }
    }
    public static void printTheBestStudent(final List<StudentV2> studentsList){
        if (studentsList == null)
            return;
        double theBestAvg = 0;
        StudentV2 student = null;
        for(StudentV2 i : studentsList){
            double tmp=0;
            int subjectCounter = 0;
            for(Map.Entry<Subject, Mark> subject : i.getSubjects().getSubject().entrySet()){
                tmp+=subject.getValue().getMark();
                ++subjectCounter;
            }
            tmp=tmp/subjectCounter;
            if(theBestAvg<tmp) {
                theBestAvg = tmp;
                student=i;
            }
        }
        if(student!=null)
            System.out.println("The best student: "+student.toString());
    }

    public static void main(String[] args) {
        List<StudentV2> list = new ArrayList<>();
        StudentV2 s1 = new StudentV2("Ivan", "Nepupkin");
        StudentV2 s2 = new StudentV2("Ivan","Pupkin");
        StudentV2 s3 = new StudentV2("Bohdan","Lazarenko");
        StudentV2 s4 = new StudentV2("Igor","Nobelev");

        s1.getSubjects().addSubject(Subject.Ukranian,new Mark(1));
        s2.getSubjects().addSubject(Subject.Programming, new Mark(4));
        s3.getSubjects().addSubject(Subject.Literature, new Mark(5));
        s4.getSubjects().addSubject(Subject.Literature, new Mark(5));

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        addSubjectToAll(list, Subject.English, new Mark(3));
        printAllStudents(list);
        printTheBestStudent(list);
        System.out.println();

        List<StudentV2> list1 = new ArrayList<>();
        list1.add(new StudentV2("Stepan","Lazarenko"));
        list1.add(new StudentV2("Yuriy","Boichuk"));
        list1.add(new StudentV2("Oleh","Mordenko"));

        addSubjectToAll(list1, Subject.English, new Mark(3));
        addSubjectToAll(list1, Subject.Maths, new Mark(3));
        addSubjectToAll(list1, Subject.Physics, new Mark(3));
        printAllStudents(list1);

        Map<Integer, Subjects> map = new HashMap<>();
        map.put(s1.getId(),s1.getSubjects());
        map.put(s2.getId(),s2.getSubjects());
        System.out.println();
        System.out.println(map.toString());
    }
}
