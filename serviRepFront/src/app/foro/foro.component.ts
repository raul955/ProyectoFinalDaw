import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2';
import { Tema } from '../tema';
import { TemaService } from '../tema.service';

@Component({
  selector: 'app-foro',
  templateUrl: './foro.component.html',
  styleUrls: ['./foro.component.css']
})
export class ForoComponent implements OnInit {

  tema: Tema = new Tema();
  listatemas: Tema[];

  temaForm = new FormGroup({
    asunto: new FormControl('', [Validators.required, Validators.minLength(5)]),
    descripcion: new FormControl('', [Validators.required, Validators.minLength(15)])  
  });

  constructor(private tem: TemaService, private router: Router) { }

  ngOnInit() {
    this.getTemas();
  }


  pasoid(){

  }

  getTemas(){

    this.tem.getTemas().subscribe(data => {
      this.listatemas = data;
      console.log(data);
      console.log(this.listatemas[0].us.nick);
    });
  }

  creaTema(formulario){
    this.tema.asunto = formulario.value.asunto;
    this.tema.descripcion = formulario.value.descripcion;
    var idusuario = JSON.parse(sessionStorage.getItem("user")).idusuario;

    console.log(this.tema);
    console.log(idusuario);

    this.tem.crearTema(this.tema, idusuario).subscribe(data =>{
      console.log(data);
      this.getTemas(); 
      this.temaForm.reset;
      this.router.navigate(['/foro']);
      if(data == null){
        Swal.fire({
          icon: 'success',
          title: 'Creado con éxito',
        })
        this.getTemas();
        this.temaForm.reset;
        this.router.navigate(['/foro']);
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
  return this.temaForm.get('asunto');
}
get descripcion() {
  return this.temaForm.get('descripcion');
}

}
