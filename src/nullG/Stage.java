package nullG;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	public void loadFile(String filename){
		BufferedReader br = null;
		FileReader fr = null;
		List<String> tempL = new ArrayList<String>();
		// file reading
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				tempL.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		// processing of the data
		writeArray = new String[tempL.size()];
		for(int i=0;i<tempL.size();i++){
			writeArray[i] = tempL.get(i);
		}
		matrix = new char[writeArray[0].length()][writeArray.length];
		for(int r=0;r<writeArray.length;r++){
			for(int c=0;c<writeArray[r].length();c++){
				matrix[c][r] = writeArray[r].charAt(c);
			}
		}
		height = writeArray.length;
		width = matrix.length;
	}
	public void autoGen(int _width, int _height, char fill){
		width  = _width;
		height = _height;
		matrix = new char[width][height];
		for(int  x=0;x<width;x++){
			for(int y=0;y<height;y++){
				char z = fill;
				if(y==height-1 || x==width-1 || y==0 || x==0){
					z = ' ';
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
	public Stage(nullG.NullG game){
	    graphics = game.graphics;
	}
	public char getChar(int x, int y){
		return matrix[x][y];
	}
}