import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/service/projects/project.service';
import { ProjectDTO } from 'src/dto/projects/projectdto';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
