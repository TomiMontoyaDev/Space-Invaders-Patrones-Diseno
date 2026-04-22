import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JFrame {
    public GameOver() {
        setTitle("Game Over");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel gameOverLabel = new JLabel("GAME OVER", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 32));
        gameOverLabel.setForeground(Color.RED);
        add(gameOverLabel, BorderLayout.CENTER);

        JButton retryButton = new JButton("Retry");
        retryButton.setFont(new Font("Arial", Font.BOLD, 24));
        retryButton.setBackground(Color.GREEN);
        retryButton.setForeground(Color.BLACK);
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana de Game Over
                mainspaceinvaders.main(null); // Reiniciar el juego
                setVisible(true);
            }
        });
        add(retryButton, BorderLayout.SOUTH);
        try {
            Thread.sleep(3000); // Esperar 3 segundos antes de mostrar el botón de retry
            retryButton.setVisible(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }   
}
