import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-putnicka-rezervacija',
  templateUrl: './putnicka-rezervacija.component.html',
  styleUrls: ['./putnicka-rezervacija.component.css']
})
export class PutnickaRezervacijaComponent implements OnInit {


  @Input('rez') rezervacija:any;
  constructor() { }

  ngOnInit(): void {
  }

}
