package coreball.notninjacats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class EnemyHeavy extends Enemy {

    public static final Texture TEXTURE = new Texture(Gdx.files.internal("Heavy.png"));

    public EnemyHeavy() {
        super(TEXTURE, "big fat heavy", 150, 5, 5000);
    }

}
