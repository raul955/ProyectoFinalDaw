import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class RolesGuard implements CanActivate {
  constructor(private router: Router) { }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

      var temporal = JSON.parse(sessionStorage.getItem('user'));
      console.log(temporal);
      if (temporal.roll != 'ADMIN') {
        console.log(temporal);
        Swal.fire({
          title: 'Error!',
          text: 'No tienes acceso a esta sección',
          icon: 'error',
          confirmButtonText: 'Aceptar',
          preConfirm: () => {
            return this.router.navigate(['']);
          }
        });
        return false;
      } else {
        return true;
      }
    
  }
  
}
