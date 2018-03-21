import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSession extends JDialog{
    JDialog addSession;
    JPanel lablels;
    GridLayout layout;
    JLabel date;
    JLabel time;
    JLabel totalTicets;
    JButton dateButton;
    JTextField timeField;
    JComboBox box;
    JButton save;
    public String datestr;

    public  AddSession(JDialog owner, FilmBase base, DefaultTableModel table, JTable films, int filmIndex){
        addSession=new JDialog(owner,"Параметры", true);
        addSession.setResizable(false);
        addSession.setSize(320,240);
        addSession.setLocation(owner.getLocation().x+200,owner.getLocation().y+150);
        addSession.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        lablels=new JPanel();
        layout=new GridLayout(3,2);
        lablels.setLayout(layout);

        date=new JLabel("Дата сеанса: ");
        lablels.add(date);
        dateButton=new JButton("Дата");
        dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateChooserSession chooser=new DateChooserSession(owner.getLocation(), films, owner, dateButton );
            }
        });
        lablels.add(dateButton);
        time=new JLabel("Время сеанса: ");
        lablels.add(time);
        timeField=new JTextField("00:00");
        lablels.add(timeField);
        totalTicets=new JLabel("Выбор зала: ");
        lablels.add(totalTicets);
        box=new JComboBox(new String[]{"Малый (25 мест)", "Средний (40 мест)"});
        lablels.add(box);
        addSession.add(lablels);
        save=new JButton("Добавить");
        addSession.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==save){
                    if(dateButton.getText()!="Дата") {
                        base.films.get(filmIndex).sessions.add(base.films.get(filmIndex).sessions.size(),new Session(dateButton.getText(), timeField.getText(), box.getSelectedIndex() == 0 ? 25 : 40, box.getSelectedIndex() == 0 ? 25 : 40));
                        table.addRow(new Object[]{dateButton.getText(), timeField.getText(), box.getSelectedIndex() == 0 ? 25 : 40, box.getSelectedIndex() == 0 ? 25 : 40});
                        addSession.dispose();
                    }
                }
            }
        });
        addSession.setVisible(true);
    }

}
