import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Button;
import java.awt.event.*;

public class TTCButton extends Button implements ActionListener {
	private int TTCnum;
	public TTCButton() 
	{
		super();
		addActionListener(this);
		setFont(new Font("TimesRoman", Font.BOLD, 42));
	}

	public TTCButton(String name) {
		super(name);
		addActionListener(this);
		setFont(new Font("TimesRoman", Font.BOLD, 42));
	}
	public void setNum(int num)
	{
		this.TTCnum = num;
	}
	
	public int getNum(TTCButton button)
	{
		return button.TTCnum;
	}
	
	public void setClickable(boolean b)
	{
		setEnabled(b);
	}
	
	public void forceAction()
	{
		System.out.println("button clicked");
		try
		{
		if (TicTacToe.getTurn() % 2 == 0)
		{
			setLabel("x");
			setClickable(false);
			TicTacToe.turn++;
			TicTacToe.checkWinner();
		}
		else if (TicTacToe.getTurn() % 2 != 0)
		{
			setLabel("o");
			setClickable(false);
			TicTacToe.turn++;
			TicTacToe.checkWinner();
		}
		}
		catch(ArithmeticException ae)
		{
			
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("button clicked");
		try
		{
		if (TicTacToe.getTurn() % 2 == 0)
		{
			setLabel("x");
			setClickable(false);
			BufferedWriter out = null;
			FileWriter writer = null;
			try {
				writer = new FileWriter(TicTacToe.dir, true);
				out = new BufferedWriter(writer);
				out.write(new Integer(getNum(this)).toString());
				out.newLine();
				System.out.println("writer wrote " + getNum(this));
				out.flush();
			}
			catch (IOException io)
			{
				System.out.println(io);
			}
			TicTacToe.turn++;
			TicTacToe.checkWinner();
		}
		else if (TicTacToe.getTurn() % 2 != 0)
		{
			setLabel("o");
			setClickable(false);
			BufferedWriter out = null;
			FileWriter writer = null;
			try {
				writer = new FileWriter(TicTacToe.dir, true);
				out = new BufferedWriter(writer);
				out.write(new Integer(getNum(this)).toString());
				out.newLine();
				System.out.println("writer wrote " + getNum(this));
				out.close();
			}
			catch (IOException io)
			{
				io.printStackTrace();
			}
			TicTacToe.turn++;
			TicTacToe.checkWinner();
		}
		}
		catch(ArithmeticException ae)
		{
			
		}
	}
}
