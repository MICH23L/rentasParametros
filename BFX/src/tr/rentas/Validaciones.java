/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.rentas;




//import Vista.mensajes.Mensajes;
import vista.mensajes.Mensajes;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author sitol
 */
public class Validaciones
{
    public static void entero (KeyEvent evt ){
        if ((evt.getKeyChar()<'0'|| evt.getKeyChar()>'9')&& (evt.getKeyChar()!='\b'))
        {
           evt.setKeyChar((char)8);
        }
    }
    
     public static void cadena (KeyEvent evt ){
        if (((evt.getKeyChar()<'a'|| evt.getKeyChar()>'z') && (evt.getKeyChar()<'A'|| evt.getKeyChar()>'Z'))&& ((evt.getKeyChar()!='\b' && evt.getKeyChar()!='ñ' && evt.getKeyChar()!='Ñ'&& evt.getKeyChar()!='á' && evt.getKeyChar()!='Á'&& evt.getKeyChar()!='é' && evt.getKeyChar()!='É' && evt.getKeyChar()!='í' && evt.getKeyChar()!='Í' && evt.getKeyChar()!='ó' && evt.getKeyChar()!='Ó' && evt.getKeyChar()!='ú' && evt.getKeyChar()!='Ú' && evt.getKeyChar()!='ü'&& evt.getKeyChar()!=' ')))
        {
           evt.setKeyChar((char)8);
        }
    }
      public static void flotante (KeyEvent evt ){
        if (((evt.getKeyChar()<'0'|| evt.getKeyChar()>'9')) && ((evt.getKeyChar()!='\b' && evt.getKeyChar()!='.')))
        {
           evt.setKeyChar((char)8);
        }
    }public static void cjaEntero( JTextField jt,Object obj, JFrame jf){
        
            
               
            
                try{
                    int x=Integer.parseInt(jt.getText());
                    ManipulaInterfaces.cambiar(obj);
                }
                catch(Exception e){
                    Mensajes.msj(jf, "Se esperaba un entero");
                    ManipulaInterfaces.selecciona(jt);
                    jt.requestFocus();
                    
                    
                }
            
    }
    
    public static void cjaDouble( JTextField jt,Object obj, JFrame jf){
        
            
               
            
                try{
                    double x=Double.parseDouble(jt.getText());
                    ManipulaInterfaces.cambiar(obj);
                }
                catch(Exception e){
                    Mensajes.msj(jf, "Se esperaba un flotante o es un verdaderpo idiota");
                    ManipulaInterfaces.selecciona(jt);
                    jt.requestFocus();
                    
                    
                }
            
    }
      
    public static void cadenaN (KeyEvent evt ){
        if (((evt.getKeyChar()<'0'|| evt.getKeyChar()>'9')&&(evt.getKeyChar()<'a'|| evt.getKeyChar()>'z') && (evt.getKeyChar()<'A'|| evt.getKeyChar()>'Z'))&& ((evt.getKeyChar()!='\b' && evt.getKeyChar()!='ñ' && evt.getKeyChar()!='Ñ'&& evt.getKeyChar()!='á' && evt.getKeyChar()!='Á'&& evt.getKeyChar()!='é' && evt.getKeyChar()!='É' && evt.getKeyChar()!='í' && evt.getKeyChar()!='Í' && evt.getKeyChar()!='ó' && evt.getKeyChar()!='Ó' && evt.getKeyChar()!='ú' && evt.getKeyChar()!='Ú' && evt.getKeyChar()!='ü'&& evt.getKeyChar()!=' ')))
        {
           evt.setKeyChar((char)8);
        }
    }
    
}
