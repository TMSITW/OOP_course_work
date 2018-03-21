
import org.apache.log4j.Logger;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;


public class FilmList extends JFrame {

    private static final Logger log = Logger.getLogger(FilmList.class);

    ActListener Action = new ActListener();
    //Главное окно
    private JFrame filmList;
    private DefaultTableModel model;
    private JButton save;
    private JButton open;
    private JButton add;
    private JButton del;
    private JButton edit;
    private JButton print;
    private JScrollPane scroll;
    private JTableEdit films;
    private JToolBar toolBar;

    private FilmBase filmBase = new FilmBase();
    private FilmInfo info;


    public class JTableEdit extends JTable {
        public JTableEdit(DefaultTableModel model) {
            super(model);
        }

        public boolean editFlag = false;
        public boolean isCellEditable(int arg0, int arg1) {
            return (arg1 == 3 || arg1 == 4) ? false : editFlag;
        }
    }

    ;

    public void show() {
        filmList = new JFrame("Кинотеатр Дружба");
        filmList.setSize(640, 480);
        filmList.setLocation(100, 100);
        filmList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        save = new JButton(new ImageIcon("./image/save.png"));
        save.addActionListener(Action);

        open = new JButton(new ImageIcon("./image/load.png"));
        open.addActionListener(Action);

        add = new JButton(new ImageIcon("./image/add1.png"));
        add.addActionListener(Action);

        del = new JButton(new ImageIcon("./image/delet.png"));
        del.addActionListener(Action);

        edit = new JButton(new ImageIcon("./image/edit.png"));
        edit.addActionListener(Action);

        print = new JButton(new ImageIcon("./image/print.png"));
        print.addActionListener(Action);


        save.setToolTipText("Сохранить список фильмов");
        open.setToolTipText("Загрузить список фильмов");
        add.setToolTipText("Добавить строку");
        del.setToolTipText("Удалить выбраную строку");
        edit.setToolTipText("Включить режим редакирования");
        print.setToolTipText("Составить афишу");


        toolBar = new JToolBar("Панель инструментов");
        toolBar.add(save);
        toolBar.add(open);
        toolBar.add(add);
        toolBar.add(del);
        toolBar.add(edit);
        toolBar.add(print);


        filmList.setLayout(new BorderLayout());
        filmList.add(toolBar, BorderLayout.NORTH);


        Object[] columns = {"Фильм", "Жанр", "Продолжительность", "Начало проката", "Конец проката"};
        Object[][] data = new Object[0][6];
        model = new DefaultTableModel(data, columns);
        films = new JTableEdit(model);
        scroll = new JScrollPane(films);
        filmList.add(scroll, BorderLayout.CENTER);


        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                try {

                    if (column == 0)
                        filmBase.films.get(films.getSelectedRow()).title = (String) films.getValueAt(row, column);
                    if (column == 1)
                        filmBase.films.get(films.getSelectedRow()).genre = (String) films.getValueAt(row, column);
                    if (column == 2)
                        filmBase.films.get(films.getSelectedRow()).duration = Integer.parseInt((String) films.getValueAt(row, column));
                    if (column == 3)
                        filmBase.films.get(films.getSelectedRow()).begin = (String) films.getValueAt(row, column);
                    if (column == 4)
                        filmBase.films.get(films.getSelectedRow()).end = (String) films.getValueAt(row, column);
                } catch (IndexOutOfBoundsException ex) {
                }
            }
        });



        films.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                int row = films.rowAtPoint(p);
                int column = films.columnAtPoint(p);
                if (!films.editFlag) {
                    if (e.getClickCount() == 2 && column != 3 && column != 4 && (row == films.getSelectedRow())) {
                        FilmInfo info = new FilmInfo(films, filmList, filmBase);
                    }
                    if (e.getClickCount() == 2 && (column == 3 || column == 4) && (row == films.getSelectedRow())) {
                        SessionInfo sInfo = new SessionInfo(filmBase, (String) films.getValueAt(row, 0), filmList, films, model);
                    }
                } else {
                    if (column == 3 || column == 4) {
                        DateChooser date = new DateChooser(filmList.getLocation(), films, filmList);
                    }

                }
            }
        });
        films.setDefaultEditor(String.class, null);

        log.info("Запуск приложения");
        filmList.setVisible(true);

    }


    public class MyException extends Exception {

        public MyException() {
            super("Не выбрана строка для удаления");
        }
    }

    public class ActListener implements ActionListener {

        public boolean removeRow() throws MyException {
            if (films.getSelectedRow() != -1) {
                filmBase.films.remove(films.getSelectedRow());
                model.removeRow(films.getSelectedRow());
                return true;
            } else {
                throw new MyException();
            }
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save) {
                    SaveXML File = new SaveXML(model, filmBase, true);

            }
            if (e.getSource() == open) {
                filmBase = new FilmBase();
                OpenXML File = new OpenXML(model, filmBase);
            }
            if (e.getSource() == edit) {
                films.editFlag = !films.editFlag;
                if (films.editFlag) {
                    edit.setIcon(new ImageIcon("./image/edit_end.png"));
                    edit.setToolTipText("Выключить режим редакирования");
                } else {
                    edit.setIcon(new ImageIcon("./image/edit.png"));
                    edit.setToolTipText("Включить режим редакирования");
                }
            }
            if (e.getSource() == add) {
                AddFilm addFilm = new AddFilm(filmList, filmBase, model, films);
            }
            if (e.getSource() == del) {
                try {
                    log.info("Удаление строки: " + films.getSelectedRow());
                    removeRow();
                } catch (MyException myEx) {
                    log.info("Исключительная ситуация", myEx);
                    JOptionPane.showMessageDialog(null, myEx.getMessage());
                }
            }
            if (e.getSource() == print) {
                SavePDF_HTML save=new SavePDF_HTML(model, filmBase, false, films);
            }

        }

    }


    public static void main(String[] args) {
        new FilmList().show();
    }
}
