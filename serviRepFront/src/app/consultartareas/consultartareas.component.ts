import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service';
import { UsuarioServiceService } from '../usuario-service.service';

@Component({
  selector: 'app-consultartareas',
  templateUrl: './consultartareas.component.html',
  styleUrls: ['./consultartareas.component.css']
})
export class ConsultartareasComponent implements OnInit {

  constructor(private tick: TicketService, private us: UsuarioServiceService) { }
  listaTickets: Ticket[];
  idusuariologeado: number;

  ngOnInit() {
    this.getTodosLosTickets();
    this.idusuariologeado = this.getid();
  }

  getTodosLosTickets(){
    this.tick.getTodosLosTickets().subscribe(data =>{
      this.listaTickets = data;
      console.log(this.listaTickets);
    },error=>{
      console.log(error);
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Algo salió mal',
      })
    });
}

  getTicketOperario(){

  }

  getid(){

    var temporal;
    temporal = JSON.parse(sessionStorage.getItem('user'));   
    return temporal.idusuario;   
  }

}
