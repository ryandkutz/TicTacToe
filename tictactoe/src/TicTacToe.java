import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;


public class TicTacToe extends TTCFrame implements ActionListener {
	static Boolean isXWin;
	static int turn = 0;
	static TTCButton[] buttons = new TTCButton[9];
	MenuBar TTCBar;
	Menu options;
	Menu io;
	MenuItem open;
	MenuItem restart;
	MenuItem setDir;
	static String dir;
	
	public TicTacToe()
	{
		super("TicTacToe", 500, 500);
		TTCBar = new MenuBar();
		options = new Menu("Menu");
		io = new Menu("I/O");
		restart = new MenuItem("Restart");
		open = new MenuItem("Open");
		setDir = new MenuItem("Set Dir.");
		options.add(restart);
		io.add(open);
		io.add(setDir);
		TTCBar.add(options);
		TTCBar.add(io);
		setMenuBar(TTCBar);
		restart.addActionListener(this);
		open.addActionListener(this);
		setDir.addActionListener(this);
		startButtons();
		JOptionPane.showMessageDialog(null, "Hi and welcome to TicTacToe by your BOY Ryan K\n\nX always goes first. To restart click Restart under the Menu dropdown");
	}
	public static int getTurn()
	{
		return turn;
	}
	
	public void resetAll()
	{
		buttons = new TTCButton[9];
		removeAll();
		startButtons();
		turn = 0;
		JOptionPane.showMessageDialog(null, "Game reset. Let's get this bread");
	}
	
	public static void winner()
	{
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i].setClickable(false);
		}
		if (isXWin == true) 
		{
			JOptionPane.showMessageDialog(null, "Player X Won!");
			System.out.println("X Won");
		}
		else if (isXWin == false)
		{
			JOptionPane.showMessageDialog(null, "Player O Won!");
			System.out.println("O Won");
		}
	}
	
	public void startButtons()
	{
		for (int i = 0; i < buttons.length; i++)
    	{
    		buttons[i] = new TTCButton();
    		buttons[i].setNum(i);
    		System.out.println(i + " set to " + i);
    		add(buttons[i]);
    		setVisible(true);
    	}
	}
	
	public void playback()
	{
		try {
			Scanner reader = new Scanner(new File(dir));
			turn = 0;
			while(reader.hasNextInt())
				{ 
					System.out.println("made it into scanner loop");
					int move = reader.nextInt();
					buttons[move].forceAction();
					System.out.println("button action forced");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			System.out.println("loop over");
		}
		catch(FileNotFoundException x)
		{
			System.out.println("oof my files");
		}
	}
	

    public static void main(String[] args) {
    	TicTacToe ttc = new TicTacToe();
    	
    }
    
    public static boolean checkAdjacent(int a, int b)
    {
    	if (buttons[a].getLabel().equals(buttons[b].getLabel()) && !buttons[a].getLabel().equals(""))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public static boolean checkWinner()
	{
    	//horizontal checks
		if (checkAdjacent(0,1) && checkAdjacent(1,2))
		{
			System.out.println("someone won");
			if(buttons[0].getLabel().equals("x"))
				isXWin = true;
			else
				isXWin = false;
			winner();
			return true;
		}
		else if (checkAdjacent(3,4) && checkAdjacent(4, 5))
		{
			System.out.println("someone won");
			if(buttons[3].getLabel().equals("x"))
				isXWin = true;
			else
				isXWin = false;
			winner();
			return true;
		}
		else if (checkAdjacent(6,7) && checkAdjacent(7,8))
		{
			System.out.println("someone won");
			if(buttons[6].getLabel().equals("x"))
				isXWin = true;
			else
				isXWin = false;
			winner();
			return true;
		}
		//vertical checks
		else if (checkAdjacent(0,3) && checkAdjacent(3,6))
		{
			System.out.println("someone won");
			if(buttons[0].getLabel().equals("x"))
				isXWin = true;
			else
				isXWin = false;
			winner();
			return true;
		}
		else if (checkAdjacent(1,4) && checkAdjacent(4,7))
		{
			System.out.println("someone won");
			if(buttons[1].getLabel().equals("x"))
				isXWin = true;
			else
				isXWin = false;
			winner();
			return true;
		}
		else if (checkAdjacent(2,5) && checkAdjacent(5, 8))
		{
			System.out.println("someone won");
			if(buttons[2].getLabel().equals("x"))
				isXWin = true;
			else
				isXWin = false;
			winner();
			return true;
		}
		//diagonal checks
		else if (checkAdjacent(0,4) && checkAdjacent(4, 8))
		{
			System.out.println("someone won");
			if(buttons[0].getLabel().equals("x"))
				isXWin = true;
			else
				isXWin = false;
			winner();
			return true;
		}
		else if (checkAdjacent(2,4) && checkAdjacent(4, 6))
		{
			System.out.println("someone won");
			if(buttons[2].getLabel().equals("x"))
				isXWin = true;
			else
				isXWin = false;
			winner();
			return true;
		}
		else
		{
			System.out.println("no one won (yet)");
			if (turn == 9)
			{
				for (int i = 0; i < buttons.length; i++)
				{
					buttons[i].setClickable(false);
				}
				JOptionPane.showMessageDialog(null, "It's a draw.");
				System.out.println("draw called");
			}
			return false;
		}
	}
    @Override
	public void actionPerformed(ActionEvent e)
	{
    	if (e.getSource() == restart)
    	{
    		resetAll();
    	}
    	else if (e.getSource() == setDir)
    	{
    		dir = TTCFile.getFileDir();
    		TTCFile.newFile(dir);
    	}
    	else if (e.getSource() == open)
    	{
    		dir = TTCFile.getFilePrompt();
    		playback();
    	}
	}
    
}
