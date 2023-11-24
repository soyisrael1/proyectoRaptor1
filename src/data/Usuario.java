package data;

public class Usuario {
int  idUser;
String correo;

String password;
String nombre;

DataUsuario du=new DataUsuario();


public Usuario() {
	
	
	
}
public boolean insertarUsuario() {
	
	
	if(du.insertarUsuario(this)) {
		return true;
	}else {
		return false;
	}
}


public boolean login() {
	
	
	if(du.login(this)) {
		return true;
	}else {
		return false;
	}
}
public boolean eliminarUsuario() {
	
	
	if(du.eliminarUsuario(this.getIdUser())) {
		return true;
	}else {
		return false;
	}
}
public boolean actualizarUsuario() {
	
	
	if(du.actualizarUsuario(this)) {
		return true;
	}else {
		return false;
	}
}

public int getIdUser() {
	return idUser;
}
public void setIdUser(int idUser) {
	this.idUser = idUser;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public boolean insertarUsuario1() {
	// TODO Auto-generated method stub
	return false;
}





}

