
package ModeloGui;
import Controles.ControladorPagos;
import ModeloBD.Pagos;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class ModelTablaPago extends AbstractTableModel{
    
    private ArrayList<Pagos> pagos = new ArrayList<Pagos>();
    private String[] titulos = new String[17];
    private ControladorPagos cp;

    public ModelTablaPago() {
        titulos[0] ="ClvFolio";      
        titulos[1] ="Nombre";
        titulos[2] ="Direccion";
        titulos[3] ="Telefono";
        titulos[4] ="Colonia";
        titulos[5] ="Municipio";
        titulos[6] ="Rfc";
        titulos[7] ="Tarifa";
        titulos[8] ="NoCuenta";
        titulos[9] ="FechaCubierta";
        titulos[10] ="MesesTranscurridos";
        titulos[11] ="FechaDePago";
        titulos[12] ="Rezago";
        titulos[13] ="PagoCalculado";
        titulos[14] ="Recargo";
        titulos[15] ="Total";
        titulos[16] ="FechaDeRegistro";
        
        cp = new ControladorPagos() {};
        try {
            pagos = (ArrayList<Pagos>) cp.getRegistros();
            System.out.println(pagos.size());
        } catch (Exception ex) {}
    }
    
    
    public void borrarFila(int index) throws Exception
    {
       cp.eliminarRegistro(pagos.get(index)); 
       pagos.remove(index);
       fireTableRowsDeleted(index, index);
    }
    
    public Pagos getFila(int index)
    {
        return pagos.get(index);
    }
    
    public int getRowCount() {
        return pagos.size();
    }

    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }
    
    

    public Object getValueAt(int rowIndex, int columnIndex) {
       
        switch(columnIndex){
            case 0: return pagos.get(rowIndex).getCivFolio();
            case 1: return pagos.get(rowIndex).getCliente().getNombre();
            case 2: return pagos.get(rowIndex).getCliente().getDireccion();
            case 3: return pagos.get(rowIndex).getCliente().getTelefono();
            case 4: return pagos.get(rowIndex).getCliente().getColonia();
            case 5: return pagos.get(rowIndex).getCliente().getMunicipio();
            case 6: return pagos.get(rowIndex).getCliente().getRfc();
            case 7: return pagos.get(rowIndex).getCliente().getTarifa();   
            case 8: return pagos.get(rowIndex).getNorCuenta();   
            case 9: return pagos.get(rowIndex).getFechaCubierta();  
            case 10: return pagos.get(rowIndex).getMesesTranscurridos();   
            case 11:return pagos.get(rowIndex).getFechaPago();
            case 12:return pagos.get(rowIndex).getRezago();    
            case 13:return pagos.get(rowIndex).getPagoCalculado();    
            case 14:return pagos.get(rowIndex).getRecargo();    
            case 15:return pagos.get(rowIndex).getTotal();    
            case 16:return pagos.get(rowIndex).getFechaFormateada(pagos.get(rowIndex).getFechaRegistro()) ;
            default: return null;
        }
    }
    
}

