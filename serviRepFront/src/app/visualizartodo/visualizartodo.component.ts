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

  pageActual = 1;
  t: Ticket = new Ticket();
  op: Usuario = new Usuario();

  todoform = new FormGroup({
    id: new FormControl('', [Validators.required]),
    detalle: new FormControl('', [Validators.required]),
    operario: new FormControl('', [Validators.required]),
    estado: new FormControl('', [Validators.required])
  });

  constructor(private tick: TicketService, private us: UsuarioServiceService) { }
  listaUsuarios: Usuario[];
  usuarioOperadorSeleccionado: Usuario[];
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

  getOperarioSeleccionado(formulario){
    this.us.getUsuarios().subscribe(data =>{
      this.usuarioOperadorSeleccionado=data;
      this.usuarioOperadorSeleccionado = this.usuarioOperadorSeleccionado.filter(function(i) { return i.correo == formulario.value.operario }); 

      return this.usuarioOperadorSeleccionado;
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

  subirTicket(idtickett: number, formulario){
    
    document.getElementById('idticket').innerText;
    this.t.es = formulario.value.estado;
    var resultadoOperarioSeleccionado = this.getOperarioSeleccionado(formulario);
    var temp = document.getElementById('idticket').innerText;

    this.us.getUsuarios().subscribe(data =>{
      this.usuarioOperadorSeleccionado=data;
      this.usuarioOperadorSeleccionado = this.usuarioOperadorSeleccionado.filter(function(i) { return i.correo == formulario.value.operario }); 
      
      if(formulario.value.operario == "" || this.t.es == null){
        Swal.fire({
          icon: 'error',
          title: 'Debe especificar operario asignado y el estado de la tarea.'
        });
      }

      this.tick.gestionTicket(this.t, idtickett, this.usuarioOperadorSeleccionado[0].idusuario).subscribe(data =>{
        this.getTodosLosTickets();
        if(data == null){
          this.todoform.reset();
          Swal.fire({
            icon: 'success',
            title: 'Ticket Creado',
          })     
        }
        this.getTodosLosTickets();
        },error=>{
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Debe especificar operario asignado y el estado de la tarea.',
        })
        });
    },error =>{
      console.log(error);
    })
  }

  borrarTicket(idticket: number){

    this.tick.borrarTickets(idticket).subscribe(data => {
      this.getTodosLosTickets();
      if (data === 1) {
        Swal.fire({
          icon: 'success',
          title: 'Ticket eliminado con éxito.'
        });
        this.getTodosLosTickets();
      } else if (data === 0) {
        Swal.fire({
          icon: 'error',
          title: 'Ups, algo salió mal'
        });
      }
    });

  } 
    
}  