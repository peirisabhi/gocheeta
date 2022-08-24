import {Component, OnInit} from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  
  constructor(private modalService: NgbModal) {
  }

  ngOnInit(): void {
  }

  open(content: any) {
    console.log(content)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
  }

  close(content:any){
    this.modalService.dismissAll();
  }

}
