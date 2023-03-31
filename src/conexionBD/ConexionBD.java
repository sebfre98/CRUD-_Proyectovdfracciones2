/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
Conectar la base de datos creada previamente en PostgreSQL para utilizarla en JAVA
 */
package conexionBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class ConexionBD {

    public final static String CLASE_CONEXION = "org.postgresql.Driver";

    private String user;
    private String password;
    private String url;
    private Connection conn;
    private Statement stmt;

    public ConexionBD(String us, String pass) {
        url = "jdbc:postgresql://localhost:5432/bdfracciones";
        user = "postgres";
        password = "71200";
        conectar();
    }

    private void conectar() {
        try {            
            Class.forName(CLASE_CONEXION).newInstance();            
            conn = DriverManager.getConnection(url, user, password);            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se genero el siguiente error " + ex, "Mensajes", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada: " + ex);
        } catch (Exception ex) {
            System.out.println("Otra excepcion: " + ex);
        }
    }

    public boolean executeUpdateStatement(String cad) {
        int r = 0;
        try {
            stmt = conn.createStatement();
            r = stmt.executeUpdate(cad);
            System.out.println("Actualizacion realizada... " + r);
            //conn.commit();
            stmt.close();
            return true;
        } catch (Exception ex) {
            System.out.println("No se pudo ejecutar la grabacion... " + ex);
            JOptionPane.showMessageDialog(null, "Se ha generado un error dado por: " + ex, "Critical Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public ResultSet executeQueryStatement(String cad) {
        ResultSet res = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = stmt.executeQuery(cad);
            System.out.println("Consulta realizada...");
        } catch (Exception ex) {
            System.out.println("No se pudo ejectuar la consulta... " + ex);
        }
        return res;
    }

   // public String executeFunction(String cadProc) {
       // String res = "";
       // try {

           // CallableStatement proc = conn.prepareCall("{? = call " + cadProc + " }");
          //  proc.registerOutParameter(1, OracleTypes.VARCHAR);
          //  proc.execute();
            //res = "" + proc.getObject(1);
       // } catch (SQLException e) {
            //System.out.println("Problemas con la invocacion del procedimiento " + cadProc + " \n" + e);
        //}

       // return res;
   // }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }
}
