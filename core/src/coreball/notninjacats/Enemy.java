package coreball.notninjacats;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

public class Enemy extends Character {

    private long lastAttackMillis;
    private int attackDelay;
    private boolean isDead;

    public Enemy(Texture tex, String name, int health, int damage, int attackDelay) {
        super(tex, name, health, damage);
        this.attackDelay = attackDelay;
        lastAttackMillis = TimeUtils.millis();
    }

    public long getLastAttackMillis() {
        return lastAttackMillis;
    }

    public void setLastAttackMillis(long lastAttackMillis) {
        this.lastAttackMillis = lastAttackMillis;
    }

    public int getAttackDelay() {
        return attackDelay;
    }

    public boolean isDead() {
        return isDead;
    }

    public void die(){
        setRotation((float)Math.random() * 90);
        isDead = true;
    }

}
