/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
Segundo paquete en crearse por cuestiones de orden y su clase es Fachada.
Toma los VO
 * and open the template in the editor.
 */
package fachada;

import java.util.List;
import modelo.Modelo;
import valueobject.EstudianteVO;
import valueobject.NivlVO;
import valueobject.PunuVO;


/**
 *
 * @author Sebastian, Diego, Jorge
 */
public class Fachada {
    
    private Modelo modelo;
    
    public Fachada(){
        modelo = new Modelo();
    }
    
    //Usuario
    public boolean registrarNuevoEstudiante(EstudianteVO estudianteVO){
        return modelo.registrarNuevoEstudiante(estudianteVO);        
    }

    public List<EstudianteVO> consultarListaEstudiante() {
        return modelo.consultarListaEstudiante();
    }
    public EstudianteVO consultarEstudiante(String idEst) {
        return modelo.consultarEstudiante(idEst);
    }
//actualizar y modificar son lo mismo en este codigo
    public boolean modificarEstudiante(EstudianteVO estudianteVO) {
        return modelo.modificarEstudiante(estudianteVO);
    }

    public boolean eliminarEstudiante(EstudianteVO estudianteVO) {
        return modelo.eliminarEstudiante(estudianteVO);
    }
    
    
    //Nivel
   
    public boolean registrarNuevoNivl(NivlVO nivlVO){
        return modelo.registrarNuevoNivl(nivlVO);        
    }
public List<NivlVO> consultarListaNivl() {
        return modelo.consultarListaNivl();
        
}
    public NivlVO consultarNivl(String idNivl) {
        return modelo.consultarNivl(idNivl);
    }

    public boolean modificarNivl(NivlVO nivlVO) {
        return modelo.modificarNivl(nivlVO);
    }

    public boolean eliminarNivl(NivlVO nivlVO) {
        return modelo.eliminarNivl(nivlVO);
    }
    
    
    //Puntuacion
    
    
    public boolean registrarNuevoPunu(PunuVO punuVO){
        return modelo.registrarNuevoPunu(punuVO);        
    }
    
    public List<PunuVO> consultarListaPunu() {
        return modelo.consultarListaPunu();
        
}
    
    public PunuVO consultarPunu(int idPunu) {
        return modelo.consultarPunu(idPunu);
    }

    public boolean modificarPunu(PunuVO punuVO) {
        return modelo.modificarPunu(punuVO);
    }

    public boolean eliminarPunu(PunuVO punuVO) {
        return modelo.eliminarPunu(punuVO);
    }


  
}
