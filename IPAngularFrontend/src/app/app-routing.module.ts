import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PorukeContainerComponent } from './poruke-container/poruke-container.component';
import { PutnickiLetoviContainerComponent } from './putnicki-letovi-container/putnicki-letovi-container.component';
import { NoviPutnickiLetComponent } from './novi-putnicki-let/novi-putnicki-let.component';

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
