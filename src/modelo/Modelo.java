/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
Por orden es mejor crear el Modelo de ultimo antes de implementar las vistas
de aca se toma el acceso a objeto de datos DAO y el VO
 * and open the template in the editor.
 */
package modelo;

import dataaccessobject.EstudianteDAO;

//Nivel
import valueobject.NivlVO;
import dataaccessobject.NivlDAO;
import dataaccessobject.PunuDAO;
import java.util.List;
import valueobject.EstudianteVO;
import valueobject.PunuVO;
/**
 *
 * @author Sebastian, Diego, Jorge
 */
public class Modelo {
    //modelo usuario
        private EstudianteDAO estudianteDAO;
  
     public boolean registrarNuevoEstudiante(EstudianteVO estudianteVO){
         estudianteDAO= new EstudianteDAO();         
         return estudianteDAO.registrarEstudiante(estudianteVO);
    }

    public List<EstudianteVO> consultarListaEstudiante() {
       estudianteDAO = new EstudianteDAO();         
         return estudianteDAO.consultarListaEstudiante();
    }
public EstudianteVO consultarEstudiante(String idEst) {
        estudianteDAO = new EstudianteDAO();         
         return estudianteDAO.consultarEstudiante(idEst);
    }
    public boolean modificarEstudiante(EstudianteVO estudianteVO) {
        estudianteDAO = new EstudianteDAO();         
         return estudianteDAO.modificarEstudiante(estudianteVO);
    }

    public boolean eliminarEstudiante(EstudianteVO estudianteVO) {
        estudianteDAO= new EstudianteDAO();         
         return estudianteDAO.eliminarEstudiante(estudianteVO);
    }

    //Modelo Nivel
    
    private NivlDAO nivlDAO;
    
    
     public boolean registrarNuevoNivl(NivlVO nivlVO){
         nivlDAO = new NivlDAO();         
         return nivlDAO.registrarNivl(nivlVO);
    }
      public List<NivlVO> consultarListaNivl() {
       nivlDAO = new NivlDAO();         
         return nivlDAO.consultarListaNivl();

      }
     public NivlVO consultarNivl(String idNivl) {
         nivlDAO = new NivlDAO();         
         return nivlDAO.consultarNivl(idNivl);
    }

    public boolean modificarNivl(NivlVO nivlVO) {
        nivlDAO = new NivlDAO();         
         return nivlDAO.modificarNivl(nivlVO);
    }

    public boolean eliminarNivl(NivlVO nivlVO) {
        nivlDAO = new NivlDAO();         
         return nivlDAO.eliminarNivl(nivlVO);
    }
    //Modelo puntuacion
    
    private PunuDAO punuDAO;
    
    
     public boolean registrarNuevoPunu(PunuVO punuVO){
         punuDAO = new PunuDAO();         
         return punuDAO.registrarPunu(punuVO);
    }
     
     public List<PunuVO> consultarListaPunu() {
       punuDAO = new PunuDAO();         
         return punuDAO.consultarListaPunu();

      }
    public PunuVO consultarPunu(int idPunu) {
        punuDAO = new PunuDAO();         
         return punuDAO.consultarPunu(idPunu);
    }

    public boolean modificarPunu(PunuVO punuVO) {
        punuDAO = new PunuDAO();         
         return punuDAO.modificarPunu(punuVO);
    }

    public boolean eliminarPunu(PunuVO punuVO) {
        punuDAO = new PunuDAO();         
         return punuDAO.eliminarPunu(punuVO);
    }
}
