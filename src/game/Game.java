package game;

import java.util.Random;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Game implements ApplicationListener {
	
	private SpriteBatch batch;
	private Floor floor;
	private OrthographicCamera camera;
	private Matrix4 projection = new Matrix4();
	public int tileSize = 32;
	public Player player;
	private int positionRng;
	private Random rng = new Random();
	
    public void create () {

    	batch = new SpriteBatch();
        floor = new Floor();
        positionRng = rng.nextInt(floor.rooms.size());
        player = new Player(floor.rooms.get(positionRng).centerX,floor.rooms.get(positionRng).centerY,floor.rooms.get(positionRng).centerX+tileSize,floor.rooms.get(positionRng).centerY+tileSize);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        
    }

    public void render () {

    	handleInput();
    	moveCamera();
    	camera.update();
//    	batch.setProjectionMatrix(camera.combined); //comment this line out for testing
    	batch.begin();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        floor.drawFloor(batch);
        player.drawPlayer(batch);
        batch.end();
    	
    }
    
    public void moveCamera(){
    	camera.position.set(player.x1, player.y1, 0);
    }

    public void resize (int width, int height) {
    }

    public void pause () {
    }

    public void resume () {
    }

    public void dispose () {
    }
    
    public static void main(String[] args){
    	new LwjglApplication(new Game(), "Dungeon Crawler", 1024, 768);
    }
    
    private void handleInput() {
    	if (Gdx.input.isKeyJustPressed(Keys.UP)){
    		camera.translate(0, tileSize, 0);
    		player.movePlayer("up", batch, floor);
    	}
    	if (Gdx.input.isKeyJustPressed(Keys.DOWN)){
    		camera.translate(0, -tileSize, 0);
    		player.movePlayer("down", batch, floor);
    	}
    	if (Gdx.input.isKeyJustPressed(Keys.RIGHT)){
    		camera.translate(tileSize, 0, 0);
    		player.movePlayer("right", batch, floor);
    	}
    	if (Gdx.input.isKeyJustPressed(Keys.LEFT)){
    		camera.translate(-tileSize, 0, 0);
    		player.movePlayer("left", batch, floor);
    	}
    }
}
