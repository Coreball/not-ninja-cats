package coreball.notninjacats.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import coreball.notninjacats.NotNinjaCats;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Not Ninja Cats";
		config.width = 1200;
		config.height = 800;
//		config.fullscreen = true;
		new LwjglApplication(new NotNinjaCats(), config);
	}
}
