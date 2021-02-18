import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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

    t: Ticket = new Ticket();

    salvarForm = new FormGroup({
    comentario: new FormControl('', [Validators.required, Validators.minLength(6)]),
    calificacion: new FormControl('', [Validators.required]),
  });

  PENDIENTECONFIRMACION: string = "PENDIENTECONFIRMACION";
  listaTickets: Ticket[];
  constructor( private inci: IncidenciaService, private us: UsuarioServiceService, private tick: TicketService ) { }

  ngOnInit() {
    var temporal;
    temporal = JSON.parse(sessionStorage.getItem('user'));
    this.getTicketsUsuario(temporal.idusuario);

  }

  getTicketsUsuario(id:number){
   
    this.tick.getTicketUsuarios(id).subscribe(data => {
      this.listaTickets = data;
      console.log(data);
      console.log(this.listaTickets);
    });
  }

  salvarComentario(idtickett: number, formulario){

  this.tick.agregarcomentarioycalificacion(this.t, idtickett, formulario.value.comentario, formulario.value.calificacion).subscribe(data =>{
    console.log(data); 
    if(data == null){
      Swal.fire({
        icon: 'success',
        title: 'Salvado con éxito',
      })
    }
  },error=>{
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Algo salió mal.',
    })
  });
  }

}
