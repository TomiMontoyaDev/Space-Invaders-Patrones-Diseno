import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class mainspaceinvaders {
    public static void main(String[] args) {
        // 1. Cargar imágenes
        ResourceManager.loadResources();

        // 2. Inicializar lógica
        SpaceInvaders gameLogic = new SpaceInvaders();

        // 3. Crear ventana
        JFrame frame = new JFrame("Space Invaders");
        GamePanel panel = new GamePanel(gameLogic);

        // 4. Configurar controles con Key Bindings (mas fiable que KeyListener)
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "shoot");

        panel.getActionMap().put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLogic.player.x -= 30;
                panel.repaint();
            }
        });

        panel.getActionMap().put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLogic.player.x += 30;
                panel.repaint();
            }
        });

        panel.getActionMap().put("shoot", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLogic.shoot();
                panel.repaint();
            }
        });

        gameLogic.shoot();
        
        
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocusInWindow();

        // 6. Bucle del juego (Game Loop)
        Timer timer = new Timer(30, e -> {
            gameLogic.update();
            panel.repaint();
        });
        timer.start();
        
        System.out.println("Motor grafico iniciado...");
    }
}