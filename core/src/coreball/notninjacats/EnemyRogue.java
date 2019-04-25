package coreball.notninjacats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class EnemyRogue extends Character {

    public static final Texture TEXTURE = new Texture(Gdx.files.internal("Rogue.png"));

    public EnemyRogue() {
        super(TEXTURE, "bad rogue", 100, 8);
    }

}
