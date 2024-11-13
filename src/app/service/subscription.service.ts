import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Subscription } from '../Interfaces/Subscription';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  private apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) { }

  getSubscriptionById(userId: number) {
    return this.http.get<Subscription[]>(`${this.apiUrl}/subscription/subscribed/` + userId);
  }
  getSubscription() {
    return this.http.get<Subscription>(`${this.apiUrl}/subscription`);
  }
  // SubscriptionService
  subscription(userId: number, subjectId: number) {
    const subscriptionData = { user: { id: userId }, subject: { id: subjectId } };
    return this.http.post<Subscription>(`${this.apiUrl}/subscription/save`, subscriptionData);
  }


  delete(id: number) {
    return this.http.delete<Subscription>(`${this.apiUrl}/subscription/${id}`);
  }

}
