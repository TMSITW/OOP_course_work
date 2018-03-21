import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketInfoSmall extends JDialog {
    JDialog addSession;
    JPanel buttonPanel;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss H");
    JButton[][] buttons = new JButton[5][5];
    GridLayout layout;
    public int rows;
    public int columns;

    public TicketInfoSmall(JDialog owner, FilmBase base, JTable films, JTable session) {
        addSession = new JDialog(owner, "Малый зал", true);
        addSession.setResizable(false);
        addSession.setSize(640, 480);
        addSession.setLocation(owner.getLocation().x + 640, owner.getLocation().y);
        layout = new GridLayout(5, 8);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(layout);
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new JButton("Р" + (i + 1) + " М" + (j + 1));
                buttonPanel.add(buttons[i][j]);
                rows = i;
                columns = j;

                if (!base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(i * 5 + j).free) {
                    buttons[i][j].setText("Занято");
                    buttons[i][j].setEnabled(false);
                }
            }

        buttons[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+0).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+0).place=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+0).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+0).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[0][0].setText("Занято");
                buttons[0][0].setEnabled(false);
            }
        });
        buttons[0][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+1).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+1).place=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+1).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+1).date=dateFormat.format(new Date());
                buttons[0][1].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[0][1].setEnabled(false);
            }
        });
        buttons[0][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+2).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+2).place=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+2).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+2).date=dateFormat.format(new Date());
                buttons[0][2].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[0][2].setEnabled(false);
            }
        });
        buttons[0][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+3).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+3).place=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+3).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+3).date=dateFormat.format(new Date());
                buttons[0][3].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[0][3].setEnabled(false);
            }
        });
        buttons[0][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+4).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+4).place=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+4).row=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(0*5+4).date=dateFormat.format(new Date());
                buttons[0][4].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[0][4].setEnabled(false);
            }
        });

        buttons[1][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+0).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+0).place=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+0).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+0).date=dateFormat.format(new Date());
                buttons[1][0].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[1][0].setEnabled(false);
            }
        });
        buttons[1][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+1).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+1).place=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+1).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+1).date=dateFormat.format(new Date());
                buttons[1][1].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[1][1].setEnabled(false);
            }
        });
        buttons[1][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+2).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+2).place=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+2).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+2).date=dateFormat.format(new Date());
                buttons[1][2].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[1][2].setEnabled(false);
            }
        });
        buttons[1][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+3).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+3).place=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+3).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+3).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[1][3].setText("Занято");
                buttons[1][3].setEnabled(false);}
        });
        buttons[1][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+4).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+4).place=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+4).row=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(1*5+4).date=dateFormat.format(new Date());
                buttons[1][4].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[1][4].setEnabled(false);
            }
        });

        buttons[2][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+0).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+0).place=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+0).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+0).date=dateFormat.format(new Date());
                buttons[2][0].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[2][0].setEnabled(false);
            }
        });
        buttons[2][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+1).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+1).place=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+1).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+1).date=dateFormat.format(new Date());
                buttons[2][1].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[2][1].setEnabled(false);
            }
        });
        buttons[2][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+2).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+2).place=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+2).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+2).date=dateFormat.format(new Date());
                buttons[2][2].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[2][2].setEnabled(false);
            }
        });
        buttons[2][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+3).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+3).place=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+3).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+3).date=dateFormat.format(new Date());
                buttons[2][3].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[2][3].setEnabled(false);
            }
        });
        buttons[2][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+4).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+4).place=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+4).row=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(2*5+4).date=dateFormat.format(new Date());
                buttons[2][4].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[2][4].setEnabled(false);
            }
        });

        buttons[3][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+0).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+0).place=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+0).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+0).date=dateFormat.format(new Date());
                buttons[3][0].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][0].setEnabled(false);
            }
        });
        buttons[3][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+1).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+1).place=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+1).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+1).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][1].setText("Занято");
                buttons[3][1].setEnabled(false);}
        });
        buttons[3][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+2).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+2).place=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+2).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+2).date=dateFormat.format(new Date());
                buttons[3][2].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][2].setEnabled(false);}
        });
        buttons[3][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+3).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+3).place=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+3).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+3).date=dateFormat.format(new Date());
                buttons[3][3].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][3].setEnabled(false);}
        });
        buttons[3][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+4).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+4).place=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+4).row=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(3*5+4).date=dateFormat.format(new Date());
                buttons[3][4].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[3][4].setEnabled(false);  }
        });

        buttons[4][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+0).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+0).place=1;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+0).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+0).date=dateFormat.format(new Date());
                buttons[4][0].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][0].setEnabled(false);  }
        });
        buttons[4][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+1).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+1).place=2;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+1).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+1).date=dateFormat.format(new Date());
                buttons[4][1].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][1].setEnabled(false);  }
        });
        buttons[4][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+2).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+2).place=3;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+2).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+2).date=dateFormat.format(new Date());
                buttons[4][2].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][2].setEnabled(false);}
        });
        buttons[4][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+3).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+3).place=4;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+3).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+3).date=dateFormat.format(new Date());
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][3].setText("Занято");
                buttons[4][3].setEnabled(false);}
        });
        buttons[4][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+4).free=false;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+4).place=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+4).row=5;
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).tickets.get(4*5+4).date=dateFormat.format(new Date());
                buttons[4][4].setText("Занято");
                base.films.get(films.getSelectedRow()).sessions.get(session.getSelectedRow()).remain-=1;
                buttons[4][4].setEnabled(false);  }
        });

        addSession.add(buttonPanel, BorderLayout.CENTER);

        addSession.setVisible(true);
    }


}
