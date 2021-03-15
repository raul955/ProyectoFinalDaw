import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Contacto } from './contacto';
import { Observable } from 'rxjs';
import { Ticket } from './ticket';

@Injectable({
  providedIn: 'root'
})
export class IncidenciaService {

  private url = 'http://localhost:8080/servirep/incidencia/';

  constructor(private http: HttpClient) { }

  crearIncidencia(ticket: Ticket, id: number): Observable<any> {
    return this.http.post(`${this.url}crearIncidencia/${id}`, ticket);
  }

  getIncidencias(): Observable<any> {
    return this.http.get<Contacto>(`${this.url}getIncidencia`);
  }

  borrarIncidencia(id: number): Observable<any>{
    return this.http.delete(`${this.url}borrarIncidencia/${id}`);
  }

}
