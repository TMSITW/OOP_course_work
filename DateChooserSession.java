import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DateChooserSession extends JDialog {
    //Окно выбора даты
    ChangeListener ChangeList = new ChangeList();
    private JDialog dateChoser;
    private JSpinner daySpin;
    private JSpinner monthSpin;
    private JSpinner yearSpin;
    private JButton setDate;
    private SpinnerNumberModel month;
    private SpinnerNumberModel day;
    private SpinnerNumberModel year;

    //Выбор даты
    public DateChooserSession(Point e, JTable films, Window owner, JButton button) {

        dateChoser = new JDialog(owner , "Выбор даты", ModalityType.APPLICATION_MODAL);
        dateChoser.setSize(250, 100);
        dateChoser.setLocation(e.getLocation());
        dateChoser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel date = new JPanel();
        setDate = new JButton("Установить дату");
        month = new SpinnerNumberModel(1, 1, 12, 1);
        day = new SpinnerNumberModel(1, 1, 31, 1);
        year = new SpinnerNumberModel(2016, 1960, 2100, 1);
        daySpin = new JSpinner(day);
        yearSpin = new JSpinner(year);
        monthSpin = new JSpinner(month);
        monthSpin.addChangeListener(ChangeList);
        yearSpin.addChangeListener(ChangeList);
        daySpin.addChangeListener(ChangeList);
        date.add(daySpin);
        date.add(monthSpin);
        date.add(yearSpin);
        date.add(setDate);
        setDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setDate) {
                    button.setText(new String(daySpin.getValue() + "." + monthSpin.getValue() + "." + yearSpin.getValue()));
                    dateChoser.dispose();
                }
            }
        });
        dateChoser.add(date);
        dateChoser.setVisible(true);
    }

    public class ChangeList implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int month = (int) monthSpin.getValue();
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                day.setMaximum(31);
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                if ((int) daySpin.getValue() > 30)
                    daySpin.setValue(30);
                day.setMaximum(30);
            }
            if (month == 2)
                if ((int) yearSpin.getValue() % 4 == 0) {
                    if ((int) daySpin.getValue() > 29)
                        daySpin.setValue(29);
                    day.setMaximum(29);
                } else {
                    day.setMaximum(28);
                    if ((int) daySpin.getValue() > 28)
                        daySpin.setValue(28);
                }
        }
    }
}
