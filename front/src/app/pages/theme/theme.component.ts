import { Component, OnInit } from '@angular/core';
import { Subject } from 'src/app/Interfaces/Subject';
import { ThemeService } from 'src/app/service/theme.service';

@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.scss']
})
export class ThemeComponent implements OnInit {
  themes: Subject[] = [];
  constructor(private themeService: ThemeService) { }

  ngOnInit(): void {

    this.themeService.getSubjects().pipe().subscribe(value => {
      this.themes = value;
    })
  }

}
