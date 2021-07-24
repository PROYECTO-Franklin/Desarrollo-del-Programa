
package Interfaces;
import java.awt.Image;
import javax.swing.JFrame;
/**
 *
 * @author HP
 */
public class Jframefondo extends JFrame {
    private final Jpanelfondo contenedor = new Jpanelfondo();

    public Jframefondo() {
        setContentPane(contenedor);
    }

    public void setImagen(String nombreImagen) {
        contenedor.setImagen(nombreImagen);
    }

    public void setImagen(Image nuevaImagen) {
        contenedor.setImagen(nuevaImagen);
    }
}

