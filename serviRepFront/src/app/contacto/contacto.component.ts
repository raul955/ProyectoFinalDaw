import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuario';
import { Contacto } from '../contacto';
import { UsuarioServiceService } from '../usuario-service.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { IncidenciaService } from '../incidencia.service';
import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {

  usuario: Usuario = new Usuario();
  ticket: Ticket = new Ticket();

  contactoform = new FormGroup({
    asunto: new FormControl('', [Validators.required, Validators.minLength(5)]),
    descripcion: new FormControl('', [Validators.required, Validators.minLength(15)])  
  });

  constructor(private us: UsuarioServiceService, private router: Router, private tick: TicketService) { }

  ngOnInit() {
  }

  creaticket(formulario){
    this.ticket.asunto = formulario.value.asunto;
    this.ticket.descripcion = formulario.value.descripcion;
    this.ticket.ususarioCreador = JSON.parse(sessionStorage.getItem("user"));
    this.ticket.es = 4;

    console.log(this.ticket);
    console.log(typeof(this.ticket.ususarioCreador.idusuario));

    this.tick.crearIncidencia(this.ticket, this.ticket.ususarioCreador.idusuario).subscribe(data =>{
      console.log(data); 
      if(data == null){
        Swal.fire({
          icon: 'success',
          title: 'Creado con éxito',
        })
        this.router.navigate(['/']);
      }
    },error=>{
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Algo salió mal',
      })
    });
  }

//Getters para recoger los errores del formulario y poder validarlos.

get asunto() {
  return this.contactoform.get('asunto');
}
get descripcion() {
  return this.contactoform.get('descripcion');
}

}
