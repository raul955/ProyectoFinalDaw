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

  salvarComentario(formulario){

  this.tick.agregarcomentarioycalificacion(this.t, Number.parseInt(document.getElementById('funcionaporfavor').innerText), formulario.value.comentario, formulario.value.calificacion, Number.parseInt(document.getElementById('idoperario').innerText)).subscribe(data =>{
    console.log(data); 
    if(data == null){
      Swal.fire({
        icon: 'success',
        title: 'Registrado con éxito',
      })
    }
  },error=>{
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Nick o correo ya existente, por favor prueba otro.',
    })
  });
    console.log(Number.parseInt(document.getElementById('idoperario').innerText));
    console.log(formulario.value.comentario);
    console.log(formulario.value.calificacion);
  }

}
