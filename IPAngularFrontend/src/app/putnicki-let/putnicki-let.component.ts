import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-putnicki-let',
  templateUrl: './putnicki-let.component.html',
  styleUrls: ['./putnicki-let.component.css']
})
export class PutnickiLetComponent implements OnInit {

  @Input('putnicki-let') putnickiLet:any;
  constructor() { }

  ngOnInit(): void {
  }

}
