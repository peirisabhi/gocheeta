import {Component, OnInit} from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {environment} from '../../../environments/environment';
import {UserRoleService} from "../../service/user-role-service/user-role.service";
import {UserRole} from "../../model/user-role-model/user-role";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userRoles: UserRole[] = [];

  constructor(private modalService: NgbModal, private userRoleService: UserRoleService) {
  }

  ngOnInit(): void {
    console.log(environment.title)
    this.getUserRoles();
  }

  open(content: any) {
    console.log(content)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
  }

  close(content: any) {
    this.modalService.dismissAll();
  }

  getUserRoles() {
    this.userRoleService.getUserRoles().subscribe(data => {
      this.userRoles = data;
      console.log(data);
    })
  }

}
