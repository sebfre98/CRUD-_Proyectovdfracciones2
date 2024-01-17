
package valueobject;

/**
 *Objeto a evaluar por orden la clase VO; es la primer clase en crearse para evitar enredos o inconvenientes.
 * @author Sebastian Aguirre L
 */
public class PunuVO {
    //llave principal 
    private int punuId;
    //codigo estudiante relacionado en tabla puntuacion
    private int codEst;
    //codigo nivel relacionado en tabla puntuacion
    private int codNiv;
    //puntaje del estudiante en el nivel jugado
    private int puntaje;

    public int getPunuId() {
        return punuId;
    }

    public void setPunuId(int punuId) {
        this.punuId = punuId;
    }

    public int getCodEst() {
        return codEst;
    }

    public void setCodEst(int codEst) {
        this.codEst = codEst;
    }

    public int getCodNiv() {
        return codNiv;
    }

    public void setCodNiv(int codNiv) {
        this.codNiv = codNiv;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    
}
