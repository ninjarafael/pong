public class Game implements Runnable {
    private GameCanvas gameCanvas;

    Game()
    {
        gameCanvas = new GameCanvas(new Control());
        new Frame(gameCanvas);
    }

    public void run()
    {
        //int fps = 60;
        int fps = 30;
        long ns = 1_000_000_000/fps;
        int speed = 4;
        double ns_speed = ns / speed;
        long now;
        long lastTime = System.nanoTime();

        while(true)
        {
            now = System.nanoTime();

            if ((now - lastTime) >= ns_speed) {
                gameCanvas.render();

                lastTime = now;
            }
        }
    }
}
