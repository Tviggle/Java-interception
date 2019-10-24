package App;

import javax.swing.*;
import java.io.Serializable;

public class SavedApp implements Serializable
{
    private static final long serialVersionUID = 1;

    private JLayeredPane objects;
    private Pacman pacman;
    private Ghost pinky,blinky,inky,clyde;
    private JLabel score;

    private int Score;
    SavedApp(JLayeredPane o, Pacman p, Ghost pin,Ghost in,Ghost b,Ghost c,JLabel s,int S)
    {
        objects=o;
        pacman=p;
        pinky=pin;
        blinky=b;
        inky=in;
        clyde=c;
        score=s;
        Score=S;
    }

    public void Loading()
    {
        Frame.objects=objects;
        Frame.pacman=pacman;
        Frame.pinky=pinky;
        Frame.blinky=blinky;
        Frame.inky=inky;
        Frame.clyde=clyde;
        Frame.score=score;
        Frame.Score=Score;
    }
}

