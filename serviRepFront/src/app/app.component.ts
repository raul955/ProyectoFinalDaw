import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioServiceService } from './usuario-service.service';
import { Usuario } from './usuario';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'serviRepFront';
  admin = 'ADMIN';
  gestor = 'GESTOR';
  usuario = 'USUARIO';
  operario = 'OPERARIO';
  
  constructor(public us: UsuarioServiceService, private router: Router) {}

  desconectarse(){
    this.us.borrarSessionStorage();
    this.router.navigate(['/']);
  }

}


