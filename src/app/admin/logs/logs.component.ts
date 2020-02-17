import { Component, OnInit } from '@angular/core';
import { LogService } from 'src/service/log.service';
import { LogDTO } from 'src/dto/logdto';
import { temporaryAllocator } from '@angular/compiler/src/render3/view/util';

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
    //this.setFormat();
  }

  getLogs() {
  //  this.setFormat();
    this.service.getAll().subscribe(logs => this.logs = logs);
  }
  setFormat(){
    var temp="";
    alert(temp);
    return temp;
  }

  insert(log: LogDTO){
    
    this.service.insert(log).subscribe(() => this.getLogs());
  }
  
}
