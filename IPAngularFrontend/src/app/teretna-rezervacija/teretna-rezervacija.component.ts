import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-teretna-rezervacija',
  templateUrl: './teretna-rezervacija.component.html',
  styleUrls: ['./teretna-rezervacija.component.css']
})
export class TeretnaRezervacijaComponent implements OnInit {

  readonly ACCEPT_URL = 'http://localhost:9000/teretne-rezervacije/accept';
  readonly DECLINE_URL = 'http://localhost:9000/teretne-rezervacije/decline';

  @Input('rez') rezervacija:any;
  @Output('odobravanje') odobravanje = new EventEmitter<any>();
  @Output('ponistavanje') ponistavanje = new EventEmitter<any>();
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  odobriLet()
  {
    let keyModel={
      letId:this.rezervacija.teretniLetId,
      korisnikId:this.rezervacija.korisnikId,
      razlogPonistavanja:null
    }
    this.http.put(this.ACCEPT_URL, keyModel).subscribe();
    this.odobravanje.next();
  }

  ponistiLet(razlog)
  {
    let keyModel={
      letId:this.rezervacija.teretniLetId,
      korisnikId:this.rezervacija.korisnikId,
      razlogPonistavanja:razlog.value
    }
    this.http.put(this.DECLINE_URL, keyModel).subscribe();
    this.ponistavanje.next();
  }



}
