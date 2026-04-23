import java.util.ArrayList;

public class SpaceInvaders {

    public Nave player;
    public ArrayList<Alien> aliens;
    public ArrayList<Bala> balanave;
    public ArrayList<Bala> balasalien;
    private int alienDirection = 1; // 1 para derecha, -1 para izquierda
    private boolean gameOver = false;
    private boolean gameWon = false;
    private final long playerShootCooldownMs = 700;
    private final long alienShootCooldownMs = 900;
    private long lastPlayerShotTime = 0L;

    public SpaceInvaders() {

        player = new Nave();

        aliens = new ArrayList<>();

        aliens.add(new Alien(100, 100));
        aliens.add(new Alien(200, 100));
        aliens.add(new Alien(300, 100));
        aliens.add(new Alien(400, 100));
        aliens.add(new Alien(500, 100));
        aliens.add(new Alien(600, 100));
        aliens.add(new Alien(700, 100));

        balanave = new ArrayList<>();
        balasalien = new ArrayList<>();
    }

    public void shoot() {
        long now = System.currentTimeMillis();
        if (now - lastPlayerShotTime < playerShootCooldownMs) {
            return;
        }

        // Crear una bala desde la posición de la nave
        Bala nuevaBala = new Bala(player.x + 20, player.y); // Ajusta el x para que salga del centro de la nave
        balanave.add(nuevaBala);
        lastPlayerShotTime = now;
    }

    public void update() {
        if (gameOver || gameWon) {
            return;
        }

        // Mover balas de la nave hacia arriba
        for (int i = 0; i < balanave.size(); i++) {
            Bala b = balanave.get(i);
            b.y -= 10;

            // Colisión con Aliens
            for (Alien a : aliens) {
                if (a.vivo && b.x > a.x && b.x < a.x + 40 && b.y > a.y && b.y < a.y + 40) {
                    a.vivo = false;
                    player.score += 100;
                    balanave.remove(i);
                    i--;
                    break;
                }
            }

            // Eliminar balas fuera de pantalla
            if (i >= 0 && b.y < 0) {
                balanave.remove(i);
                i--;
            }
        }

        // Mover balas de los aliens hacia abajo
        for (int i = 0; i < balasalien.size(); i++) {
            Bala b = balasalien.get(i);
            b.y += 10;
            // Colisión con la nave
            if (b.x > player.x && b.x < player.x + 50 && b.y > player.y && b.y < player.y + 50) {
                System.out.println("¡La nave ha sido alcanzada!");
                balasalien.remove(i);
                i--;
                player.vidas--;
            }
            // Eliminar balas fuera de pantalla
            if (i >= 0 && b.y > 600) {
                balasalien.remove(i);
                i--;
            }
        }

        // Mover Aliens
        for (Alien a : aliens) {
            if (a.vivo) {
                a.x += (3 * alienDirection);
            }
        }

        // Si algún alien toca el borde, todos bajan y cambian de dirección
        boolean tocarBorde = false;
        for (Alien a : aliens) {
            if (a.vivo && (a.x > 750 || a.x < 0)) {
                tocarBorde = true;
                break;
            }
        }

        if (tocarBorde) {
            alienDirection *= -1;
            for (Alien a : aliens) {
                a.y += 5;
            }
        }

        // Aliens disparan aleatoriamente       
        long now = System.currentTimeMillis();
        for (Alien a : aliens) {
            if (a.vivo && a.canShoot(now, alienShootCooldownMs) && Math.random() < 0.01) { // 1% de probabilidad por actualización
                Bala balaAlien = new Bala(a.x + 18, a.y + 40); // Ajusta para que salga del centro del alien
                balasalien.add(balaAlien);
                a.registerShot(now);
            }
        }   

        // Eliminar aliens muertos
        for (int i = 0; i < aliens.size(); i++) {
            if (!aliens.get(i).vivo) {
                aliens.remove(i);
                i--;
            }
        }

        // Ganar si todos los aliens son muertos
        if (aliens.isEmpty()) {
            System.out.println("¡Has ganado!");
            gameWon = true;
            return;
        }

        // Perder si la nave se sale de la pantalla
        if (player.y < 0) {
            player.vidas--;
            if (player.vidas <= 0) {
                gameOver = true;
            }
        }

        // Perder si la nave se choca con un alien
        for (Alien a : aliens) {
            if (a.vivo && a.x > player.x && a.x < player.x + 50 && a.y > player.y && a.y < player.y + 50) {
                player.vidas--;
                if (player.vidas <= 0) {
                    gameOver = true;
                    return;
                }
            }
        }

        // Verificar vidas
        if (player.vidas <= 0) {   
            gameOver = true;
        }

        // Delay en balas para evitar que se disparen demasiado rápido
        
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void updateBullets() {
        // Metodo mantenido por compatibilidad. El cooldown ya se controla con timestamps.
    }
}