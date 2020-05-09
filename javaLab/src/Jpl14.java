
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Jpl14 extends JComponent
{

   Popup popup;
    Jpl14()
    {

        JFrame frame = new JFrame("graphical");
        Checkbox checkbox = new Checkbox();
        CheckboxGroup cbg = new CheckboxGroup();
        Checkbox checkbox1 = new Checkbox("first checkbox",cbg,true);
        checkbox1.setBounds(100,20,100,50);
        Checkbox checkbox2 = new Checkbox("second checkbox",cbg,false);
        checkbox2.setBounds(100,60,100,50);
        frame.add(checkbox1);
        frame.add(checkbox2);
        checkbox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                TextArea textArea =new TextArea();
                textArea.setBounds(250,20,100,50);
                frame.add(textArea);
            }
        });


        JRadioButton radioButton1 = new JRadioButton("RadioButton");
        JRadioButton radioButton2 = new JRadioButton("RadioButton 2");
        radioButton1.setBounds(100,100,100,50);
        radioButton2.setBounds(100,140,100,50);
        frame.add(radioButton1);
        frame.add(radioButton2);
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextArea textArea =new TextArea();
                textArea.setBounds(250,100,100,50);
                frame.add(textArea);
            }
        });

        DefaultListModel<String> listModel  = new DefaultListModel<>();
        listModel.addElement("list element 1");
        listModel.addElement("list element 2");
        listModel.addElement("list element 3");
        listModel.addElement("list element 4");
        listModel.setSize(30);


        JList<String> list  = new JList<>(listModel);
        list.setBounds(100,200, 100,100);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (popup != null) {
                    popup.hide();
                }
                JLabel text = new JLabel("You've clicked at: " + e.getPoint());
                popup = PopupFactory.getSharedInstance().getPopup(e.getComponent(), text, e.getXOnScreen(), e.getYOnScreen());
                popup.show();
            }
        });


        frame.add(list);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {

        new Jpl14();

    }

}