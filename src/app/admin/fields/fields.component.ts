import { Component, OnInit, Injectable, IterableDiffers } from '@angular/core';
import { FieldDTO } from 'src/dto/fielddto';
import { EntityOwnerDTO } from 'src/dto/entityownerdto';
import { FieldService } from 'src/service/field.service';
import { EntityOwnerService } from 'src/service/entityowner.service';
import { ProjectDTO } from 'src/dto/projectdto';
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
  
  fields: Array<FieldDTO>;
  fieldtoinsert: FieldDTO = new FieldDTO();

  constructor(private service: FieldService, private serviceEntity: EntityOwnerService, private iterableDiffers: IterableDiffers) { 
    this.entities=[{ id: 0, name: '', project: this.sample }]
   } //I servicees si inizializzano nel cstruttore

  ngOnInit() {
    this.getFields();
    this.getEntities();
  }

  setField(id : number, index : number){
    this.fields[index].id = id;
  }

  getEntities() {
    this.serviceEntity.getAll().subscribe(entities => this.entities = entities);
    console.log(this.entities[0]);
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
