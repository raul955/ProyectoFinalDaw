import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tema } from './tema';

@Injectable({
  providedIn: 'root'
})
export class TemaService {

  private url = 'http://localhost:8080/tema/';

  constructor(private http: HttpClient) {}

  /**Crea un nuevo tema en el foro */
  crearTema(tema: Tema, idusuario: number): Observable<any> {
    return this.http.post(`${this.url}crearTema/${idusuario}/`, tema);
  }

  /**Trae todos los temas existentes para su visualización */
  getTemas(): Observable<any> {
    return this.http.get<Tema>(`${this.url}getTemas`);
  }
  
}
