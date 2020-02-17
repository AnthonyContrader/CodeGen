import { Component, OnInit } from '@angular/core';
import { RelationshipService } from 'src/service/relationship.service';
import { RelationshipDTO } from 'src/dto/relationshipdto';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { EntityOwnerService } from 'src/service/entityowner.service';
import { EntityCustomerDTO } from 'src/dto/entitycustomerdto';
import { EntityCustomerService } from 'src/service/entitycustomer.service';
import { LogDTO } from 'src/dto/logdto';
import { LogService } from 'src/service/log.service';

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
  logtoinsert: LogDTO = new LogDTO();
  date: Date = new Date();


  constructor(private service: RelationshipService, private serviceeo: EntityOwnerService, private serviceec: EntityCustomerService, private servicelog: LogService){
  }

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
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.moment = this.date;
    this.logtoinsert.action="SHOW RELATIONSHIP";
    this.servicelog.insert(this.logtoinsert).subscribe(() => this.servicelog.getAll());
  }

  delete(relationship: RelationshipDTO) {
    this.service.delete(relationship.id).subscribe(() => this.getRelationships());
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action="DELETE RELATIONSHIP";
    this.logtoinsert.moment = this.date;
    this.servicelog.insert(this.logtoinsert).subscribe(() => this.servicelog.getAll());
  }

  update(relationship: RelationshipDTO) {
    this.service.update(relationship).subscribe(() => this.getRelationships());
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action="UPDATE RELATIONSHIP";
    this.logtoinsert.moment = this.date;
    this.servicelog.insert(this.logtoinsert).subscribe(() => this.servicelog.getAll());
  }

  insert(relationship: RelationshipDTO) {
    if (relationship.entityowner.id!=relationship.entitycustomer.id)
    {
    this.service.insert(relationship).subscribe(() => this.getRelationships());
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;  
    this.logtoinsert.moment = this.date; 
    this.logtoinsert.action="INSERT RELATIONSHIP";
    this.servicelog.insert(this.logtoinsert).subscribe(() => this.servicelog.getAll());
    }
    else this.alert();
    this.clear();
  }

  clear(){
    this.relationshiptoinsert = new RelationshipDTO();
  }

  alert() {
    window.alert("You can't link same entities between them! Please retry.");
  }
}
