import { Component, OnInit } from '@angular/core';
import { LogService } from 'src/service/log.service';
import { LogDTO } from 'src/dto/logdto';

declare const FormatDate: any;


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

  onLoad(){
    FormatDate();
  }
  getLogs() {
    this.service.getAll().subscribe(logs => this.logs = logs);
  }
  
  insert(log: LogDTO){
    
    this.service.insert(log).subscribe(() => this.getLogs());
  }
  

  
}

