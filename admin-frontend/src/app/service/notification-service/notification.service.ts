import { Injectable } from '@angular/core';
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private toast: ToastrService) { }

  showSuccess(message : String, title : String){
    this.toast.success(message, title)
  }

  showError(message : String, title : String){
    this.toast.error(message, title)
  }

  showInfo(message : String, title : String){
    this.toast.info(message, title)
    this.toast.info(message, title);
  }

  showWarning(message : String, title : String){
    this.toast.warning(message, title)
  }
}
