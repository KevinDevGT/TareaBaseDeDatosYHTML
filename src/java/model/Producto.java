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

/**
 *
 * @author d3le0n
 */
public class Producto {
    
    
    private String nombre;
    private float precio;
    private String peso;
    private int categoria;
    private int marca;
    
    public Producto(){
        
    }
    
    
    public Producto(String nombre, float precio, String peso, int categoria, int marca){
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
        this.categoria = categoria;
        this.marca = marca;
    }
    
    
    
    
    public void ConsultarProductos(StringBuffer buffer){
        
        
            Conexion conexion = new Conexion();
            conexion.conectar();
            ResultSet resultado = conexion.ejecutar(Procedimientos.MostrarProductos);
            conexion.desconectar();
            
            if (resultado == null)
                return;
       try {     
           
            while (resultado.next()){
               
               buffer.append("<tr>");
                buffer.append(resultado.getString("CodigoProducto"));
                buffer.append(resultado.getString("Nombre"));
                buffer.append(resultado.getFloat("Precio"));
                buffer.append(resultado.getString("Peso"));
                buffer.append(resultado.getInt("CodigoCategoria"));
                buffer.append(resultado.getInt("Codigomarca"));
               buffer.append("</tr>");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ConsultarProductoPorCodigo(int codigoProducto, StringBuffer buffer){
        
        Conexion conexion = new Conexion();
        conexion.conectar();
        
        String numero = String.valueOf(codigoProducto);
        ResultSet resultado = conexion.ejecutar(Procedimientos.ObtenerProductoPorCodigo.replace("$", numero));
        conexion.desconectar();
        
        if (resultado == null)
                return;
       try {     
           
            while (resultado.next()){
               
                buffer.append("<tr>");
                buffer.append(resultado.getString("CodigoProducto"));
                buffer.append(resultado.getString("Nombre"));
                buffer.append(resultado.getFloat("Precio"));
                buffer.append(resultado.getString("Peso"));
                buffer.append(resultado.getInt("CodigoCategoria"));
                buffer.append(resultado.getInt("Codigomarca"));
               buffer.append("</tr>");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void guardarProducto(Producto producto){
        
        Conexion conexion = new Conexion();
        conexion.conectar();
        conexion.ejecutar(Procedimientos.CrearProducto.replace("$", producto.toString()));
        conexion.desconectar();
        
    }
    
    public void ActualizarProducto(int codigoProducto,Producto producto){
        
        Conexion conexion = new Conexion();
        conexion.conectar();
        conexion.ejecutar(Procedimientos.CrearProducto.replace("$", String.valueOf(codigoProducto) + ',' + producto.toString()));
        conexion.desconectar();
        
    }
    
    public void EliminarProducto(int codigoProducto){
        
        Conexion conexion = new Conexion();
        conexion.conectar();
        
        String numero = String.valueOf(codigoProducto);
        conexion.ejecutar(Procedimientos.EliminarProducto.replace("$", numero));
        conexion.desconectar();
        
    }
    
    
    @Override
    public String toString(){
        
        return "'" +this.nombre + "'," + this.precio +", '" + peso +"',"+ this.marca + ',' + this.categoria; 
    }
}