/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablepro;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class JNumberField extends JTextField {
 
     public JNumberField() {
         super();
     }
 
     protected Document createDefaultModel() {
         return new JNumberDocument(this);
     }
 
     static class JNumberDocument extends PlainDocument {

         JNumberField field;
        private JNumberDocument(JNumberField field) {
            super();
            this.field = field;
        }
 
         public void insertString(int offs, String str, AttributeSet a)
             throws BadLocationException {
 
             if (str == null || field.getText().length() >= 4) {
                 return;
             }
             char[] chars = str.toCharArray();
             String allowedInput = new String();
             for (int i = 0; i < chars.length; i++) {
                 if (Character.isDigit(chars[i]) || chars[i] == '-')
                     allowedInput += chars[i];
             }
             super.insertString(offs, allowedInput, a);
         }
     }
 }