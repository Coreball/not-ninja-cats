package coreball.notninjacats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class EndScreen implements Screen {

    private final NotNinjaCats game;
    private Sprite background;

    public EndScreen() {
        Gdx.app.log("Game", "Creating EndScreen");
        game = NotNinjaCats.getCurrentGame();
        game.getCamera().setToOrtho(false, 1200, 800);

        background = new Sprite(new Texture(Gdx.files.internal("writing.jpg")));
        background.setSize(1200, 800);
        Gdx.app.log("Game", "Done creating EndScreen");
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
        game.getFont().draw(game.getBatch(), "yOu DiEd" +
                "\n\nclick anywhere to play aGaIn", 200, 600);
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
