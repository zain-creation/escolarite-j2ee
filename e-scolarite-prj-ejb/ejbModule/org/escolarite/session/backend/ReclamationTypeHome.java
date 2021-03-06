package org.escolarite.session.backend;

import org.escolarite.database.persistance.entities.*;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityHome;

@Name("reclamationTypeHome")
@Scope(ScopeType.EVENT)
public class ReclamationTypeHome extends EntityHome<ReclamationType> {

	public void setReclamationTypesId(Long id) {
		setId(id);
	}

	public Long getReclamationTypesId() {		
		return (Long) getId();		
	}

	@Override
	protected ReclamationType createInstance() {
		ReclamationType reclamationType = new ReclamationType();
		return reclamationType;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public ReclamationType getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
