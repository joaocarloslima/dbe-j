package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;

@Named
@RequestScoped
public class UserBean {

	private User user = new User();
	
	private UserDao dao = new UserDao();
	
	public void save() {
		System.out.println(this.user);
		dao.create(user);
	}
	
	public List<User> getAll(){
		return dao.listAll();
	}
	
	public String login() {
		System.out.println(user);
		if (dao.exist(user)) {
			return "setups";
		}else {
			return "login";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
