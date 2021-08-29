import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PorukeContainerComponent } from './poruke-container/poruke-container.component';
import { PutnickiLetoviContainerComponent } from './putnicki-letovi-container/putnicki-letovi-container.component';
import { NoviPutnickiLetComponent } from './novi-putnicki-let/novi-putnicki-let.component';
import { TeretniLetoviContainerComponent } from './teretni-letovi-container/teretni-letovi-container.component';
import { NoviTeretniLetComponent } from './novi-teretni-let/novi-teretni-let.component';
import { PutnickeRezervacijeContainerComponent } from './putnicke-rezervacije-container/putnicke-rezervacije-container.component';
import { TeretnaRezervacijaContainerComponent } from './teretna-rezervacija-container/teretna-rezervacija-container.component';

const routes: Routes = [
  {
    path: 'poruke',
    children: [
      {path:'all', component: PorukeContainerComponent},
      {path:'unread', component:PorukeContainerComponent}
    ]
  },
  {
    path: 'putnicki-letovi',
    component: PutnickiLetoviContainerComponent
  },
  {
    path: 'novi-putnicki-let',
    component: NoviPutnickiLetComponent
  },
  {
    path: 'teretni-letovi',
    component: TeretniLetoviContainerComponent
  },
  {
    path: 'novi-teretni-let',
    component: NoviTeretniLetComponent
  },
  {
    path: 'putnicke-rezervacije',
    component: PutnickeRezervacijeContainerComponent
  },
  {
    path: 'teretne-rezervacije',
    component: TeretnaRezervacijaContainerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
