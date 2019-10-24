package App;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Frame {
    static public JFrame frame= new JFrame("Pacman");
    static public JLayeredPane objects = new JLayeredPane();
    static Level level;
    static Pacman pacman;
    static Ghost pinky,blinky,inky,clyde;

    static Rate record=new Rate();

    static int Score=0;

    static boolean gameOn=false;

    static JLabel score=new JLabel("Score: "+ Score),start=new JLabel("Нажмите пробел, чтобы начать игру"),
    restart=new JLabel("Нажмите R, чтобы начать заново"),save= new JLabel("S - Сохранить игру"),
            load= new JLabel("L - Загрузить игру"), table= new JLabel("T - Показать рейтинг");

    static public int WIDTH= 1000, HEIGHT = 900;

    Frame()
    {

        try {
            FileInputStream fileInputStream = new FileInputStream("src/records.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            DB db = (DB) objectInputStream.readObject();
            db.load();
            fileInputStream.close();
            objectInputStream.close();
        }
        catch (Exception e1){e1.printStackTrace();}


        frame.setLayout(null);
        frame.setSize(WIDTH,HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.requestFocus();



        objects.setLayout(null);
        objects.setBounds(0,0,WIDTH,HEIGHT);

        frame.add(objects);
        Controls controls=new Controls();
        level =new Level();
        pacman=new Pacman();
        Level.ghosts.add(pacman);
        pinky= new Ghost(6,25,19);
        Level.ghosts.add(pinky);
        blinky=new Ghost(3,1,1);
        Level.ghosts.add(blinky);
        inky=new Ghost(5,25,1);
        Level.ghosts.add(inky);
        clyde=new Ghost(4,1,19);
        Level.ghosts.add(clyde);

        score.setBounds(760,100,150,50);
        Font font=new Font("TimesRoman",Font.BOLD,26);
        score.setFont(font);
        score.setForeground(Color.yellow);
        save.setFont(font);
        save.setForeground(Color.yellow);
        save.setBounds(660,200,300,50);
        load.setFont(font);
        load.setForeground(Color.yellow);
        load.setBounds(660,250,340,50);
        table.setFont(font);
        table.setForeground(Color.yellow);
        table.setBounds(660,300,300,50);
        font=new Font("TimesRoman",Font.BOLD,45);
        start.setFont(font);
        start.setBounds(100,350,850,100);
        start.setForeground(Color.RED);
        restart.setFont(font);
        restart.setBounds(100,350,850,100);
        restart.setForeground(Color.RED);
        objects.add(start,4,0);
        objects.add(score,3,0);
        objects.add(save,3,0);
        objects.add(load,3,0);
        objects.add(table,3,0);
    }

    static public void launch()
    {
        Frame frame = new Frame();
        Manage manage = new Manage();
        manage.start();
        Frame.pinky.start();
        Frame.blinky.start();
        Frame.inky.start();
        Frame.clyde.start();
    }
}
