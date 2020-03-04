import { Component, OnInit } from '@angular/core';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { EntityOwnerService } from 'src/service/entityowner.service';
import { ProjectDTO } from 'src/dto/projectdto';
import { ProjectService } from 'src/service/project.service';
import { EntityCustomerDTO } from 'src/dto/entitycustomerdto';
import { EntityCustomerService } from 'src/service/entitycustomer.service';
import { LogDTO } from 'src/dto/logdto';
import { LogService } from 'src/service/log.service';


@Component({
  selector: 'app-entities',
  templateUrl: './entities.component.html',
  styleUrls: ['./entities.component.css']
})
export class EntitiesComponent implements OnInit {

  entities: EntityOwnerDTO[];
  entitie2s:EntityCustomerDTO[];
  
  entitytoinsert: EntityOwnerDTO = new EntityOwnerDTO();
  entity2toinsert : EntityCustomerDTO = new EntityCustomerDTO();
  
  projects: ProjectDTO[];
  logtoinsert: LogDTO = new LogDTO();
  date: Date = new Date();
 

  constructor(private service: EntityOwnerService, private servicep:ProjectService, private servicee:EntityCustomerService, private servicelog: LogService) { }

  ngOnInit() {
    
    this.getEntities();
    this.getProjects();
    this.getEntitie2s();
    
  }

  getEntities() {
    this.service.getAll().subscribe(entities => this.entities = entities);
   
    
  }
  getEntitie2s() {
    this.servicee.getAll().subscribe(entitie2s => this.entitie2s = entitie2s);
    
  }
  getProjects() {
    this.servicep.getAll().subscribe(projects => this.projects = projects);
    this.InsertLog("SHOW ENTITY");
  
   
    
  }

  delete(entity: EntityOwnerDTO,entity2: EntityCustomerDTO) {
    this.service.delete(entity.id).subscribe(() => this.getEntities());
    this.servicee.delete(entity.id).subscribe(()=> this.getEntitie2s());
    this.InsertLog("DELETE ENTITY");
    

   
  }

  update(entity: EntityOwnerDTO, entity2: EntityCustomerDTO) {
    this.service.update(entity).subscribe(() => this.getEntities());
    this.servicee.update(entity).subscribe(()=> this.getEntitie2s());
    this.InsertLog("UPDATE ENTITY");
    
    
    }

  insert(entity: EntityOwnerDTO) {

    this.service.insert(entity).subscribe(() => this.getEntities());
    this.servicee.insert(entity).subscribe(() => this.getEntitie2s());
    this.InsertLog("INSERT ENTITY");
    
   
    
    this.clear();
  }

  clear(){
    this.entitytoinsert = new EntityOwnerDTO();
    this.entity2toinsert = new EntityCustomerDTO();
  }
  
   
   
   InsertLog(op: string){
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action=op;
    var inst = new Date();
    inst.setHours ( inst.getHours( )+ 1);
    this.logtoinsert.moment =new Date(inst);
    this.servicelog.insert(this.logtoinsert).subscribe(() => this.servicelog.getAll()); 
  }

}
