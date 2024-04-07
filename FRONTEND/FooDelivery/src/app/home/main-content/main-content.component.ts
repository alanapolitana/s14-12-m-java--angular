import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { FooterComponent } from "../footer/footer.component";
<<<<<<< HEAD
import { NavComponent } from '../nav/nav.component';

=======
>>>>>>> dd5ac6646478680df758b52bd8ef690ecae5d49b

@Component({
    selector: 'app-main-content',
    standalone: true,
    templateUrl: './main-content.component.html',
<<<<<<< HEAD
    styleUrls: ['./main-content.component.css'],
    imports: [HeaderComponent, FooterComponent, NavComponent]
})

=======
    styleUrl: './main-content.component.css',
    imports: [HeaderComponent, FooterComponent]
})
>>>>>>> dd5ac6646478680df758b52bd8ef690ecae5d49b
export class MainContentComponent {

}
