**1** el siguiente command:

```
ng new pc14328u202317584 –-skip-git
```
CSS y no

**2** Entrar al raider
y abrir terminal del proyecto:

```
ng add @angular/material
```

```
npm install @ngx-translate/core @ngx-translate/http-loader --save
```

**3** Generar la parte de idiomas:

agregar en public/assets/i18n

los paquetes en.json y es.json

en.json
```
{
  "footer": {
    "rights": "“Copyright © 2025 FBI. All rights reserved.",
    "intro": "Developed by",
    "author": "u202317584 - Mathias Aspajo Alvarez"
  }
}
```

es.json
```
{
  "footer": {
    "rights": "Copyright © 2025 FBI. Todos los derechos reservados.",
    "intro": "Hecho por",
    "author": "u202317584 - Mathias Aspajo Alvarez"
  }
}
```

**4** Generar los environments:
```
ng generate environments
```

Poner en environment:
De una url completa ejemplo: https://api.fbi.gov/wanted/v1/list
```
export const environment = {
  production: true,
  wantedFbiApiBaseUrl: 'https://api.fbi.gov',
  wantedFbiApiEndPoint: '/wanted/v1/list'
};
```
y en el otro solo poner false

**5** Generar componentes en public (header, footer, language-switcher):
```
ng generate component public/components/header-content --skip-tests=true
```
```
ng generate component public/components/footer-content --skip-tests=true
```
```
ng generate component public/components/language-switcher --skip-tests=true
```
**6** Generar los siguientes archivos:
```
ng generate interface wanteds/services/wanted response
```
```
ng generate class wanteds/model/wanted --type=entity --skip-tests=true
```
```
ng generate class wanteds/services/wanted --type=assembler --skip-tests=true
```
```
ng generate service wanteds/services/wanteds-api --skip-tests=true
```
```
ng generate component wanteds/components/wanted-item --skip-tests=true
```
```
ng generate component wanteds/components/wanted-list --skip-tests=true
```
**7** Agregar code en language.ts:
```
import { TranslateService } from "@ngx-translate/core";
import { MatButtonToggleModule } from '@angular/material/button-toggle';
```
```
@Component({
  selector: 'app-language-switcher',
  imports: [MatButtonToggleModule],
  templateUrl: './language-switcher.component.html',
  styleUrl: './language-switcher.component.css'
})
```
```
export class LanguageSwitcherComponent {
  currentLang: string = 'en';
  languages: string[] = ['en', 'es'];

  constructor(private translate: TranslateService) {
    this.currentLang = translate.currentLang;
  }

  useLanguage(language: string) : void {
    this.translate.use(language);
  }
}
```
**8** Agregar code en language.html:
```
<mat-button-toggle-group [value]="currentLang" appearance="standard" aria-label="Preferred Language" name="language">
  @for (language of languages; track language) {
    <mat-button-toggle (click)="useLanguage(language)"
                       [aria-label]="language"
                       [value]="language">{{ language.toUpperCase() }}
    </mat-button-toggle>
  }
</mat-button-toggle-group>
```
**9** Agregar code en header.ts:
```
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import {LanguageSwitcherComponent} from '../language-switcher/language-switcher.component';
import {MatCardImage} from '@angular/material/card';
```
```
@Component({
  selector: 'app-header-content',
  imports: [MatToolbarModule, MatButtonModule, LanguageSwitcherComponent, MatCardImage],
  templateUrl: './header-content.component.html',
  styleUrl: './header-content.component.css'
})
```
**10** Agregar code en header.html:
```
<mat-toolbar color="primary">
  <img mat-card-image src="https://logo.clearbit.com/fbi.gov" alt="logo-algo">
  <div class="toolbar-title">TITULO</div>
  <span class="example-spacer"></span>
  <span>
    <app-language-switcher/>
  </span>
</mat-toolbar>
```
**11** Agregar code en header.css:
```
.example-spacer {
  flex: 1 1 auto;
}

mat-toolbar {
  display: flex;
  flex-wrap: wrap;
  padding: 1rem;
  box-sizing: border-box;
  height: 100%;
  max-height: 200px;
}

.toolbar-title {
  font-size: 1.25rem;
}

@media (max-width: 600px) {
  mat-toolbar {
    flex-direction: column;
    align-items: center;
    gap: 0.5rem;
  }

  .toolbar-title {
    white-space: normal;
    text-align: center;
    width: 100%;
    font-size: 1.1rem;
  }

  .example-spacer {
    display: none;
  }

  app-language-switcher {
    margin: 0 auto;
  }
}
```
**12** Agregar code en footer.ts:
```
import { TranslateModule } from "@ngx-translate/core";
import {MatIcon} from '@angular/material/icon';
```
```
@Component({
  selector: 'app-footer-content',
  imports: [TranslateModule, MatIcon],
  templateUrl: './footer-content.component.html',
  styleUrl: './footer-content.component.css'
})
```
**13** Agregar code en footer.html:
```
<div class="footer-content">
  <p>Copyright &copy; 2025 {{ 'footer.rights' | translate }}</p>
  {{ 'footer.intro' | translate }}
  <mat-icon color="warn" class="heart-icon">favorite</mat-icon>
  {{ 'footer.author' | translate }}
</div>
```
**14** Agregar code en footer.css:
```
.footer-content {
  width: 100%;
  box-sizing: border-box;
  background-color: #101414;
  color: #e0e3e2;
  text-align: center;
  margin: 0;
  padding: 2rem;
}
```
**15** Agregar code en app.config.ts:
```
import { HttpClient, provideHttpClient } from "@angular/common/http";
import { provideTranslateService, TranslateLoader } from "@ngx-translate/core";
import { TranslateHttpLoader } from "@ngx-translate/http-loader";
```
debajo de app.routes:
```
const httpLoaderFactory: (http: HttpClient) =>
  TranslateLoader = (http: HttpClient) =>
  new TranslateHttpLoader(http, './assets/i18n/', '.json');
```
luego reemplazar:
```
export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(),
    provideTranslateService({
      loader: {
        provide: TranslateLoader,
        useFactory: httpLoaderFactory,
        deps: [HttpClient]
      },
      defaultLanguage: 'en',
    })
  ]
};
```
**16** Agregar code en wanted.response:
Revisar el json
```
export interface WantedResponse {
  items: WantedResource[];
}
export interface WantedResource {
  images: { original: string }[];
  title: string;
  publication: string;
  description: string;
  status: string;
  sex: string;
  warning_message: string;
  details: string;
  url: string;
  poster_classification: string;
}
```
revisar segun el json completo
```
export interface UserResponse {
  items: UserResource[];
}
export interface UserResource {
  id: number;
  name: string;
  username: string;
  email: string;
  address: {
    street: string;
    suite: string;
    city: string;
    zipcode: string;
    geo: {
      lat: string;
      lng: string;
    }
  },
  phone: string;
  website: string;
  company: {
    name: string;
    catchPhrase: string;
    bs: string;
  }
}
```
**16** Agregar code en wanted.assembler:
```
import {WantedResource, WantedResponse} from './wanted.response';
import {Wanted} from '../model/wanted.entity';

export class WantedAssembler {

  static toEntityFromResource(resource:WantedResource):Wanted {
    return{
      ...resource
    }
  }

  static toEntitiesFromResponse(response:WantedResponse): Wanted[] {
    return response.items.map(wanted=>
      this.toEntityFromResource(wanted));
  }
}
```
**17** Agregar code en wanted.entity:
```
export class Wanted {
  constructor(
    public images: { original: string }[],
    public title: string,
    public publication: string,
    public description: string,
    public status: string,
    public sex: string,
    public warning_message: string,
    public details: string,
    public url: string,
    public poster_classification: string,
  ) { }
}
```
```
export class Address {
  constructor(
    public street: string,
    public suite: string,
    public city: string,
    public zipcode: string,
    public geo: {
      lat: string;
      lng: string;
    }
  ) {
  }
}

import { Address } from './address.entity';

export class User {
  constructor(
    public id: number,
    public name: string,
    public username: string,
    public email: string,
    public address: Address,
    public phone: string,
    public website: string,
    public company: {
      name: string;
      catchPhrase: string;
      bs: string;
    },
  ) { }
}
```
**18** Agregar code en wanteds-api.service:
```
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map} from 'rxjs';
import {Wanted} from '../model/wanted.entity';
import {WantedResponse} from './wanted.response';
import {WantedAssembler} from './wanted.assembler';
import {environment} from '../../../environments/environment';
```
```
@Injectable({
  providedIn: 'root'
})
export class WantedsApiService {
  private baseUrl=environment.wantedFbiApiBaseUrl;
  private wantedsEndpoint=environment.wantedFbiApiEndPoint;
  constructor(private http: HttpClient) { }
  getWanteds(): Observable<Wanted[]> {
    return this.http.get<WantedResponse>(`${this.baseUrl}${this.wantedsEndpoint}`)
      .pipe(
        map(response => WantedAssembler.toEntitiesFromResponse(response)));
  }
}
```
**19** Agregar code en wanted-item.ts:
```
import { Component } from '@angular/core';
import {Input} from '@angular/core';
import { Wanted } from '../../model/wanted.entity';
import {MatCardImage, MatCardModule} from '@angular/material/card';
import {TranslatePipe} from '@ngx-translate/core';
import {MatIcon} from '@angular/material/icon';
import {NgIf} from '@angular/common';
import {MatAnchor} from '@angular/material/button';

@Component({
  selector: 'app-wanted-item',
  imports: [MatCardModule, MatIcon, TranslatePipe, NgIf, MatCardImage, MatAnchor],
  templateUrl: './wanted-item.component.html',
  styleUrl: './wanted-item.component.css'
})
export class WantedItemComponent {
  @Input() wanted!: Wanted;
}
```
**19** Agregar code en wanted-item.html:
aqui se pone lo que va a decir cada card
```
<mat-card class="wanted-card">
  <img mat-card-image [src]="wanted.images?.[0]?.original" alt="{{ wanted.title }}"/>

  <mat-card-header>
    <mat-card-title>{{ wanted.title }}</mat-card-title>
    <mat-card-subtitle>{{ wanted.publication }}</mat-card-subtitle>
  </mat-card-header>

  <mat-card-content>
    <section class="info-section">
      <div class="info-block">
        <mat-icon class="info-icon">description</mat-icon>
        <strong>{{ 'Description' | translate }}:</strong> {{ wanted.description }}
      </div>

      <div class="info-block">
        <mat-icon class="info-icon">check_circle</mat-icon>
        <strong>{{ 'Status' | translate }}:</strong> {{ wanted.status }}
      </div>

      <div class="info-block">
        <mat-icon class="info-icon">wc</mat-icon>
        <strong>{{ 'Sex' | translate }}:</strong> {{ wanted.sex }}
      </div>

      <div class="info-block" *ngIf="wanted.warning_message">
        <mat-icon class="info-icon">warning</mat-icon>
        <strong>{{ 'Warning message' | translate }}:</strong> {{ wanted.warning_message }}
      </div>

      <div class="info-block" *ngIf="wanted.details">
        <mat-icon class="info-icon">info</mat-icon>
        <strong>{{ 'Details' | translate }}:</strong> {{ wanted.details }}
      </div>
    </section>
  </mat-card-content>

  <mat-card-footer class="card-footer">
    <div class="footer-left">
      <a [href]="wanted.url" target="_blank" mat-button color="primary">
        <mat-icon>open_in_new</mat-icon>
        View Details
      </a>
    </div>
    <div class="footer-right">
      <strong>Classification:</strong> {{ wanted.poster_classification }}
    </div>
  </mat-card-footer>
</mat-card>
```
```
<mat-card class="user-card">
  <mat-card-header>
    <mat-card-title>{{ user.id }} - {{ user.name }}</mat-card-title>
  </mat-card-header>

  <mat-card-content>
    <section class="info-section">
      <div class="info-block">
        <mat-icon class="info-icon">person</mat-icon>
        <strong>{{ 'user-info.username' | translate }}:</strong>{{ user.username }}
      </div>

      <div class="info-block">
        <mat-icon class="info-icon">email</mat-icon>
        <strong>{{ 'user-info.email' | translate }}:</strong>{{ user.email }}
      </div>

      <div class="info-block">
        <mat-icon class="info-icon">phone</mat-icon>
        <strong>{{ 'user-info.phone' | translate }}:</strong>{{ user.phone }}
      </div>

      <div class="info-block">
        <mat-icon class="info-icon">language</mat-icon>
        <strong>{{ 'user-info.website' | translate }}:</strong>
        <a href="https://{{ user.website }}" target="_blank">{{ user.website }}</a>
      </div>

      <div class="info-block">
        <mat-icon class="info-icon">business</mat-icon>
        <strong>{{ 'user-info.company' | translate }}:</strong>
        <span>{{ user.company.name }}</span>
        <small>"{{ user.company.catchPhrase }}"</small>
      </div>

      <div class="info-block">
        <mat-icon class="info-icon">home</mat-icon>
        <strong>{{ 'user-info.address' | translate }}:</strong>
        <ul class="address-list">
          <li>{{ user.address.street }}, {{ user.address.suite }}</li>
          <li>{{ user.address.city }} ({{ user.address.zipcode }})</li>
          <li>
            {{ 'user-info.coordinates' | translate }}:
            {{ user.address.geo.lat }}, {{ user.address.geo.lng }}
          </li>
        </ul>
      </div>
    </section>
  </mat-card-content>
</mat-card>
```
**20** Agregar code en wanteds-item.css:
```
.wanted-card {
  padding: 10px;
  background-color: #263238;
  color: white;
  border-radius: 16px;
}

.info-section {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.info-block {
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 4px;
}

.info-icon {
  color: #f06292;
}

mat-card-image {
  border-radius: 8px;
  object-fit: cover;
  max-height: 300px;
}

.card-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 12px 16px;
  border-top: 1px solid rgba(255, 255, 255, 0.1);
  font-size: 0.9rem;
}

.footer-left a {
  display: flex;
  align-items: center;
  gap: 6px;
  text-decoration: none;
  color: #90caf9;
}

.footer-right {
  text-align: right;
}
```
**21** Agregar code en wanted-list.ts:
```
import { Component } from '@angular/core';
import {Input} from '@angular/core';
import {Wanted} from '../../model/wanted.entity';
import {WantedsApiService} from '../../services/wanteds-api.service';
import {WantedItemComponent} from '../wanted-item/wanted-item.component';

@Component({
  selector: 'app-wanted-list',
  imports: [WantedItemComponent],
  templateUrl: './wanted-list.component.html',
  styleUrl: './wanted-list.component.css'
})
export class WantedListComponent {
  wanteds: Array<Wanted> = [];
  constructor(private wantedsApiService: WantedsApiService) { }
  ngOnInit(): void {
    this.wantedsApiService.getWanteds().subscribe(
      wanteds => this.wanteds = wanteds);
  }
}
```
**22** Agregar code en wanted-list.html:
```
<div class="wanted-list-container">
  @for (wanted of wanteds; track wanted.url) {
    <app-wanted-item [wanted]="wanted"/>
  }
</div>
```
**23** Agregar code en wanted-list.css:
```
.wanted-list-container{
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(400px, 1fr));
  gap: 11px;
}

@media (max-width: 600px) {
  .wanted-list-container {
    grid-template-columns: 1fr;
  }
}
```
**24** Agregar code en app.component.ts:
```
import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import {HeaderContentComponent} from './public/components/header-content/header-content.component';
import {FooterContentComponent} from './public/components/footer-content/footer-content.component';
import {WantedListComponent} from './wanteds/components/wanted-list/wanted-list.component';

@Component({
  selector: 'app-root',
  imports: [ HeaderContentComponent, FooterContentComponent, WantedListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'JSON Placeholder Users API';
  constructor(private translate: TranslateService) {
    this.translate.addLangs(['en', 'es']);
    this.translate.setDefaultLang('en');
    this.translate.use('en');
  }
}
```
**25** Agregar code en app.component.html:
```
<div class="app-container">
  <app-header-content/>
  <main><app-wanted-list/></main>
  <app-footer-content/>
</div>
```
**26** Agregar code en app.component.css:
```
.app-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

main {
  flex: 1;
  padding: 1rem;
  max-width: 100%;
  box-sizing: border-box;
}
```
**27** Agregar en run:

antes de correr un comando: npm install

agregar un npm 
y que vaya al package.json
commnad run
scripts: start

