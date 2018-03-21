import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketInfoBig extends JDialog {
    JDialog addSession;
    JPanel buttonPanel;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss H");
    JButton[][] buttons = new JButton[5][8];
    GridLayout layout;
    public int rows;
    public int columns;

    JLabel text1;
    public TicketInfoBig(){}

    public TicketInfoBig(JDialog owner, FilmBase base, JTable films, JTable session) {
        addSession = new JDialog(owner, "Большой зал", true);
        addSession.setResizable(false);
        addSession.setSize(640, 480);
        addSession.setLocation(owner.getLocation().x + 640, owner.getLocation().y);
        layout = new GridLayout(5, 8);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(layout);
        text1=new JLabel("                                                                                                      ЭКРАН");
        addSession.add(text1, BorderLayout.NORTH);
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton("Р" + (i + 1) + " М" + (j + 1));
                buttonPanel.add(buttons[i][j]);
                rows = i;
                columns = j;

                if (!base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(i * 8 + j).free) {
                    buttons[i][j].setText("Занято");
                    buttons[i][j].setEnabled(false);
                }
            }

        buttons[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+0).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+0).place=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+0).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+0).date=dateFormat.format(new Date());
                buttons[0][0].setText("Занято");
                buttons[0][0].setEnabled(false);
            }
        });
        buttons[0][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+1).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+1).place=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+1).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+1).date=dateFormat.format(new Date());
                buttons[0][1].setText("Занято");
                buttons[0][1].setEnabled(false);
            }
        });
        buttons[0][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+2).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+2).place=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+2).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+2).date=dateFormat.format(new Date());
                buttons[0][2].setText("Занято");
                buttons[0][2].setEnabled(false);
            }
        });
        buttons[0][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+3).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+3).place=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+3).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+3).date=dateFormat.format(new Date());
                buttons[0][3].setText("Занято");
                buttons[0][3].setEnabled(false);
            }
        });
        buttons[0][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+4).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+4).place=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+4).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+4).date=dateFormat.format(new Date());
                buttons[0][4].setText("Занято");
                buttons[0][4].setEnabled(false);
            }
        });
        buttons[0][5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+5).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+5).place=6;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+5).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+5).date=dateFormat.format(new Date());
                buttons[0][5].setText("Занято");
                buttons[0][5].setEnabled(false);
            }
        });
        buttons[0][6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+6).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+6).place=7;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+6).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+6).date=dateFormat.format(new Date());
                buttons[0][6].setText("Занято");
                buttons[0][6].setEnabled(false);
            }
        });
        buttons[0][7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+7).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+7).place=8;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+7).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*8+7).date=dateFormat.format(new Date());
                buttons[0][7].setText("Занято");
                buttons[0][7].setEnabled(false);
            }
        });
        buttons[1][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+0).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+0).place=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+0).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+0).date=dateFormat.format(new Date());
                buttons[1][0].setText("Занято");
                buttons[1][0].setEnabled(false);
            }
        });
        buttons[1][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+1).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+1).place=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+1).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+1).date=dateFormat.format(new Date());
                buttons[1][1].setText("Занято");
                buttons[1][1].setEnabled(false);
            }
        });
        buttons[1][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+2).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+2).place=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+2).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+2).date=dateFormat.format(new Date());
                buttons[1][2].setText("Занято");
                buttons[1][2].setEnabled(false);
            }
        });
        buttons[1][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+3).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+3).place=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+3).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+3).date=dateFormat.format(new Date());

                buttons[1][3].setText("Занято");
                buttons[1][3].setEnabled(false);}
        });
        buttons[1][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+4).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+4).place=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+4).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+4).date=dateFormat.format(new Date());
                buttons[1][4].setText("Занято");
                buttons[1][4].setEnabled(false);
            }
        });
        buttons[1][5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+5).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+5).place=6;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+5).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+5).date=dateFormat.format(new Date());
                buttons[1][5].setText("Занято");
                buttons[1][5].setEnabled(false);
            }
        });
        buttons[1][6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+6).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+6).place=7;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+6).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+6).date=dateFormat.format(new Date());
                buttons[1][6].setText("Занято");
                buttons[1][6].setEnabled(false);
            }
        });
        buttons[1][7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+7).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+7).place=8;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+7).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*8+7).date=dateFormat.format(new Date());
                buttons[1][7].setText("Занято");
                buttons[1][7].setEnabled(false);
            }
        });
        buttons[2][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+0).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+0).place=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+0).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+0).date=dateFormat.format(new Date());
                buttons[2][0].setText("Занято");
                buttons[2][0].setEnabled(false);
            }
        });
        buttons[2][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+1).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+1).place=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+1).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+1).date=dateFormat.format(new Date());
                buttons[2][1].setText("Занято");
                buttons[2][1].setEnabled(false);
            }
        });
        buttons[2][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+2).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+2).place=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+2).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+2).date=dateFormat.format(new Date());
                buttons[2][2].setText("Занято");
                buttons[2][2].setEnabled(false);
            }
        });
        buttons[2][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+3).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+3).place=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+3).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+3).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[2][3].setText("Занято");
                buttons[2][3].setEnabled(false);
            }
        });
        buttons[2][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+4).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+4).place=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+4).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+4).date=dateFormat.format(new Date());
                buttons[2][4].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[2][4].setEnabled(false);
            }
        });
        buttons[2][5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+5).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+5).place=6;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+5).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+5).date=dateFormat.format(new Date());
                buttons[2][5].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[2][5].setEnabled(false);
            }
        });
        buttons[2][6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+6).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+6).place=7;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+6).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+6).date=dateFormat.format(new Date());
                buttons[2][6].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[2][6].setEnabled(false);
            }
        });
        buttons[2][7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+7).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+7).place=8;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+7).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*8+7).date=dateFormat.format(new Date());
                buttons[2][7].setText("Занято");
                buttons[2][7].setEnabled(false);
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
            }
        });
        buttons[3][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+0).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+0).place=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+0).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+0).date=dateFormat.format(new Date());
                buttons[3][0].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][0].setEnabled(false);
            }
        });
        buttons[3][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+1).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+1).place=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+1).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+1).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][1].setText("Занято");
                buttons[3][1].setEnabled(false);}
        });
        buttons[3][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+2).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+2).place=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+2).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+2).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][2].setText("Занято");
                buttons[3][2].setEnabled(false);}
        });
        buttons[3][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+3).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+3).place=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+3).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+3).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][3].setText("Занято");
                buttons[3][3].setEnabled(false);}
        });
        buttons[3][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+4).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+4).place=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+4).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+4).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][4].setText("Занято");
                buttons[3][4].setEnabled(false);  }
        });
        buttons[3][5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+5).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+5).place=6;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+5).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+5).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][5].setText("Занято");
                buttons[3][5].setEnabled(false);}
        });
        buttons[3][6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+6).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+6).place=7;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+6).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+6).date=dateFormat.format(new Date());

                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][6].setText("Занято");
                buttons[3][6].setEnabled(false);}

        });
        buttons[3][7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+7).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+7).place=8;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+7).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*8+7).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][7].setText("Занято");
                buttons[3][7].setEnabled(false);}
        });
        buttons[4][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+0).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+0).place=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+0).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+0).date=dateFormat.format(new Date());
                buttons[4][0].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][0].setEnabled(false);  }
        });
        buttons[4][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+1).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+1).place=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+1).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+1).date=dateFormat.format(new Date());
                buttons[4][1].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][1].setEnabled(false);  }
        });
        buttons[4][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+2).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+2).place=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+2).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+2).date=dateFormat.format(new Date());
                buttons[4][2].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][2].setEnabled(false);}
        });
        buttons[4][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+3).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+3).place=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+3).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+3).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][3].setText("Занято");
                buttons[4][3].setEnabled(false);}
        });
        buttons[4][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+4).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+4).place=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+4).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+4).date=dateFormat.format(new Date());
                buttons[4][4].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][4].setEnabled(false);  }
        });
        buttons[4][5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+5).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+5).place=6;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+5).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+5).date=dateFormat.format(new Date());
                buttons[4][5].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][5].setEnabled(false);  }
        });
        buttons[4][6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+6).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+6).place=7;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+6).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+6).date=dateFormat.format(new Date());
                buttons[4][6].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][6].setEnabled(false);
            }
        });
        buttons[4][7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+7).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+7).place=8;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+7).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*8+7).date=dateFormat.format(new Date());
                buttons[4][7].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][7].setEnabled(false);}
        });
        addSession.add(buttonPanel, BorderLayout.CENTER);

        addSession.setVisible(true);
    }


}
