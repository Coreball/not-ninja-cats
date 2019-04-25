package coreball.notninjacats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Character {

    public static final Texture TEXTURE = new Texture(Gdx.files.internal("Siamese Bard.png"));
    private int exp;

    public Player() {
        super(TEXTURE, "namehere", 100, 10);
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}
