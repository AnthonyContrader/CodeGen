import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/service/project.service';
import { ProjectDTO } from 'src/dto/projectdto';
import { LogDTO } from 'src/dto/logdto';
import { LogService } from 'src/service/log.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  projects: ProjectDTO[];
  projecttoinsert: ProjectDTO = new ProjectDTO();
  logtoinsert: LogDTO = new LogDTO();
  date: Date = new Date();

  constructor(private service: ProjectService, private servicelog: LogService) { }

  ngOnInit() {
    this.getProjects();
  }

  getProjects() {
    this.service.getAll().subscribe(projects => this.projects = projects);
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action="SHOW PROJECT";
    this.logtoinsert.moment = this.date;
    this.servicelog.insert(this.logtoinsert).subscribe(() => this.servicelog.getAll());
  }

  delete(project: ProjectDTO) {
    this.service.delete(project.id).subscribe(() => this.getProjects());
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action="DELETE PROJECT";
    this.logtoinsert.moment = this.date;
    this.servicelog.insert(this.logtoinsert).subscribe(() => this.servicelog.getAll());
  }

  update(project: ProjectDTO) {
    this.service.update(project).subscribe(() => this.getProjects());
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action="UPDATE PROJECT";
    this.logtoinsert.moment = this.date;
    this.servicelog.insert(this.logtoinsert).subscribe(() => this.servicelog.getAll());
  }

  insert(project: ProjectDTO) {
    this.service.insert(project).subscribe(() => this.getProjects());
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action="INSERT PROJECT";
    this.logtoinsert.moment = this.date;
    this.servicelog.insert(this.logtoinsert).subscribe(() => this.servicelog.getAll());
    this.clear();
  }

  clear(){
    this.projecttoinsert = new ProjectDTO();
  }
}
