import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { EntityCustomerDTO } from 'src/dto/entitycustomerdto';
import { HttpClient } from '@angular/common/http';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Selenia Brunco
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class EntityCustomerService extends AbstractService<EntityCustomerDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'entitycustomer';
  }

  }
