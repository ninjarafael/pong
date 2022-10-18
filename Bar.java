public class Bar extends Element {
    Bar(int x, int y)
    {
        super(x, y, 40, 5);
    }

    public void goRight()
    {
        x++;
    }

    public void goLeft()
    {
        x--;
    }
}
