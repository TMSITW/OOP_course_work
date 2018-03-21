
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class OpenXML extends JFrame {
    public OpenXML(DefaultTableModel model, FilmBase base) {

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            FileDialog load = new FileDialog(this, "Выбор файла для открытия", FileDialog.LOAD);
            load.setFile("База фильмов.xml");
            load.setVisible(true);
            String fileName = load.getDirectory() + load.getFile();
            if(load.getFile()==null) {return;}
            Document doc = builder.parse(new File(fileName));
            doc.getDocumentElement().normalize();
            int rows = model.getRowCount();
            for (int i = 0; i < rows; i++) model.removeRow(0); // Очистка таблицы


            NodeList filmlist = doc.getElementsByTagName("film");
            for (int i = 0; i < filmlist.getLength(); i++) {
                Node elem = filmlist.item(i);
                NamedNodeMap attrs = elem.getAttributes();
                String title = attrs.getNamedItem("title").getNodeValue();
                String genre = attrs.getNamedItem("genre").getNodeValue();
                String duration = attrs.getNamedItem("duration").getNodeValue();
                String begin = attrs.getNamedItem("begin").getNodeValue();
                String end = attrs.getNamedItem("end").getNodeValue();
                String poster = attrs.getNamedItem("poster").getNodeValue();
                String description = attrs.getNamedItem("description").getNodeValue();
                model.addRow(new String[]{title, genre, duration, begin, end});
                NodeList sessionlist = elem.getChildNodes();
                ArrayList<Session> arrayList=new ArrayList<Session>();
                String[] str = new String[4];

                for (int j = 0; j < sessionlist.getLength(); j++) {
                    Node elemS = sessionlist.item(j);
                    NamedNodeMap attrsS = elemS.getAttributes();
                    str[0] = attrsS.getNamedItem("date").getNodeValue();
                    str[1] = attrsS.getNamedItem("time").getNodeValue();
                    str[2] = attrsS.getNamedItem("totaltickets").getNodeValue();
                    str[3] = attrsS.getNamedItem("freetickets").getNodeValue();

                    NodeList ticketList=elemS.getChildNodes();
                    ArrayList<Ticket> arrT=new ArrayList<Ticket>();
                    String[] strT=new String[4];
                    for (int n=0; n<ticketList.getLength();n++){
                        Node elemT = ticketList.item(n);
                        NamedNodeMap attrsT = elemT.getAttributes();
                        strT[0] = attrsT.getNamedItem("date").getNodeValue();
                        strT[1] = attrsT.getNamedItem("free").getNodeValue();
                        strT[2] = attrsT.getNamedItem("row").getNodeValue();
                        strT[3] = attrsT.getNamedItem("place").getNodeValue();
                        arrT.add(n, new Ticket(strT[0], Boolean.parseBoolean(strT[1]),Integer.parseInt(strT[2]), Integer.parseInt(strT[3])));
                    }
                    arrayList.add(j, new Session(str[0],str[1],Integer.parseInt(str[2]),Integer.parseInt(str[3]), arrT));
                }
                base.films.add(i, new Film(title, genre, Integer.parseInt(duration), begin, end,poster, description, arrayList));
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
