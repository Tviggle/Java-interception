package App;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Level {

    private ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource(
            "/images/screen.jpg")).getImage().getScaledInstance(1000,900, Image.SCALE_DEFAULT));

    private ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(getClass().getResource(
            "/images/wall.png")).getImage().getScaledInstance(30,31, Image.SCALE_DEFAULT));

    private ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(getClass().getResource(
            "/images/coin.png")).getImage().getScaledInstance(10,10, Image.SCALE_DEFAULT));

    static Vector ghosts= new Vector();

    static int[][] map={{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1},
                        {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
                        {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
                        {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
                        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
                        {1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1},
                        {1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1},
                        {1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1},
                        {1,1,1,1,1,2,1,1,1,0,1,0,1,1,1,2,1,1,1,1,1},
                        {0,0,0,0,1,2,1,0,0,0,0,0,0,0,1,2,1,0,0,0,0},
                        {0,0,0,0,1,2,1,0,1,1,1,1,1,0,1,2,1,0,0,0,0},
                        {0,0,0,0,1,2,0,0,1,1,1,1,1,0,0,2,1,0,0,0,0},
                        {0,0,0,0,1,2,0,0,1,1,1,1,1,0,0,2,1,0,0,0,0},
                        {0,0,0,0,1,2,1,0,1,1,1,1,1,0,1,2,1,0,0,0,0},
                        {0,0,0,0,1,2,1,0,0,0,0,0,0,0,1,2,1,0,0,0,0},
                        {0,0,0,0,1,2,1,0,1,1,1,1,1,0,1,2,1,0,0,0,0},
                        {1,1,1,1,1,2,1,0,1,1,1,1,1,0,1,2,1,1,1,1,1},
                        {1,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1},
                        {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
                        {1,2,2,2,1,2,2,2,2,2,0,2,2,2,2,2,1,2,2,2,1},
                        {1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1},
                        {1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1},
                        {1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1},
                        {1,2,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1},
                        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    Level()
    {
        JLabel tmp = new JLabel();
        tmp.setLayout(null);
        tmp.setBounds( 0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        tmp.setIcon(imageIcon);
        Frame.objects.add(tmp,0,0);
        Frame.objects.repaint();
        for(int i=0;i<27;i++)
            for(int j=0;j<21;j++)
                paint(i,j,map[i][j]);
    }

    void paint(int i,int j, int n)
    {
        switch (n)
        {
            case 1:
            {
                JLabel tmp = new JLabel();
                tmp.setLayout(null);
                int x=10+30*j;
                int y=30+30*i;
                tmp.setBounds( x, y, imageIcon1.getIconWidth(), imageIcon1.getIconHeight());
                tmp.setIcon(imageIcon1);
                Frame.objects.add(tmp,1,0);
                Frame.objects.repaint();
                break;
            }
            case 2:
            {
                int x=10+30*j+10;
                int y=30+30*i+10;
                JLabel tmp = new JLabel();
                tmp.setLayout(null);
                tmp.setBounds( x, y, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
                tmp.setIcon(imageIcon2);
                Frame.objects.add(tmp,0,0);
                Frame.objects.repaint();
                break;
            }
            case 7:
            {
                Level.map[i][j]=2;
                paint(i,j,2);
            }
            default:
            {
                /*Ghost ghost=new Ghost(map[i][j],i,j);
                ghosts.add(ghost);*/
                break;
            }
        }
    }
}
