import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ArticlesComponent } from './pages/articles/articles.component';
import { ThemeComponent } from './pages/theme/theme.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { CreateArticleComponent } from './pages/create-article/create-article.component';
import { ArticleDetailComponent } from './pages/article-detail/article-detail.component';
import { UserProfilComponent } from './pages/user-profil/user-profil.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'articles', component: ArticlesComponent, canActivate: [AuthGuard] },
  { path: 'subject', component: ThemeComponent, canActivate: [AuthGuard] },
  { path: 'create', component: CreateArticleComponent, canActivate: [AuthGuard] },
  { path: 'detail/:id', component: ArticleDetailComponent, canActivate: [AuthGuard] },
  { path: 'user', component: UserProfilComponent, canActivate: [AuthGuard] },
  { path: '**', component: NotFoundComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
