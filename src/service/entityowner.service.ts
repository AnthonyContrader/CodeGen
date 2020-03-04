import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { HttpClient } from '@angular/common/http';
import { UserDTO } from 'src/dto/userdto';


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
    this.name = 'management';
    this.type = 'entity';
    this.port = '9090';
  }

  auth() {
    const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;
    if (user) {
      return 'Bearer ' + user.authorities;
    } else {
      return '';
    }
  }

  userLogged(username: string) {
     return this.http.get('http://localhost:9090/api/users/' + username, {
       headers: {
         Authorization: this.auth()
       }
     });
   }

}
