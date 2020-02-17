import { Component, OnInit } from '@angular/core';
import { LogService } from 'src/service/log.service';
import { LogDTO } from 'src/dto/logdto';

@Component({
  selector: 'app-logs',
  templateUrl: './logs.component.html',
  styleUrls: ['./logs.component.css']
})
export class LogsComponent implements OnInit {

  constructor(private service : LogService) { }
  logtoinsert: LogDTO = new LogDTO();
  logs: LogDTO[];

  ngOnInit() {
    this.getLogs();
  }

  getLogs() {
    this.getFormat(this.logs);
    this.service.getAll().subscribe(logs => this.logs = logs);
  }
  getFormat(dt: Date){
    alert(log.moment);
    return dt;
  }

  insert(log: LogDTO){
    
    this.service.insert(log).subscribe(() => this.getLogs());
  }
  
}
