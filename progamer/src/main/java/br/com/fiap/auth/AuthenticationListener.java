package br.com.fiap.auth;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.fiap.model.User;

public class AuthenticationListener implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent arg0) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		String viewId = context.getViewRoot().getViewId();
		if (viewId.equals("/login.xhtml") || viewId.equals("/register.xhtml")) return;
		
		User user = (User) context
			.getExternalContext()
			.getSessionMap()
			.get("user");
		
		if(user == null) {
			context
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(context, null, "login");
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
