import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    SpaceInvaders logic;

    public GamePanel(SpaceInvaders logic) {
        this.logic = logic;
        this.setBackground(Color.BLACK); // Espacio exterior
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar Nave
        if (logic.player != null) {
            g2d.drawImage(ResourceManager.NaveImg, logic.player.x, logic.player.y, 50, 50, null);
        }

        // Dibujar Aliens
        for (Alien a : logic.aliens) {
            if (a != null && a.vivo) {
                g2d.drawImage(ResourceManager.AlienImg, a.x, a.y, 40, 40, null);
            }
        }

        // Dibujar Bala de Nave
        for (Bala b : logic.balanave) {
            // Trazo solido para asegurar visibilidad aunque la imagen tenga transparencia
            g2d.setColor(Color.WHITE);
            g2d.fillRect(b.x, b.y, 4, 12);
        }

        // Dibujar Bala de Alien
        for (Bala b : logic.balasalien) {
            g2d.setColor(Color.RED);
            g2d.fillRect(b.x, b.y, 4, 12);
        }
    }
}