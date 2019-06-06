package coreball.notninjacats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {

    private final NotNinjaCats game;
    private Sprite background;

    private Player player;
    private Enemy enemy;
    private long lastEnemyDeathMillis;
    private Sound hit;
    private Sound oof;
    private Sound appear;
    private Sound die;

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

        hit = Gdx.audio.newSound(Gdx.files.internal("hit.mp3"));
        oof = Gdx.audio.newSound(Gdx.files.internal("oof.mp3"));
        appear = Gdx.audio.newSound(Gdx.files.internal("appear.mp3"));
        die = Gdx.audio.newSound(Gdx.files.internal("die.mp3"));
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

        // Check for death
        if(enemy.getHealth() <= 0 && !enemy.isDead()) {
            Gdx.app.log("Game", "Enemy died");
            enemy.die();
            player.addExp(10);
            lastEnemyDeathMillis = TimeUtils.millis();
            playDie();
        }
        if(player.getHealth() <= 0) {
            Gdx.app.log("Game", "Player died");
            game.setScreen(new EndScreen());  // the end!
        }

        // Check respawn
        if(enemy.isDead() && TimeUtils.timeSinceMillis(lastEnemyDeathMillis) >= 2000) {
            playAppear();
            enemy = randomEnemy();  // make a new enemy 2000ms after last one died
            enemy.setScale(0.8f);  // make it small and put it slightly near background
            enemy.setFlip(true, false);  // to face player
            enemy.setCenter(300, 400);
        }

        // Enemy attack if delay period passed
        if(TimeUtils.timeSinceMillis(enemy.getLastAttackMillis()) > enemy.getAttackDelay() && !enemy.isDead()) {
            Gdx.app.log("Game", "Enemy attacking");
            playOof();
            enemy.attack(player);
            enemy.setLastAttackMillis(TimeUtils.millis());
            player.setScale(0.95f);
        }
        if(player.getScaleX() != 1 && TimeUtils.timeSinceMillis(enemy.getLastAttackMillis()) > 100) {
            player.setScale(1);
        }

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
                Gdx.app.log("Game", "Spawned Heavy");
                return new EnemyHeavy();
            case 1:
                Gdx.app.log("Game", "Spawned Mage");
                return new EnemyMage();
            case 2:
                Gdx.app.log("Game", "Spawned Rogue");
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

    public void playHit() {
        hit.play();  // Play sound for player hit enemy
    }

    public void playOof() {
        oof.play();  // Play sound for player was hurt
    }

    public void playAppear() {
        appear.play();
    }

    public void playDie() {
        die.play();
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
