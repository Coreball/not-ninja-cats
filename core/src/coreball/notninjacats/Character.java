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

    public void attack(Character victim) {
        victim.hurt(getDamage());
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void hurt(int oof) {
        if(health - oof < 0) {
            health = 0;  // Prevent negative health values
        } else {
            health -= oof;
        }
    }

    public int getDamage() {
        return damage;
    }

}
