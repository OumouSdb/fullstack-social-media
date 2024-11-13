import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../Interfaces/User';
import { Observable } from 'rxjs';
import { LoginResponse } from '../Interfaces/loginResponse';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) { }

  login(user: User) {
    return this.http.post<any>(`${this.apiUrl}/auth/login`, user).subscribe(response => {
      const token = response.token;
      if (token) {
        console.log(token);
        localStorage.setItem('token', token);
      }
    });
  }


  register(user: User) {
    return this.http.post<User>(`${this.apiUrl}/auth/register`, user);
  }

  me(): Observable<LoginResponse> {
    return this.http.get<LoginResponse>(`${this.apiUrl}/auth/me`);
  }
}
