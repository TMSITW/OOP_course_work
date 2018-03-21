

import java.util.ArrayList;

public class Session {
    ArrayList<Ticket> tickets;
    int ticket;
    int remain;
    String date;
    String begin;
    public Session(String d, String b, int t, int r, ArrayList<Ticket> ti){
        date=d;
        begin=b;
        ticket=t;
        remain=r;
        tickets=ti;
    }
    public Session(String d, String b, int t, int r){
        date=d;
        begin=b;
        ticket=t;
        remain=r;
        tickets=new ArrayList<Ticket>();
        for (int i=0;i<5;i++)
            for(int n=0;n<(ticket==40?8:5);n++)
                tickets.add(i, new Ticket(i+1, n+1));
    }


}
