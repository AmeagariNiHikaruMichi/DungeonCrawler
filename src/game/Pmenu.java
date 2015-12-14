package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Pmenu implements Screen{

	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonResume, buttonStats, buttonExit;
	private BitmapFont white;
	private Label heading;
	
	@Override
	public void dispose() {
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		white.dispose();
	}

	@Override
	public void hide() {

		
	}

	@Override
	public void pause() {

		
	}

	@Override
	public void render(float arg0) {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Table.drawDebug(stage);
		stage.act(arg0);
		stage.draw();
	}

	@Override
	public void resize(int arg0, int arg1) {

		
	}

	@Override
	public void resume() {

		
	}

	@Override
	public void show() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		atlas = new TextureAtlas("src/assets.PMbut/button.pack");
		skin = new Skin(atlas);
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		white = new BitmapFont(Gdx.files.internal("src/assets.Font/white.fnt"), false);
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("nbutton");
		textButtonStyle.down = skin.getDrawable("pbutton");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = - 1;
		textButtonStyle.font = white;
		textButtonStyle.fontColor = Color.BLACK;
		buttonExit = new TextButton("Exit", textButtonStyle);
		buttonExit.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		buttonExit.pad(20);
		buttonResume = new TextButton("Resume", textButtonStyle);
		buttonResume.pad(20);
		buttonStats = new TextButton("Stats", textButtonStyle);
		//buttonStats.addListener(new ClickListener(){
		//	@Override
		//	public void clicked(InputEvent event, float x, float y) {
		//		((Game) Gdx.app.getApplicationListener()).setScreen(new Stats());
		//	}
		//});
		buttonStats.pad(20);
		LabelStyle headingStyle = new LabelStyle(white, Color.WHITE);
		heading = new Label("Wrath of the Ascendant", headingStyle);
		heading.setFontScale(3);

		table.add(heading);
		table.getCell(heading).spaceBottom(100);
		table.row();
		table.add(buttonResume);
		table.add(buttonStats);
		table.add(buttonExit);
		//table.debug();
		stage.addActor(table);
	}

}
