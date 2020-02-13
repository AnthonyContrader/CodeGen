import { Component, OnInit } from '@angular/core';
import { RelationshipService } from 'src/service/relationship.service';
import { RelationshipDTO } from 'src/dto/relationshipdto';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { EntityOwnerService } from 'src/service/entityowner.service';
import { EntityCustomerDTO } from 'src/dto/entitycustomerdto';
import { EntityCustomerService } from 'src/service/entitycustomer.service';

@Component({
  selector: 'app-relationships',
  templateUrl: './relationships.component.html',
  styleUrls: ['./relationships.component.css']
})
export class RelationshipsComponent implements OnInit {

  entitiesc: EntityCustomerDTO[];
  entities: EntityOwnerDTO[];
  relationships: RelationshipDTO[];
  relationshiptoinsert: RelationshipDTO = new RelationshipDTO();


  constructor(private service: RelationshipService, private serviceeo: EntityOwnerService, private serviceec: EntityCustomerService) { }

  ngOnInit() {
    this.getRelationships();
    this.getEntities();
  }

  getRelationships() {
    this.service.getAll().subscribe(relationships => this.relationships = relationships);
  }

  getEntities() {
    this.serviceeo.getAll().subscribe(entities => this.entities = entities);
    this.serviceec.getAll().subscribe(entitiesc => this.entitiesc = entitiesc);
  }

  delete(relationship: RelationshipDTO) {
    this.service.delete(relationship.id).subscribe(() => this.getRelationships());
  }

  update(relationship: RelationshipDTO) {
    this.service.update(relationship).subscribe(() => this.getRelationships());
  }

  insert(relationship: RelationshipDTO) {
    if (relationship.entityowner.id!=relationship.entitycustomer.id)
    this.service.insert(relationship).subscribe(() => this.getRelationships());
    else this.alert();
    this.clear();
  }

  clear(){
    this.relationshiptoinsert = new RelationshipDTO();
  }

  alert() {
    window.alert("Hello! I am an alert box!!");
  }
}
