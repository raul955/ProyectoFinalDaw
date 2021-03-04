import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { Usuario } from '../usuario';
import { UsuarioServiceService } from '../usuario-service.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  
  pageActual = 1;
  listausuarios: Usuario[];
  op: Usuario = new Usuario();


  userForm = new FormGroup({
    roll: new FormControl('', [Validators.required]),
    idusuario: new FormControl('', [Validators.required])
  });

  constructor(private us: UsuarioServiceService) { }

  ngOnInit() {
    this.getUsuarios();
  }


  getUsuarios(){

    this.us.getUsuarios().subscribe(data => {
      this.listausuarios = data;
    });
  }

  salvarDatosUsuario(idusuario: number, formulario){
    
    this.op.roll = formulario.value.roll;
    this.op.idusuario = idusuario;
    console.log(formulario);
    console.log(this.op);
    if(formulario.value.roll == ""){
      Swal.fire({
        icon: 'error',
        title: 'Debe especificar el roll del usuario.'
      });
    }

    this.us.modificaUsuario(this.op).subscribe(data => {
      
      this.getUsuarios();
      if (data === null) {
        this.userForm.reset();
        Swal.fire({
          icon: 'success',
          title: 'Usuario modificado con éxito.'
        });
      } else if (data === 0) {
        Swal.fire({
          icon: 'error',
          title: 'Ups, algo salió mal'
        });
      }
    });
    
  }

  borrarUsuario(idusuario){

    this.us.borrarUsuario(idusuario).subscribe(data => {
      this.getUsuarios();
      if (data === 1) {
        Swal.fire({
          icon: 'success',
          title: 'Usuario eliminado con éxito.'
        });
        this.getUsuarios();
      } else if (data === 0) {
        Swal.fire({
          icon: 'error',
          title: 'Ups, algo salió mal'
        });
      }
    });
  }

  get roll() {
    return this.roll.get('roll');
  }


}
