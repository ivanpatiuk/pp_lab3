package laboratory3.task3.lab2_task3_4_package;

import java.util.HashMap;
import java.util.Map;

public class Subjects {
    private Map<Subject, Mark> subjects = new HashMap<>();

    public Subjects(){}
    public Subjects(final Map<Subject, Mark> subjects){ this.subjects=subjects; }

    public Map<Subject, Mark> getSubject() { return subjects; }
    public void setSubjects(final Map<Subject, Mark> subjects) { this.subjects = subjects; }
    public void addSubject(final Subject subject, final Mark mark){ subjects.putIfAbsent(subject,mark); }
    public void removeSubject(final Subject subject) {subjects.remove(subject);}
    public void changeMark(final Subject subject, final Mark mark){
        subjects.replace(subject, this.subjects.get(subject),mark);
    }
    @Override
    public boolean equals(final Object obj){
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;
        Subjects tmp = (Subjects)obj;
        return this.getSubject().equals(tmp.getSubject());
    }
    @Override
    public int hashCode(){ return 1000*subjects.hashCode()+27; }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Map.Entry<Subject,Mark> item : subjects.entrySet()){
            str.append(item.getKey());
            str.append(" ");
            str.append(item.getValue().getMark());
            str.append(", ");
        }
        str.delete(str.length()-2, str.length());
        return str.toString();
    }
}
