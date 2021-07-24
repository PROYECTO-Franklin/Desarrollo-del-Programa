
package ModeloBD;
import Controles.EncriptadorPassword;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HP
 */
public class ModeloGeneric {
     private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    private Date fechaString;
    private final static String PASSNAME = "IdSfrc"; //no cambiar
    private static EncriptadorPassword ep;
    public String getFechaFormateada(Date fecha)
    {
        return formato.format((Date)fecha);
    }
    
    public Date stringToDate(String text)
    {        
        try {
            fechaString=(Date)formato.parseObject(text);
        } catch (ParseException ex) {}
        return fechaString;
    }
    
    public static String encriptarPassword(String pass)
    {
         ep = new EncriptadorPassword(PASSNAME);
         String encrypted = ep.encrypt(pass);
         return  encrypted;
    }
    
    public static String desEncriptarPassword(String pass)
    {
          ep = new EncriptadorPassword(PASSNAME);           
          String desEncrypted  = ep.decrypt(pass);
          return  desEncrypted;
    }
    
}
