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

    pageActual = 1;
    estadoo = "PENDIENTECONFIRMACION";
    t: Ticket = new Ticket();

    salvarForm = new FormGroup({
    comentario: new FormControl('', [Validators.required, Validators.minLength(6)]),
    calificacion: new FormControl('0', [Validators.required]),
  });

  PENDIENTECONFIRMACION: string = "PENDIENTECONFIRMACION";
  listaTickets: Ticket[];
  res: string = "RESUELTO";
  constructor( private inci: IncidenciaService, private us: UsuarioServiceService, private tick: TicketService ) { }
   
  ngOnInit() {
    var temporal;
    temporal = JSON.parse(sessionStorage.getItem('user'));
    this.getTicketsUsuario(temporal.idusuario);

  }

  getTicketsUsuario(id:number){
   
    this.tick.getTicketUsuarios(id).subscribe(data => {
      this.listaTickets = data;
    });
  }

  salvarComentario(idtickett: number, formulario){
    console.log("primero: "+formulario.value.calificacion);
    if(!formulario.value.calificacion){
      formulario.value.calificacion == 0;
    }
  console.log(formulario.value.calificacion);
  this.tick.agregarcomentarioycalificacion(this.t, idtickett, formulario.value.comentario, formulario.value.calificacion).subscribe(data =>{ 
    if(data == null){
      this.salvarForm.reset();
      this.calificacionp.setValue(0);
      Swal.fire({
        icon: 'success',
        title: 'Salvado con éxito',
      })
    }
  },error=>{
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Tienes que establecer una puntuación y un comentario.',
    })
  });
  }

  get calificacionp() {
    return this.salvarForm.get('calificacion');
  }

}
