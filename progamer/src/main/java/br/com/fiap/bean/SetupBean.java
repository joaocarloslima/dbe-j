package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;
import br.com.fiap.service.UploadService;

@Named
@RequestScoped
public class SetupBean {

	private Setup setup = new Setup();
	
	@Inject //injeção de dependencia
	private SetupDao dao;
	
	private UploadedFile image;
	
	public String save() {
		System.out.println(this.setup);
		setup.setImagePath( UploadService.write(image, "setups"));
		dao.create(setup);
		
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage("Setup cadastrado com sucesso"));
		
		return "setups";
	}
	
	public List<Setup> getAll(){
		return dao.listAll();
	}
	
	public String remove(Setup setup) {
		dao.remove(setup);
		
		FacesContext
		.getCurrentInstance()
		.addMessage(null, new FacesMessage("Setup apagado com sucesso"));

		return "setups?faces-redirect=true";
	}
	
	public void edit() {
		dao.update(setup);
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage("Setup atualizado com sucesso"));
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

}
