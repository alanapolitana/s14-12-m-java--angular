import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
<<<<<<< HEAD
import { HttpClient } from '@angular/common/http';
import { HeaderComponent } from './home/header/header.component';
import { FooterComponent } from './home/footer/footer.component';
import { NavComponent } from './home/nav/nav.component';


=======
>>>>>>> dd5ac6646478680df758b52bd8ef690ecae5d49b

@Component({
  selector: 'app-root',
  standalone: true,
<<<<<<< HEAD
  imports: [RouterOutlet,HeaderComponent,FooterComponent,NavComponent],
=======
  imports: [RouterOutlet],
>>>>>>> dd5ac6646478680df758b52bd8ef690ecae5d49b
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
<<<<<<< HEAD
  title = 'FooDelivery';  
  constructor(private http: HttpClient) {
   
  }
=======
  title = 'FooDelivery';
>>>>>>> dd5ac6646478680df758b52bd8ef690ecae5d49b
}
