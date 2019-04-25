package coreball.notninjacats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MenuScreen implements Screen {

    private final NotNinjaCats game;
    private Sprite background;

    public MenuScreen() {
        Gdx.app.log("Game", "Creating MenuScreen");
        game = NotNinjaCats.getCurrentGame();
        game.getCamera().setToOrtho(false, 1200, 800);

        background = new Sprite(new Texture(Gdx.files.internal("writing.jpg")));
        background.setSize(1200, 800);
        Gdx.app.log("Game", "Done creating MenuScreen");
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
        game.getFont().draw(game.getBatch(), "absolutely not ninja cats\n" +
                "click 2 hurt baddie\n" +
                "Well, in the Ninja Cat Clan, we specialize in the skills of\n" +
                "[insert multiple skills relevant to each cat class]\n" +
                "click anywhere to continue", 200, 600);
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
