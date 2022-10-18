import java.awt.Rectangle;

public class Collision {
    public static boolean hitRightSide(Element element)
    {
        double size = element.getX() + element.WIDTH;

        return size >= GameCanvas.WIDTH;
    }

    public static boolean hitLeftSide(Element element)
    {
        return element.getX() < 0;
    }

    public static boolean hitTheTop(Element element)
    {
        return element.getY() <= 0;
    }

    public static boolean hitTheBottom(Element element)
    {
        return element.getY() > GameCanvas.HEIGHT;
    }

    public static boolean ballHitBar(Ball ball, Bar bar)
    {
        Rectangle ballRectangle = new Rectangle(ball.getX(), ball.getY(), ball.WIDTH, ball.HEIGHT);
        Rectangle barRectangle = new Rectangle(bar.getX(), bar.getY(), bar.WIDTH, bar.HEIGHT);

        return ballRectangle.intersects(barRectangle);
    }
}
