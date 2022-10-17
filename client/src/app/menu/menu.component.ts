import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from '../service/auth/authentication.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  constructor(private router: Router,
              private authService: AuthenticationService) {
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
