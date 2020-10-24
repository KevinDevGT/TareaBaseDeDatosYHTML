/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Conexion;
import utilidades.Procedimientos;

public class Categoria {
    
    
    public void ConsultarCategorias(StringBuffer buffer){
        
        
            Conexion conexion = new Conexion();
            conexion.conectar();
            ResultSet resultado = conexion.ejecutar(Procedimientos.LeerCategorias);
            conexion.desconectar();
            
            if (resultado == null)
                return;
       try {     
           
            while (resultado.next()){
                buffer.append("<option value=\"").append(resultado.getString("CodigoCategoria")).append(" \">").append(resultado.getString("Nombre")).append("</option>");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}