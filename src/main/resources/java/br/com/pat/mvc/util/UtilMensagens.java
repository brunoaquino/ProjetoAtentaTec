package br.com.pat.mvc.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UtilMensagens {
	public static void setMsgInfo(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Aten��o!", msg));
	}

	public static void setMsgWarn(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Aten��o!", msg));
	}

	public static void setMsgError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", msg));
	}

	public static void setMsgFatal(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro Fatal!",msg));
	}
}
