package nullG;

import java.io.IOException;
import java.util.List;

class NullG{
	// constants
	public static final int tickTime  = 20;
	private static final int movementDelayX = 20;
	private static final int movementDelayY = 400;
	
	// game-wide objects
	public Graphics graphics;
	public Player player;
	public static Utils utils;
	public Events events;
	// game-wide variables
	public Stage currentStage = null;
	public String currentOS;
	
	// game wide conditions
	public boolean allowMovementX = true;
	public boolean allowMovementY = true;
	
	public void stop(){
		// don't leave a mess!
		graphics.calibrate();
		// keep it simple for now. In the future we will save the data upon exit
		System.exit(0);
	}
	public NullG(int width, int height){
		currentOS = System.getProperty("os.name");
		// use jansi for cross platform escape code support!
		utils = new Utils(this);
		graphics = new Graphics(this,width,height);
		player = new Player(this,0,0,Defaults.playerChar);
		events = new Events(this);
	}
	public void run(){
		// initialize graphics
		graphics.calibrate();
		//graphics.writeString(ConsoleColors.numToString[1],-10,-10);
		//graphics.setColor(ConsoleColors.ForeGround.GREEN_BRIGHT,ConsoleColors.Background.BLACK);
		
		// set stage
		currentStage = new Stage(this);
		//currentStage.autoGen(graphics.getWidth(),graphics.getHeight(),' ');
		currentStage.loadFile("./nullGData/home.stage");
		currentStage.writeStage();
		player.render();
		
		// create key checking thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                events.keys.keysThread();
            }
        }).start();
        float t1 = System.nanoTime();
        // mainloop
		while(true){
			List<Integer> kz = events.keys.getKeys();
			int xOffset = 0;
			int yOffset = 0;
			if(kz.size() > 0){
				int c = kz.get(0);
				switch (c){
					case Defaults.charEXIT:
						stop();
						break;
					case Defaults.charUP:
						yOffset = -1;
						break;
					case Defaults.charDOWN:
						yOffset = 1;
						break;
					case Defaults.charLEFT:
						xOffset = -1;
						break;
					case Defaults.charRIGHT:
						xOffset = 1;
						break;
					default:
						break;
				}
			}
			if( (xOffset != 0 && allowMovementX) || (yOffset != 0 && allowMovementX) ){
				int[] oldPos = player.getPos();
				int[] newPos = oldPos.clone();
				// x movement
				if(xOffset != 0 && allowMovementX){
					newPos[0]+=xOffset;
					// set delay for next press
					allowMovementX = false;
			        new Thread(new Runnable() {
			            @Override
			            public void run() {
			            	try{
			            		Thread.sleep(movementDelayX);
			            	} catch(InterruptedException e){}
			            	allowMovementX = true;
			            }
			        }).start();
				}
				// y movement
				if(yOffset != 0 && allowMovementX){
					newPos[1]+=yOffset;
					// set delay for next press
					allowMovementY = false;
			        new Thread(new Runnable() {
			            @Override
			            public void run() {
			            	try{
			            		Thread.sleep(movementDelayY);
			            	} catch(InterruptedException e){}
			            	allowMovementY = true;
			            }
			        }).start();
				}
				player.movePos(newPos[0],newPos[1]);
				graphics.writeChar(currentStage.getChar(oldPos[0],oldPos[1]),oldPos[0],oldPos[1]);
				player.render();
			}
			float diff = (System.nanoTime() - t1)/1000000000;
			float fps = 1f/diff;
			graphics.writeString(Float.toString(fps)+" fps",currentStage.width,currentStage.height);
			t1 = System.nanoTime();
			try{
				Thread.sleep(tickTime);
			} catch(InterruptedException e){}
		}
	}
}

public class Main{
	public static void main( String[] args){
		NullG game = new NullG(117,33);
		game.run();
		/*
		try{
			game.run();
		} catch(Exception e){
			System.err.println(e);
			System.exit(1);
			//game.stop();
		}
		*/
	}
}