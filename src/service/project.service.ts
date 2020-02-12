import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ProjectDTO } from 'src/dto/projectdto';
import { HttpClient } from '@angular/common/http';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class ProjectService extends AbstractService<ProjectDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'project';
  }

}
