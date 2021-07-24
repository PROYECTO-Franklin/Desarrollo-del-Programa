package Controles;

import ModeloBD.ModeloGeneric;
import java.sql.ResultSet;
import java.util.List;
import Interfaces.BD_manager;

/**
 *
 * FRC
 */
public abstract class ControladorAbs<mdl extends ModeloGeneric> {
    public BD_manager dbManager;
    public ResultSet rs;
    public String sql;
    
     public BD_manager getDbManager() {
        return dbManager;
    }

    public void setDbManager(BD_manager dbManager) {
        this.dbManager = dbManager;
    }
    
     public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    
    public abstract boolean getDatos()throws Exception;
    public abstract List getRegistros()throws Exception;
    public abstract void guardarRegistro(mdl model)throws Exception;
    public abstract void actualizarRegistro(mdl model)throws Exception;
    public abstract void eliminarRegistro(mdl model)throws Exception;
  
    
}
