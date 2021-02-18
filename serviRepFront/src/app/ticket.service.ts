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

  /****************Tickets Usuarios***************/

  crearIncidencia(ticket: Ticket, id: number): Observable<any> {
    return this.http.post(`${this.url}crearTicketUsuario/${id}`, ticket);
  }

  getIncidencias(): Observable<any> {
    return this.http.get<Ticket>(`${this.url}getTicketUsuario`);
  }

  borrarIncidencia(id: number): Observable<any>{
    return this.http.delete(`${this.url}borrarIncidencia/${id}`);
  }
  
  /***********************************************/

  crearTicket(ticket: Ticket, idincidencia: number, idoperario: number): Observable<any> {
    return this.http.post(`${this.url}crearTicket/${idincidencia}/${idoperario}`, ticket);
  }

  /*Pagina de gestion de tickets, asigna estado y operario*/
  gestionTicket(ticket: Ticket, idticket: number, idusuario: number): Observable<any> {
    return this.http.post(`${this.url}gestionTicket/${idticket}/${idusuario}`, ticket);
  }

  /*Mis tickets, trae los tickets del usuario cliente que está consultando */
  getTicketUsuarios(idusuario: number): Observable<any> {
    return this.http.get<Usuario>(`${this.url}cargartickets/${idusuario}`);
  }

  /*Modifica los campos comentario cliente y calificacion en la vista de mis tickets de usuario cliente*/
  agregarcomentarioycalificacion(t: Ticket, idticket: number, comentario: String, calificacion: number): Observable<any> {
    return this.http.post(`${this.url}agregarcomentarioycalificacion/${idticket}/${comentario}/${calificacion}`, t);
  }

  /*Modifica los campos comentario empleado y estado en la vista de mis tickets de usuario cliente*/
  agregarcomentarioyestado(t: Ticket, idticket: number, comentario: String): Observable<any> {
    return this.http.post(`${this.url}agregarcomentarioyestado/${idticket}/${comentario}`, t);
  }

  /**Trae todos los tickets */
  getTodosLosTickets(): Observable<any> {
    return this.http.get<Ticket>(`${this.url}verTodosLosTickets`);
  }

  //Visualizar tareas empleado, trae los tickets de empleado que está consultando
  getTicketOperario(idusuario: number): Observable<any> {
    return this.http.get<Usuario>(`${this.url}cargarTicketsOperario/${idusuario}`);
  }

  borrarTickets(id: number): Observable<any>{
    return this.http.delete(`${this.url}borrarTickets/${id}`);
  }

}
