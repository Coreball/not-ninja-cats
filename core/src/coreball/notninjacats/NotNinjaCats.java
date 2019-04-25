package coreball.notninjacats;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.TimeUtils;

public class NotNinjaCats extends Game {

	private static NotNinjaCats currentGame;
	private BitmapFont font;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	@Override
	public void create () {
		Gdx.app.log("Game", "Creating NotNinjaCats");

		long createStart = TimeUtils.millis();
		currentGame = this;
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Hack-Regular.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		font = generator.generateFont(parameter);
		generator.dispose();
		Gdx.input.setInputProcessor(new Input());
		this.setScreen(new MenuScreen());

		Gdx.app.log("Game", "Done creating NotNinjaCats in " + TimeUtils.timeSinceMillis(createStart));
	}

	public static NotNinjaCats getCurrentGame() {
		return currentGame;
	}

	public BitmapFont getFont() {
		return font;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

}
