import { Routes } from '@angular/router';
import { MainContentComponent } from './home/main-content/main-content.component';

export const routes: Routes = [
    {path: "home", component: MainContentComponent},
    {path: "**", redirectTo: "home"}
];
