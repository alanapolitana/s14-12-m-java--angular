import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
}) 
export class NavComponent implements OnInit, OnDestroy {
  userLoginOn: boolean = false;
  private isLoggedInSubscription: Subscription = new Subscription();

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.isLoggedInSubscription = this.authService.isLoggedIn.subscribe(isLoggedIn => {
      this.userLoginOn = isLoggedIn;
    });
  }

  ngOnDestroy(): void {
    this.isLoggedInSubscription.unsubscribe();
  }

  logout(): void {
    this.authService.removeToken();
    this.router.navigate(['/inicio']);
  }

  goToRegister(): void {
    this.router.navigate(['/registro']);
  }
}
