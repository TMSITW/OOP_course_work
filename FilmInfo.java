import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FilmInfo extends JDialog {


    //Окно информации
    private JDialog filmInfo;
    private String posterDir;
    private JPanel panel;
    private JPanel infoPanel;
    private JLabel poster;
    private JTextField discription;
    private JButton saveDiscr;
    private JButton savePoster;
    private JTextArea discrInf;
    private int row;

    //public FilmInfo(){}

    public FilmInfo(JTable films, JFrame owner, FilmBase base) {


        filmInfo = new JDialog(owner ,"Информация о фиьме", true);
        row = films.getSelectedRow();


        filmInfo.setSize(640, 480);
        filmInfo.setLocation(740, 100);
        filmInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        poster = new JLabel(new ImageIcon(base.films.get(row).poster));
        poster.setSize(190,270);



        panel = new JPanel();
        infoPanel = new JPanel();
        JLabel titleInf = new JLabel("Название: " + films.getValueAt(row, 0));
        JLabel genreInf = new JLabel("Жанр: " + films.getValueAt(row, 1));
        JLabel timeInf = new JLabel("Длительность: " + films.getValueAt(row, 2));
        JLabel beginInf = new JLabel("Начало проката: " + films.getValueAt(row, 3));
        JLabel endInf = new JLabel("Конец проката: " + films.getValueAt(row, 4));

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(titleInf);
        infoPanel.add(genreInf);
        infoPanel.add(timeInf);
        infoPanel.add(beginInf);
        infoPanel.add(endInf);
        panel.add(poster, BorderLayout.WEST);
        panel.add(infoPanel, BorderLayout.EAST);


        saveDiscr = new JButton("Сохранить описание");
        savePoster = new JButton("Изменить обложку");
        savePoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == savePoster) {
                    FileDialog save = new FileDialog(filmInfo, "Выбор обложки");
                    save.setVisible(true);
                    String fileName = save.getDirectory() + save.getFile();
                    if (save.getFile() != null) {
                        base.films.get(films.getSelectedRow()).poster=fileName;
                        poster.setIcon(new ImageIcon(base.films.get(films.getSelectedRow()).poster));
                    }
                }
            }
        });
        saveDiscr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == saveDiscr) {
                    base.films.get(films.getSelectedRow()).description=discrInf.getText();
                }
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveDiscr, BorderLayout.WEST);
        buttonPanel.add(savePoster, BorderLayout.EAST);

        JLabel discr = new JLabel("Описание:");
        JPanel panelDiscr = new JPanel();
        panelDiscr.add(discr, BorderLayout.NORTH);
        discrInf = new JTextArea(base.films.get(films.getSelectedRow()).description);
        discrInf.setSize(filmInfo.getWidth() - 50, 200);
        discrInf.setRows(5);
        JScrollPane scrollText = new JScrollPane(discrInf);
        discrInf.setLineWrap(true);
        discrInf.setWrapStyleWord(true);

        panelDiscr.add(scrollText, BorderLayout.WEST);


        filmInfo.add(panelDiscr, BorderLayout.CENTER);
        filmInfo.add(panel, BorderLayout.NORTH);
        filmInfo.add(buttonPanel, BorderLayout.SOUTH);
        filmInfo.setVisible(true);


    }
}
