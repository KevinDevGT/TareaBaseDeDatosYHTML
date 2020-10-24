/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

/**
 *
 * @author KEVINSAMA
 */
public class Procedimientos {
    
    public static String LeerCategorias = "call listarCategorias();";
    
    public static String LeerMarcas = "call listarMarcas();";
    
    public static String ObtenerProductoPorCodigo = "call ObtenerProductoPorCodigo($);";
    
    public static String MostrarProductos = "call MostrarProducto();";
    
    public static String EliminarProducto = "call EliminarProducto($);";
    
    public static String ActualizarProducto = "call ActualizarProducto($);";
    
    public static String CrearProducto = "call CrearProducto($);";
    
}
