import java.awt.*;
import java.awt.event.*;


public class TTCFrame extends Frame implements WindowListener {
	public TTCFrame(String name, int x, int y)
	{
		setLayout(new GridLayout(3,3));
		setTitle(name);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		addWindowListener(this);
	}
	

		@Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

        @Override
        public void windowOpened(WindowEvent e) {}

        @Override
        public void windowClosed(WindowEvent e) {}

        @Override
        public void windowIconified(WindowEvent e) {}

        @Override
        public void windowDeiconified(WindowEvent e) {}

        @Override
        public void windowActivated(WindowEvent e) {}

        @Override
        public void windowDeactivated(WindowEvent e) {}
}
