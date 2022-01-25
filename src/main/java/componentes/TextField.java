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
        super();
        initialize("");
    }
    
    public TextField(String text){
        super();
        initialize(text);
    }
    
    
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        System.out.print("Color: " + hint);
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
    
    private void initialize (String text) {
        if (getText().isEmpty()) {
            setEmpty(true);
        }
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isEmpty()) {
                    setEmpty(false);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setEmpty(true);
                }
            } 
        });
    }
    
    @Override
    protected void printComponent(Graphics g) {        
        super.paintComponent(g);
        
        if((hint != null) && isEmpty() && !hasFocus()) {
            if(hintColor != null) {
                g.setColor(hintColor);
            } else {
                g.setColor(getForeground().brighter().brighter().brighter());              
            }
            int padding = (getHeight() - getFont().getSize()) / 2;
            g.drawString(hint, 2, getHeight() - padding - 1); 
        }
    }
    
    
    private String hint;
    private boolean empty;
    private Color hintColor;
}
