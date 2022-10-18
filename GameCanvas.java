import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class GameCanvas extends Canvas {
    public static final short WIDTH = 240;
    public static final short HEIGHT = 160;
    private final byte SCALE = 4;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferStrategy bufferStrategy;

    private Bar player;
    private Bar opponent;
    private Ball ball;

    private Control control;

    GameCanvas(Control control)
    {
        this.control = control;

        newMatch();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        addKeyListener(control);
    }

    public void render()
    {
        bufferStrategy = getBufferStrategy();
        Graphics graphics = image.getGraphics();

        if (bufferStrategy == null)
        {
            createBufferStrategy(3);
            return;
        }

        requestFocus();

        renderBackground(graphics);
        renderPlayer(graphics);
        renderBall(graphics);
        renderOpponent(graphics);

        graphics = bufferStrategy.getDrawGraphics();

        graphics.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
        bufferStrategy.show();
    }

    private void barGoRight(Bar bar)
    {
        bar.goRight();

        if (Collision.hitRightSide(bar))
        {
            bar.goLeft();
        }
    }

    private void barGoLeft(Bar bar)
    {
        bar.goLeft();

        if(Collision.hitLeftSide(bar))
        {
            bar.goRight();
        }
    }

    private void movePlayer()
    {
        if (control.getRightKey())
        {
            barGoRight(player);
        }

        if(control.getLeftKey())
        {
            barGoLeft(player);
        }
    }

    private void moveOpponent()
    {
        double x = ball.getX() * 0.7;

        if (x > opponent.getX())
        {
            barGoRight(opponent);

            return;
        }

        if (x < opponent.getX())
        {
            barGoLeft(opponent);
        }
    }

    private void renderBackground(Graphics graphics)
    {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    private void renderOpponent(Graphics graphics)
    {
        moveOpponent();

        graphics.setColor(opponent.COLOR);
        graphics.fillRect(opponent.getX(), opponent.getY(), opponent.WIDTH, opponent.HEIGHT);
    }

    private void renderPlayer(Graphics graphics)
    {
        movePlayer();

        graphics.setColor(player.COLOR);
        graphics.fillRect(player.getX(), player.getY(), player.WIDTH, player.HEIGHT);
    }

    private void renderBall(Graphics graphics)
    {
        ball.move();

        if (Collision.hitTheBottom(ball))
        {
            System.out.println("Opponent's point!");

            newMatch();

            return;
        }

        if (Collision.hitTheTop(ball))
        {
            System.out.println("Player's point!");

            newMatch();

            return;
        }
        /*
        if (Collision.hitTheTop(ball) || Collision.hitTheBottom(ball))
        //if (Collision.hitTheTop(ball))
        {
            ball.changeYDirection();
        }
        */
        if (Collision.hitRightSide(ball) || Collision.hitLeftSide(ball))
        {
            ball.changeXDirection();
        }

        if (Collision.ballHitBar(ball, player) || Collision.ballHitBar(ball, opponent))
        {
            ball.changeYDirection();
        }

        graphics.setColor(ball.COLOR);
        graphics.fillRect(ball.getX(), ball.getY(), ball.WIDTH, ball.HEIGHT);
    }

    private void newMatch()
    {
        player = new Bar(100, 155);
        opponent = new Bar(100, 0);
        ball = new Ball(WIDTH / 2, 40);
    }
}
