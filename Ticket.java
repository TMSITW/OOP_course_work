

public class Ticket {
    String date;
    boolean free;
    int row;
    int place;
    public Ticket(String d, boolean f,int r, int p){
        date=d;
        free=f;
        row=r;
        place=p;
    }
    public Ticket(int row, int place){
        free=true;
        this.row=row;
        this.place=place;
    }

}
