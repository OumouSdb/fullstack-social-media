import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  menuOpen: boolean = false;
  isMobile: boolean = window.innerWidth < 768;


  constructor() { }

  ngOnInit(): void {
  }

  // Toggle the visibility of the menu
  toggleMenu() {
    this.menuOpen = !this.menuOpen;
  }

  // Listen to window resize events to determine if we're on mobile
  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.isMobile = event.target.innerWidth < 768;
    if (!this.isMobile) {
      this.menuOpen = false;
    }
  }

}
