import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class keyPanel extends JPanel implements ActionListener
{
	JButton tButton = new JButton("t");
	JButton backButton = new JButton("C");
	JButton creaButton = new JButton("AC");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button0 = new JButton("0");
	JButton equalsButton = new JButton("=");
	JButton dotButton = new JButton(".");
	JButton additionButton = new JButton("+");
	JButton subtractionButton = new JButton("-");
	JButton multiplicationButton = new JButton("*");
	JButton divisionButton = new JButton("/");

	JTextArea area;
	JTextField text;

	findOut calc = new findOut();

	boolean inputState = false;

   Twitter twitter = TwitterFactory.getSingleton();

	keyPanel(displayPanel disp)
	{


	this.area = disp.area;

	setLayout(null);
	setBounds(10,0,135,145);


	tButton.setContentAreaFilled(false);
	tButton.setFocusPainted(false);
	tButton.setMargin(new Insets(0,0,0,0));
	tButton.setBounds(0,0,30,25);
	tButton.addActionListener(this);

	backButton.setContentAreaFilled(false);
	backButton.setFocusPainted(false);
	backButton.setMargin(new Insets(0,0,0,0));
	backButton.setBounds(35,0,30,25);
	backButton.addActionListener(this);

	creaButton.setContentAreaFilled(false);
	creaButton.setFocusPainted(false);
	creaButton.setMargin(new Insets(0,0,0,0));
	creaButton.setBounds(70,0,30,25);
	creaButton.addActionListener(this);

	button7.setContentAreaFilled(false);
	button7.setFocusPainted(false);
	button7.setMargin(new Insets(0,0,0,0));
	button7.setBounds(0,30,30,25);
	button7.addActionListener(this);

	button8.setContentAreaFilled(false);
	button8.setFocusPainted(false);
	button8.setMargin(new Insets(0,0,0,0));
	button8.setBounds(35,30,30,25);
	button8.addActionListener(this);

	button9.setContentAreaFilled(false);
	button9.setFocusPainted(false);
	button9.setMargin(new Insets(0,0,0,0));
	button9.setBounds(70,30,30,25);
	button9.addActionListener(this);

	button4.setContentAreaFilled(false);
	button4.setMargin(new Insets(0,0,0,0));
	button4.setFocusPainted(false);
	button4.setBounds(0,60,30,25);
	button4.addActionListener(this);

	button5.setContentAreaFilled(false);
	button5.setMargin(new Insets(0,0,0,0));
	button5.setFocusPainted(false);
	button5.setBounds(35,60,30,25);
	button5.addActionListener(this);

	button6.setContentAreaFilled(false);
	button6.setMargin(new Insets(0,0,0,0));
	button6.setFocusPainted(false);
	button6.setBounds(70,60,30,25);
	button6.addActionListener(this);

	button1.setContentAreaFilled(false);
	button1.setMargin(new Insets(0,0,0,0));
	button1.setFocusPainted(false);
	button1.setBounds(0,90,30,25);
	button1.addActionListener(this);

	button2.setContentAreaFilled(false);
	button2.setMargin(new Insets(0,0,0,0));
	button2.setFocusPainted(false);
	button2.setBounds(35,90,30,25);
	button2.addActionListener(this);

	button3.setContentAreaFilled(false);
	button3.setMargin(new Insets(0,0,0,0));
	button3.setFocusPainted(false);
	button3.setBounds(70,90,30,25);
	button3.addActionListener(this);

	button0.setContentAreaFilled(false);
	button0.setMargin(new Insets(0,0,0,0));
	button0.setFocusPainted(false);
	button0.setBounds(0,120,65,25);
	button0.addActionListener(this);

	equalsButton.setContentAreaFilled(false);
	equalsButton.setMargin(new Insets(0,0,0,0));
	equalsButton.setFocusPainted(false);
	equalsButton.setBounds(105,120,30,25);
	equalsButton.addActionListener(this);

	dotButton.setContentAreaFilled(false);
	dotButton.setMargin(new Insets(0,0,0,0));
	dotButton.setFocusPainted(false);
	dotButton.setBounds(70,120,30,25);
	dotButton.addActionListener(this);

	additionButton.setContentAreaFilled(false);
	additionButton.setMargin(new Insets(0,0,0,0));
	additionButton.setFocusPainted(false);
	additionButton.setBounds(105,90,30,25);
	additionButton.addActionListener(this);

	subtractionButton.setContentAreaFilled(false);
	subtractionButton.setMargin(new Insets(0,0,0,0));
	subtractionButton.setFocusPainted(false);
	subtractionButton.setBounds(105,60,30,25);
	subtractionButton.addActionListener(this);

	multiplicationButton.setContentAreaFilled(false);
	multiplicationButton.setMargin(new Insets(0,0,0,0));
	multiplicationButton.setFocusPainted(false);
	multiplicationButton.setBounds(105,30,30,25);
	multiplicationButton.addActionListener(this);

	divisionButton.setContentAreaFilled(false);
	divisionButton.setMargin(new Insets(0,0,0,0));
	divisionButton.setFocusPainted(false);
	divisionButton.setBounds(105,0,30,25);
	divisionButton.addActionListener(this);

	add(tButton);
	add(backButton);
	add(creaButton);
	add(button7);
	add(button8);
	add(button9);
	add(button4);
	add(button5);
	add(button6);
	add(button1);
	add(button2);
	add(button3);
	add(button0);
	add(dotButton);
	add(equalsButton);
	add(additionButton);
	add(subtractionButton);
	add(multiplicationButton);
	add(divisionButton);
}

	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource() == tButton)
		{
	        try {
	            Status status = twitter.updateStatus(area.getText());
	            System.out.println("sucess [" + status.getText() + "]");
	        } catch (TwitterException Te) {
	            Te.printStackTrace();
	        }
			area.setText("");
			inputState = true;
		}
		else if (e.getSource() == creaButton)
		{
			area.setText("");
			inputState = true;
		}
		else if (e.getSource() == backButton)
		{
			area.setText("");
			inputState = true;
		}
		else if (e.getSource() == button7)
		{
			area.append("7");
			inputState = true;
		}
		else if (e.getSource() == button8)
		{
			area.append("8");
			inputState = true;
		}
		else if (e.getSource() == button9)
		{
			area.append("9");
			inputState = true;
		}
		else if (e.getSource() == button4)
		{
			area.append("4");
			inputState = true;
		}
		else if (e.getSource() == button5)
		{
			area.append("5");
			inputState = true;
		}
		else if (e.getSource() == button6)
		{
			area.append("6");
			inputState = true;
		}
		else if (e.getSource() == button1)
		{
			area.append("1");
			inputState = true;
		}
		else if (e.getSource() == button2)
		{
			area.append("2");
			inputState = true;
		}
		else if (e.getSource() == button3)
		{
			area.append("3");
			inputState = true;
		}
		else if (e.getSource() == button0)
		{
			area.append("0");
			inputState = true;
		}
		else if (e.getSource() == dotButton)
		{
			area.append(".");
			inputState = true;
		}


		if(inputState)
		{

		if (e.getSource() == equalsButton)
		{
			area.append("=");
			area.setText(String.valueOf(calc.getAns(area.getText())));
		}
		else if (e.getSource() == additionButton)
		{
			area.append("+");
			inputState = false;
		}
		else if (e.getSource() == subtractionButton)
		{
			area.append("-");
			inputState = false;
		}
		else if (e.getSource() == multiplicationButton)
		{
			area.append("*");
			inputState = false;
		}
		else if (e.getSource() == divisionButton)
		{
			area.append("/");
			inputState = false;
		}

		}
	}
}