import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { User } from 'src/app/Interfaces/User';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  user: User | undefined;
  form!: FormGroup;

  constructor(private loginService: LoginService, private fb: FormBuilder, private router: Router) { }
  ngOnInit(): void {
    this.form = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  onSubmit() {

    if (this.form?.valid) {
      this.loginService.login(this.form.value);
      this.router.navigate(['/articles']);
    }

  }

}
