import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teretni-letovi-container',
  templateUrl: './teretni-letovi-container.component.html',
  styleUrls: ['./teretni-letovi-container.component.css']
})
export class TeretniLetoviContainerComponent implements OnInit {

  letovi:any;
  readonly URL = "http://localhost:9000/teretni-letovi";
  constructor(private http: HttpClient, private router:Router) { }

  async ngOnInit(): Promise<void> {
    this.letovi = await this.http.get(this.URL).toPromise();
  }

  noviPutnickiLet()
  {
    this.router.navigate(['./novi-teretni-let'])
  }

  obrisiLet(index)
  {
    this.letovi.splice(index, 1);
  }

}
