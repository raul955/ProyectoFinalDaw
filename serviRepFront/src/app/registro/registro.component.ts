import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Usuario } from '../usuario';
import { UsuarioServiceService } from '../usuario-service.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  usuario: Usuario = new Usuario();
  registro = new FormGroup({
    nombre: new FormControl('', [Validators.required]),
    apellidos: new FormControl('', [Validators.required, Validators.minLength(6)]),
    nick: new FormControl('', [Validators.required, Validators.minLength(5)]),
    correo: new FormControl('', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]),
    pass: new FormControl('', [Validators.required, Validators.minLength(6)]),
    pass2: new FormControl('', [Validators.required, Validators.minLength(6)])
  });

  constructor(private us: UsuarioServiceService, private router: Router) { }

  ngOnInit() {
  }

  registrarse(formulario) {
    this.usuario.nombre = formulario.value.nombre;
    this.usuario.apellidos = formulario.value.apellidos;
    this.usuario.nick = formulario.value.nick;
    this.usuario.correo = formulario.value.correo;
    if(formulario.value.pass == formulario.value.pass2){
      this.usuario.pass = formulario.value.pass;

      this.usuario.roll = 2;
      this.usuario.calificacion = formulario.value.calificacion;

      console.log(this.usuario);

      this.us.registrarse(this.usuario).subscribe(data =>{
        console.log(data); 
        if(data == null){
          Swal.fire({
            icon: 'success',
            title: 'Registrado con éxito',
          })
          this.us.logearse(this.usuario.correo, this.usuario.pass);
          this.router.navigate(['/']);
        }
      },error=>{
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Nick o correo ya existente, por favor prueba otro.',
        })
      });
    }else{
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Las contraseñas de los campos no coinciden',       
      })
    }
  }

  //Getters para recoger los errores del formulario y poder validarlos.

  get nombre() {
    return this.registro.get('nombre');
  }
  get apellidos() {
    return this.registro.get('apellidos');
  }
  get nick() {
    return this.registro.get('nick');
  }
  get correo() {
    return this.registro.get('correo');
  }

  get pass() {
    return this.registro.get('pass');
  }
  get roll() {
    return this.registro.get('roll');
  }
  get calificacion() {
    return this.registro.get('calificacion');
  }

  get pass2() {
    return this.registro.get('pass2');
  }
  

}
