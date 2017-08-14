package nullG;

class Player{
	public int x;
	public int y;
	public char avatar;
	private nullG.Graphics graphics;
	public int[] getPos(){
		int[] pos = new int[2];
		pos[0] = x;
		pos[1] = y;
		return pos;
	}
	public Player(nullG.NullG _game, int xpos, int ypos,char avatarChar){
	    graphics = _game.graphics;
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