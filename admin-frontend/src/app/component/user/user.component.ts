import {Component, OnInit} from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {environment} from '../../../environments/environment';
import {UserRoleService} from "../../service/user-role-service/user-role.service";
import {UserRole} from "../../model/user-role-model/user-role";
import {User} from "../../model/user-model/user";
import {UserService} from "../../service/user-service/user.service";
import {NotificationService} from "../../service/notification-service/notification.service";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userRoles: UserRole[] = [];
  user: User = new User();

  constructor(private modalService: NgbModal,
              private userRoleService: UserRoleService,
              private userService: UserService,
              private notifyService: NotificationService) {
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

  saveUser() {
    console.log("okk")


    this.userService.saveUser(this.user)
      .subscribe(data => {
        console.log("saving --- " + data);
        this.user = new User();
        this.notifyService.showSuccess("Successfully User Saved", "Success");
      })
  }

}
