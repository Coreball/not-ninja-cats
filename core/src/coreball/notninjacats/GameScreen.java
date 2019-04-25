package coreball.notninjacats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameScreen implements Screen {

    private final NotNinjaCats game;
    private Sprite background;

    private Player player;

    public GameScreen() {
        Gdx.app.log("Game", "Creating GameScreen");
        game = NotNinjaCats.getCurrentGame();
        game.getCamera().setToOrtho(false, 1200, 800);

        background = new Sprite(new Texture(Gdx.files.internal("silk.jpg")));
        background.setSize(1200, 800);

        player = new Player();
        player.setCenter(900, 300);

        Gdx.app.log("Game", "Done creating GameScreen");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getCamera().update();

        game.getBatch().setProjectionMatrix(game.getCamera().combined);
        game.getBatch().begin();
        background.draw(game.getBatch());
        game.getFont().draw(game.getBatch(), "bad guy hp lol", 100, 700);
        game.getFont().draw(game.getBatch(), "you health: " + player.getHealth() +
                "\nexp: " + player.getExp(), 1000, 700);
        player.draw(game.getBatch());
        game.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
