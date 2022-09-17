import {Injectable} from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import {Observable} from 'rxjs';
import {StorageService} from "../service/storage-service/storage.service";

@Injectable()
export class RequestInterceptor implements HttpInterceptor {

  constructor(private storageService: StorageService) {
  }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    const jwtToken = this.storageService.getUser().jwt_token;
    if (jwtToken != null) {
      request = request.clone({
        url: request.url,
        setHeaders: {
          Authorization: `Bearer ${jwtToken}`
        }
      });
    }
    return next.handle(request);
  }

//   return next.handle(request).pipe(
//     catchError((err) => {
//   if (err instanceof HttpErrorResponse) {
//   if (err.status === 401) {
//   // redirect user to the logout page
// }
// }
// return throwError(err);
// })
// )
// }


}
