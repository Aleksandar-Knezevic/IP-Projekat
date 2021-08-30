import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PorukeContainerComponent } from './poruke-container/poruke-container.component';
import { PutnickiLetoviContainerComponent } from './putnicki-letovi-container/putnicki-letovi-container.component';
import { NoviPutnickiLetComponent } from './novi-putnicki-let/novi-putnicki-let.component';
import { TeretniLetoviContainerComponent } from './teretni-letovi-container/teretni-letovi-container.component';
import { NoviTeretniLetComponent } from './novi-teretni-let/novi-teretni-let.component';
import { PutnickeRezervacijeContainerComponent } from './putnicke-rezervacije-container/putnicke-rezervacije-container.component';
import { TeretnaRezervacijaContainerComponent } from './teretna-rezervacija-container/teretna-rezervacija-container.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LoginGuardGuard } from './login-guard.guard';


const routes: Routes = [
  {
    path: 'poruke',
    children: [
      {path:'all', component: PorukeContainerComponent},
      {path:'unread', component:PorukeContainerComponent}
    ],
    canActivate: [LoginGuardGuard]
  },
  {
    path: 'putnicki-letovi',
    component: PutnickiLetoviContainerComponent,
    canActivate: [LoginGuardGuard]
  },
  {
    path: 'novi-putnicki-let',
    component: NoviPutnickiLetComponent,
    canActivate: [LoginGuardGuard]
  },
  {
    path: 'teretni-letovi',
    component: TeretniLetoviContainerComponent,
    canActivate: [LoginGuardGuard]
  },
  {
    path: 'novi-teretni-let',
    component: NoviTeretniLetComponent,
    canActivate: [LoginGuardGuard]
  },
  {
    path: 'putnicke-rezervacije',
    component: PutnickeRezervacijeContainerComponent,
    canActivate: [LoginGuardGuard]
  },
  {
    path: 'teretne-rezervacije',
    component: TeretnaRezervacijaContainerComponent,
    canActivate: [LoginGuardGuard]
  },
  {
    path:'login',
    component: LoginComponent
  },
  {
    path: '',
    component: HomeComponent,
    canActivate: [LoginGuardGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
