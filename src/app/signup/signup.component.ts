import { Component, OnInit } from '@angular/core';
import {SignupDTO} from 'src/dto/signupdto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupDTO: SignupDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }
  
  signup(f: NgForm): void {
    this.signupDTO = new SignupDTO(f.value.username, f.value.email, f.value.password);

    this.service.signup(this.signupDTO).subscribe((token:any) => {
      localStorage.setItem("AUTOKEN", JSON.stringify({ "authorities": token.id_token }));
      localStorage.setItem("currentUser", JSON.stringify({ "authorities": token.id_token }));
      this.service.userLogged(this.signupDTO.username).subscribe((user:UserDTO)=>{

        if (user != null) {
          localStorage.setItem('AUTOKEN', JSON.stringify(user));
          if(user.authorities == "ROLE_ADMIN" ) {
            this.router.navigate(['/admin-dashboard']);
          }
          if(user.authorities == "ROLE_USER") {
            this.router.navigate(['/user-dashboard']);
          }
        }else{
          this.router.navigate(['/signup']);
          }
        });
      });
      }
  }
