package App;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Random;

public class Ghost extends Thread implements Serializable {

    int i,j,x,y;
    JLabel tmp;

    static boolean shutdown=false;

    boolean direction1=false,direction2=false,direction3=false,direction4=false;

    private ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource(
            "/images/Blinky.jpg")).getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));

    private ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(getClass().getResource(
            "/images/Clyde.jpg")).getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));

    private ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(getClass().getResource(
            "/images/Inky.jpg")).getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));

    private ImageIcon imageIcon3 = new ImageIcon(new ImageIcon(getClass().getResource(
            "/images/Pinky.jpg")).getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));

    public void run()
    {
        while (!shutdown) {
            if(Frame.gameOn) {
                this.change();
                this.move();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Ghost(int n,int i,int j)
    {
        switch(n){
            case 3: {
                tmp = new JLabel();
                tmp.setLayout(null);
                this.i=i;
                this.j=j;
                int x = 10 + 30 * this.j;
                int y = 30 + 30 * this.i;
                this.x = x;
                this.y = y;
                this.direction3=true;
                tmp.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
                tmp.setIcon(imageIcon);
                Frame.objects.add(tmp, 2, 0);
                Frame.objects.repaint();
                break;
            }
            case 4:
            {
                tmp = new JLabel();
                tmp.setLayout(null);
                this.i=i;
                this.j=j;
                int x = 10 + 30 * this.j;
                int y = 30 + 30 * this.i;
                this.x = x;
                this.y = y;
                this.direction4=true;
                tmp.setBounds(x, y, imageIcon1.getIconWidth(), imageIcon1.getIconHeight());
                tmp.setIcon(imageIcon1);
                Frame.objects.add(tmp, 2, 0);
                Frame.objects.repaint();
                break;
            }
            case 5:
            {
                tmp = new JLabel();
                tmp.setLayout(null);
                this.i=i;
                this.j=j;
                int x = 10 + 30 * this.j;
                int y = 30 + 30 * this.i;
                this.x = x;
                this.y = y;
                this.direction2=true;
                tmp.setBounds(x, y, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
                tmp.setIcon(imageIcon2);
                Frame.objects.add(tmp, 2, 0);
                Frame.objects.repaint();
                break;
            }
            case 6:
            {
                tmp = new JLabel();
                tmp.setLayout(null);
                this.i=i;
                this.j=j;
                int x = 10 + 30 * this.j;
                int y = 30 + 30 * this.i;
                this.x = x;
                this.y = y;
                this.direction1=true;
                tmp.setBounds(x, y, imageIcon3.getIconWidth(), imageIcon3.getIconHeight());
                tmp.setIcon(imageIcon3);
                Frame.objects.add(tmp, 2, 0);
                Frame.objects.repaint();
            }
        }
    }

    void change() {
        int n = 0;
        boolean isNeed=true;
        if (direction1&&isNeed) {
            if (Level.map[this.i][this.j - 1] != 1)
                n++;
            if (Level.map[this.i + 1][this.j] != 1)
                n++;
            if (Level.map[this.i - 1][this.j] != 1)
                n++;
            Random random = new Random();
            int i = random.nextInt(100);
            for (; ; ) {

                if (Level.map[this.i][this.j - 1] != 1) {
                    i -= 100 / n;
                    if (i <= 0)
                    {
                        isNeed = false;
                        break;
                    }
                }
                if (Level.map[this.i - 1][this.j] != 1) {
                    i -= 100 / n;
                    if (i <= 0) {
                        direction1 = false;
                        direction2 = true;
                        isNeed=false;
                        break;
                    }
                }
                if (Level.map[this.i + 1][this.j] != 1) {
                    i =i - (100 / n);
                    if (i <= 0) {
                        direction1 = false;
                        direction4 = true;
                        isNeed=false;
                        break;
                    }
                }
            }
        }

        if (direction2&&isNeed) {
            if (Level.map[this.i][this.j - 1] != 1)
                n++;
            if (Level.map[this.i][this.j+1] != 1)
                n++;
            if (Level.map[this.i-1][this.j] != 1)
                n++;
            Random random = new Random();
            int i = random.nextInt(100);
            for (; ; )
            {
                if (Level.map[this.i-1][this.j] != 1) {
                    i -= 100 / n;
                    if (i <= 0)
                    {
                        isNeed=false;
                        break;
                    }

                }
                if (Level.map[this.i][this.j+1] != 1) {
                    i -= 100 / n;
                    if (i <= 0) {
                        direction2 = false;
                        direction3 = true;
                        isNeed=false;
                        break;
                    }
                }
                if (Level.map[this.i][this.j-1] != 1) {
                    i -= 100 / n;
                    if (i <= 0) {
                        direction2 = false;
                        direction1 = true;
                        isNeed=false;
                        break;
                    }
                }
            }
        }
        if (direction3&&isNeed) {
            if (Level.map[this.i+1][this.j] != 1)
                n++;
            if (Level.map[this.i][this.j+1] != 1)
                n++;
            if (Level.map[this.i-1][this.j] != 1)
                n++;
            Random random = new Random();
            int i = random.nextInt(100);
            for (; ; )
            {
                if (Level.map[this.i][this.j+1] != 1) {
                    i -= 100 / n;
                    if (i <= 0)
                    {
                        isNeed = false;
                        break;
                    }
                }
                if (Level.map[this.i+1][this.j] != 1) {
                    i -= 100 / n;
                    if (i <= 0) {
                        direction3 = false;
                        direction4 = true;
                        isNeed=false;
                        break;
                    }
                }
                if (Level.map[this.i-1][this.j] != 1) {
                    i -= 100 / n;
                    if (i <= 0) {
                        direction3 = false;
                        direction2 = true;
                        isNeed=false;
                        break;
                    }
                }
            }
        }
        if (direction4&&isNeed) {
            if (Level.map[this.i][this.j - 1] != 1)
                n++;
            if (Level.map[this.i][this.j + 1] != 1)
                n++;
            if (Level.map[this.i+1][this.j] != 1)
                n++;
            Random random = new Random();
            int i = random.nextInt(100);
            for (; ; )
            {
                if (Level.map[this.i+1][this.j] != 1) {
                    i -= 100 / n;
                    if (i <= 0)
                    {
                        isNeed = false;
                        break;
                    }
                }
                if (Level.map[this.i][this.j+1] != 1) {
                    i -= 100 / n;
                    if (i <= 0) {
                        direction4 = false;
                        direction3 = true;
                        isNeed=false;
                        break;
                    }
                }
                if (Level.map[this.i][this.j-1] != 1) {
                    i -= 100 / n;
                    if (i <= 0) {
                        direction4 = false;
                        direction1 = true;
                        isNeed=false;
                        break;
                    }
                }
            }
        }
    }


    void move() {
        if (direction1) {
            this.j--;
            int x = 10 + 30 * this.j;
            while (x != this.x) {
                this.x--;
                tmp.setLocation(this.x, y);
                if((this.x < Frame.pacman.x+15)&&(this.y == Frame.pacman.y)&&(Frame.pacman.x<this.x)) {
                    Frame.gameOn = false;
                    Frame.record.save();
                    Frame.objects.add(Frame.restart,4,0);
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (direction2) {
            this.i--;
            int y = 30 + 30 * this.i;
            while (y != this.y) {
                this.y--;
                tmp.setLocation(x, this.y);
                if((this.y < Frame.pacman.y+15)&&(this.x == Frame.pacman.x)&&(Frame.pacman.y<this.y)) {
                    Frame.gameOn = false;
                    Frame.record.save();
                    Frame.objects.add(Frame.restart,4,0);
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (direction3) {
            this.j++;
            int x = 10 + 30 * this.j;
            while (x != this.x) {
                this.x++;
                tmp.setLocation(this.x, y);
                if((this.x+15 > Frame.pacman.x)&&(this.y == Frame.pacman.y)&&(Frame.pacman.x >this.x)) {
                    Frame.gameOn = false;
                    Frame.record.save();
                    Frame.objects.add(Frame.restart,4,0);
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (direction4) {
            this.i++;
            int y = 30 + 30 * this.i;
            while (y != this.y) {
                this.y++;
                tmp.setLocation(x, this.y);
                if((this.y+15 > Frame.pacman.y)&&(this.x == Frame.pacman.x)&&(Frame.pacman.y>this.y)) {
                    Frame.gameOn = false;
                    Frame.record.save();
                    Frame.objects.add(Frame.restart,4,0);
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    }

