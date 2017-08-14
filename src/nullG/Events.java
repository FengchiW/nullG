package nullG;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Events{
    public Keys keys;
    class Keys{
        nullG.NullG game;
        
        public List<Integer> keys = Collections.synchronizedList(new ArrayList<Integer>());
        public Keys(nullG.NullG _game){
            game = _game;
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
    			int c = game.utils.getChar();
    			k.add(c);
    			setKeys(k);
    			try{
    				Thread.sleep(game.tickTime);
    			} catch(InterruptedException e){}
    		}
    	}
    }
    public Events(nullG.NullG _game){
        keys = new Keys(_game);
    }
}