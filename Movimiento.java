import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Movimiento {
    private SpaceInvaders logic;
    private JPanel panel;

    public Movimiento(SpaceInvaders logic, JPanel panel) {
        this.logic = logic;
        this.panel = panel;
    }
    
    public void setupKeyListener(JFrame frame) {

    frame.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    logic.player.x -= 30;
                    break;
                case KeyEvent.VK_RIGHT:
                    logic.player.x += 30;
                    break;
                default:
                    break;
            }
            panel.repaint();
        }
    });
}}
