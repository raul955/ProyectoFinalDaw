import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from './usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {

  private url = 'http://localhost:8080/usuario/';
  us: Usuario = new Usuario();
  usersesion: Usuario = new Usuario();

  constructor(private http: HttpClient) { }

/************************************************/

/**Registro */
registrarse(usuario: Usuario): Observable<any> {
  return this.http.post(`${this.url}registrarse`, usuario);
}

/**Logeo */
logearse(correo:string, pass:string): Observable<any>{

  this.http.get<Usuario>(`${this.url}login/${correo}/${pass}`).subscribe(data =>{
    this.us = data;
    if(data!==null){
      sessionStorage.setItem('user', JSON.stringify(this.us));
    }
  })

  return this.http.get<Usuario>(`${this.url}login/${correo}/${pass}`);
}

/**Borra el ssesion storage, deslogeado */
borrarSessionStorage(){
  sessionStorage.removeItem("user");
}

/**Comprueba si hay un usuario logeado */
comprobarlogeado(){
  this.usersesion = JSON.parse(sessionStorage.getItem("user"));
  if(this.usersesion !== null){
    return this.usersesion;
  }else{
    return null;
  }
}

/*Trae todos los usuarios */
getUsuarios(): Observable<any>{
  return this.http.get<Usuario>(`${this.url}operarios`);
}

/*Borra el usuario */
borrarUsuario(idusuario: number):Observable<any> {
  return this.http.delete(`${this.url}borrarUsuario/${idusuario}`);
}

/**Modifica el roll de usuario */
modificaUsuario(usuario: Usuario): Observable<any> {
  return this.http.post(`${this.url}modificaUsuario`, usuario);
}

/**Trae la lista de operarios ordenada para el ranking */
getRanking(): Observable<any>{
  return this.http.get<Usuario>(`${this.url}ranking`);
}

}
