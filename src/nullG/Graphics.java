package nullG;

import java.util.Map;
import java.io.IOException;
import java.io.PrintStream;
import org.fusesource.jansi.AnsiConsole;

class Graphics{
    // variables from the main game object
    nullG.NullG game;
    String currentOS;
    nullG.Utils utils;
    // local class stuff
	private static final int heightUpperLimit = 50;
	private static final int widthUpperLimit  = 200;
	char escapeCode = 0x1B;
	Map<String, String> env = System.getenv();
	int rowsOffset = 1;
	int columnsOffset = 1;
	int width;
	int height; 
	PrintStream console;
	public Graphics(nullG.NullG _game,int wwidth, int hheight){
	    // "importing" variables from main game object
	    currentOS = _game.currentOS;
	    utils = _game.utils;
	    game = _game;
	    // local stuff
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
				game.stop();
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
				game.stop();
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