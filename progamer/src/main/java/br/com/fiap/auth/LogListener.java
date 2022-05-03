package br.com.fiap.auth;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent e) {
		System.out.println("DEPOIS DA FASE " + e.getPhaseId());
		
	}

	@Override
	public void beforePhase(PhaseEvent e) {
		System.out.println("ANTES DA FASE " + e.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
