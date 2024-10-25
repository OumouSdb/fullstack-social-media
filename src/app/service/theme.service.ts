import { Injectable } from '@angular/core';
import { Subject } from '../Interfaces/Subject';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  private apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) { }


  getSubjects(): Observable<Subject[]> {
    return this.http.get<Subject[]>(`${this.apiUrl}/subject/`);
  }
}
