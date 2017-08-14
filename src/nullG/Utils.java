package nullG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Utils{
    private nullG.NullG game;
	public String[] getCommandOutput(String[] cmd){
		String output = "";
		String err = "";
		try{
			Runtime rt = Runtime.getRuntime();
			String[] preset;
			if(game.currentOS.contains("Windows")){
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
	public Utils(nullG.NullG _game){
	    game = _game;
	}
}