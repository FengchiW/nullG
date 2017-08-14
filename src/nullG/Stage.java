package nullG;


class Stage{
	public char[][] matrix;
	public String[] writeArray;
	public int width;
	public nullG.Graphics graphics;
	public int height;
	public void writeStage(){
		for(int r=0;r<height;r++){
			graphics.writeString(writeArray[r],0,r);
		}
	}
	public Stage(nullG.NullG game, int inWidth, int inHeight, char fill){
	    graphics = game.graphics;
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