import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Film {
    String begin;
    String end;
    String title;
    int duration;
    String genre;
    String poster;
    String description;
    ArrayList<Session> sessions;


    public Film(String t, String g, int d, String b, String e,String p,String des, ArrayList<Session> s) {
        title = t;
        duration = d;
        genre = g;
        poster=p;
        description=des;
        begin=b;
        end=e;
        sessions=s;
    }
    public Film(String t, String g, int d, String b, String e) {
        title = t;
        duration = d;
        genre = g;
        begin=b;
        end=e;
        sessions=new ArrayList<Session>();

    }
}
