/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
el dataaccessobject por orden es mejor crearlo despues del VO y la conexionBD
toma los VO y la conexiona base de datos 
 */
package dataaccessobject;

import conexionBD.ConexionBD;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import valueobject.NivlVO;

/**
 *
 * @author Sebastian, Jorge, Diego
 */
public class NivlDAO {
    //Conectar con la base de datos creada en PostgreSQL
    private ConexionBD conexion;
    
    public NivlDAO(){
        conexion = new ConexionBD("postgres","71200");
    }
    
    public boolean registrarNivl(NivlVO nivlVO){
        String cadenaSQL = "INSERT INTO public.\"Nivel\" (\"COD_NIVEL\",\"NOM_NIVEL\") "
                           +" VALUES ('"+nivlVO.getNivlId()+"','"+nivlVO.getNivlNombre()+"')";
    
        System.out.println("cadenaSQL "+cadenaSQL);
        
        return conexion.executeUpdateStatement(cadenaSQL);
    
    }
    //Consultar lista de niveles
    //actualizado 10/03/23 para ordenar ascendentemente por codigo de nivel
    public List<NivlVO> consultarListaNivl(){
        String cadenaSQL = "SELECT * FROM public.\"Nivel\"ORDER BY \"COD_NIVEL\" ASC ";
        
        System.out.println("cadenaSQL "+cadenaSQL);
        
        ResultSet resultadoConsulta = conexion.executeQueryStatement(cadenaSQL);
        
        List<NivlVO> listaNivlVO = new ArrayList<>();
        
        try{
            while (resultadoConsulta.next()){
               NivlVO nivlVO = new NivlVO();
                
                nivlVO.setNivlId(resultadoConsulta.getInt("COD_NIVEL"));                
                nivlVO.setNivlNombre(resultadoConsulta.getString("NOM_NIVEL"));
               
                
                listaNivlVO.add(nivlVO);
            }
        }catch(SQLException ex){
            System.out.println("Se genero un error de tipo SQL en el metodo [consultarListaNivl()] de la clase [NivlDAO] "+ ex.getMessage());
        }
        
        return listaNivlVO;
        
    }
//Consultar nivel por codigo
    public NivlVO consultarNivl(String idNivl) {
        
        
        String cadenaSQL = "SELECT * FROM public.\"Nivel\" WHERE \"COD_NIVEL\" = "+idNivl;
        
        System.out.println("cadenaSQL "+cadenaSQL);
        
        ResultSet resultadoConsulta = conexion.executeQueryStatement(cadenaSQL);
        
       NivlVO nivlVO = null;
        
        try{
            while (resultadoConsulta.next()){
                nivlVO = new NivlVO();
                
                nivlVO.setNivlId(resultadoConsulta.getInt("COD_NIVEL"));                
                nivlVO.setNivlNombre(resultadoConsulta.getString("NOM_NIVEL"));
                                          
            }
        }catch(SQLException ex){
            System.out.println("Se genero un error de tipo SQL en el metodo [consultarReto(idNivl)] de la clase [NivlDAO] "+ ex.getMessage());
        }
        
        return nivlVO;

    }
    //Modificar nivel (No se puede modificar el codigo).
//TENER EN CUENTA LAS COMILLAS SIMPLES :V '
    public boolean modificarNivl(NivlVO nivlVO) {
        String cadenaSQL = "UPDATE public.\"Nivel\" SET \"NOM_NIVEL\" = '"+ nivlVO.getNivlNombre() +
                "' WHERE \"COD_NIVEL\" = "+nivlVO.getNivlId();
    
        System.out.println("cadenaSQL "+cadenaSQL);
        
        return conexion.executeUpdateStatement(cadenaSQL);
    }
//Eliminar Nivel
    public boolean eliminarNivl(NivlVO nivlVO) {
        String cadenaSQL = "DELETE FROM public.\"Nivel\" WHERE \"COD_NIVEL\" = "+nivlVO.getNivlId();
    
        System.out.println("cadenaSQL "+cadenaSQL);
        
        return conexion.executeUpdateStatement(cadenaSQL);
    }



}
