import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-putnicki-letovi-container',
  templateUrl: './putnicki-letovi-container.component.html',
  styleUrls: ['./putnicki-letovi-container.component.css']
})
export class PutnickiLetoviContainerComponent implements OnInit {

  letovi:any;
  readonly URL = "http://localhost:9000/putnicki-letovi";
  constructor(private http: HttpClient, private router:Router) { }

  async ngOnInit(): Promise<void> {
    this.letovi = await this.http.get(this.URL).toPromise();
  }

  noviPutnickiLet()
  {
    this.router.navigate(['./novi-putnicki-let'])
  }

  obrisiLet(index)
  {
    this.letovi.splice(index, 1);
  }

}
