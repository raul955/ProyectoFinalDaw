import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service';
import { Usuario } from '../usuario';
import { UsuarioServiceService } from '../usuario-service.service';

@Component({
  selector: 'app-visualizartodo',
  templateUrl: './visualizartodo.component.html',
  styleUrls: ['./visualizartodo.component.css']
})
export class VisualizartodoComponent implements OnInit {

  todoform = new FormGroup({
    id: new FormControl('', [Validators.required]),
    detalle: new FormControl('', [Validators.required]),
    operario: new FormControl('', [Validators.required]),
    estado: new FormControl('', [Validators.required])
  });

  constructor(private tick: TicketService, private us: UsuarioServiceService) { }
  listaUsuarios: Usuario[];
  listaTickets: Ticket[];
  operario = 'OPERARIO';

  ngOnInit() {
    this.getTodosLosTickets();
    this.getOperarios();
  }

  getOperarios(){

    this.us.getUsuarios().subscribe(data =>{
      this.listaUsuarios=data;
      this.listaUsuarios = this.listaUsuarios.filter(function(i) { return i.roll.toString() == 'OPERARIO' }); 
      console.log(this.listaUsuarios);
    },error =>{
      console.log(error);
    })
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

}
