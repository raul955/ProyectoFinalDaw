import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comentario } from './comentario';

@Injectable({
  providedIn: 'root'
})
export class ComentarioService {

  constructor(private http: HttpClient) { }

  private url = 'http://localhost:8080/comentario/';

  /**Crea un nuevo comentario en el tema */
  crearComentario(comentario: Comentario, idusuario: number, idtema: number): Observable<any> {
    return this.http.post(`${this.url}crearComentario/${idusuario}/${idtema}/`, comentario);
  }

  /**Pasa el tema en el que se clicka a la vista personalizada */
  getComentariosTemas(idtema: number): Observable<any> {
    return this.http.get<Comentario>(`${this.url}getComentariosTemas/${idtema}/`);
  }
}
