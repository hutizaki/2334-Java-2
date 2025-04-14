package guistuff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerExample {
    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Action Listener Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button
        JButton button = new JButton("Click Me");

        // Make background color changes visible
        button.setOpaque(true);
        button.setBorderPainted(false);

        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(Color.CYAN);
            }
        });

        // Add button to frame
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.setVisible(true);
    }
}


