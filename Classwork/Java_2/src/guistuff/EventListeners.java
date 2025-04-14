package guistuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventListeners {
	
	private JFrame frame;
	private JButton stutter;
	private JTextField textfield;

	public EventListeners() {

		stutter.addActionListener(new StutterListener());
	}

// When button is clicked, doubles the field's text.
private class StutterListener implements ActionListener {
	
	public void actionPerformed(ActionEvent event) {
	
			String text = textfield.getText();
			textfield.setText(text + text);
	}

	}
}

