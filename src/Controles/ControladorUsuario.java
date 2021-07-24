package Controles;
import ModeloBD.ModeloGeneric;
import ModeloBD.Usuarios;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.BD_manager;

/**
 *
 * @author HP
 */
public class ControladorUsuario extends ControladorAbs{
    
    private String usuario;
    private String pass;    
    private Usuarios user;;

    public ControladorUsuario(String usuario, String pass) {
        this.dbManager = new BD_manager();        
        this.usuario = usuario;
        this.pass = ModeloGeneric.encriptarPassword(pass);       
        sql = "select ClvUsuario,Usuario,Contraseña,Archivo,IniciarSesion,CerrarSesion,RegistroDeUsuario,SalirDeAplicacion,Clientes,RegistroDeClientes,Pagos,RegistroDePagos,EmisionesOrdenes,Reportes,ReporteDeIngresos,ReporteDePagos,ReporteDeOrdenes,Herramientas,Calculadora,RespaldarBd,RestaurarBd,Ayuda,MostrarAyuda,AcercaDe from tblusuario where Usuario='" + this.usuario + "' and Contraseña='" + this.pass+ "'";
    }

    public ControladorUsuario() {
         this.dbManager = new BD_manager(); 
    }
    
    
    
    public boolean getDatos() throws Exception
    {
        rs = dbManager.consultar(sql);
        if(rs.next())
        {
            user = new Usuarios(usuario,pass);
            user.setArchivo(rs.getBoolean(4));
            user.setIniciarSesion(rs.getBoolean(5));
            user.setCerrarSesion(rs.getBoolean(6));
            user.setRegistroDeUsuario(rs.getBoolean(7));
            user.setSalirDeAplicacion(rs.getBoolean(8));
            
            user.setClientes(rs.getBoolean(9));
            user.setRegistroDeClientes(rs.getBoolean(10));
            
            user.setPagos(rs.getBoolean(11));
            user.setRegistroDePagos(rs.getBoolean(12));
            user.setEmisionesOrdenes(rs.getBoolean(13));
            
            user.setReportes(rs.getBoolean(14));
            user.setReporteDeIngresos(rs.getBoolean(15));
            user.setReporteDePagos(rs.getBoolean(16));
            user.setReporteDeOrdenes(rs.getBoolean(17));
            
            user.setHerramientas(rs.getBoolean(18));
            user.setCalculadora(rs.getBoolean(19));
            user.setRestaurarBd(rs.getBoolean(20));
            user.setRespaldarBd(rs.getBoolean(21));
            
            user.setAyuda(rs.getBoolean(22));
            user.setAcercaDe(rs.getBoolean(23));
            user.setMostrarAyuda(rs.getBoolean(24));
            rs.close();
            return true;
        }
        return false;
    } 
    
    public List getRegistros() throws Exception
    {
        ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
        sql = "select * from tblusuario";
        rs = dbManager.consultar(sql);
        while(rs.next())
        {
            user = new Usuarios(rs.getString(2),ModeloGeneric.desEncriptarPassword(rs.getString(3)));
            user.setClvUsuario(rs.getInt(1));
            user.setArchivo(rs.getBoolean(4));
            user.setIniciarSesion(rs.getBoolean(5));
            user.setCerrarSesion(rs.getBoolean(6));
            user.setRegistroDeUsuario(rs.getBoolean(7));
            user.setSalirDeAplicacion(rs.getBoolean(8));
            
            user.setClientes(rs.getBoolean(9));
            user.setRegistroDeClientes(rs.getBoolean(10));
            
            user.setPagos(rs.getBoolean(11));
            user.setRegistroDePagos(rs.getBoolean(12));
            user.setEmisionesOrdenes(rs.getBoolean(13));
            
            user.setReportes(rs.getBoolean(14));
            user.setReporteDeIngresos(rs.getBoolean(15));
            user.setReporteDePagos(rs.getBoolean(16));
            user.setReporteDeOrdenes(rs.getBoolean(17));
            
            user.setHerramientas(rs.getBoolean(18));
            user.setCalculadora(rs.getBoolean(19));
            user.setRestaurarBd(rs.getBoolean(20));
            user.setRespaldarBd(rs.getBoolean(21));
            
            user.setAyuda(rs.getBoolean(22));
            user.setAcercaDe(rs.getBoolean(23));
            user.setMostrarAyuda(rs.getBoolean(24));
            usuarios.add(user);
        }
        return usuarios;
    }
    

   

    public String getPass() {
        return ModeloGeneric.desEncriptarPassword(pass);
    }

    public void setPass(String pass) {
        this.pass = ModeloGeneric.encriptarPassword(pass);
    }

   

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }
    
    public static Integer getUltimoRegistro() throws Exception
    {
             int claveclientess=0;
        
               BD_manager obj = new BD_manager();
               String sql;
               ResultSet rs;
               sql=("select ClvUsuario FROM tblusuario order by ClvUsuario desc limit 1");
               rs= obj.consultar(sql);
             
               if(rs.next())
               {
                   claveclientess=rs.getInt(1);
                   return new Integer(claveclientess+1);                      
               }
                 
           
        
        return null;        
    }
    
    public void guardarRegistro(ModeloGeneric usr1) throws Exception
    {
        Usuarios usr = (Usuarios)usr1;
        sql = ("INSERT INTO tblusuario Values (" + usr.getClvUsuario()+ ",'" + usr.getUsuario()+ "','" + 
                ModeloGeneric.encriptarPassword(usr.getPassword())+ "'," +
                usr.getArchivo() + "," + 
                usr.getIniciarSesion() + "," + 
                usr.getCerrarSesion() + "," + 
                usr.getRegistroDeUsuario() + "," + 
                usr.getSalirDeAplicacion() + "," + 
                usr.getClientes() + "," + 
                usr.getRegistroDeClientes() + "," + 
                usr.getPagos() + "," + 
                usr.getRegistroDePagos() + "," + 
                usr.getEmisionesOrdenes() + "," + 
                usr.getReportes() + "," + 
                usr.getReporteDeIngresos() + "," + 
                usr.getReporteDePagos()+ "," + 
                usr.getReporteDeOrdenes() + "," + 
                usr.getHerramientas() + "," + 
                usr.getCalculadora() + "," + 
                usr.getRespaldarBd() + "," + 
                usr.getRestaurarBd() + "," + 
                usr.getAyuda() + "," + 
                usr.getMostrarAyuda() + "," + 
                usr.getAcercaDe() + ")");
        dbManager.AbcProye(sql);        
    }
    
    public void actualizarRegistro(ModeloGeneric usr1)throws Exception
    {
        Usuarios usr = (Usuarios)usr1;
        sql = ("UPDATE tblusuario SET Usuario='" + usr.getUsuario() + 
                "',Contraseña='" + ModeloGeneric.encriptarPassword(usr.getPassword()) + 
                "',Archivo=" + usr.getArchivo() + 
                ",IniciarSesion=" + usr.getIniciarSesion() +
                ",CerrarSesion=" + usr.getCerrarSesion() + 
                ",RegistroDeUsuario=" + usr.getRegistroDeUsuario() +
                ",SalirDeAplicacion=" + usr.getSalirDeAplicacion() +
                ",Clientes=" + usr.getClientes() + 
                ",RegistroDeClientes=" + usr.getRegistroDeClientes() +
                ",Pagos=" + usr.getPagos() + 
                ",RegistroDePagos=" + usr.getRegistroDePagos() +
                ",EmisionesOrdenes=" + usr.getEmisionesOrdenes() + 
                ",Reportes=" + usr.getReportes() + 
                ",ReporteDeIngresos=" + usr.getReporteDeIngresos() + 
                ",ReporteDePagos=" + usr.getReporteDePagos() + 
                ",ReporteDeOrdenes=" + usr.getReporteDeOrdenes() + 
                ",Herramientas=" + usr.getHerramientas() + 
                ",Calculadora=" + usr.getCalculadora() + 
                ",RespaldarBd=" + usr.getRespaldarBd() + 
                ",RestaurarBd=" + usr.getRestaurarBd() + 
                ",Ayuda=" + usr.getAyuda() + 
                ",MostrarAyuda=" + usr.getMostrarAyuda() +
                ",AcercaDe=" + usr.getAcercaDe() + 
                " where ClvUsuario=" + usr.getClvUsuario() + "");
                dbManager.AbcProye(sql);
    }
    
    public void eliminarRegistro(ModeloGeneric usr1) throws Exception
    {
        Usuarios usr = (Usuarios)usr1;
        sql=("DELETE  FROM tblusuario WHERE ClvUsuario='" + usr.getClvUsuario() + "'");
        dbManager.AbcProye(sql);
    }


    public void guardarRegistro(Object model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Para cambiar el cuerpo de los métodos generados, elija Herramientas | Plantillas.
    }

    public void actualizarRegistro(Object model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void eliminarRegistro(Object model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");     }

   
    
    
    
}
