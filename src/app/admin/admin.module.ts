import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';

import { FieldsComponent } from './fields/fields.component';
import { LogsComponent } from './logs/logs.component';

import { ProjectsComponent } from './projects/projects.component';
import { RelationshipsComponent } from './relationships/relationships.component';
import { EntitiesComponent } from './entities/entities.component';
import { ProjectviewComponent } from './projectview/projectview.component';


/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Giuseppe De Palma
 * 
 * @see AdminRoutingModule
 */
@NgModule({

  declarations: [AdminDashboardComponent, UsersComponent, WorkInProgressComponent, FieldsComponent, LogsComponent,ProjectsComponent, RelationshipsComponent, EntitiesComponent, ProjectviewComponent],

  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
