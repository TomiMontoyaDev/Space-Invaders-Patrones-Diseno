import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {
    public GameMenu() {
        setTitle("Space Invaders - Menu");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        // Crear panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBackground(Color.BLACK);

        // Agregar título
        JLabel titleLabel = new JLabel("SPACE INVADERS", SwingConstants.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.CYAN);
        panel.add(titleLabel);

        // Crear botón de inicio
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.BLACK);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar el menú
                mainspaceinvaders.main(null); // Iniciar el juego
            }
        });

        // Boton de salir
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 24));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.BLACK);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Salir del juego
            }
        });

        // Boton Creditos
        JButton creditsButton = new JButton("Credits");
        creditsButton.setFont(new Font("Arial", Font.BOLD, 24));
        creditsButton.setBackground(Color.BLUE);
        creditsButton.setForeground(Color.WHITE);
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Space Invaders\nDesarrollado por Tomas Montoya y Michael Naranjo\n2026", "Credits", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Agregar botón al panel
        panel.add(startButton);
        add(panel);
        // Agregar botón de créditos al panel
        panel.add(creditsButton);
        // Agregar botón de salir al panel
         panel.add(exitButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameMenu menu = new GameMenu();
            menu.setVisible(true);
        });
    }
}