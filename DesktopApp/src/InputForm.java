import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class InputForm {
    private JPanel MainPanel;
    private JButton Collapse;
    private JTextField familyTextField;
    private JTextField nameTextField;
    private JTextField fatherTextField;
    private JLabel fatherLbl;
    private JLabel nameLbl;
    private JLabel familyLbl;
    private JLabel MsgLbl;
    private JPanel InputPanel;
    private JPanel BtnPanel;
    private JTextField MsgTF;
    private JPanel MsgPanel;
    private JTextPane MsgText;

    public InputForm() {
        Collapse.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Collapse.getText().equals("Collapse")) {
                    if (familyTextField.getText().equals("") || nameTextField.getText().equals("")) {
                        MsgText.setBackground(MainPanel.getBackground());
                        MsgText.setForeground(Color.RED);
                        MsgText.setText("ОШИБКА!" + "\n Заполните обязательные поля!");
                    } else {
                        InputPanel.setVisible(false);
                        MsgText.setBackground(Color.WHITE);
                        MsgText.setForeground(Color.BLACK);
                        MsgText.setBounds(25,25,300,25);
                        MsgText.setText(familyTextField.getText() + " " + nameTextField.getText()
                                + " " + fatherTextField.getText());
                        Collapse.setText("Expand");
                    }
                } else if (Collapse.getText().equals("Expand")) {
                    InputPanel.setVisible(true);
                    familyTextField.setText("");
                    fatherTextField.setText("");
                    nameTextField.setText("");
                    MsgText.setBackground(MainPanel.getBackground());
                    MsgText.setForeground(Color.BLACK);
                    MsgText.setText("Обязательны к вводу имя и фамилия");
                    Collapse.setText("Collapse");
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }


}
