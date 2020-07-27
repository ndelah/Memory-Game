import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBoston extends JFrame {
    private JTextField item1;
    private JTextField item2;
    private JTextField item3;
    private JPasswordField passwordField;

    public NewBoston (){
        super("Title window");
        setLayout(new FlowLayout());

        item1 = new JTextField(10);
        add(item1);

        item2 = new JTextField("Enter text field here");
        add(item2);

        item3 = new JTextField("uneditable", 20);
        item3.setEditable(false);
        add(item3);

        passwordField = new JPasswordField("Mypass");
        add(passwordField);

        // we are building this class in  here so that inherits all the crap from the class outside
        class TheHandler implements ActionListener {
        //only gets one method that is an action that happens automatically every time an event occurs

            public void actionPerformed(ActionEvent event){
                String string = "";

                if (event.getSource() == item1)
                    string = String.format("field1: %s", event.getActionCommand());
                else if (event.getSource() == item1)
                    string = String.format("field2: %s", event.getActionCommand());
                else if (event.getSource() == item3 )
                    string = String.format("field3: %s", event.getActionCommand());
                else if (event.getSource() == passwordField)
                    string = String.format("passwordField: %s", event.getActionCommand());

                JOptionPane.showMessageDialog(null,string);

            }
        }
        // build the objects before you build the class
        // builds an action listener object
        // need to add this object to each of the items
        TheHandler handler = new TheHandler();
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        passwordField.addActionListener(handler);
    }

}
