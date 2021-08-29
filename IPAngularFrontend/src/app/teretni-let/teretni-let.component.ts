import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teretni-let',
  templateUrl: './teretni-let.component.html',
  styleUrls: ['./teretni-let.component.css']
})
export class TeretniLetComponent implements OnInit {

  @Input('putnicki-let') putnickiLet:any;
  @Input('id') id:any;
  @Output('brisanje') brisanje = new EventEmitter<any>();
  readonly URL = "http://localhost:9000/teretni-letovi/"

  constructor(private http:HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  deleteFlight()
  {
    this.http.delete(this.URL+this.id).subscribe();
    this.brisanje.next();
  }

}
