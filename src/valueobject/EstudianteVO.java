/*
 * Clase EstudianteVO;
 */
package valueobject;

/**
 *Objeto a evaluar por orden la clase VO; es la primer clase en crearse para evitar enredos o inconvenientes.
 * @author Sebastian, Diego, Jorge
 */
public class EstudianteVO {
    
    private int estId;
    private String estNombre;
    private String estApellido;
    private String estTelefono;
    private String estCorreo;
    private String estCurso;

    public int getEstId() {
        return estId;
    }

    public void setEstId(int estId) {
        this.estId = estId;
    }

    public String getEstNombre() {
        return estNombre;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    public String getEstApellido() {
        return estApellido;
    }

    public void setEstApellido(String estApellido) {
        this.estApellido= estApellido;
    }

    public String getEstTelefono (){
       return estTelefono;
    }
    
    public void setEstTelefono (String estTelefono) {
        this.estTelefono = estTelefono;
    
    }
    
    public String getEstCorreo() {
        return estCorreo;
    }

    public void setEstCorreo(String estCorreo) {
        this.estCorreo = estCorreo;
    }
    
      public String getEstCurso() {
        return estCurso;
    }

    public void setEstCurso(String estCurso) {
        this.estCurso = estCurso;
    }
    
}
