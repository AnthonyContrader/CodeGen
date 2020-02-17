import { Component, OnInit } from '@angular/core';
import { LogService } from 'src/service/log.service';
import { LogDTO } from 'src/dto/logdto';

declare function FormateDate() : any;

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
     FormateDate();
  }

  getLogs() {
    this.service.getAll().subscribe(logs => this.logs = logs);
  }
  
  insert(log: LogDTO){
    
    this.service.insert(log).subscribe(() => this.getLogs());
  }
  
  setFormat() {
    var i=0;
      while(document.getElementById(""+i) != null){
        var temp = document.getElementById(""+i).getAttribute("value");
        var data = temp.substring(0, 10);
        var ora = temp.substring(11, 19);
        var date = data.split("-");
        var data=date[2]+"/"+date[1]+"/"+date[0];

        document.getElementById(""+i).setAttribute("value",data+" "+ora);
        i++;
      }
  }

  
}

