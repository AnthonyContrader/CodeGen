import { Component, OnInit } from '@angular/core';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { EntityOwnerService } from 'src/service/entityowner.service';
import { ProjectDTO } from 'src/dto/projectdto';
import { ProjectService } from 'src/service/project.service';
import { EntityCustomerDTO } from 'src/dto/entitycustomerdto';
import { EntityCustomerService } from 'src/service/entitycustomer.service';


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

  constructor(private service: EntityOwnerService, private servicep:ProjectService, private servicee:EntityCustomerService) { }

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
  }

  delete(entity: EntityOwnerDTO,entity2: EntityCustomerDTO) {
    this.service.delete(entity.id).subscribe(() => this.getEntities());
    this.servicee.delete(entity2.id).subscribe(()=> this.getEntitie2s());
  }

  update(entity: EntityOwnerDTO,entity2: EntityCustomerDTO) {
    this.service.update(entity).subscribe(() => this.getEntities());
    this.servicee.update(entity2).subscribe(()=> this.getEntitie2s());
    
  }

  insert(entity: EntityOwnerDTO, entity2: EntityCustomerDTO) {

    this.service.insert(entity).subscribe(() => this.getEntities());
    this.servicee.insert(entity2).subscribe(() => this.getEntitie2s());
    this.clear();
  }

  clear(){
    this.entitytoinsert = new EntityOwnerDTO();
    this.entity2toinsert = new EntityCustomerDTO();
  }
  
  }


