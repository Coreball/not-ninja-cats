package coreball.notninjacats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class EnemyMage extends Character {

    public static final Texture TEXTURE = new Texture(Gdx.files.internal("Mage.png"));

    public EnemyMage() {
        super(TEXTURE, "mister mage", 60, 15);
    }

}
