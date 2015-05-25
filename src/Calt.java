import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calt extends JFrame
{
	Calt(String title)
	{
	    setResizable(false);
		setTitle(title);
		setBounds(100,100,160,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainContainer = new JPanel();
		mainContainer.setLayout(null);
		mainContainer.setBounds(0,0,160,250);

		displayPanel disp = new displayPanel();
		disp.setBounds(10,5,155,80);

		keyPanel key = new keyPanel(disp);
		key.setBounds(10,70,135,145);

		mainContainer.add(key);
		mainContainer.add(disp);

		Container contentPane = getContentPane();
		contentPane.add(mainContainer,BorderLayout.CENTER);
	}
}
