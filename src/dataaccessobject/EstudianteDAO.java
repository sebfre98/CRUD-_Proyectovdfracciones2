/*
 *Clase usuarioDAO, Guardo informacion acerca de registrar, consultar, actualizar o eliminar el usuario.
el dataaccessobject por orden es mejor crearlo despues del VO y la conexionBD
toma los VO y la conexiona base de datos 
 */
package dataaccessobject;

import conexionBD.ConexionBD;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import valueobject.EstudianteVO;

/**
 *
 * @author Sebastian,Diego, Jorge
 */
public class EstudianteDAO {
     //Conectar con la base de datos creada en PostgreSQL
    private ConexionBD conexion;
    
    public EstudianteDAO(){
        conexion = new ConexionBD("postgres","71200");
    }
    
    //Registrar Estudiante en la tabla Estudiante
    public boolean registrarEstudiante(EstudianteVO estudianteVO){
        String cadenaSQL = "INSERT INTO public.\"Estudiante\" (\"COD_ESTUDIANTE\",\"NOM_ESTUDIANTE\",\"APE_ESTUDIANTE\",\"TEL_ESTUDIANTE\",\"COR_ESTUDIANTE\",\"CUR_ESTUDIANTE\") "
                          +" VALUES ('"+estudianteVO.getEstId()+"','"+estudianteVO.getEstNombre()+"', '"+estudianteVO.getEstApellido()+"','"+estudianteVO.getEstTelefono()+"','"+estudianteVO.getEstCorreo()+"','"+estudianteVO.getEstCurso()+"')";
    
        System.out.println("cadenaSQL "+cadenaSQL);
        
        return conexion.executeUpdateStatement(cadenaSQL);
    
    }
    //Consultar lista de Estudiantes 
    //actualizado 10/03/23 para ordenar ascendentemente por codigo de ESTUDIANTE
    public List<EstudianteVO> consultarListaEstudiante(){
        String cadenaSQL = "SELECT * FROM public.\"Estudiante\"ORDER BY \"COD_ESTUDIANTE\" ASC ";
        System.out.println("cadenaSQL "+cadenaSQL);
        
        ResultSet resultadoConsulta = conexion.executeQueryStatement(cadenaSQL);
        
        List<EstudianteVO> listaEstudianteVO = new ArrayList<>();
        
        
        try{
            while (resultadoConsulta.next()){
                EstudianteVO estudianteVO = new EstudianteVO();
                
                estudianteVO.setEstId(resultadoConsulta.getInt("COD_ESTUDIANTE"));                
               estudianteVO.setEstNombre(resultadoConsulta.getString("NOM_ESTUDIANTE"));
                estudianteVO.setEstApellido(resultadoConsulta.getString("APE_ESTUDIANTE"));
                estudianteVO.setEstTelefono(resultadoConsulta.getString("TEL_ESTUDIANTE"));
                estudianteVO.setEstCorreo(resultadoConsulta.getString("COR_ESTUDIANTE"));
                estudianteVO.setEstCurso(resultadoConsulta.getString("CUR_ESTUDIANTE"));
                
                listaEstudianteVO.add(estudianteVO);
            }
        }catch(SQLException ex){
            System.out.println("Se genero un error de tipo SQL en el metodo [consultarListaEstudiante()] de la clase [EstudianteDAO] "+ ex.getMessage());
        }
        
        return listaEstudianteVO;
        
    }
//Consular Estudiante por codigo
    public EstudianteVO consultarEstudiante(String idEst) {
        
        
        String cadenaSQL = "SELECT * FROM public.\"Estudiante\" WHERE \"COD_ESTUDIANTE\" = "+idEst;
        
        System.out.println("cadenaSQL "+cadenaSQL);
        
        ResultSet resultadoConsulta = conexion.executeQueryStatement(cadenaSQL);
        
        EstudianteVO estudianteVO = null;
        
        try{
            while (resultadoConsulta.next()){
                estudianteVO= new EstudianteVO();
                
                 estudianteVO.setEstId(resultadoConsulta.getInt("COD_ESTUDIANTE"));                
               estudianteVO.setEstNombre(resultadoConsulta.getString("NOM_ESTUDIANTE"));
                estudianteVO.setEstApellido(resultadoConsulta.getString("APE_ESTUDIANTE"));
                estudianteVO.setEstTelefono(resultadoConsulta.getString("TEL_ESTUDIANTE"));
                estudianteVO.setEstCorreo(resultadoConsulta.getString("COR_ESTUDIANTE"));
                estudianteVO.setEstCurso(resultadoConsulta.getString("CUR_ESTUDIANTE"));                               
            }
        }catch(SQLException ex){
            System.out.println("Se genero un error de tipo SQL en el metodo "
                    + "[consultarEstudiante(idEstudiante)] de la clase [EstudianteDAO] "+ ex.getMessage());
        }
        
        return estudianteVO;
        

    }
    
    //Modificar Estudiante (No se puede modificar el codigo).
    //error al actualizar estudiante revisar
    public boolean modificarEstudiante(EstudianteVO estudianteVO) {
        String cadenaSQL = "UPDATE public.\"Estudiante\" SET \"NOM_ESTUDIANTE\" = '"
                + estudianteVO.getEstNombre() +"', \"APE_ESTUDIANTE\" = '"+ estudianteVO.getEstApellido() 
                 +"', \"TEL_ESTUDIANTE\" = '" +estudianteVO.getEstTelefono()+"', \"COR_ESTUDIANTE\"  = '"
                + estudianteVO.getEstCorreo() +"', \"CUR_ESTUDIANTE\" = "+ estudianteVO.getEstCurso() +
                         " WHERE \"COD_ESTUDIANTE\" = " + estudianteVO.getEstId();
    
        System.out.println("cadenaSQL "+cadenaSQL);
        
        return conexion.executeUpdateStatement(cadenaSQL);
    }

    //Eliminar Estudiante
    public boolean eliminarEstudiante(EstudianteVO estudianteVO) {
        String cadenaSQL = "DELETE FROM public.\"Estudiante\" WHERE \"COD_ESTUDIANTE\" = "+estudianteVO.getEstId();
    
        System.out.println("cadenaSQL "+cadenaSQL);
        
        return conexion.executeUpdateStatement(cadenaSQL);
    }
    
    //revisar el metodo modificar
  
}
