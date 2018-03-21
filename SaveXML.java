
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class SaveXML extends JFrame{
    static String fileName;


    public SaveXML(DefaultTableModel model, FilmBase base, boolean flag){

        try {
            DocumentBuilder builder= DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();
            Node filmlist = doc.createElement("filmlist");
            doc.appendChild(filmlist);

            for(int i=0; i<model.getRowCount();i++) {
                Element film=doc.createElement("film");
                filmlist.appendChild(film);
                film.setAttribute("title", ""+model.getValueAt(i,0));
                film.setAttribute("genre", ""+model.getValueAt(i,1));
                film.setAttribute("duration", ""+model.getValueAt(i,2));
                film.setAttribute("begin", ""+model.getValueAt(i,3));
                film.setAttribute("end", ""+model.getValueAt(i,4));
                film.setAttribute("poster", base.films.get(i).poster);
                film.setAttribute("description", base.films.get(i).description);
                for(int j=0;j<base.films.get(i).sessions.size();j++) {

                    Session str=base.films.get(i).sessions.get(j);
                    Element session=doc.createElement("session");
                    film.appendChild(session);
                    session.setAttribute("date", str.date);
                    session.setAttribute("time",str.begin);
                    session.setAttribute("totaltickets",""+str.ticket);
                    session.setAttribute("freetickets", ""+str.remain);
                    for(int n=0; n<base.films.get(i).sessions.get(j).tickets.size();n++){
                        Ticket ticket=base.films.get(i).sessions.get(j).tickets.get(n);
                        Element tick=doc.createElement("ticket");
                        session.appendChild(tick);
                        tick.setAttribute("date", ticket.date);
                        tick.setAttribute("free", ""+ticket.free);
                        tick.setAttribute("row", ""+ticket.row);
                        tick.setAttribute("place", ""+ticket.place);
                    }
                }
            }
            Transformer trans=TransformerFactory.newInstance().newTransformer();
            if (flag){
            FileDialog save= new FileDialog(this,"Выбор файла для сохранения", FileDialog.SAVE);
            save.setFile("База фильмов.xml");
            save.setVisible(true);
            fileName=save.getDirectory()+save.getFile();}
            else fileName="FilmBaseForReport.xml";
            java.io.FileWriter fw=new FileWriter(fileName);
            trans.transform(new DOMSource(doc),new StreamResult(fw));
        }
        catch(ParserConfigurationException e) {e.printStackTrace();}
        catch (TransformerConfigurationException e){e.printStackTrace();}
        catch (TransformerException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
    }

    static boolean isFileName(String file) {
        return file==fileName;
    }
}
