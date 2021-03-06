package coreball.notninjacats;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public class Input implements InputProcessor {

    private final NotNinjaCats game;
    private Vector3 touchPos;

    public Input() {
        Gdx.app.log("Game", "Creating Input");
        game = NotNinjaCats.getCurrentGame();
        touchPos = new Vector3();
        Gdx.app.log("Game", "Creating Input");
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

        if(game.getScreen() instanceof MenuScreen) {
            game.setScreen(new GameScreen());  // on click start game
        }

        else if(game.getScreen() instanceof GameScreen) {
            GameScreen gameScreen = (GameScreen) game.getScreen();
            gameScreen.getPlayer().attack(gameScreen.getEnemy());  // have player attack enemy
            if(!gameScreen.getEnemy().isDead()) {
                gameScreen.getEnemy().setScale(0.75f);  // depress if actually got hurt
                gameScreen.playHit();
            }
        }

        else if(game.getScreen() instanceof EndScreen) {
            game.setScreen(new GameScreen());  // play again
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(game.getScreen() instanceof GameScreen) {
            GameScreen gameScreen = (GameScreen) game.getScreen();
            gameScreen.getEnemy().setScale(0.8f);  // undepress when release mouse
        }

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
