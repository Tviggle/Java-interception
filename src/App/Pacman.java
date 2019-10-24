package App;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Pacman implements Serializable {

    int i=10,j=10,x,y;
    JLabel tmp;

    boolean animation=true;

    boolean direction1=false,direction2=false,direction3=false,direction4=false;

    private ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource(
            "/images/pacman1.png")).getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));

    private ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(getClass().getResource(
            "/images/pacman2.png")).getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));

    private ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(getClass().getResource(
            "/images/screen.jpg")).getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));

    Pacman()
    {
        tmp = new JLabel();
        tmp.setLayout(null);
        int x=10+30*this.j;
        int y=30+30*this.i;
        this.x=x;
        this.y=y;
        tmp.setBounds( x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        tmp.setIcon(imageIcon);
        Frame.objects.add(tmp,3,0);
        Frame.objects.repaint();
    }

    void trace(int i,int j)
    {
        JLabel tmp = new JLabel();
        tmp.setLayout(null);
        int x=10+30*j;
        int y=30+30*i;
        tmp.setBounds( x, y, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        tmp.setIcon(imageIcon2);
        Frame.objects.add(tmp,1,0);
        if(animation) {
            this.tmp.setIcon(imageIcon1);
            animation=false;
        }
        else
        {
            this.tmp.setIcon(imageIcon);
            animation=true;
        }
        Frame.score.setText("Score: "+Frame.Score);
        Frame.objects.repaint();
    }

    void move()
    {
        if(direction1)
        {
            if(Level.map[this.i][this.j-1]!=1)
            {
                if(Level.map[this.i][this.j-1]==2)
                    Frame.Score+=50;
                if(Level.map[this.i][this.j]!=0)
                Level.map[this.i][this.j]=7;
                trace(this.i,this.j);
                this.j--;
                int x=10+30*this.j;
                while(x!=this.x)
                {
                    if(!Frame.gameOn)
                        break;
                    this.x--;
                    tmp.setBounds(this.x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
         if(direction2)
        {
            if(Level.map[this.i-1][this.j]!=1)
            {
                if(Level.map[this.i-1][this.j]==2)
                    Frame.Score+=50;
                if(Level.map[this.i][this.j]!=0)
                Level.map[this.i][this.j]=7;
                trace(this.i,this.j);
                this.i--;
                int y=30+30*this.i;
                while(y!=this.y)
                {
                    if(!Frame.gameOn)
                        break;
                    this.y--;
                    tmp.setBounds(x, this.y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if(direction3)
        {
            if(Level.map[this.i][this.j+1]!=1)
            {
                if(Level.map[this.i][this.j+1]==2)
                    Frame.Score+=50;
                if(Level.map[this.i][this.j]!=0)
                Level.map[this.i][this.j]=7;
                trace(this.i,this.j);
                this.j++;
                int x=10+30*this.j;
                while(x!= this.x)
                {
                    if(!Frame.gameOn)
                        break;
                    this.x++;
                    tmp.setBounds(this.x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if(direction4)
        {
            if(Level.map[this.i+1][this.j]!=1)
            {
                if(Level.map[this.i+1][this.j]==2)
                    Frame.Score+=50;
                if(Level.map[this.i][this.j]!=0)
                Level.map[this.i][this.j]=7;
                trace(this.i,this.j);
                this.i++;
                int y=30+30*this.i;
                while(y!=this.y)
                {
                    if(!Frame.gameOn)
                        break;
                    this.y++;
                    tmp.setBounds(x, this.y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
