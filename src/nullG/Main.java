package nullG;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.PrintStream;
import org.fusesource.jansi.AnsiConsole;

class NullG{
	// settings
	private static final int charUP    = 119;
	private static final int charDOWN  = 115;
	private static final int charLEFT  = 97 ;
	private static final int charRIGHT = 100;
	private static final int charEXIT  = 3  ;
	// constants
	private static final int tickTime  = 20;
	private static final int movementDelayX = 20;
	private static final int movementDelayY = 400;
	
	// game-wide objects
	public Graphics graphics;
	public Player player;
	public static Utils utils;
	// game-wide variables
	public List<Integer> keys = Collections.synchronizedList(new ArrayList<Integer>());
	public Stage currentStage = null;
	private static String currentOS;
	
	// game wide conditions
	public boolean allowMovementX = true;
	public boolean allowMovementY = true;
	
	class Player{
		public int x;
		public int y;
		public char avatar;
		public int[] getPos(){
			int[] pos = new int[2];
			pos[0] = x;
			pos[1] = y;
			return pos;
		}
		public Player(int xpos, int ypos,char avatarChar){
			x = xpos;
			y = ypos;
			avatar = avatarChar;
		}
		public void render(){
			graphics.writeChar(avatar,x,y);
		}
		public void setPos(int xpos, int ypos){
			x = xpos;
			y = ypos;
		}
		public void movePos(int xpos, int ypos){
			// not <= since the width assumes 1 is the first value, and xpos/ypos assumes 0 is the first value
			if(xpos < graphics.getWidth() && xpos >= 0){
				x = xpos;
			}
			if(ypos < graphics.getHeight() && ypos >= 0){
				y = ypos;
			}
		}
	}
	class Graphics{
		private static final int heightUpperLimit = 50;
		private static final int widthUpperLimit  = 200;
		char escapeCode = 0x1B;
		Map<String, String> env = System.getenv();
		int rowsOffset = 1;
		int columnsOffset = 1;
		int width;
		int height; 
		PrintStream console;
		public Graphics(int wwidth, int hheight){
			width = wwidth;
			height = hheight;
			if(currentOS.contains("Windows")){
				AnsiConsole.systemInstall();
				console = AnsiConsole.out;
			} else{
				console = System.out;
			}
			// this is buggy on windows...
			if(!currentOS.contains("Windows")){
				columnsOffset = Math.min((getScreenWidth() - getWidth())/2, widthUpperLimit/2);
				rowsOffset = Math.min((getScreenHeight() - getHeight())/2, heightUpperLimit/2);
			}
		}
		public int getWidth(){
			return width;
		}
		public int getHeight(){
			return height;
		}
		public int getScreenWidth(){
			int w = -1;
			if(!currentOS.contains("Windows")){
				try{
					w = Integer.parseInt(env.get("COLUMNS"));
				} catch(NumberFormatException e){
					console.println("Error retrieving the width of the console.");
					console.println("If so, try: export COLUMNS LINES");
					throw e;
				}
			} else{
				String[] o = utils.getCommandOutput((new String[]{"mode","CON"}));
				if(o[1] == ""){
					boolean searching = false;
					String parsedText = "";
					for(int i=o[0].indexOf("Columns:")+"Columns:".length();i<o[0].length();i++){
						if(o[0].charAt(i) != ' '){
							searching = true;
						}
						if(searching && o[0].charAt(i) == ' '){
							break;
						} else if(searching){
							parsedText+=o[0].charAt(i);
						}
					}
					w = Integer.parseInt(parsedText);
				} else{
					console.println("Error running [mode CON] in order to get columns.");
					stop();
				}
			}
			return w;
		}
		public int getScreenHeight(){
			int h = -1;
			if(!currentOS.contains("Windows")){
				try{
					h = Integer.parseInt(env.get("LINES"));
				} catch(NumberFormatException e){
					console.println("Error retrieving the width of the console.");
					console.println("If so, try: export COLUMNS LINES");
					throw e;
				}
			} else{
				String[] o = utils.getCommandOutput((new String[]{"mode","CON"}));
				if(o[1] == ""){
					boolean searching = false;
					String parsedText = "";
					for(int i=o[0].indexOf("Lines:")+"Lines:".length();i<o[0].length();i++){
						if(o[0].charAt(i) != ' '){
							searching = true;
						}
						if(searching && o[0].charAt(i) == ' '){
							break;
						} else if(searching){
							parsedText+=o[0].charAt(i);
						}
					}
					h = Integer.parseInt(parsedText);
				} else{
					console.println("Error running [mode CON] in order to get columns.");
					stop();
				}
			}
			return h;
		}
		public void setColor(String foreground, String background){
			console.print(String.format("%c[%d;%df",escapeCode,0,0));
			console.print(foreground+background);
			
		}
		public void writeColorChar(char c, int column, int row, String foreground, String background){
			writeString(foreground+background+c,column,row);
		}
		public void writeColorString(String s, int column, int row, String foreground, String background){
			writeString(foreground+background+s,column,row);
		}
		public void writeChar(char c, int column, int row){
			row+=rowsOffset;
			column+=columnsOffset;
			// go to position
			console.print(String.format("%c[%d;%df",escapeCode,row,column));
			// print character
			console.print(c);
			// return to 0,0 so the cursor doesn't show
			console.print(String.format("%c[%d;%df",escapeCode,0,0));
		}
		public void writeString(String s, int column, int row){
			row+=rowsOffset;
			column+=columnsOffset;
			// go to position
			console.print(String.format("%c[%d;%df",escapeCode,row,column));
			// print string
			console.print(s);
			// return to 0,0 so the cursor doesn't show
			console.print(String.format("%c[%d;%df",escapeCode,0,0));
		}
		public void calibrate(){
			if(currentOS.contains("Windows")){
				clear();
			} else{
				for (int r=0; r<Math.min(getScreenHeight()+1,heightUpperLimit); r++) {
					String s = ConsoleColors.RESET;
					for(int c=0; c<Math.min(getScreenWidth(),widthUpperLimit); c++){
						s+=' ';
					}
					writeString(s,0,r);
				}
			}
			//writeString(ConsoleColors.RESET,0,0);
			console.print(String.format("%c[%d;%df",escapeCode,0,0));
		}
		public void clear(){
		    try {
		        if (currentOS.contains("Windows"))
		            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		        else
		            Runtime.getRuntime().exec("clear");
		    } catch (IOException | InterruptedException ex) {
		    	console.println("derp");
		    }
		}
	}
	class Utils{
		public String[] getCommandOutput(String[] cmd){
			String output = "";
			String err = "";
			try{
				Runtime rt = Runtime.getRuntime();
				String[] preset;
				if(currentOS.contains("Windows")){
					preset = new String[]{"cmd","/c"};
				} else{
					preset = new String[]{};
				}
				String[] commands = new String[preset.length + cmd.length];
				System.arraycopy(preset, 0, commands, 0, preset.length);
				System.arraycopy(cmd, 0, commands, preset.length, cmd.length);


				Process proc = rt.exec(commands);

				BufferedReader stdInput = new BufferedReader(new 
				     InputStreamReader(proc.getInputStream()));

				BufferedReader stdError = new BufferedReader(new 
				     InputStreamReader(proc.getErrorStream()));

				// read the output from the command
				String s = null;
				while ((s = stdInput.readLine()) != null) {
				    output+=s;
				}

				// read any errors from the attempted command
				while ((s = stdError.readLine()) != null) {
				    err+=s;
				}
			} catch(IOException e){
				System.err.println(e);
				System.exit(1);
			}
			return (new String[]{output,err});
		}
		public int getChar(){
			int c = -1;
			try{
				c = RawConsoleInput.read(true);
			} catch(IOException e){
				
			}
			return c;
		}
	}
	class Stage{
		public char[][] matrix;
		public String[] writeArray;
		public int width;
		public int height;
		public void writeStage(){
			for(int r=0;r<height;r++){
				graphics.writeString(writeArray[r],0,r);
			}
		}
		public Stage(int inWidth, int inHeight, char fill){
			width  = inWidth;
			height = inHeight;
			matrix = new char[width][height];
			for(int  x=0;x<width;x++){
				for(int y=0;y<height;y++){
					char z = fill;
					if(y==height-1 || x==width-1 || y==0 || x==0){
						z = '#';
					}
					matrix[x][y] = z;
				}
				
			}
			String[][] rcMatrix = new String[height][width];
			for(int x=0;x<width;x++){
				for(int y=0;y<height;y++){
					rcMatrix[y][x]=Character.toString(matrix[x][y]);
				}
			}
			writeArray = new String[height];
			for(int r=0;r<height;r++){
				writeArray[r] = String.join("",rcMatrix[r]);
			}
		}
		public char getChar(int x, int y){
			return matrix[x][y];
		}
	}
	public List<Integer> getKeys(){
		synchronized(keys){
			return keys;
		}
	}
	public void setKeys(List<Integer> ks){
		synchronized(keys){
			keys = ks;
		}
	}
	public void keysThread(){
		while(true){
			List<Integer> k = new ArrayList<Integer>();
			setKeys(k);
			int c = utils.getChar();
			k.add(c);
			setKeys(k);
			try{
				Thread.sleep(tickTime);
			} catch(InterruptedException e){}
		}
	}
	public void stop(){
		// don't leave a mess!
		graphics.calibrate();
		// keep it simple for now. In the future we will save the data upon exit
		System.exit(0);
	}
	public NullG(int width, int height){
		currentOS = System.getProperty("os.name");
		// use jansi for cross platform escape code support!
		utils = new Utils();
		graphics = new Graphics(width,height);
		player = new Player(0,0,'Z');
	}
	public void run(){
		// initialize graphics
		graphics.calibrate();
		//graphics.setColor(ConsoleColors.ForeGround.GREEN_BRIGHT,ConsoleColors.Background.BLACK);
		
		// set stage
		currentStage = new Stage(graphics.getWidth(),graphics.getHeight(),' ');
		currentStage.writeStage();
		player.render();
		
		// create key checking thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                keysThread();
            }
        }).start();
        float t1 = System.nanoTime();
        // mainloop
		while(true){
			List<Integer> kz = getKeys();
			int xOffset = 0;
			int yOffset = 0;
			if(kz.size() > 0){
				int c = kz.get(0);
				switch (c){
					case charEXIT:
						stop();
						break;
					case charUP:
						yOffset = -1;
						break;
					case charDOWN:
						yOffset = 1;
						break;
					case charLEFT:
						xOffset = -1;
						break;
					case charRIGHT:
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