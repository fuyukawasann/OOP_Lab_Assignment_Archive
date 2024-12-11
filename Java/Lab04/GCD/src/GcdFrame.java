import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GcdFrame extends JFrame {
    private JLabel label;

    private JTextField num1TextField;
    private JTextField num2TextField;
    private JTextField resultTextField;

    private JButton GCDButton;
    private JButton clearButton;

    private JPanel buttonRow1;
    private JPanel buttonRow2;

    public GcdFrame(String title) {
        // Set the title of JFrame with the superclass constructor
        super(title);
        // Set the JFrame to be a 2x2 Grid, with a gap of 5 between each row and column
        setLayout(new GridLayout(3,2,5,5));
        // Create an instance of the components appearing in the 2x2 grid
        num1TextField = new JTextField("0", 5); // Begin with 0
        num2TextField = new JTextField("0", 5); // Begin with 0
        resultTextField = new JTextField(5); // Begin empty
        buttonRow1 = getButtonPanelGCD();
        buttonRow2 = getButtonPanelClear();
        label = new JLabel("GCD");

        add(label);
        add(num1TextField);
        add(buttonRow1);
        add(num2TextField);
        add(buttonRow2);
        add(resultTextField);
    }

    private JPanel getButtonPanelClear()
    {
        JPanel myPanelC = new JPanel();
        myPanelC.setLayout(new FlowLayout());
// Create an instance of each button
        clearButton = new JButton("CLEAR");
// Add ActionListeners to all the buttons
        ButtonListener listener = new ButtonListener();
        clearButton.addActionListener(listener);
// Add the 3 buttons to myPanel
        myPanelC.add(clearButton);
        return myPanelC;
    }

    private JPanel getButtonPanelGCD()
    {
        JPanel myPanelM = new JPanel();
        myPanelM.setLayout(new FlowLayout());
// Create an instance of each button
        GCDButton = new JButton("Calculate!");
// Add ActionListeners to all the buttons
        ButtonListener listener = new ButtonListener();
        GCDButton.addActionListener(listener);
// Add the 3 buttons to myPanel
        myPanelM.add(GCDButton);
        return myPanelM;
    }

    private int recursiveGCD(int num1, int num2){
        if(num2==0) return num1;
        else if(num2>0)return recursiveGCD(num2,num1%num2);
        else return 0;
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int num1, num2, result = 0;
            if (event.getSource() == clearButton) {
                num1TextField.setText("0");
                num2TextField.setText("0");
                resultTextField.setText("");
            } else {
                try {
                    num1 = Integer.parseInt(num1TextField.getText());
                    num2 = Integer.parseInt(num2TextField.getText());
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Please Enter an integer");
                    return;
                }
                if (event.getSource() == GCDButton)
                    result = recursiveGCD(num1, num2);
//                    result = num1*num2;
                resultTextField.setText(String.format("%d", result));
            }
        }
    }

}