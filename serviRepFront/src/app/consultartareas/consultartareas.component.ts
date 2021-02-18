import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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

  t: Ticket = new Ticket();
  salvarForm = new FormGroup({
    comentario: new FormControl('', [Validators.required, Validators.minLength(6)]),
    estado: new FormControl('', [Validators.required])
  });

  constructor(private tick: TicketService, private us: UsuarioServiceService) { }
  listaTickets: Ticket[];
  idusuariologeado: number;

  ngOnInit() {
    var temporal;
    temporal = JSON.parse(sessionStorage.getItem('user'));
    this.getTicketOperario(temporal.idusuario);
  }


  getTicketOperario(id:number){

    this.tick.getTicketOperario(id).subscribe(data => {
      this.listaTickets = data;
      console.log(data);
      console.log(this.listaTickets);
    });
  }

  salvarDatosEmpleado(idtickett: number, formulario){

    this.t.es = formulario.value.estado;
    this.tick.agregarcomentarioyestado(this.t, idtickett, formulario.value.comentario).subscribe(data =>{
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
