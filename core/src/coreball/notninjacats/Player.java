package coreball.notninjacats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Character {

    public static final Texture TEXTURE = new Texture(Gdx.files.internal("Siamese Bard.png"));
    private int exp;

    public Player() {
        super(TEXTURE, "namehere", 100, 10);
    }

    public void attack(Character victim) {
        int damage = (int)(getDamage() * (Math.random() + 0.5));
        Gdx.app.log("Game", "Player attack for: " + damage);
        victim.hurt(damage);
    }

    public int getExp() {
        return exp;
    }

    public void addExp(int exp) {
        this.exp += exp;
    }

}
