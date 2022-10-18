import java.awt.Color;

public class Element {
    public final Color COLOR = Color.WHITE;
    public final int WIDTH;
    public final int HEIGHT;

    protected int x;
    protected int y;

    Element(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        WIDTH = width;
        HEIGHT = height;
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
