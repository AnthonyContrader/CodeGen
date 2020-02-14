import { Component, OnInit } from '@angular/core';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { EntityOwnerService } from 'src/service/entityowner.service';
import { ProjectDTO } from 'src/dto/projectdto';
import { ProjectService } from 'src/service/project.service';

@Component({
  selector: 'app-entities',
  templateUrl: './entities.component.html',
  styleUrls: ['./entities.component.css']
})
export class EntitiesComponent implements OnInit {

  entities: EntityOwnerDTO[];
 
  entitytoinsert: EntityOwnerDTO = new EntityOwnerDTO();
  projects: ProjectDTO[];

  constructor(private service: EntityOwnerService, private servicep:ProjectService) { }

  ngOnInit() {
    this.getEntities();
    this.getProjects();
  }

  getEntities() {
    this.service.getAll().subscribe(entities => this.entities = entities);
  }
  getProjects() {
    this.servicep.getAll().subscribe(projects => this.projects = projects);
  }

  delete(entity: EntityOwnerDTO) {
    this.service.delete(entity.id).subscribe(() => this.getEntities());
  }

  update(entity: EntityOwnerDTO) {
    this.service.update(entity).subscribe(() => this.getEntities());
  }

  insert(entity: EntityOwnerDTO) {
    this.service.insert(entity).subscribe(() => this.getEntities());
    this.clear();
  }

  clear(){
    this.entitytoinsert = new EntityOwnerDTO();
  }
  
  }


