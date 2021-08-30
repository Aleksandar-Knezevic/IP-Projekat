import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { HeaderComponent } from './header/header.component';
import { MenuComponent } from './menu/menu.component';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { PorukeContainerComponent } from './poruke-container/poruke-container.component';
import { HttpClientModule } from '@angular/common/http';
import { PorukaComponent } from './poruka/poruka.component';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { PutnickiLetoviContainerComponent } from './putnicki-letovi-container/putnicki-letovi-container.component';
import { PutnickiLetComponent } from './putnicki-let/putnicki-let.component';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { NoviPutnickiLetComponent } from './novi-putnicki-let/novi-putnicki-let.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { ReactiveFormsModule } from '@angular/forms';
import { TeretniLetComponent } from './teretni-let/teretni-let.component';
import { TeretniLetoviContainerComponent } from './teretni-letovi-container/teretni-letovi-container.component';
import { NoviTeretniLetComponent } from './novi-teretni-let/novi-teretni-let.component';
import { PutnickeRezervacijeContainerComponent } from './putnicke-rezervacije-container/putnicke-rezervacije-container.component';
import { PutnickaRezervacijaComponent } from './putnicka-rezervacija/putnicka-rezervacija.component';
import { TeretnaRezervacijaComponent } from './teretna-rezervacija/teretna-rezervacija.component';
import { TeretnaRezervacijaContainerComponent } from './teretna-rezervacija-container/teretna-rezervacija-container.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MenuComponent,
    PorukeContainerComponent,
    PorukaComponent,
    PutnickiLetoviContainerComponent,
    PutnickiLetComponent,
    NoviPutnickiLetComponent,
    TeretniLetComponent,
    TeretniLetoviContainerComponent,
    NoviTeretniLetComponent,
    PutnickeRezervacijeContainerComponent,
    PutnickaRezervacijaComponent,
    TeretnaRezervacijaComponent,
    TeretnaRezervacijaContainerComponent,
    HomeComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatSliderModule,
    MatButtonModule,
    MatMenuModule,
    HttpClientModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    ReactiveFormsModule
  ],
  providers: [
    MatDatepickerModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
