

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFilm extends JDialog {
    JDialog addFilm;
    JPanel lablels;

    GridLayout layout;
    JLabel title;
    JLabel genre;
    JLabel time;
    JLabel beginLabel;
    JLabel endLabel;
    JTextField titleField;
    JButton dateBegin;
    JButton dateEnd;
    JTextField timeField;
    JList list;
    JButton save;
    JScrollPane scroll;

    public AddFilm(JFrame owner, FilmBase base, DefaultTableModel table, JTable films){
        addFilm=new JDialog(owner,"Параметры", true);
        addFilm.setResizable(false);
        addFilm.setSize(320,400);
        addFilm.setLocation(owner.getLocation().x+200,owner.getLocation().y+150);
        addFilm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        lablels=new JPanel();
        layout=new GridLayout(5,2);
        lablels.setLayout(layout);

        title=new JLabel("Название: ");
        lablels.add(title);
        titleField=new JTextField("Название");
        lablels.add(titleField);


        genre=new JLabel("Жанр");
        lablels.add(genre);
        String[] data=new String[]{"Комедия","Драма", "Боевик", "Фантастика", "Фентези", "Детектив", "Трилер","Документальный","Ужасы"};
        list=new JList(data);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(9);
        scroll=new JScrollPane(list);
        lablels.add(scroll);

        time=new JLabel("Длительность:");
        lablels.add(time);
        timeField=new JTextField("90");
        lablels.add(timeField);

        beginLabel=new JLabel("Начало проката:");
        lablels.add(beginLabel);
        dateBegin=new JButton("Начало");
        dateBegin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateChooserSession chooser=new DateChooserSession(owner.getLocation(), films, owner, dateBegin );
            }
        });
        lablels.add(dateBegin);

        endLabel=new JLabel("Конец проката:");
        lablels.add(endLabel);
        dateEnd=new JButton("Конец");
        dateEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateChooserSession chooser=new DateChooserSession(owner.getLocation(), films, owner, dateEnd );
            }
        });
        lablels.add(dateEnd);

        addFilm.add(lablels);

        save=new JButton("Добавить");
        addFilm.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==save){
                    if(dateBegin.getText()!="Начало"&& dateEnd.getText()!="Конец") {
                        int[] count=list.getSelectedIndices();
                        String str="";
                        for (int i=0;i<count.length;i++)  { str=str+data[count[i]]+" "; }
                        base.films.add(base.films.size(), new Film(titleField.getText(), str, Integer.parseInt(timeField.getText()), dateBegin.getText(), dateEnd.getText()));
                        table.addRow(new Object[]{titleField.getText(), str, Integer.parseInt(timeField.getText()), dateBegin.getText(), dateEnd.getText()});
                        addFilm.dispose();

                    }
                }
            }
        });
        addFilm.setVisible(true);

    }
}
