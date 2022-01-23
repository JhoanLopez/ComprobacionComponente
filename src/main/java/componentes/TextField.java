package componentes;

import static com.sun.java.accessibility.util.AWTEventMonitor.addFocusListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 * @date 19 ene. 2022
 * @author Jhoan López
 * @email Jhoanlopezclase@gmail.com
 */

public class TextField extends JTextField implements Serializable{
    
    
    public TextField(){
         if (getText().isEmpty()) {
            setEmpty(true);
            setText(hint);
        }
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isEmpty()) {
                    setEmpty(false);
                    setText(""); 
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setEmpty(true);
                    setText(hint); 
                }
            }
        });
    }
    
    
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Color getHintColor() {
        return hintColor;
    }

    public void setHintColor(Color hintColor) {
        this.hintColor = hintColor;
    }
    
    private String hint;
    private boolean empty;
    private Color hintColor;
    

}
