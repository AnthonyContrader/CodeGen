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
  FormatDate()
  {
    let i:number=0;
    while(document.getElementById(i.toString()) != null)
    {
      var temp = (<HTMLInputElement>document.getElementById(i.toString())).value;
      var data = temp.substring(0, 10);
      var ora = temp.substring(11, 19);
      var date = data.split("-");
      var data=date[2]+"/"+date[1]+"/"+date[0];

      //alert(data+" "+ora);
     // $("#"+i).val(data+" "+ora);

      //(<HTMLInputElement>document.getElementById(i.toString())).setAttribute("value",data+" "+ora);
      i++;
    }
  }
  getLogs() {
    
    this.service.getAll().subscribe(logs => this.logs = logs);
    FormatDate();
  }
  
  insert(log: LogDTO){
    
    this.service.insert(log).subscribe(() => this.getLogs());
  }
  

  
}

