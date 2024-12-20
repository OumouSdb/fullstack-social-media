import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ArticlesComponent } from './pages/articles/articles.component';
import { RegisterComponent } from './pages/register/register.component';
import { ThemeComponent } from './pages/theme/theme.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { HeaderComponent } from './shared/header/header.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatCardModule } from '@angular/material/card';
// import { ArticleDetailComponent } from './pages/article-detail/article-detail.component';
import { CreateArticleComponent } from './pages/create-article/create-article.component';
import { UserProfilComponent } from './pages/user-profil/user-profil.component';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { ArticleDetailComponent } from './pages/article-detail/article-detail.component';
import { MatSidenavModule } from '@angular/material/sidenav';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ArticlesComponent,
    RegisterComponent,
    ThemeComponent,
    NotFoundComponent,
    HeaderComponent,
    ArticleDetailComponent,
    CreateArticleComponent,
    UserProfilComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatSelectModule,
    MatInputModule,
    MatFormFieldModule,
    HttpClientModule,
    MatSlideToggleModule,
    MatCardModule,
    MatDividerModule,
    MatIconModule,
    ReactiveFormsModule,
    MatSidenavModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
