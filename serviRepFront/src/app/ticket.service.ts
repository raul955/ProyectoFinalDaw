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
}
