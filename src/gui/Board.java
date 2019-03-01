package gui;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Sean Joyce
 *
 */

@SuppressWarnings("serial")
public class Board extends JPanel implements MouseListener {
	
	
	//Arraylists
	public static ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	public static ArrayList<ClickableButton> buttons = new ArrayList<ClickableButton>();
	public static ArrayList<Clickable> clickables = new ArrayList<Clickable>();



	Drawable floor = new Drawable(0, 0, 1000, 800, "GUIimages/floor.png");
	
	//Drawable tile = new Drawable(0, 0, 50, 50, "GUIimages/tile.png");
	
	ClickableButton[][] matrix;
	
	
	//JPanel board = new JPanel();
	
	public Board() {
		
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(1000,800));
		addMouseListener(this);
		tileCreation();
		gameStarted(this);
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent( g );
		
		for( int i = 0; i < drawables.size(); i++ ){
			drawables.get( i ).draw( g );
		}
		
	}
	
	public ArrayList<Integer> indexFind(Clickable c) {
		
		for(int i = 0; i < matrix.length;i++) {
			for ( int t = 0; t < matrix[i].length;t++) {
				if (c == matrix[i][t]) {
					
					ArrayList<Integer> coor = new ArrayList<Integer>();
					coor.add(i+1);
					coor.add(t+1);
					return(coor);
				}
			}
			
		}
		return null;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased( MouseEvent mouseEvent ) {
		
		//If there's something held, let it go
		if( ClickableButton.heldButton != null ) {
			
			//If we just released over the held button then we did a full click on it
			if( ClickableButton.heldButton.pointWithin( mouseEvent.getX() ,  mouseEvent.getY() ) ){
				
				ClickableButton.heldButton.onClicked();
				
				ClickableButton.onMouseUp();
				
			}
			
		}
		
		//Redraw everything
		this.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
	
		System.out.println("Mouse Clicked");
		//Right off the bat, if we are already holding something then we have a problem.
		if( ClickableButton.heldButton != null ) {
			//If this is the case, we'll do some error avoidance and just ignore this event.
			
			return;
		}
		
		System.out.println();
		//Check if we just started clicking any buttons
		for(  int i = clickables.size()-1 ; i>= 0; i--) {
			Clickable clickable = clickables.get(i);
			
			if( clickable.pointWithin( mouseEvent.getX() ,  mouseEvent.getY() ) ){
				
				clickable.onMouseDown();
				System.out.println(indexFind(clickable));
				break;
			}
			
		}
		
		//Redraw everything
		this.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void gameStarted(Board board)  {
		
		
		JFrame frame = new JFrame();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
	}

	@SuppressWarnings("null")
	public void tileCreation() {
		
		
		int rowCount = 15;
		int colCount = 19;
		
		int colWidth = 850/colCount;
		int rowHeight = 650/rowCount;
		
		matrix = new ClickableButton[rowCount][colCount];
		
		for(int col = 0; col < colCount; col ++) {
			for(int row = 0; row < rowCount; row ++) {
				
				
				if(col > 7 && col < 11 && row > 5 && row < 9){
					matrix[row][col] = new ClickableButton(colWidth*col+75,rowHeight*row+75,45,45,"GUIimages/tableTop.png","GUIimages/tableTop.png","GUIimages/tableTop.png");
				}else if(col%6 == 0 && row%7==0){
					matrix[row][col] = new ClickableButton(colWidth*col+75,rowHeight*row+75,45,45,"GUIimages/tilePressed.png","GUIimages/tile.png","GUIimages/tilePressed.png");
				} else {
				matrix[row][col] = new ClickableButton(colWidth*col+75,rowHeight*row+75,45,45,"GUIimages/tile.png","GUIimages/tilePressed.png","GUIimages/tilePressed.png");
				}
			}
		}
	
	}
	
		
}
















