import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { AdminComponent } from './admin/admin.component';
import { ConsultartareasComponent } from './consultartareas/consultartareas.component';
import { ContactoComponent } from './contacto/contacto.component';
import { CrearticketComponent } from './crearticket/crearticket.component';
import { ForoComponent } from './foro/foro.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MisticketsComponent } from './mistickets/mistickets.component';
import { RankingComponent } from './ranking/ranking.component';
import { RegistroComponent } from './registro/registro.component';
import { VisualizartodoComponent } from './visualizartodo/visualizartodo.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'aboutus', component: AboutusComponent},
  {path: 'consultartareas', component: ConsultartareasComponent},
  {path: 'contacto', component: ContactoComponent},
  {path: 'crearticket', component: CrearticketComponent},
  {path: 'foro', component: ForoComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registro', component: RegistroComponent},
  {path: 'ranking', component: RankingComponent},
  {path: 'visualizartodo', component: VisualizartodoComponent},
  {path: 'mistickets', component: MisticketsComponent},
  {path: 'admin', component: AdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
