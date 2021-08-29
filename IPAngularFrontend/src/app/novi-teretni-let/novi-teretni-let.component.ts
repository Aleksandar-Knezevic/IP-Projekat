import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-novi-teretni-let',
  templateUrl: './novi-teretni-let.component.html',
  styleUrls: ['./novi-teretni-let.component.css']
})
export class NoviTeretniLetComponent implements OnInit {

  readonly STATE_URL = 'http://localhost:9000/drzave';
  readonly CITY_URL = 'http://localhost:9000/gradovi';
  readonly POST_URL = 'http://localhost:9000/teretni-letovi';
  noviPutnickiLetForm: FormGroup;
  @Input('drzave') drzave:any;
  @Input('polazniGradovi') polazniGradovi:any;
  @Input('odredisniGradovi') odredisniGradovi:any;
  formValid:boolean;


  constructor(private http: HttpClient, private fb:FormBuilder, private router: Router) {
    this.formValid=false;
   }

  ngOnInit(): void {
    this.drzave = this.http.get(this.STATE_URL);
    this.initializeForm();
  }

  initializeForm():void
  {
      this.noviPutnickiLetForm = this.fb.group({
        datumiLeta: this.fb.array([this.fb.control('')]),
        vrijemePolaska: '',
        vrijemeDolaska: '',
        polaznaDrzava: 'Polazna drzava',
        polazniGrad: 'Polazni grad',
        odredisnaDrzava: 'Odredisna drzava',
        odredisniGrad:'Odredisni grad',
        status:''
      });
  }

  get datumiLeta(): FormArray{
    return this.noviPutnickiLetForm.get('datumiLeta') as FormArray;
  }

  getPolazniGradovi(event){
      this.polazniGradovi = this.http.get(this.STATE_URL+'/'+event);
      
  }

  getOdredisniGradovi(event)
  {
    this.odredisniGradovi = this.http.get(this.STATE_URL+'/'+event);
  }

  dodajDatum()
  {
    this.datumiLeta.push(this.fb.control(''));
  }

  ukloniDatum(i){
    this.datumiLeta.removeAt(i);
  }

  async onSubmit(){
    let noviLet = this.noviPutnickiLetForm.value;
    let polazniGrad:any={};
    let odredisniGrad:any={};
    try{
      polazniGrad = await this.http.get(this.CITY_URL+'/'+this.noviPutnickiLetForm.value.polazniGrad).toPromise();
      odredisniGrad = await this.http.get(this.CITY_URL+'/'+this.noviPutnickiLetForm.value.odredisniGrad).toPromise();
      let nazivPolaza = polazniGrad.nazivGrada;
      let nazivOdredista = odredisniGrad.nazivGrada;
      if(nazivPolaza!=='Banja Luka' && nazivOdredista!=='Banja Luka')
        throw 'Gradovi error';
      if(nazivPolaza==='Banja Luka' && nazivOdredista==='Banja Luka')
        throw 'Gradovi error';
      noviLet.datumiLeta.forEach(element => {
        this.http.post(this.POST_URL, {
          datumLeta: element,
          polazniGrad: noviLet.polazniGrad,
          odredisniGrad: noviLet.odredisniGrad,
          polaznaDrzava: noviLet.polaznaDrzava,
          odredisnaDrzava: noviLet.odredisnaDrzava,
          status: noviLet.status,
          vrijemePolaska: noviLet.vrijemePolaska,
          vrijemeDolaska: noviLet.vrijemeDolaska
        }).subscribe();
      });
      
      this.formValid=false;
      this.router.navigate(['./teretni-letovi'])
      
      
    }
    catch(error){
      this.formValid=true;
    }

    
    
  }

}
