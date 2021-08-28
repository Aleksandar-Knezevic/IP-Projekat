import { Component, Input, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-poruke-container',
  templateUrl: './poruke-container.component.html',
  styleUrls: ['./poruke-container.component.css']
})
export class PorukeContainerComponent implements OnInit {

  poruke:any;
  readonly ROOT_URL = 'http://localhost:9000/poruke';

  constructor(private http: HttpClient, public route: ActivatedRoute)
  {
    this.route.url.subscribe(params => {
      if(params[0].path=='all')
        this.poruke = http.get(this.ROOT_URL);
      if(params[0].path=='unread')
        this.poruke = http.get(this.ROOT_URL+'/unread');
      
    });
  }

  ngOnInit(): void {
  }

  searchMessages(search)
  {
    if(search== '')
      this.poruke = this.http.get(this.ROOT_URL);
    else
    {
      let header = new HttpHeaders();
      header = header.set('Content-Type', 'text/plain');
      this.poruke = this.http.post(this.ROOT_URL+'/search', search, {headers:header});
    }
    
  }



}
