package App;

public class Manage extends Thread {
    public void run()
    {
        while (true) {
            if(Frame.gameOn)
            Frame.pacman.move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

