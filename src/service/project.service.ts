import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ProjectDTO } from 'src/dto/projectdto';
import { UserDTO } from 'src/dto/userdto';
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
export class ProjectService extends AbstractService<ProjectDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'api/projects';
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
     return this.http.get('http://192.168.1.202:9090/api/users/' + username, {
       headers: {
         Authorization: this.auth()
       }
     });
   }


}
