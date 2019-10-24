package App;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Controls {

    boolean isRunning=false;

    Controls()
    {
        Frame.frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                DB db= new DB(Frame.record.rating);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("src/records.ser");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(db);
                    fileOutputStream.close();
                    objectOutputStream.close();
                }
                catch (Exception e1){e1.printStackTrace();}
                System.exit(0);
            }
        });

        Frame.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_LEFT)
                {
                    Frame.pacman.direction1 = true;
                }
                if(e.getKeyCode()== KeyEvent.VK_UP)
                {
                    Frame.pacman.direction2=true;
                }
                if(e.getKeyCode()== KeyEvent.VK_RIGHT)
                {
                    Frame.pacman.direction3 = true;
                }
                if(e.getKeyCode()== KeyEvent.VK_DOWN)
                {
                    Frame.pacman.direction4=true;
                }
                if((e.getKeyCode()== KeyEvent.VK_SPACE)&&(!isRunning))
                {
                    Frame.gameOn=true;
                    isRunning=true;
                    Frame.objects.remove(Frame.start);
                }

                if((e.getKeyCode()== KeyEvent.VK_T)&&(!Frame.gameOn))
                {
                    Frame.record.show();
                }

                if((e.getKeyCode()== KeyEvent.VK_R)&&(isRunning)&&(!Frame.gameOn))
                {
                    Frame.objects.removeAll();
                    Level.ghosts.clear();
                    Ghost.shutdown=true;
                    Frame.level =new Level();
                    Frame.pacman=new Pacman();
                    Level.ghosts.add( Frame.pacman);
                    Frame.pinky= new Ghost(6,25,19);
                    Level.ghosts.add( Frame.pinky);
                    Frame.blinky=new Ghost(3,1,1);
                    Level.ghosts.add( Frame.blinky);
                    Frame.inky=new Ghost(5,25,1);
                    Level.ghosts.add( Frame.inky);
                    Frame.clyde=new Ghost(4,1,19);
                    Level.ghosts.add( Frame.clyde);
                    Frame.Score=0;
                    Frame.score.setText("Score: "+Frame.Score);
                    Frame.objects.add(Frame.score,3,0);
                    Frame.objects.repaint();
                    Ghost.shutdown=false;
                    Frame.gameOn=true;
                    Frame.pinky.start();
                    Frame.blinky.start();
                    Frame.inky.start();
                    Frame.clyde.start();
                }

                if(e.getKeyCode()== KeyEvent.VK_S)
                {
                    SavedApp sap = new SavedApp(Frame.objects,Frame.pacman,Frame.pinky,Frame.inky,Frame.blinky,Frame.clyde,Frame.score,Frame.Score);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream("src/save.ser");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        objectOutputStream.writeObject(sap);
                        fileOutputStream.close();
                        objectOutputStream.close();
                    }
                    catch (Exception e1){e1.printStackTrace();}
                }
                if(e.getKeyCode()== KeyEvent.VK_L)
                {
                    Frame.gameOn=false;
                    Frame.objects.removeAll();
                    Level.ghosts.clear();
                    Ghost.shutdown=true;
                    try {
                        FileInputStream fileInputStream = new FileInputStream("src/save.ser");
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                        SavedApp sap = (SavedApp) objectInputStream.readObject();

                        sap.Loading();
                        fileInputStream.close();
                        objectInputStream.close();
                    }
                    catch (Exception e1){e1.printStackTrace();}
                    Frame.frame.add(Frame.objects);
                    Frame.objects.add(Frame.start,4,0);
                    Frame.objects.repaint();
                    Ghost.shutdown=false;
                    Frame.blinky.start();
                    Frame.pinky.start();
                    Frame.inky.start();
                    Frame.clyde.start();
                    isRunning=false;
                }
            }
        });
        Frame.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                if(e.getKeyCode()== KeyEvent.VK_LEFT)
                {
                    Frame.pacman.direction1=false;
                }
                if(e.getKeyCode()== KeyEvent.VK_UP)
                {
                    Frame.pacman.direction2=false;
                }
                if(e.getKeyCode()== KeyEvent.VK_RIGHT)
                {
                    Frame.pacman.direction3=false;
                }
                if(e.getKeyCode()== KeyEvent.VK_DOWN)
                {
                    Frame.pacman.direction4=false;
                }
            }
        });
    }
}
