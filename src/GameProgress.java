import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String path, GameProgress state) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
           // byte[] buffer = this.toString().getBytes();
           // fout.write(buffer, 0, buffer.length);
            oos.writeObject(state);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}