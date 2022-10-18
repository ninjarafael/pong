public class Ball extends Element {
    private int dX = 1;
    private int dY = 1;

    Ball(int x, int y)
    {
        super(x, y, 5, 5);
    }

    public void move()
    {
        x += 1 * dX;
        y += 1 * dY;
    }

    public void changeXDirection()
    {
        dX *= -1;
    }

    public void changeYDirection()
    {
        dY *= -1;
    }
}
