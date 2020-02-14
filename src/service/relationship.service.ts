import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { RelationshipDTO } from 'src/dto/relationshipdto';
import { HttpClient } from '@angular/common/http';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Salvatore Petrianni
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class RelationshipService extends AbstractService<RelationshipDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'relationship';
  }

}
