import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-poruka',
  templateUrl: './poruka.component.html',
  styleUrls: ['./poruka.component.css']
})
export class PorukaComponent implements OnInit {

  @Input('msg') poruka:any;
  @Input('allMsg') svePoruke:any[];
  constructor(private http: HttpClient) { }
  readonly URL:string = 'http://localhost:9000/poruke/mark-as-read/';

  ngOnInit(): void {
  }

  markAsRead()
  {
    if(this.poruka.status=='Neprocitana')
    {
      this.http.put(this.URL + this.poruka.id, {}).subscribe();
      
    }
      
  }

}
