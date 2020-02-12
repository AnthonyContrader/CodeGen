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

  private servicee : EntityOwnerService;
  entities: EntityOwnerDTO[];
  relationships: RelationshipDTO[];
  relationshiptoinsert: RelationshipDTO = new RelationshipDTO();

  constructor(private service: RelationshipService) { }

  ngOnInit() {
    this.getRelationships();
  }

  getRelationships() {
    this.service.getAll().subscribe(relationships => this.relationships = relationships);
  }

  getEntities() {
    this.servicee.getAll().subscribe(entities => this.entities = entities);
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
