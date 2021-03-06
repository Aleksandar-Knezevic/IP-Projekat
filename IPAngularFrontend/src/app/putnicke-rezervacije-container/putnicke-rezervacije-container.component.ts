import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-putnicke-rezervacije-container',
  templateUrl: './putnicke-rezervacije-container.component.html',
  styleUrls: ['./putnicke-rezervacije-container.component.css']
})
export class PutnickeRezervacijeContainerComponent implements OnInit {

  readonly URL = 'http://localhost:9000/putnicke-rezervacije'
  rezervacije:any;
  selected='Nova';

  constructor(private http:HttpClient) { }

  async ngOnInit(): Promise<void> {
    this.rezervacije= await this.http.get(this.URL+'/Nova').toPromise();
  }

  async updateRezervacije(event)
  {
    this.rezervacije= await this.http.get(this.URL+'/'+event).toPromise();
  }

  odobriLet(index)
  {
    this.rezervacije.splice(index, 1);
  }

  ponistiLet(index)
  {
    this.rezervacije.splice(index, 1);
  }

}
