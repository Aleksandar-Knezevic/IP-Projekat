import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-putnicka-rezervacija',
  templateUrl: './putnicka-rezervacija.component.html',
  styleUrls: ['./putnicka-rezervacija.component.css']
})
export class PutnickaRezervacijaComponent implements OnInit {

  readonly ACCEPT_URL = 'http://localhost:9000/putnicke-rezervacije/accept';
  readonly DECLINE_URL = 'http://localhost:9000/putnicke-rezervacije/decline';

  @Input('rez') rezervacija:any;
  @Output('odobravanje') odobravanje = new EventEmitter<any>();
  @Output('ponistavanje') ponistavanje = new EventEmitter<any>();
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  odobriLet()
  {
    let keyModel={
      letId:this.rezervacija.korisnikId,
      korisnikId:this.rezervacija.putnickiLetId,
      razlogPonistavanja:null
    }
    this.http.put(this.ACCEPT_URL, keyModel).subscribe();
    this.odobravanje.next();
  }

  ponistiLet(razlog)
  {
    let keyModel={
      letId:this.rezervacija.korisnikId,
      korisnikId:this.rezervacija.putnickiLetId,
      razlogPonistavanja:razlog.value
    }
    this.http.put(this.DECLINE_URL, keyModel).subscribe();
    this.ponistavanje.next();
  }



}
