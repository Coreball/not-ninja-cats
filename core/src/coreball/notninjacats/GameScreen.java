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
    private Enemy enemy;
    private long lastEnemyDeathMillis;

    public GameScreen() {
        Gdx.app.log("Game", "Creating GameScreen");
        game = NotNinjaCats.getCurrentGame();
        game.getCamera().setToOrtho(false, 1200, 800);

        background = new Sprite(new Texture(Gdx.files.internal("silk.jpg")));
        background.setSize(1200, 800);

        player = new Player();
        player.setCenter(900, 300);

        enemy = randomEnemy();
        enemy.setScale(0.8f);  // make it small and put it slightly near background
        enemy.setFlip(true, false);  // to face player
        enemy.setCenter(300, 400);

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
        game.getFont().draw(game.getBatch(), "bad guy hp: " + enemy.getHealth() +
                "\ntype: " + enemy.getName(), 100, 700);
        game.getFont().draw(game.getBatch(), "you health: " + player.getHealth() +
                "\nexp: " + player.getExp(), 1000, 700);
        player.draw(game.getBatch());
        enemy.draw(game.getBatch());

        game.getBatch().end();
    }

    private Enemy randomEnemy() {
        switch((int)(Math.random() * 3)) {
            case 0:
                return new EnemyHeavy();
            case 1:
                return new EnemyMage();
            case 2:
                return new EnemyRogue();
        }
        return null;
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
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
