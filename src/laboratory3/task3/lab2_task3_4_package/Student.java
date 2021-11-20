package laboratory3.task3.lab2_task3_4_package;

public class Student {
    protected Subjects subjects = new Subjects();
    protected String name;
    protected String surname;

    public Student(){}
    public Student(final String name, final String surname){this.name=name;this.surname=surname;}
    public Student(final String name, final String surname,final Subjects subjects){
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;
    }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getName() { return name; }
    public String getSurname() { return surname; }

    public void setSubjects(final Subjects subjects) { this.subjects = subjects;}
    public Subjects getSubjects() { return subjects; }

    @Override
    public String toString(){ return name+" "+surname+": " +subjects.toString(); }
}
