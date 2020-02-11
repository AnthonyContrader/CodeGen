import { Component, OnInit } from '@angular/core';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { EntityOwnerService } from 'src/service/entityowner.service';

@Component({
  selector: 'app-entities',
  templateUrl: './entities.component.html',
  styleUrls: ['./entities.component.css']
})
export class EntitiesComponent implements OnInit {

  entities: EntityOwnerDTO[];
  entitytoinsert: EntityOwnerDTO = new EntityOwnerDTO();

  constructor(private service: EntityOwnerService) { }

  ngOnInit() {
    this.getEntities();
  }

  getEntities() {
    this.service.getAll().subscribe(users => this.entities = this.entities);
  }

  delete(entity: EntityOwnerDTO) {
    this.service.delete(entity.id).subscribe(() => this.getEntities());
  }

  update(entity: EntityOwnerDTO) {
    this.service.update(entity).subscribe(() => this.getEntities());
  }

  insert(entity: EntityOwnerDTO) {
    this.service.insert(entity).subscribe(() => this.getEntities());
  }

  clear(){
    this.entitytoinsert = new EntityOwnerDTO();
  }
}
