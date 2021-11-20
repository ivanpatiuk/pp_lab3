package laboratory3.task3.task3_package;
;
import laboratory3.task3.lab2_task3_4_package.Student;
import laboratory3.task3.lab2_task3_4_package.Subjects;

public class StudentV2 extends Student {
    private final int id;
    private static int created = 0;

    public StudentV2(){ super(); ++created; id = created;}
    public StudentV2(final String name, final String surname){
        super(name,surname);
        ++created;
        id = created;
    }
    public StudentV2(final String name, final String surname,final Subjects subjects){
        super(name,surname,subjects);
        ++created;
        id =created;
    }

    public int getId() { return id; }
    @Override
    public String toString(){ return id +" "+ name + " " + surname + " " + subjects.toString(); }
}
