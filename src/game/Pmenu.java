package game;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

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
		atlas = new TextureAtlas("assets/PMbut/button.pack");
		skin = new Skin(atlas);
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		white = new BitmapFont(Gdx.files.internal("assets/Font/white.fnt"), false);
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("nbutton");
		textButtonStyle.down = skin.getDrawable("pbutton");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = - 1;
		textButtonStyle.font = white;
		textButtonStyle.fontColor = Color.BLACK;
		buttonExit = new TextButton("3.Exit", textButtonStyle);
		//buttonExit.addListener(new ClickListener(){
		if(Gdx.input.isKeyPressed(Input.Keys.TAB) && Gdx.input.isKeyPressed(Input.Keys.NUM_3)){
			//@Override
			//public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			//}
		}
		//});
		buttonExit.pad(20);
		buttonResume = new TextButton("1.Resume", textButtonStyle);
		if(Gdx.input.isKeyPressed(Input.Keys.TAB) && Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
			try {
    	        Robot robot = new Robot();
    	        robot.keyRelease(KeyEvent.VK_TAB);
    	        robot.keyRelease(KeyEvent.VK_1);

    	} catch (AWTException e) {
    	        e.printStackTrace();
    	}
		}
		buttonResume.pad(20);
		buttonStats = new TextButton("2.Stats", textButtonStyle);
		//buttonStats.addListener(new ClickListener(){
			//public void clicked(InputEvent event, float x, float y){
		if(Gdx.input.isKeyPressed(Input.Keys.TAB) && Gdx.input.isKeyPressed(Input.Keys.NUM_2)){
				JOptionPane.showMessageDialog(null, "Player level: " + Player.getLvl() + 
						"\nPlayer health: " + Player.getHealth() + 
						"\nPlayer attack: " + Player.getAtk() + 
						"\nPlayer defense: " + Player.getDef() + 
						"\nPlayer mana: " + Player.getMana(),
						"Stats", JOptionPane.INFORMATION_MESSAGE);
				try {
	    	        Robot robot = new Robot();
	    	        robot.keyRelease(KeyEvent.VK_2);

	    	} catch (AWTException e) {
	    	        e.printStackTrace();
	    	}
			}
		//});
		buttonStats.pad(20);
		LabelStyle headingStyle = new LabelStyle(white, Color.WHITE);
		heading = new Label("Wrath of the Ascendant", headingStyle);
		heading.setFontScale(2);

		table.add(heading);
		table.getCell(heading).spaceBottom(100);
		table.row();
		table.add(buttonResume).row();
		table.add(buttonStats).row();
		table.add(buttonExit);
		//table.debug();
		stage.addActor(table);
	    this.render(1);
	}

}
