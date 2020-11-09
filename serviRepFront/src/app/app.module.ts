import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { ContactoComponent } from './contacto/contacto.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ForoComponent } from './foro/foro.component';
import { RankingComponent } from './ranking/ranking.component';
import { MisticketsComponent } from './mistickets/mistickets.component';
import { VisualizartodoComponent } from './visualizartodo/visualizartodo.component';
import { CrearticketComponent } from './crearticket/crearticket.component';
import { ConsultartareasComponent } from './consultartareas/consultartareas.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistroComponent,
    ContactoComponent,
    AboutusComponent,
    ForoComponent,
    RankingComponent,
    MisticketsComponent,
    VisualizartodoComponent,
    CrearticketComponent,
    ConsultartareasComponent,
    HomeComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
