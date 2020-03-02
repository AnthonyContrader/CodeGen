import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SignupComponent} from './signup/signup.component';

/**
 * Questo è un modulo di routing. Essendo il modulo principale deve UNICAMENTE 
 * eseguire il redirect sul persorso /login (modulo di login) e NON DEVE contenere
 * altri percorsi: questi vanno specificati nei vari sotto-moduli di routing.
 * 
 * @see LoginRoutingModule
 * 
 * @author Vittorio Valent
 */
const routes: Routes = [
  { path: '', redirectTo:'/login', pathMatch: 'full'},
  { path: 'signup', component: SignupComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
