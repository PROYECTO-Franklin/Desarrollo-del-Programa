
package Controles;
import ModeloBD.Cliente;
import ModeloBD.ModeloGeneric;
import ModeloBD.Pagos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.BD_manager;

/**
 *
 * @author HP
 */
public abstract class ControladorPagos extends ControladorAbs{

    @Override
    public boolean getDatos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ControladorPagos() {
        this.dbManager = new BD_manager();
    }

    
    
     public static Integer getUltimoRegistro() throws Exception
    {
             int claveclientess=0;
        
               BD_manager obj = new BD_manager();
               String sql;
               ResultSet rs;
               sql=("select ClvFolio FROM tblpago order by ClvFolio desc limit 1");
               rs= obj.consultar(sql);
             
               if(rs.next())
               {
                   claveclientess=rs.getInt(1);
                   return new Integer(claveclientess+1);                      
               }
                 
           
        
        return null;        
    }
    
    @Override
    public List getRegistros() throws Exception {
        ArrayList<Pagos> pagos  = new ArrayList<Pagos>();
        ControladorCliente cc = new ControladorCliente();
        Pagos pago;
        sql = "select ClvFolio,tblpago.NoCuenta,FechaCubierta,MesesTranscurridos,FechaDePago,Rezago,PagoCalculado,Recargo,Total,FechaDeRegistro from tblpago,tblcliente where tblpago.NoCuenta=tblcliente.NoCuenta";
        rs = dbManager.consultar(sql);
        while(rs.next())
        {
            pago = new Pagos();
            pago.setCivFolio(rs.getInt(1));
            pago.setNorCuenta(rs.getInt(2));
            pago.setFechaCubierta(rs.getString(3));
            pago.setMesesTranscurridos(rs.getInt(4));
            pago.setFechaPago(rs.getString(5));
            pago.setRezago(rs.getFloat(6));
            pago.setPagoCalculado(rs.getFloat(7));
            pago.setRecargo(rs.getFloat(8));
            pago.setTotal(rs.getFloat(9));
            pago.setFechaRegistro(rs.getDate(10));
            pago.setCliente((Cliente)cc.getRegistro(pago.getNorCuenta()));
            pagos.add(pago);
            
        }
        return pagos;       
    }

    @Override
    public void guardarRegistro(ModeloGeneric model) throws Exception {
        Pagos pago = (Pagos)model;
        sql = ("INSERT INTO tblpago (ClvFolio,NoCuenta,FechaCubierta,MesesTranscurridos,FechaDePago,Rezago,PagoCalculado,Recargo,Total,FechaDeRegistro) Values (" +
                pago.getCivFolio() + "," 
                + pago.getNorCuenta()+ ",'" 
                + pago.getFechaCubierta() + "'," 
                + pago.getMesesTranscurridos() + ",'" + 
                pago.getFechaPago() + "'," +
                pago.getRezago() + "," +
                pago.getPagoCalculado() + "," +
                pago.getRecargo() + "," + 
                pago.getTotal() + ",'" + 
                pago.getFechaFormateada(pago.getFechaRegistro()) + "')");
        dbManager.AbcProye(sql);
    }

    @Override
    public void actualizarRegistro(ModeloGeneric model) throws Exception {
        Pagos pago = (Pagos)model;
        sql = ("UPDATE tblpago SET FechaCubierta=" + pago.getFechaCubierta() 
                + ",MesesTranscurridos=" + pago.getMesesTranscurridos() 
                + ",FechaDePago=" + pago.getFechaPago()
                + ",Rezago=" + pago.getRezago() 
                + ",PagoCalculado=" + pago.getPagoCalculado() 
                + ",Recargo=" + pago.getRecargo() 
                + ",Total=" + pago.getTotal() 
                + ",FechaDeRegistro='"+ pago.getFechaFormateada(pago.getFechaRegistro())
                + "' where ClvFolio=" + pago.getCivFolio() + "");
        
        dbManager.AbcProye(sql);
    }

    @Override
    public void eliminarRegistro(ModeloGeneric model) throws Exception {
         Pagos pago = (Pagos)model;
         sql=("DELETE  FROM tblpago WHERE ClvFolio=" + pago.getCivFolio() + "");
         dbManager.AbcProye(sql);
    }
    
    public Pagos getFechaRegistro(String fecha) throws Exception
    {
        Pagos pg=null;
        sql=("select Clvfolio,Nocuenta,FechaCubierta FROM tblpago where NoCuenta='"+fecha+"' order by Clvfolio desc limit 1");
        rs = dbManager.consultar(sql);
        if(rs.next())
        {
            pg = new Pagos();
            pg.setCivFolio(rs.getInt(1));
            pg.setNorCuenta(rs.getInt(2));
            pg.setFechaCubierta(rs.getString(3));
        }
        
        return pg;
    }
    
    
}
