
package dataaccessobject;

import conexionBD.ConexionBD;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import valueobject.PunuVO;


/**
 *el dataaccessobject por orden es mejor crearlo despues del VO y la conexionBD
toma los VO y la conexiona base de datos 
 * @author Sebastian, Diego, Jorge
 */
public class PunuDAO {
     //Conectar con la base de datos creada en PostgreSQL
    private ConexionBD conexion;
    
    public PunuDAO(){
        conexion = new ConexionBD("postgres","71200");
    }
    //Registrar puntuacion en tabla puntuacion
    public boolean registrarPunu(PunuVO punuVO){
        String cadenaSQL = "INSERT INTO public.\"Puntuacion\" (\"COD_PUNTUACION\",\"COD_ESTUDIANTE\", \"COD_NIVEL\", \"PUNTAJE\") "
                           +" VALUES ('"+punuVO.getPunuId()+"','"+punuVO.getCodEst()+"','"+punuVO.getCodNiv()+"','"+punuVO.getPuntaje()+"')";
    
        System.out.println("cadenaSQL "+cadenaSQL);
        
        return conexion.executeUpdateStatement(cadenaSQL);
    
    }
    //Consultar lista de puntuacion
    //actualizado 10/03/23 para ordenar ascendentemente por codigo de PUNTUACION
    public List<PunuVO> consultarListaPunu(){
        String cadenaSQL = "SELECT * FROM public.\"Puntuacion\"ORDER BY \"COD_PUNTUACION\" ASC ";
        
        System.out.println("cadenaSQL "+cadenaSQL);
        
        ResultSet resultadoConsulta = conexion.executeQueryStatement(cadenaSQL);
        
        List<PunuVO> listaPunuVO = new ArrayList<>();
        
        try{
            while (resultadoConsulta.next()){
               PunuVO punuVO = new PunuVO();
                
                punuVO.setPunuId(resultadoConsulta.getInt("COD_PUNTUACION"));                
                punuVO.setCodEst(resultadoConsulta.getInt("COD_ESTUDIANTE"));
                punuVO.setCodNiv(resultadoConsulta.getInt("COD_NIVEL"));
                punuVO.setPuntaje(resultadoConsulta.getInt("PUNTAJE"));
                
                listaPunuVO.add(punuVO);
            }
        }catch(SQLException ex){
            System.out.println("Se genero un error de tipo SQL en el metodo [consultarListaPunu()] de la clase [PunuDAO] "+ ex.getMessage());
        }
        
        return listaPunuVO;
        
    }
//Consultar PUNTUACION por codigo
    public PunuVO consultarPunu(int idPunu) {
        
        
        String cadenaSQL = "SELECT * FROM public.\"Puntuacion\" WHERE \"COD_PUNTUACION\" = "+idPunu;
        
        System.out.println("cadenaSQL "+cadenaSQL);
        
        ResultSet resultadoConsulta = conexion.executeQueryStatement(cadenaSQL);
        
       PunuVO punuVO = null;
        
        try{
            while (resultadoConsulta.next()){
                punuVO = new PunuVO();
                
                punuVO.setPunuId(resultadoConsulta.getInt("COD_PUNTUACION"));                
                punuVO.setCodEst(resultadoConsulta.getInt("COD_ESTUDIANTE"));
                punuVO.setCodNiv(resultadoConsulta.getInt("COD_NIVEL"));
                punuVO.setPuntaje(resultadoConsulta.getInt("PUNTAJE"));                                
            }
        }catch(SQLException ex){
            System.out.println("Se genero un error de tipo SQL en el metodo [consultarPunu(idPunu)] de la clase [PunuDAO] "+ ex.getMessage());
        }
        
        return punuVO;
        
        
        
    }

    //Modificar Puntuacion (No se puede modificar el codigo).
    public boolean modificarPunu(PunuVO punuVO) {
        String cadenaSQL = "UPDATE public.\"Puntuacion\" SET \"COD_ESTUDIANTE\" = '"
                + punuVO.getCodEst() +"', \"COD_NIVEL\" = '"
                + punuVO.getCodNiv() +"', \"PUNTAJE\" = "+ punuVO.getPuntaje() 
                + " WHERE \"COD_PUNTUACION\" = "+ punuVO.getPunuId();
    
        System.out.println("cadenaSQL "+cadenaSQL);
        
        return conexion.executeUpdateStatement(cadenaSQL);
    }

    //Eliminar PUNTUACION
    public boolean eliminarPunu(PunuVO punuVO) {
        String cadenaSQL = "DELETE FROM public.\"Puntuacion\" WHERE \"COD_PUNTUACION\" = "
                +punuVO.getPunuId();
    
        System.out.println("cadenaSQL "+cadenaSQL);
        
        return conexion.executeUpdateStatement(cadenaSQL);
    }

   

}
