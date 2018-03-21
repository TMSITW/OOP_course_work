import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class SessionInfo extends JDialog {
    //Окно сеансов
    private JDialog sessionInfo;
    private DefaultTableModel sessionModel;
    private JTableEdit sessionTable;
    private JButton sellTicket;
    private JButton report;
    private JButton addSession;
    private JScrollPane scrollS;
    private TicketInfoBig infoB=new TicketInfoBig();
    private TicketInfoSmall infoS;
    boolean flag=true;

    public class JTableEdit extends JTable {
        public JTableEdit(DefaultTableModel model) {
            super(model);
        }

        public boolean editFlag = false;
        public boolean isCellEditable(int arg0, int arg1) {
            return false;
        }
    }

    public SessionInfo(FilmBase base, String title, JFrame owner, JTable films, DefaultTableModel model) {
        sessionInfo = new JDialog(owner, "Расписание сеансов фильма: " + title, true);
        sessionInfo.setSize(640, 480);
        sessionInfo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        sessionInfo.setLocation(owner.getLocation().x, owner.getLocation().y + 480);
        Object[] sessionColumns = {"Дата", "Начало сеанса", "Всего билетов", "Осталось билетов"};

        if (base.films.get(films.getSelectedRow()).sessions.size() != 0) {
            String[][] data = new String[base.films.get(films.getSelectedRow()).sessions.size()][4];

            for (int i = 0; i < base.films.get(films.getSelectedRow()).sessions.size(); i++) {
                data[i][0] = base.films.get(films.getSelectedRow()).sessions.get(i).date;
                data[i][1] = base.films.get(films.getSelectedRow()).sessions.get(i).begin;
                data[i][2] = "" + base.films.get(films.getSelectedRow()).sessions.get(i).ticket;
                data[i][3] = "" + base.films.get(films.getSelectedRow()).sessions.get(i).remain;
            }
            sessionModel = new DefaultTableModel(data, sessionColumns);
        } else {
            String[][] data = new String[0][4];
            sessionModel = new DefaultTableModel(data, sessionColumns);
        }
        sessionInfo.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                    if (!flag) sessionTable.setValueAt("" + base.films.get(films.getSelectedRow()).sessions.get(sessionTable.getSelectedRow()).remain,sessionTable.getSelectedRow(), 3);
                    flag=false;
            }

            @Override
            public void windowLostFocus(WindowEvent e) {

            }
        });
        sessionTable = new JTableEdit(sessionModel);
        sessionModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                try {

                    if (column == 0)
                        base.films.get(films.getSelectedRow()).sessions.get(row).date = (String) sessionTable.getValueAt(row, column);
                    if (column == 1)
                        base.films.get(films.getSelectedRow()).sessions.get(row).begin = (String) sessionTable.getValueAt(row, column);
                    if (column == 2)
                        base.films.get(films.getSelectedRow()).sessions.get(row).ticket = Integer.parseInt((String) sessionTable.getValueAt(row, column));
                    if (column == 3)
                        base.films.get(films.getSelectedRow()).sessions.get(row).remain = Integer.parseInt((String) sessionTable.getValueAt(row, column));
                } catch (IndexOutOfBoundsException ex) {
                }
            }
        });
        sessionTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                int row = sessionTable.rowAtPoint(p);
                int column = sessionTable.columnAtPoint(p);
                if (("" + sessionTable.getValueAt(row, 2)).equals("40")) {
                    infoB = new TicketInfoBig(sessionInfo, base, films, sessionTable);
                } else if (("" + sessionTable.getValueAt(row, 2)).equals("25")) {
                    infoS = new TicketInfoSmall(sessionInfo, base, films, sessionTable);
                }
            }

        });
        scrollS = new

                JScrollPane(sessionTable);
        sessionInfo.add(scrollS, BorderLayout.CENTER);
        JPanel ticketPanel = new JPanel();
        report=new JButton("Отчет о продаже");
        report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==report){
                    SavePDF_HTML reportPDF=new SavePDF_HTML(model, base, true , films);
                }
            }
        });
        addSession = new JButton("Добавить сеанс");
        addSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addSession) {
                    AddSession addSession = new AddSession(sessionInfo, base, sessionModel, sessionTable, films.getSelectedRow());
                }
            }
        });

        ticketPanel.add(addSession);
        ticketPanel.add(report);
        sessionInfo.add(ticketPanel, BorderLayout.SOUTH);
        sessionInfo.setVisible(true);
    }
}
