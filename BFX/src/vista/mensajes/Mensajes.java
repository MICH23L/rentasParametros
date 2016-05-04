/*
 * Techno Engineers
 * Mensajes
 * 10/04/2016 -- Autorizo: Oscar de Paz Feliciano // Lider de proyecto
 * Modificaciones: 
 * Sirven para generalizar los mensajes de confirmación y fallos en el sistema
 * Numero de métodos en el codigo: 0
 * Interfaces: 
 */
package vista.mensajes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Techno Engineers
 */
public class Mensajes
{
    
    public static void exito(JFrame jf)
    {
        JOptionPane.showMessageDialog(jf, "La acción solicitada se ha realizado con éxito");
    }
    
    public static void falla(JFrame jf)
    {
        JOptionPane.showMessageDialog(jf, "La acción solicitada no se pudo concretar, verifique porfavor");
    }
    
    public static void falla(JFrame jf, String s)
    {
        JOptionPane.showMessageDialog(jf, s);
    }
    
    public static int consulta(JFrame jf,String s)
    {
        return JOptionPane.showConfirmDialog(jf, s);
    }
    public static void msj(JFrame jf , String s)
    {
        if(jf== null)
        {
            System.out.println("");
        }
    }
}
