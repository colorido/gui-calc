import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class displayPanel extends JPanel
{

	JTextArea area = new JTextArea();
    JTextField text = new JTextField();

	displayPanel()
	{
		setLayout(null);
		setBounds(0,0,160,60);

		textValidate thread = new textValidate(area);
		thread.start();
		thread.setStop();

	    text.setEditable(false);
		text.setOpaque(false);
		text.setBorder(null);
	    text.setBounds(0,0,140,20);

		area.setOpaque(false);
		area.setLineWrap(true);
		area.setBounds(0,20,140,40);

		area.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent inEvent)
			{
				thread.setStop();
			}

			public void focusLost(FocusEvent inEvent)
			{
				thread.setStop();
			}
		});

		add(text);
		add(area);

	}
}

class textValidate extends Thread
{
	boolean end = false;
	boolean stop = false;
	JTextArea area;


	textValidate(JTextArea area)
	{
		this.area = area;
	}

	public void run()
	{
		while(!end)
		{
			try
			{
				if(area.getText().length() > 22)
				{
				    area.setText(area.getText().substring(0,22));
				}

				if(area.getText().indexOf("++") != -1)
				{
					area.setText(area.getText().substring(0,area.getText().indexOf("++")));
				}

				System.out.println("");

				synchronized(this)
				{
					if (stop) wait();
				}

			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public synchronized void setStop()
	{
		stop = !stop;
		if (!stop) notify();
	}
}
