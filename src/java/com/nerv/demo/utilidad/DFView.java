package com.nerv.demo.utilidad;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author santosdx
 */ 
@ManagedBean(name = "dfView")
public class DFView implements Serializable{

    public void view2() {
        RequestContext.getCurrentInstance().openDialog("view-acceso-sistema");
    }
        
    public void view(String view) {
        RequestContext.getCurrentInstance().openDialog(view);
    }
     
    public void viewCustomized(String view) {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 320);
        
        //RequestContext context = RequestContext.getCurrentInstance();
        //context.openDialog(view, options, null);
        RequestContext.getCurrentInstance().openDialog(view, options, null);
    }
}