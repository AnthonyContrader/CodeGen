import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { LogDTO } from 'src/dto/logdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LogService extends AbstractService<LogDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'log';
  }

}
