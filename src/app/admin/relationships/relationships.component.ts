import { Component, OnInit } from '@angular/core';
import { RelationshipService } from 'src/service/relationship.service';
import { RelationshipDTO } from 'src/dto/relationshipdto';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { EntityOwnerService } from 'src/service/entityowner.service';

@Component({
  selector: 'app-relationships',
  templateUrl: './relationships.component.html',
  styleUrls: ['./relationships.component.css']
})
export class RelationshipsComponent implements OnInit {

  entities: EntityOwnerDTO[];
  relationships: RelationshipDTO[];
  relationshiptoinsert: RelationshipDTO = new RelationshipDTO();

  constructor(private service: RelationshipService, private servicee : EntityOwnerService) { }

  ngOnInit() {
    this.getRelationships();
    this.getEntities();
  }

  getRelationships() {
    this.service.getAll().subscribe(relationships => this.relationships = relationships);
  }

  getEntities() {
    this.servicee.getAll().subscribe(entities => this.entities = entities);
    console.log(this.entities[0]);
  }

  delete(relationship: RelationshipDTO) {
    this.service.delete(relationship.id).subscribe(() => this.getRelationships());
  }

  update(relationship: RelationshipDTO) {
    this.service.update(relationship).subscribe(() => this.getRelationships());
  }

  insert(relationship: RelationshipDTO) {
    this.service.insert(relationship).subscribe(() => this.getRelationships());
    this.clear();
  }

  clear(){
    this.relationshiptoinsert = new RelationshipDTO();
  }
}
