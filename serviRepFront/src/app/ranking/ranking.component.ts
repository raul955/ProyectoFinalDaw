import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuario';
import { UsuarioServiceService } from '../usuario-service.service';

@Component({
  selector: 'app-ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.css']
})
export class RankingComponent implements OnInit {

  listausuarios: Usuario[];

  constructor(private us: UsuarioServiceService) { }

  ngOnInit() {
    this.getUsuariosRanking();
  }

  getUsuariosRanking(){

    this.us.getRanking().subscribe(data => {
      this.listausuarios = data;
    });
  }

}
