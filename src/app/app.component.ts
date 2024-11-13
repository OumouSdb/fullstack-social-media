import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Route, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  showHeader = true;

  constructor(private router: Router) { }
  ngOnInit(): void {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        // Récupérer l'URL actuelle après chaque navigation
        const currentRoute = event.url;
        if (currentRoute === '/') {
          this.showHeader = false;
        } else {
          this.showHeader = true;
        }
      }
    });
  }


}
