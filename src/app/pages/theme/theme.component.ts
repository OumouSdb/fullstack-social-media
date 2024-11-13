import { Component, OnInit } from '@angular/core';
import { Subject } from 'src/app/Interfaces/Subject';
import { SubscriptionService } from 'src/app/service/subscription.service';
import { ThemeService } from 'src/app/service/theme.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.scss']
})
export class ThemeComponent implements OnInit {
  themes: Subject[] = [];
  message = "";
  userId?: number;

  constructor(
    private themeService: ThemeService,
    private subscriptionService: SubscriptionService,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    // Obtenez l'utilisateur actuel
    this.loginService.me().subscribe(user => {
      this.userId = user.id;
    });

    // Récupération des thèmes disponibles
    this.themeService.getSubjects().subscribe(value => {
      this.themes = value;
    });
  }

  subscribe(theme: Subject) {
    if (!this.userId) {
      this.message = "Vous devez être connecté pour vous abonner.";
      return;
    }

    if (!theme.id) {
      this.message = "Thème invalide.";
      return;
    }

    this.subscriptionService.subscription(this.userId, theme.id).subscribe(
      () => {
        this.message = "Abonnement réussi !";
      },
      (error) => {
        console.error("Erreur lors de l'abonnement", error);
        this.message = "Échec de l'abonnement.";
      }
    );
  }


}
