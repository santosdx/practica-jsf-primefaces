package com.nerv.demo.componente.lista;

import com.nerv.demo.dto.ObjListaUnicaSeleccion;
import com.nerv.demo.utilidad.Mensaje;
import java.util.List;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import org.apache.log4j.Logger;

/**
 * Clase que administra la implementación del un componente de unica seleccion.
 * @author santosdx
 */
@FacesComponent (value = "ListaUnicaSeleccion")
public class UnicaSeleccion extends UINamingContainer{
    
    final static Logger LOGGER = Logger.getLogger(UnicaSeleccion.class);
    private List<ObjListaUnicaSeleccion> lista;
    private ObjListaUnicaSeleccion objSeleccion;
    
    public UnicaSeleccion() {  
        super();  
    }
    
    /**
     * Método que permite visualizar un mensaje con los datos del item seleccionado de la lista.
     * @param actionEvent 
     */
    public void validarSeleccion(ActionEvent actionEvent) {
        if(getObjSeleccion() != null){
            Mensaje.agregarMensajeGrowl("Selección,["+getObjSeleccion().getId()+"] "+getObjSeleccion().getLabel());
        }else{
            Mensaje.agregarMensajeGrowl("Debe seleccionar un item.");
        }
    } 

    /**
     * Método listener que se ejecuta al seleccionar un item en el objeto visual de la lista.
     */
    public void seleccionListener() {
        if(getObjSeleccion() != null){
            LOGGER.info("Selección,["+getObjSeleccion().getId()+"] "+getObjSeleccion().getLabel());
        }else{
            LOGGER.info("Debe seleccionar un item.");
        }
    } 

    /**
     * Método que permite obtener un item de la lista, buscando por el id.
     * @param id
     * @return 
     */
    public ObjListaUnicaSeleccion getById(String id){
        ObjListaUnicaSeleccion resultado = null;
        
        for (ObjListaUnicaSeleccion item : getLista()) {
            if(id.equals(item.getId())){
                resultado = item;
                break;
            }
        }
        return resultado;
    }
    
    // Lista Métodos Set y Get
    
    public List<ObjListaUnicaSeleccion> getLista() {
        return lista;
    }

    public void setLista(List<ObjListaUnicaSeleccion> lista) {
        this.lista = lista;
    }

    public ObjListaUnicaSeleccion getObjSeleccion() {
        return objSeleccion;
    }

    public void setObjSeleccion(ObjListaUnicaSeleccion objSeleccion) {
        this.objSeleccion = objSeleccion;
    }
    
    
}
