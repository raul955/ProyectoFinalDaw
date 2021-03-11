import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Comentario } from '../comentario';
import { ComentarioService } from '../comentario.service';
import { Tema } from '../tema';
import { TemaService } from '../tema.service';

@Component({
  selector: 'app-visualizartema',
  templateUrl: './visualizartema.component.html',
  styleUrls: ['./visualizartema.component.css']
})
export class VisualizartemaComponent implements OnInit {

  comentarioForm = new FormGroup({
    descripcion: new FormControl('', [Validators.required, Validators.minLength(15), Validators.maxLength(500)])
  });

  pageActual = 1;
  tema: Tema = new Tema();
  comentario: Comentario = new Comentario();
  idtema: number;
  listaComentarios: Comentario[];
  rola = "ADMIN";
  temporal: any;
  

  constructor(private com: ComentarioService, private tem: TemaService, private router: Router, public route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(response => {
      this.idtema = parseInt(response.get('id'), 10);
      this.tem.getTemaId(this.idtema).subscribe(data => {
        this.tema = data;
    });
    });
    this.getComentarios();
    this.temporal = JSON.parse(sessionStorage.getItem('user'));
  }


  borrarComentario(idcomentario){
    console.log("la id es "+idcomentario);
    this.com.borrarComentarioo(idcomentario).subscribe(data => {
      this.getComentarios();
      if (data === 1) {
        Swal.fire({
          icon: 'success',
          title: 'Comentario eliminado con éxito.'
        });
        this.getComentarios();
      } else if (data === 0) {
        Swal.fire({
          icon: 'error',
          title: 'Ups, algo salió mal'
        });
      }
    });
  }

  getTema(id: number) {
    this.tem.getTemaId(id).subscribe(data => {
      this.tema = data;
    });
  }

  getComentarios(){
    this.com.getComentariosTemas(this.idtema).subscribe(data => {
      console.log(data);
      this.listaComentarios = data;
    });  
  }

  creaComentario(formulario){
    this.comentario.descripcion = formulario.value.descripcion;
    var idusuario = JSON.parse(sessionStorage.getItem("user")).idusuario;
    var idtema = this.tema.idtema;

    console.log(this.comentario);
    console.log(idusuario);

    this.com.crearComentario(this.comentario, idusuario, idtema).subscribe(data =>{
      console.log(data);
      this.getComentarios(); 
      
      if(data == null){
        this.comentarioForm.reset();
        Swal.fire({
          icon: 'success',
          title: 'Creado con éxito',
        })
        this.getComentarios();
        this.comentarioForm.reset;
      }
    },error=>{
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Algo salió mal',
      })
    });
  }


  get descripcion() {
    return this.comentarioForm.get('descripcion');
  }
}
