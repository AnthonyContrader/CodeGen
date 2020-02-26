import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { LogDTO } from 'src/dto/logdto';
import { LogService } from 'src/service/log.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: UserDTO[];
  usertoinsert: UserDTO = new UserDTO();
  logtoinsert: LogDTO = new LogDTO();
  date: Date = new Date();

  constructor(private service: UserService, private servicelog: LogService) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    this.service.getAll().subscribe(users => this.users = users);
    this.InsertLog("SHOW USER");
  }

  delete(user: UserDTO) {
    this.service.delete(user.id).subscribe(() => this.getUsers());
    this.InsertLog("DELETE USER");
  }

  update(user: UserDTO) {
    this.service.update(user).subscribe(() => this.getUsers());
    this.InsertLog("UPDATE USER");
  }

  insert(user: UserDTO) {
    this.service.insert(user).subscribe(() => this.getUsers());
    this.InsertLog("INSERT USER");
    this.clear();
  }

  clear(){
    this.usertoinsert = new UserDTO();
  }

  InsertLog(op: string){
    this.logtoinsert.user= JSON.parse(localStorage.getItem('currentUser')).username;   
    this.logtoinsert.action=op;
    var inst = new Date();
    inst.setHours ( inst.getHours( )+ 1);
    this.logtoinsert.moment =new Date(inst);
    this.servicelog.insert(this.logtoinsert).subscribe(() => this.servicelog.getAll()); 
  }
}
