import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWon extends JFrame {
    public GameWon() {
        setTitle("Game Won");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
       

        JLabel gameWonLabel = new JLabel("GAME WON!", SwingConstants.CENTER);
        gameWonLabel.setFont(new Font("Arial", Font.BOLD, 32));
        gameWonLabel.setForeground(Color.GREEN);
        gameWonLabel.setBackground(Color.BLACK);
        gameWonLabel.setOpaque(true);
        add(gameWonLabel, BorderLayout.CENTER);

        JButton retryButton = new JButton("FINAL LEVEL");
        retryButton.setFont(new Font("Arial", Font.BOLD, 24));
        retryButton.setBackground(Color.GREEN);
        retryButton.setForeground(Color.BLACK);
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana de Game Won
                mainspaceinvaders.main(null); // Reiniciar el juego
            }
        });
        add(retryButton, BorderLayout.SOUTH);
        retryButton.setVisible(true);

        // Agregar botón de salir al panel
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
        add(exitButton, BorderLayout.NORTH);
        exitButton.setVisible(true);
    }
}
