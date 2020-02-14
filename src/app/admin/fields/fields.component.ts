import { Component, OnInit, Injectable, IterableDiffers } from '@angular/core';
import { FieldDTO } from 'src/dto/fielddto';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { FieldService } from 'src/service/field.service';
import { EntityOwnerService } from 'src/service/entityowner.service';
import { ProjectDTO } from 'src/dto/projectdto';
import { LogDTO } from 'src/dto/logdto';
import { LogService } from 'src/service/log.service';
import { log } from 'util';

/**
 * @author Dott. De Palma Giuseppe
 */
@Component({
  selector: 'app-fields',
  templateUrl: './fields.component.html',
  styleUrls: ['./fields.component.css']
})

export class FieldsComponent implements OnInit {
  
  sample = new ProjectDTO();  
  entities : EntityOwnerDTO[] ;   //La lista delle entità
  logtoinsert: LogDTO = new LogDTO();
  fields: Array<FieldDTO>;
  fieldtoinsert: FieldDTO = new FieldDTO();

  constructor(private service: FieldService, private serviceEntity: EntityOwnerService,private ServiceLog: LogService) { 
   } //I services si inizializzano nel cstruttore

  ngOnInit() {
    this.getFields();
    this.getEntities();
  }

  getEntities() {
    this.serviceEntity.getAll().subscribe(entities => this.entities = entities);
  }
  getFields() {
    this.service.getAll().subscribe(fields => this.fields = fields);
    this.serviceEntity.getAll().subscribe(entities=> this.entities);
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action="SHOW FIELD";
    //da sistemare this.logtoinsert.moment.setDate;
    this.ServiceLog.insert(this.logtoinsert).subscribe(() => this.ServiceLog.getAll());
  }
  delete(field: FieldDTO){
    this.service.delete(field.id).subscribe(() => this.getFields());
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;  
    this.logtoinsert.action="DELETE FIELD";
    this.ServiceLog.insert(this.logtoinsert);
  }

  insert(field: FieldDTO){
    this.service.insert(field).subscribe(() => this.getFields());
    this.fieldtoinsert = new FieldDTO();
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action="INSERT FIELD";
    this.ServiceLog.insert(this.logtoinsert);
  }
  update(field: FieldDTO){
    this.service.update(field).subscribe(() => this.getFields());
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action="UPDATE FIELD";
    this.ServiceLog.insert(this.logtoinsert);
  }
  clear(field: FieldDTO){
    this.fieldtoinsert = new FieldDTO();
  }
}
