package coreball.notninjacats;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Character extends Sprite {

    // does this even have to be abstract though

    private String name;
    private int health;
    private int damage;

    public Character(Texture tex, String name, int health, int damage) {
        super(tex);
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void hurt(int oof) {
        health -= oof;
    }

    public int getDamage() {
        return damage;
    }
}
