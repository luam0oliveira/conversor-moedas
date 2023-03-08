package utils;

import org.w3c.dom.Text;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFilter extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        String regex = "[^0-9,.]";
        str = str.replaceAll(regex, "");
        str = str.replaceAll(",", ".");
        if(this.getText(0, this.getLength()).contains(".") && str.contains(".")){
            return;
        }
        super.insertString(offs, str, a);
    }
}
