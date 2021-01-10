import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuario';
import { Contacto } from '../contacto';
import { UsuarioServiceService } from '../usuario-service.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { IncidenciaService } from '../incidencia.service';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {

  usuario: Usuario = new Usuario();
  contacto: Contacto = new Contacto();

  contactoform = new FormGroup({
    asunto: new FormControl('', [Validators.required, Validators.minLength(5)]),
    descripcion: new FormControl('', [Validators.required, Validators.minLength(15)])  
  });

  constructor(private us: UsuarioServiceService, private router: Router, private inc: IncidenciaService) { }

  ngOnInit() {
  }

  creaticket(formulario){
    this.contacto.asunto = formulario.value.asunto;
    this.contacto.descripcion = formulario.value.descripcion;
    this.contacto.usuario = JSON.parse(sessionStorage.getItem("user"));
    this.contacto.activo = false;

    console.log(this.contacto);
    console.log(typeof(this.contacto.usuario.idusuario));

    this.inc.crearIncidencia(this.contacto, this.contacto.usuario.idusuario).subscribe(data =>{
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
