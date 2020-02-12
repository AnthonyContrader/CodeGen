import { Component, OnInit, Injectable } from '@angular/core';
import { FieldDTO } from 'src/dto/fielddto';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { FieldService } from 'src/service/field.service';
import { EntityOwnerService } from 'src/service/entityowner.service';
/**
 * @author Dott. De Palma Giuseppe
 */
@Component({
  selector: 'app-fields',
  templateUrl: './fields.component.html',
  styleUrls: ['./fields.component.css']
})

export class FieldsComponent implements OnInit {
  private serviceEntity : EntityOwnerService;
  entities: EntityOwnerDTO[];
  fields: FieldDTO[];
  fieldtoinsert: FieldDTO = new FieldDTO();

  constructor(private service: FieldService) { }

  ngOnInit() {
    this.getFields();
  }
  getFields() {
    this.service.getAll().subscribe(fields => this.fields = fields);
    this.serviceEntity.getAll().subscribe(entities=> this.entities);
  }
  delete(field: FieldDTO){
    this.service.delete(field.id).subscribe(() => this.getFields());
  }

  insert(field: FieldDTO){
    this.service.insert(field).subscribe(() => this.getFields());
  }
  update(field: FieldDTO){
    this.service.update(field).subscribe(() => this.getFields());
  }
  clear(field: FieldDTO){
    this.fieldtoinsert = new FieldDTO();
  }
}
