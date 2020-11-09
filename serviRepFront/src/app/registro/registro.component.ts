import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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
    roll: new FormControl('', [Validators.required]),
    calificacion: new FormControl(null, [Validators.required])
  });

  constructor(private us: UsuarioServiceService) { }

  ngOnInit() {
  }

  registrarse(formulario) {
    this.usuario.nombre = formulario.value.nombre;
    this.usuario.apellidos = formulario.value.apellidos;
    this.usuario.nick = formulario.value.nick;
    this.usuario.correo = formulario.value.correo;
    this.usuario.pass = formulario.value.pass;
    this.usuario.roll = 2;
    this.usuario.calificacion = formulario.value.calificacion;

    console.log(this.usuario);

    this.us.registrarse(this.usuario).subscribe(data => {
    console.log("registro" + this.usuario.roll);
    }, error => {
      console.log('Error al añadir usuario', error);
    });

  }

}
