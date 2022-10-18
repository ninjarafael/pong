import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements KeyListener{
    private boolean rightKey = false;
    private boolean leftKey = false;

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT :
                rightKey = true;
            break;

            case KeyEvent.VK_LEFT :
                leftKey = true;
            break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT :
                rightKey = false;
            break;

            case KeyEvent.VK_LEFT :
                leftKey = false;
            break;
        }
    }

    public boolean getRightKey() { return rightKey; }

    public boolean getLeftKey() { return leftKey; }
}
