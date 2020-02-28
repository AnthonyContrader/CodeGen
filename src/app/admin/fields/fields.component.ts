import { Component, OnInit } from '@angular/core';
import { FieldDTO } from 'src/dto/fielddto';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { FieldService } from 'src/service/field.service';
import { EntityOwnerService } from 'src/service/entityowner.service';
import { ProjectDTO } from 'src/dto/projectdto';
import { LogDTO } from 'src/dto/logdto';
import { LogService } from 'src/service/log.service';



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
  date: Date = new Date();

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
    this.InsertLog("SHOW ALL FIELD");    
  }
  delete(field: FieldDTO){
    this.service.delete(field.id).subscribe(() => this.getFields());
    this.InsertLog("DELETE FIELD");    
  }

  insert(field: FieldDTO){
    this.service.insert(field).subscribe(() => this.getFields());
    this.fieldtoinsert = new FieldDTO();
    this.InsertLog("INSERT FIELD");    
  }
  update(field: FieldDTO){
    this.service.update(field).subscribe(() => this.getFields());
    this.InsertLog("UPDATE FIELD");    
  }
  clear(field: FieldDTO){
    this.fieldtoinsert = new FieldDTO();
  }
 
  InsertLog(op: string){
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action=op;
    var inst = new Date();
    inst.setHours ( inst.getHours( )+ 1);
    //var inst_ = (inst.getFullYear()+"-"+inst.getMonth()+"-"+inst.getDay( )+" "+inst.getHours( )+":"+inst.getMinutes()+":"+inst.getSeconds());

    this.logtoinsert.moment =new Date(inst);
    this.ServiceLog.insert(this.logtoinsert).subscribe(() => this.ServiceLog.getAll());
    
  }
}
