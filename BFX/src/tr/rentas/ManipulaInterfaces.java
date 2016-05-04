/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.rentas;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author sitol
 */
public class ManipulaInterfaces
{

    public static void habilita(Object obj, boolean b)
    {
        if (obj instanceof JTextField)
        {
            JTextField jt = (JTextField) obj;
            jt.setEnabled(b);
        } else
        {
            if (obj instanceof JButton)
            {
                JButton jb = (JButton) obj;
                jb.setEnabled(b);
            }else
            {
                if (obj instanceof JComboBox)
                {
                    JComboBox jb = (JComboBox) obj;
                    jb.setEnabled(b);
                }
            }
        }
    }

    public static void cambiar(Object obj)
    {
        habilita(obj, true);
        if (obj instanceof JTextField)
        {
            JTextField jt = (JTextField) obj;
            selecciona(jt);
            jt.requestFocus();
        } else
        {
            if (obj instanceof JButton)
            {
                JButton jb = (JButton) obj;
                jb.requestFocus();
            }else
            {
                if (obj instanceof JComboBox)
                {
                    JComboBox jb = (JComboBox) obj;
                    jb.requestFocus();
                }
            }
        }
    }

    public static void selecciona(JTextField jt)
    {
        jt.setSelectionStart(0);
        jt.setSelectionEnd(jt.getText().length());
    }

    public static void habObjetos(boolean b, Object... arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            limpia(arr[i]);
            habilita(arr[i], b);

        }
    }

    public static void limpia(Object obj)
    {
        if (obj instanceof JTextField)
        {
            JTextField jt = (JTextField) obj;

            jt.setText("");
        }
    }
    
}
