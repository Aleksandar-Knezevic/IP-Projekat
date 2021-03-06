import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-putnicki-let',
  templateUrl: './putnicki-let.component.html',
  styleUrls: ['./putnicki-let.component.css']
})
export class PutnickiLetComponent implements OnInit {

  @Input('putnicki-let') putnickiLet:any;
  @Input('id') id:any;
  @Output('brisanje') brisanje = new EventEmitter<any>();
  readonly URL = "http://localhost:9000/putnicki-letovi/"

  constructor(private http:HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  deleteFlight()
  {
    this.http.delete(this.URL+this.id).subscribe();
    this.brisanje.next();
  }

}
