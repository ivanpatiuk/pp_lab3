package laboratory3.task3.task3_package;

public class Mark {
    private int mark;

    public Mark(){}
    public Mark(int mark){ this.mark = mark;}

    public void setMark(final int mark) {
        if (mark < 0 | mark > 5)
            System.out.println("Error: mark is < 0 or > 5");
        else
            this.mark = mark;
    }
    public int getMark() { return mark; }

    @Override
    public boolean equals(final Object obj){
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;
        Mark tmp = (Mark)obj;
        return this.mark == tmp.mark;
    }
    @Override
    public int hashCode(){
        return 1000*mark+27;
    }
}
