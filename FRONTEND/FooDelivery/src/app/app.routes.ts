import { Routes } from '@angular/router';
import { MainContentComponent } from './home/main-content/main-content.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { ProductsListComponent } from './products/products-list/products-list.component';

export const routes: Routes = [
    {path: "home", component: MainContentComponent},
    {path: "login", component: LoginComponent},
    {path: "register", component: RegisterComponent},
    {path: "products", component: ProductsListComponent},
    {path: "**", redirectTo: "home"}
];
