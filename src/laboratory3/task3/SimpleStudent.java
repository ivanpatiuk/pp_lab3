package laboratory3.task3;

public class SimpleStudent {
    private int ID;
    private String name;
    private String surname;

    public SimpleStudent(){}
    public SimpleStudent(final int ID, final String name, final String surname){
        this.ID = ID;
        this.name=name;
        this.surname=surname;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
