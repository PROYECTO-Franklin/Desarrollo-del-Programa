
package Interfaces;
import javax.swing.text.*;

/**
 *
 * @author HP
 */
public class Jtexfield extends PlainDocument
{
    private int limit;
    
    private boolean toUppercase = false;

    Jtexfield(int limit) {
    super();
    this.limit = limit;
    }

    Jtexfield(int limit, boolean upper) {
    super();
    this.limit = limit;
    toUppercase = upper;
    }
    
}
