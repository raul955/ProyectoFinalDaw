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

registrarse(usuario: Usuario): Observable<any> {
  return this.http.post(`${this.url}registrarse`, usuario);
}

logearse(correo:string, pass:string): Observable<any>{

  this.http.get<Usuario>(`${this.url}login/${correo}/${pass}`).subscribe(data =>{
    this.us = data;
    if(data!==null){
      sessionStorage.setItem('user', JSON.stringify(this.us));
    }
  })

  return this.http.get<Usuario>(`${this.url}login/${correo}/${pass}`);
}

borrarSessionStorage(){
  sessionStorage.removeItem("user");
}

comprobarlogeado(){
  this.usersesion = JSON.parse(sessionStorage.getItem("user"));
  if(this.usersesion !== null){
    return this.usersesion;
  }else{
    return null;
  }
}

getUsuarios(): Observable<any>{
  return this.http.get<Usuario>(`${this.url}operarios`);
}

}


