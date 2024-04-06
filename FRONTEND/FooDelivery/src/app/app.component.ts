import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
<<<<<<< HEAD
import { HttpClient } from '@angular/common/http';


=======
>>>>>>> 5bdf00885c09b64f9ecff4cd81294b1a645f33d3

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'FooDelivery';  
  constructor(private http: HttpClient) {
   
  }
}
