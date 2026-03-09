import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceManager {
    public static BufferedImage NaveImg;
    public static BufferedImage AlienImg;
    public static BufferedImage bulletImg;
    public static BufferedImage AlienBulletImg;

    public static void loadResources() {
        try {
            // Intenta cargar primero desde classpath y luego desde carpeta local img/
            NaveImg = ImageIO.read(getResource("/img/nave.png"));
            AlienImg = ImageIO.read(getResource("/img/alien.png"));
            bulletImg = ImageIO.read(getResource("/img/balanave.png"));
            AlienBulletImg = ImageIO.read(getResource("/img/balaalien.png"));

        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error: No se encontraron las imágenes en /resources/img/");
            e.printStackTrace();
        }
    }

    private static InputStream getResource(String classpathPath) throws IOException {
        InputStream in = ResourceManager.class.getResourceAsStream(classpathPath);
        if (in != null) {
            return in;
        }

        // Fallback para ejecución local (proyecto sin empaquetar)
        String localPath = classpathPath.startsWith("/") ? classpathPath.substring(1) : classpathPath;
        return new FileInputStream(localPath);
    }
}