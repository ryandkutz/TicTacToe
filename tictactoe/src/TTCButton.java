import java.awt.*;
import java.awt.event.*;
import java.awt.Button;
import java.awt.event.*;

public class TTCButton extends Button implements ActionListener {
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
	public void setClickable(boolean b)
	{
		setEnabled(b);
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
}
