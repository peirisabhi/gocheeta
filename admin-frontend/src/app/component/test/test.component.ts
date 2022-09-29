import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {TestService} from "../../service/test-service/test.service";
import {HttpEventType, HttpResponse} from "@angular/common/http";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  selectedFiles?: FileList;
  currentFile?: File | null | undefined;
  progress = 0;
  message = '';
  fileInfos?: Observable<any>;
  constructor(private testService: TestService) { }

  hero = {name: 'Dr.', alterEgo: 'Dr. What'};

  heroForm?: FormGroup;

  ngOnInit(): void {
    this.heroForm = new FormGroup({
      name: new FormControl(this.hero.name, [
        Validators.required,
        Validators.minLength(4),
        // forbiddenNameValidator(/bob/i) // <-- Here's how you pass in the custom validator.
      ]),
      alterEgo: new FormControl(this.hero.alterEgo),
    });
  }

  // get name() { return this.heroForm.get('name'); }


  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
    // this.currentFile = this.selectedFiles?.item(0);
    this.currentFile = (event.target.files).item(0);
  }

  upload(): void {
    // this.progress = 0;
    // if (this.selectedFiles) {
    //   const file: File | null = this.selectedFiles.item(0);
    //   if (file) {
    //     this.currentFile = file;

    // @ts-ignore
    console.log(this.selectedFiles.length)

    if (this.currentFile) {
      this.testService.upload(this.currentFile).subscribe({
        next: (event: any) => {
          if (event.type === HttpEventType.UploadProgress) {
            this.progress = Math.round(100 * event.loaded / event.total);
          } else if (event instanceof HttpResponse) {
            this.message = event.body.message;
            // this.fileInfos = this.testService.getFiles();
          }
        },
        error: (err: any) => {
          console.log(err);
          this.progress = 0;
          if (err.error && err.error.message) {
            this.message = err.error.message;
          } else {
            this.message = 'Could not upload the file!';
          }
          this.currentFile = undefined;
        }
      });
    }
    //   }
    //   this.selectedFiles = undefined;
    // }
  }

}
