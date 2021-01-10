import { Component, OnInit, ɵConsole } from '@angular/core';
import Swal from 'sweetalert2';
import { Contacto } from '../contacto';
import { IncidenciaService } from '../incidencia.service';
import { Usuario } from '../usuario';
import { UsuarioServiceService } from '../usuario-service.service';
import { TicketService } from '../ticket.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Ticket } from '../ticket';

@Component({
  selector: 'app-crearticket',
  templateUrl: './crearticket.component.html',
  styleUrls: ['./crearticket.component.css']
})
export class CrearticketComponent implements OnInit {
  
  t: Ticket = new Ticket();
  ticketform = new FormGroup({
    idincidencia: new FormControl('', [Validators.required]),
    detalle: new FormControl('', [Validators.required]),
    estado: new FormControl('', [Validators.required]),
    operario: new FormControl('', [Validators.required])
  });

  incidencias: Contacto[];
  listaUsuarios: Usuario[];
  operario = 'OPERARIO';

  constructor(private inci: IncidenciaService, private us: UsuarioServiceService, private tick: TicketService) { }

  ngOnInit() {

    this.getIncidencias();
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

  getIncidencias(){
      this.inci.getIncidencias().subscribe(data =>{
        this.incidencias = data;
        console.log(this.incidencias);
      },error=>{
        console.log(error);
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Algo salió mal',
        })
      });
  }

  borrarInci(id: number){
    this.inci.borrarIncidencia(id).subscribe(data => {
      this.getIncidencias();
      if (data === 1) {
        Swal.fire({
          icon: 'success',
          title: 'Incidencia eliminado con éxito.'
        });
        this.getIncidencias();
      } else if (data === 0) {
        Swal.fire({
          icon: 'error',
          title: 'Ups, algo salió mal'
        });
      }
    });
  }

  subirTicket(formulario){

  this.t.detalle = formulario.value.detalle;
  this.t.estado = formulario.value.estado;
console.log(this.t.estado);
  this.tick.crearTicket(this.t, formulario.value.idincidencia, formulario.value.operario).subscribe(data =>{
    console.log('ERRRRR' + data); 
    if(data == null){
      Swal.fire({
        icon: 'success',
        title: 'Ticket Creado',
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

