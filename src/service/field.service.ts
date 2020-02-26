import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { FieldDTO } from 'src/dto/fielddto';
import { HttpClient } from '@angular/common/http';
//import { Observable } from 'rxjs'; //libreria per chiamate asincrone

/**
 * @author Dott. De Palma Giuseppe
 */
@Injectable({ //@autowired per spring 
    providedIn:'root'
})
export class FieldService extends AbstractService<FieldDTO>{
    constructor(http:HttpClient){
        super(http);
        this.type='field';
    }
}