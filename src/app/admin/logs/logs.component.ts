import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logs',
  templateUrl: './logs.component.html',
  styleUrls: ['./logs.component.css']
})
export class LogsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  getLogs() {
    this.service.getAll().subscribe(fields => this.logs = logs);
  }

  insert(log: LogDTO){
    this.service.insert(field).subscribe(() => this.getLogs());
    this.logtoinsert = new LogDTO();
  }
  clear(log: LogDTO){
    this.logtoinsert = new LogDTO();
  }
}
