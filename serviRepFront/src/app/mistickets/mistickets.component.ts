import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { IncidenciaService } from '../incidencia.service';
import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service';
import { UsuarioServiceService } from '../usuario-service.service';

@Component({
  selector: 'app-mistickets',
  templateUrl: './mistickets.component.html',
  styleUrls: ['./mistickets.component.css']
})
export class MisticketsComponent implements OnInit {

  listaTickets: Ticket[];
  constructor( private inci: IncidenciaService, private us: UsuarioServiceService, private tick: TicketService ) { }

  ngOnInit() {
    var temporal;
    temporal = JSON.parse(sessionStorage.getItem('user'));
    console.log(temporal);
    this.getTicketsUsuario(temporal.idusuario);

  }

  getTicketsUsuario(id:number){
   
    this.tick.getTicketUsuarios(id).subscribe(data => {
      this.listaTickets = data;
      console.log(data);
      console.log(this.listaTickets);
    });
  
  }

}
