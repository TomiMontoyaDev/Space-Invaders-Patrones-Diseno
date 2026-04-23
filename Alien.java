public class Alien {
    public int x;
    public int y;
    public boolean vivo = true;
    public long lastShotTime = 0L;

    public Alien(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean canShoot(long now, long cooldownMs) {
        return now - lastShotTime >= cooldownMs;
    }

    public void registerShot(long now) {
        lastShotTime = now;
    }
}