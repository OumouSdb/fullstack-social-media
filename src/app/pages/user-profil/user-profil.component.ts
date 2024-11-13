import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginResponse } from 'src/app/Interfaces/loginResponse';
import { Subscription } from 'src/app/Interfaces/Subscription';
import { User } from 'src/app/Interfaces/User';
import { LoginService } from 'src/app/service/login.service';
import { SubscriptionService } from 'src/app/service/subscription.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-user-profil',
  templateUrl: './user-profil.component.html',
  styleUrls: ['./user-profil.component.scss']
})
export class UserProfilComponent implements OnInit {
  subscriptions: Subscription[] = [];
  currentUser!: LoginResponse;
  form!: FormGroup;

  constructor(
    private subscriptionService: SubscriptionService,
    private loginService: LoginService,
    private router: Router,
    private userService: UserService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {

    const token = localStorage.getItem('token');
    if (!token) {

      this.router.navigate(['/login']);
      return;
    }

    this.loginService.me().subscribe(user => {
      this.currentUser = user;

      if (this.currentUser) {
        this.form = this.fb.group({
          firstname: [this.currentUser.firstname],
          email: [this.currentUser.email]
        });

        this.subscriptionService.getSubscriptionById(this.currentUser.id).subscribe(value => {
          this.subscriptions = value;
        });
      }
    });
  }

  signOut() {

    localStorage.removeItem('token');
    localStorage.removeItem('isAuthenticated');

    this.router.navigate(['/login']);
  }

  unSubscribe(id: number) {
    this.subscriptionService.delete(id).subscribe(() => {
      this.subscriptions = this.subscriptions.filter(sub => sub.id !== id);
    });
  }

  save() {
    if (!this.form.valid) {
      return;
    }

    const userAccount: User = {
      ...this.currentUser,
      firstname: this.form.get('firstname')?.value,
      password: ''
    };

    this.userService.updateUser(this.currentUser.id, userAccount).subscribe({
      next: (value) => {

        localStorage.setItem('user', JSON.stringify({
          id: this.currentUser.id,
          firstname: userAccount.firstname,
        }));

        this.currentUser = { ...this.currentUser, ...userAccount };
      },
      error: (error) => {
        console.error('Erreur lors de la mise à jour de l utilisateur', error);
      }
    });
  }

}
