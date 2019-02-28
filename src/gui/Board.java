package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

	Drawable tile = new Drawable(0, 0, 23, 23, "GUIimages/tile.png");
	
	
	
	JPanel board = new JPanel();
	
	public Board() {
		
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(1000,800));
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent( g );
		
		for( int i = 0; i < drawables.size(); i++ ){
			drawables.get( i ).draw( g );
		}
		
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void gameStarted()  {
		
		this.repaint();
	}

	
		
}
