import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Disparo {
    private SpaceInvaders logic;
    private JPanel panel;
    public Disparo(SpaceInvaders logic, JPanel panel) {
        this.logic = logic;
        this.panel = panel;
    }
    public void setupKeyListener(JFrame frame) {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    logic.shoot();
                    panel.repaint();
                }
            }
        });
    }
}
