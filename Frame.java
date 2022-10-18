import javax.swing.JFrame;

public class Frame extends JFrame {
    Frame(GameCanvas gameCanvas)
    {
        add(gameCanvas);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
