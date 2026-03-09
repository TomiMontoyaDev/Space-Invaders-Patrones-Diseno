import java.util.ArrayList;

public class SpaceInvaders {

    public Nave player;
    public ArrayList<Alien> aliens;
    public ArrayList<Bala> balanave;
    public ArrayList<Bala> balasalien;
    private int alienDirection = 1; // 1 para derecha, -1 para izquierda

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
        // Crear una bala desde la posición de la nave
        Bala nuevaBala = new Bala(player.x + 20, player.y); // Ajusta el x para que salga del centro de la nave
        balanave.add(nuevaBala);
    }

    public void update() {
        // Mover balas de la nave hacia arriba
        for (int i = 0; i < balanave.size(); i++) {
            Bala b = balanave.get(i);
            b.y -= 10;

            // Colisión con Aliens
            for (Alien a : aliens) {
                if (a.vivo && b.x > a.x && b.x < a.x + 40 && b.y > a.y && b.y < a.y + 40) {
                    a.vivo = false;
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
    }
}