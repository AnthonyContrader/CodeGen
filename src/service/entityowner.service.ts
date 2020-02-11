import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

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
export class EntityOwnerService extends AbstractService<EntityOwnerDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'entity';
  }

  login(loginDTO: LoginDTO): Observable<EntityOwnerDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)
  }

}
