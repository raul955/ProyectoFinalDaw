import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket } from './ticket';
import { Usuario } from './usuario';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private url = 'http://localhost:8080/ticket/';

  constructor(private http: HttpClient) { }

  crearTicket(ticket: Ticket, idincidencia: number, idoperario: number): Observable<any> {
    return this.http.post(`${this.url}crearTicket/${idincidencia}/${idoperario}`, ticket);
  }

  getTicketUsuarios(idusuario: number): Observable<any> {
    return this.http.get<Usuario>(`${this.url}cargartickets/${idusuario}`);
  }

  agregarcomentarioycalificacion(t: Ticket, idticket: number, comentario: String, calificacion: number, idusuario: number): Observable<any> {
    return this.http.post(`${this.url}agregarcomentarioycalificacion/${idticket}/${comentario}/${calificacion}/${idusuario}`, t);
  }

  getTodosLosTickets(): Observable<any> {
    return this.http.get<Ticket>(`${this.url}verTodosLosTickets`);
  }
}
