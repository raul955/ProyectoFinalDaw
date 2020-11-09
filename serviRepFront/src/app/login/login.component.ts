import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UsuarioServiceService } from '../usuario-service.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private us: UsuarioServiceService, private router: Router) { }

  ngOnInit() {
  }
    loginfor = new FormGroup({
      correo: new FormControl('', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]),
      pass: new FormControl('', [Validators.required, Validators.minLength(6)]),
  });

  login(formulariologin){
    
    console.log(formulariologin.value.correo+' '+formulariologin.value.pass);
    this.us.logearse(formulariologin.value.correo, formulariologin.value.pass).subscribe(data =>{
      console.log(data); 
      if(data == null){
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Algo ha salido mal, vuelve a probar',
        })
      }else{
        Swal.fire({
          icon: 'success',
          title: 'Logeado con éxito',
        })
        this.router.navigate(['/']);
      }    
    },error=>{
      console.log("error", error);
    });

  }


  //Getters para recoger los errores del formulario y poder validarlos.
  
  get correo() {
    return this.loginfor.get('correo');
  }

  get pass() {
    return this.loginfor.get('pass');
  }

}
