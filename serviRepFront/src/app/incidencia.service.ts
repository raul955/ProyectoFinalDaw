import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Contacto } from './contacto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IncidenciaService {

  private url = 'http://localhost:8080/incidencia/';

  constructor(private http: HttpClient) { }

  crearIncidencia(contacto: Contacto, id: number): Observable<any> {
    return this.http.post(`${this.url}crearIncidencia/${id}`, contacto);
  }

  getIncidencias(): Observable<any> {
    return this.http.get<Contacto>(`${this.url}getIncidencia`);
  }

  borrarIncidencia(id: number): Observable<any>{
    return this.http.delete(`${this.url}borrarIncidencia/${id}`);
  }

}
