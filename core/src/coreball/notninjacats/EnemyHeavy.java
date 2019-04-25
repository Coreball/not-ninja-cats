package coreball.notninjacats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class EnemyHeavy extends Character {

    public static final Texture TEXTURE = new Texture(Gdx.files.internal("Heavy.png"));

    public EnemyHeavy() {
        super(TEXTURE, "big fat heavy", 200, 5);
    }

}
