**1** el siguiente command:

```
sudo ng new ea4328u202317584 
```
CSS y no

**2** Entrar al intel idea
y abrir terminal del proyecto:

```
sudo ng add @angular/material
```
Y
azure blue
Y
```
npm install @ngx-translate/core @ngx-translate/http-loader --save
```
```
npm install -g json-server@0.17.4
```
**3** Generar la parte del server:
db.json y routes.json
```
{
  "thresholds": [
    {
      "id": "1",
      "fuelTankType": "Type A",
      "minAverage": 10,
      "maxAverage": 15
    },
    {
      "id": "2",
      "fuelTankType": "Type B",
      "minAverage": 8,
      "maxAverage": 12
    },
    {
      "id": "3",
      "fuelTankType": "Type C",
      "minAverage": 6,
      "maxAverage": 10
    },
    {
      "id": "4",
      "fuelTankType": "Type D",
      "minAverage": 5,
      "maxAverage": 8
    }
  ],
  "efficiency-records": [
    {
      "id": "1",
      "busId": 101,
      "fuelTankType": "Type A",
      "averageKmPerGallon": 12,
      "calculatedAt": "2025-05-22T08:00:00Z"
    },
    {
      "id": "2",
      "busId": 102,
      "fuelTankType": "Type B",
      "averageKmPerGallon": 7,
      "calculatedAt": "2025-05-22T09:00:00Z"
    },
    {
      "id": "3",
      "busId": 103,
      "fuelTankType": "Type C",
      "averageKmPerGallon": 11,
      "calculatedAt": "2025-05-22T10:00:00Z"
    },
    {
      "id": "4",
      "busId": 104,
      "fuelTankType": "Type D",
      "averageKmPerGallon": 6,
      "calculatedAt": "2025-05-22T11:00:00Z"
    },
    {
      "busId": 1,
      "fuelTankType": "Type A",
      "averageKmPerGallon": 20,
      "calculatedAt": "2025-05-22T17:34:49.876Z",
      "id": "lD-6hZZ"
    }
  ],
  "issues": [
    {
      "id": "1",
      "busId": 102,
      "issueType": "Fuel Efficiency",
      "registeredAt": "2025-05-22T09:00:00Z"
    },
    {
      "id": "2",
      "busId": 103,
      "issueType": "Fuel Efficiency",
      "registeredAt": "2025-05-22T10:00:00Z"
    },
    {
      "id": "3",
      "busId": 105,
      "issueType": "Fuel Efficiency",
      "registeredAt": "2025-05-22T12:00:00Z"
    },
    {
      "id": "4",
      "busId": 106,
      "issueType": "Fuel Efficiency",
      "registeredAt": "2025-05-22T13:00:00Z"
    },
    {
      "busId": 1,
      "issueType": "Fuel Tank Issue",
      "registeredAt": "2025-05-22T17:34:49.909Z",
      "id": "Q2HqUXK"
    }
  ]
}
```
```
{
  "/api/v1/*": "/$1"
}
```
**3** Generar la parte de idiomas:

agregar en public/assets/i18n

los paquetes en.json y es.json

en.json
```
{
  "home": {
    "home": "Home",
    "welcome": "Welcome a Whova",
    "efficiency": "Efficiency Analytics"
  },
  "toolbar": {
    "home": "Home",
    "fuel": "Fuel Wfficiency"
  },
  "footer": {
    "copyright": "Copyright © 2025.",
    "designer": "Designer Mathias Aspajo u202317584"
  },
  "fuel": {
    "title1": "Fuel Efficiency Records",
    "title2": "Add a Fuel Efficiency Record"
  }

}
```

es.json
```
{
  "home": {
    "home": "Inicio",
    "welcome": "Bienvenido a Whova",
    "efficiency": "Eficiencia Analytics"

  },
  "toolbar": {
    "home": "Inicio",
    "fuel": "Fuel Efficiency"
  },
  "footer": {
    "copyright": "Copyright © 2025.",
    "designer": "Diseñador Mathias Aspajo u202317584"
  },
  "fuel": {
    "title1": "Registros de eficiencia de combustible",
    "title2": "Agregar un registro de eficiencia de combustible"
  }
}
```

**4** Generar carpeta firstudent=nombre y public de la app en src/app:

crear carpetas:
components {carpeta fuel-tank-type-efficiency, luego crear lo mismo que termina en .component .css, .html, .ts y .spec.ts}
models {carpeta efficiency-record.entity luego mismo nombre en .ts y .spec.ts}
service {efficiency-record.service.ts}

**5** fuel-tank-type-efficiency:
.css
```
mat-card {
  margin: 16px;
  max-width: 400px;
  background-color: #A9A9A9;
}

mat-card-content {
  padding: 16px;
}

.footer-content {
  padding: 16px;
  background-color: #5A5A5A;
}

p {
  margin: 8px 0;
}
```
```
<mat-card appearance="outlined">
  <mat-card-header>
    <mat-card-title>{{ fuelTankType }}</mat-card-title>
  </mat-card-header>

  <mat-card-content>
    <p><strong>Buses Count:</strong> {{ busesCount }}</p>
    <p><strong>Average Km Per Gallon:</strong> {{ averageKmPerGallon }}</p>
  </mat-card-content>

  <mat-card-footer>
    <div class="footer-content">
      <p><strong>Reported Issues:</strong> {{ reportedIssues }}</p>
      <p><strong>Last Report:</strong> {{ lastReport }}</p>
    </div>
  </mat-card-footer>
</mat-card>
```
```
import { Component, Input, OnInit } from '@angular/core';
import { EfficiencyRecordEntity } from '../../models/efficiency-record.entity/efficiency-record.entity';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-fuel-tank-type-efficiency',
  templateUrl: './fuel-tank-type-efficiency.component.html',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule
  ],
  styleUrls: ['./fuel-tank-type-efficiency.component.css']
})
export class FuelTankTypeEfficiencyComponent implements OnInit {
  @Input() fuelTankType!: string;
  @Input() efficiencyRecords: EfficiencyRecordEntity[] = [];
  @Input() issues: any[] = [];

  busesCount: number = 0;
  averageKmPerGallon: string = '0.00';
  reportedIssues: number = 0;
  lastReport: string = 'No issues';

  ngOnInit(): void {
    this.calculateIndicators();
  }

  private calculateIndicators(): void {
    const records = this.efficiencyRecords.filter(record => record.fuelTankType === this.fuelTankType);
    this.busesCount = records.length;

    const totalKmPerGallon = records.reduce((sum, record) => sum + record.averageKmPerGallon, 0);
    this.averageKmPerGallon = (records.length > 0 ? (totalKmPerGallon / records.length).toFixed(2) : '0.00');

    const relatedIssues = this.issues.filter(issue => {
      const record = records.find(r => r.busId === issue.busId);
      return !!record;
    });
    this.reportedIssues = relatedIssues.length;

    if (relatedIssues.length > 0) {
      const lastIssue = relatedIssues.reduce((latest, issue) =>
        new Date(issue.registeredAt) > new Date(latest.registeredAt) ? issue : latest
      );
      this.lastReport = new Date(lastIssue.registeredAt).toLocaleString();
    }
```
**6** efficiency-record.entity:
```
export class EfficiencyRecordEntity {
  id: number;
  busId: number;
  fuelTankType: string;
  averageKmPerGallon: number;
  calculatedAt: string;

  constructor(
    record: {
      id: number;
      busId: number;
      fuelTankType: string;
      averageKmPerGallon: number;
      calculatedAt: string;
    }
  ) {
    this.id = record.id;
    this.busId = record.busId;
    this.fuelTankType = record.fuelTankType;
    this.averageKmPerGallon = record.averageKmPerGallon;
    this.calculatedAt = record.calculatedAt;
  }
}
```
**7** efficiency-record.service.ts:

```
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { EfficiencyRecordEntity } from '../models/efficiency-record.entity/efficiency-record.entity';

interface Threshold {
  id: number;
  fuelTankType: string;
  minAverage: number;
  maxAverage: number;
}

interface Issue {
  id?: number;
  busId: number;
  issueType: string;
  registeredAt: string;
}

@Injectable({
  providedIn: 'root'
})
export class EfficiencyRecordService {
  private apiUrl = 'http://localhost:3000';

  constructor(private http: HttpClient) {}

  getEfficiencyRecords(): Observable<EfficiencyRecordEntity[]> {
    return this.http.get<EfficiencyRecordEntity[]>(`${this.apiUrl}/efficiency-records`);
  }


  getThresholds(): Observable<Threshold[]> {
    return this.http.get<Threshold[]>(`${this.apiUrl}/thresholds`);
  }


  addEfficiencyRecord(record: Omit<EfficiencyRecordEntity, 'id'>): Observable<EfficiencyRecordEntity> {
    return this.http.post<EfficiencyRecordEntity>(`${this.apiUrl}/efficiency-records`, record);
  }


  addIssue(issue: Omit<Issue, 'id'>): Observable<Issue> {
    return this.http.post<Issue>(`${this.apiUrl}/issues`, {
      ...issue,
      issueType: 'Fuel Tank Issue'
    });
  }


  checkExistingIssueForToday(busId: number): Observable<boolean> {
    return this.http.get<Issue[]>(`${this.apiUrl}/issues`).pipe(
      map(issues => {
        const today = new Date().toISOString().split('T')[0];
        return issues.some(issue =>
          issue.busId === busId &&
          new Date(issue.registeredAt).toISOString().startsWith(today)
        );
      })
    );
  }
  getIssues(): Observable<Issue[]> {
    return this.http.get<Issue[]>(`${this.apiUrl}/issues`);
  }
}
```
**8** en public:
crear carpetas:
components {carpetas footer-component: mismo nombre .component .css, .html y .ts
language-switcher: mismo nombre .component .css, .html y .ts}
pages {carpetas fuel-efficiency: mismo nombre .component .css, .html y .ts
home: mismo nombre .component .css, .html y .ts
page-not-found: mismo nombre .component .css, .html y .ts
}
**9** footer-component:
.css
```
.footer-content {
  background: #23272a;
  color: #b0b3b8;
  border-top: 1px solid #222;
  text-align: center;
  font-family: 'Roboto', 'Segoe UI', Arial, sans-serif;
  padding: 16px 0 8px 0;
  font-size: 1em;
}
```
.html
```
<div class="footer-content">
  <p>{{ 'footer.copyright' | translate }}</p>
  <p>{{ 'footer.designer' | translate }}</p>
</div>
```
.ts
```
import { Component } from '@angular/core';
import {TranslatePipe} from '@ngx-translate/core';

@Component({
  selector: 'app-footer-component',
  imports: [
    TranslatePipe
  ],
  templateUrl: './footer-component.component.html',
  styleUrl: './footer-component.component.css'
})
export class FooterComponentComponent {

}
```
**10** language-switcher:
.css
```
mat-button-toggle-group {
  background: #23272a;
  box-shadow: 0 1px 4px rgba(0,0,0,0.18);
  border-radius: 6px;
}

mat-button-toggle {
  color: #b0b3b8;
  font-family: 'Roboto', 'Segoe UI', Arial, sans-serif;
}

mat-button-toggle.mat-button-toggle-checked {
  background: #1976d2 !important;
  color: #fff !important;
}

mat-button-toggle:hover:not(.mat-button-toggle-checked) {
  background: #181a1b !important;
  color: #90caf9 !important;
}
```
.html
```
<mat-button-toggle-group [value]="currentLang"
                         appearance="standard"
                         aria-label="Preferred language"
                         name="language">
  @for (language of languages; track language) {
    <mat-button-toggle [value]="language"
                       [aria-label]="language"
                       (click)="useLanguage(language)">
      {{ language.toUpperCase() }}
    </mat-button-toggle>
  }
</mat-button-toggle-group>
```
.ts
```
import { Component } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import {MatButtonToggle, MatButtonToggleGroup} from '@angular/material/button-toggle';

@Component({
  selector: 'app-language-switcher',
  imports: [
    MatButtonToggleGroup,
    MatButtonToggle,
  ],
  templateUrl: './language-switcher.component.html',
  styleUrl: './language-switcher.component.css'
})
export class LanguageSwitcherComponent {
  protected currentLang: string = 'en';
  protected languages: string[] = [ 'en', 'es' ]

  constructor(private translate: TranslateService) {
    this.currentLang = translate.currentLang;
  }

  useLanguage(language: string): void {
    this.translate.use(language);
    this.currentLang = language;
  }
}
```
**11** fuel-efficiency:
.css
```

.container {
  padding: 20px;
  max-width: 600px;
  margin: 0 auto;
}

.form-container {
  display: flex;
  flex-direction: column;
  gap: 16px;
  margin-top: 20px;
}

mat-form-field {
  width: 100%;
}

button {
  align-self: flex-start;
}

.message {
  margin-top: 16px;
  padding: 12px;
  border-radius: 4px;
}

.error-message {
  background-color: #ffebee;
  color: #c62828;
}

.success-message {
  background-color: #e8f5e9;
  color: #2e7d32;
}
```
.html
```
<div class="container">
  <div class="header">
    <h1>{{ 'fuel.title1' | translate }}</h1>
  </div>

  <h2>{{'fuel.title2' |translate}}</h2>

  <form [formGroup]="recordForm" (ngSubmit)="onSubmit()" class="form-container">
    <mat-form-field appearance="outline">
      <mat-label>Bus Identifier</mat-label>
      <input matInput type="number" formControlName="busId">
    </mat-form-field>

    <mat-form-field appearance="outline">
      <mat-label>Fuel Tank Type</mat-label>
      <mat-select formControlName="fuelTankType">
        <mat-option *ngFor="let type of fuelTankTypes" [value]="type">
          {{type}}
        </mat-option>
      </mat-select>
    </mat-form-field>

    <mat-form-field appearance="outline">
      <mat-label>Average Km per Gallon</mat-label>
      <input matInput type="number" formControlName="averageKmPerGallon">
    </mat-form-field>

    <button mat-raised-button color="primary" type="submit">
      Add Record
    </button>
  </form>

  <div *ngIf="message" [class.error-message]="isError" [class.success-message]="!isError" class="message">
    {{ message }}
  </div>
</div>
```
.ts
```
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { EfficiencyRecordService } from '../../../firststudent/service/efficiency-record.service';
import {TranslatePipe} from '@ngx-translate/core';
import { MatOptionModule } from '@angular/material/core';

@Component({
  selector: 'app-fuel-efficiency',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatOptionModule,
    TranslatePipe
  ],
  templateUrl: './fuel-efficiency.component.html',
  styleUrls: ['./fuel-efficiency.component.css']
})
export class FuelEfficiencyComponent {
  recordForm: FormGroup;
  fuelTankTypes = ['Type A', 'Type B', 'Type C', 'Type D'];
  message = '';
  isError = false;

  constructor(
    private fb: FormBuilder,
    private efficiencyService: EfficiencyRecordService
  ) {
    this.recordForm = this.fb.group({
      busId: ['', [Validators.required, Validators.min(1)]],
      fuelTankType: ['', Validators.required],
      averageKmPerGallon: ['', [Validators.required, Validators.min(0)]]
    });
  }

  onSubmit() {
    if (this.recordForm.valid) {
      const formValue = this.recordForm.value;

      // Verificar el tipo de tanque y sus límites
      this.efficiencyService.getThresholds().subscribe({
        next: (thresholds) => {
          const threshold = thresholds.find(t => t.fuelTankType === formValue.fuelTankType);

          if (!threshold) {
            this.showMessage('Invalid Fuel Tank Type', true);
            return;
          }

          const record = {
            ...formValue,
            calculatedAt: new Date().toISOString()
          };

          // Verificar si está fuera de los límites
          if (formValue.averageKmPerGallon < threshold.minAverage ||
            formValue.averageKmPerGallon > threshold.maxAverage) {

            // Verificar si ya existe un issue para este bus hoy
            this.efficiencyService.checkExistingIssueForToday(formValue.busId).subscribe({
              next: (exists) => {
                if (!exists) {
                  const issue = {
                    busId: formValue.busId,
                    issueType: "Fuel Tank Issue",
                    registeredAt: new Date().toISOString()
                  };
                  this.efficiencyService.addIssue(issue).subscribe();
                }
              }
            });
          }

          // Guardar el registro
          this.efficiencyService.addEfficiencyRecord(record).subscribe({
            next: () => {
              this.showMessage('Record successfully created', false);
              this.recordForm.reset();
            },
            error: () => this.showMessage('Error creating record', true)
          });
        },
        error: () => this.showMessage('Error validating fuel tank type', true)
      });
    }
  }

  private showMessage(text: string, isError: boolean) {
    this.message = text;
    this.isError = isError;
    setTimeout(() => {
      this.message = '';
    }, 3000);
  }
}
```
**12** home:
.css
```
.container {
  padding: 20px;
}

.content {
  max-width: 1200px;
  margin: 0 auto;
}

h1, h2 {
  color: #333;
  margin-bottom: 20px;
}


.content {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 20px;
  padding: 20px;
}


.header {
  grid-column: 1 / -1;
}

h1, h2, p {
  grid-column: 1 / -1;
}
.loading-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 200px;
}
```
.html
```
<div class="container">
  <div class="header">
    <h1>{{ 'home.home' | translate }}</h1>
    <p>{{ 'home.welcome' | translate}}</p>
    <h2>{{ 'home.efficiency' |translate}}</h2>
  </div>

  <div *ngIf="isLoading" class="loading-container">
    <mat-spinner diameter="40"></mat-spinner>
  </div>

  <div class="content" *ngIf="!isLoading">
    <app-fuel-tank-type-efficiency
      *ngFor="let fuelTankType of fuelTankTypes"
      [fuelTankType]="fuelTankType"
      [efficiencyRecords]="efficiencyRecords"
      [issues]="issues">
    </app-fuel-tank-type-efficiency>
  </div>
</div>
```
.ts
```
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { FuelTankTypeEfficiencyComponent } from '../../../firststudent/components/fuel-tank-type-efficiency/fuel-tank-type-efficiency.component';
import { EfficiencyRecordService } from '../../../firststudent/service/efficiency-record.service';
import { TranslatePipe } from '@ngx-translate/core';
import { forkJoin } from 'rxjs';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import {EfficiencyRecordEntity} from '../../../firststudent/models/efficiency-record.entity/efficiency-record.entity';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule,
    FuelTankTypeEfficiencyComponent,
    TranslatePipe,
    MatProgressSpinnerModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
   fuelTankTypes: string[] = ['Type A', 'Type B', 'Type C', 'Type D'];
    efficiencyRecords: EfficiencyRecordEntity[] = [];
     issues: any[] = [];
     isLoading = true;

  constructor(private efficiencyRecordService: EfficiencyRecordService) {}

  ngOnInit(): void {
    this.loadData();
  }
private loadData(): void {
  forkJoin({
    records: this.efficiencyRecordService.getEfficiencyRecords(),
    issues: this.efficiencyRecordService.getIssues()
  }).subscribe({
    next: (data) => {
      if (data.records && Array.isArray(data.records)) {
        this.efficiencyRecords = data.records.map(record => new EfficiencyRecordEntity(record));
      } else {
        console.error('Invalid data format for efficiency records:', data.records);
        this.efficiencyRecords = [];
      }

      if (data.issues && Array.isArray(data.issues)) {
        this.issues = data.issues;
      } else {
        console.error('Invalid data format for issues:', data.issues);
        this.issues = [];
      }

      this.isLoading = false;
    },
    error: (error) => {
      console.error('Error loading data:', error);
      this.isLoading = false;
    }
  });
}
```
**13** page-not-found:
.css
```
:host {
  background: #181a1b;
  color: #f5f5f5;
  font-family: 'Roboto', 'Segoe UI', Arial, sans-serif;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

h1 {
  color: #90caf9;
}

button[mat-button] {
  background: #23272a;
  color: #90caf9;
  border: 1px solid #1976d2;
  border-radius: 4px;
  transition: background 0.2s;
}

button[mat-button]:hover {
  background: #1976d2;
  color: #fff;
}
```
.html
```
<h1>Page not found</h1>
<p>The path <b>{{ invalidPath }}</b> is not valid.</p>


<button mat-button (click)="onNavigateHome()">Home</button>
```
3 ama y 1 rojo
.ts
```
import {Component, inject, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MatButton} from '@angular/material/button';

@Component({
  selector: 'app-page-not-found',
  imports: [
    MatButton
  ],
  templateUrl: './page-not-found.component.html',
  styleUrl: './page-not-found.component.css'
})
export class PageNotFoundComponent {
  /*logian para regrear a home*/
  protected invalidPath: string = '';
  private route: ActivatedRoute = inject(ActivatedRoute);
  private router: Router = inject(Router);

  ngOnInit(): void {
    this.invalidPath = this.route.snapshot.url.map(urlSegment => urlSegment.path).join('/');
  }

  protected onNavigateHome(): void {
    this.router.navigate(['home']).then();
  }
}
```
**14** app.component.css:
```
:host {
  background: #181a1b;
  color: #f5f5f5;
  font-family: 'Roboto', 'Segoe UI', Arial, sans-serif;
  min-height: 100vh;
  display: block;
}

a[mat-button] {
  color: #90caf9;
  transition: background 0.2s, color 0.2s;
}

a[mat-button]:hover {
  background: #23272a;
  color: #fff;
}

mat-toolbar {
  background: #23272a !important;
  color: #f5f5f5 !important;
}

.mat-spacer {
  flex: 1 1 auto;
}

.logo-container {
  display: flex;
  align-items: center;
  gap: 16px;
}

.logo {
  height: 40px;
  width: auto;
}

.mat-spacer {
  flex: 1 1 auto;
}
```
2 amarillos
**15** app.component.html:
```
<mat-toolbar color="primary">

  <mat-toolbar-row>

    <div class="logo-container">
      <img src="https://logo.clearbit.com/firststudentinc.com" alt="FIRSTstudent Logo" class="logo">
      <span style="font-weight:bold; font-size:1.3em;">HALO Maintenance</span>
    </div>

    <span class="mat-spacer"></span>


    <a mat-button [routerLink]="'/home'">{{ 'toolbar.home' | translate }}</a>

    <a mat-button [routerLink]="'/fuelefficiency'">fuel efficiency</a>

    <app-language-switcher></app-language-switcher>

  </mat-toolbar-row>

</mat-toolbar>

<router-outlet></router-outlet>

<app-footer-component></app-footer-component>
```
2 rojos 1 amarillo
**16** app.component.ts:
```
import { Component } from '@angular/core';
import {RouterLink, RouterLinkActive, RouterOutlet} from '@angular/router';
import {TranslatePipe, TranslateService} from '@ngx-translate/core';
import {FooterComponentComponent} from './public/components/footer-component/footer-component.component';
import {LanguageSwitcherComponent} from './public/components/language-switcher/language-switcher.component';
import {MatToolbar, MatToolbarRow} from '@angular/material/toolbar';
import {MatAnchor} from '@angular/material/button';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MatToolbar,
    MatToolbarRow, MatAnchor, RouterLink, RouterLinkActive, TranslatePipe,
    LanguageSwitcherComponent, FooterComponentComponent, TranslatePipe],

  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ea4328u202317584';
  options = [
    { link: '/home', label: 'home'},
    //store/ se puede quitar

    { link: '/fuelefficiency', label: 'fuelefficiency'},
  ]

  constructor(private translate: TranslateService) {
    this.translate.setDefaultLang('en');
    this.translate.use('en');
  }
}
```
**17** app.config.ts:
```
import {ApplicationConfig, importProvidersFrom, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import {HttpClient, provideHttpClient} from '@angular/common/http';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';

export const HttpLoaderFactory = (http: HttpClient) =>
  new TranslateHttpLoader(http);
// toda cambiar

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(),
    importProvidersFrom(TranslateModule.forRoot({
      loader: { provide: TranslateLoader, useFactory: HttpLoaderFactory, deps: [HttpClient]}
    }))
  ]

};
```
**18** app.routes.ts:
```
import { Routes } from '@angular/router';
import  {HomeComponent} from './public/pages/home/home.component';

const fuelefficiencyComponent =
  ()=> import('./public/pages/fuel-efficiency/fuel-efficiency.component')
    .then(m => m.FuelEfficiencyComponent);

const PageNotFoundComponent =
  () => import('./public/pages/page-not-found/page-not-found.component')
    .then(m => m.PageNotFoundComponent);

export const routes: Routes = [
  { path: 'home',     component:      HomeComponent },

  //{ path: 'bundles',  loadComponent:  BundlesComponent },
  { path: 'fuelefficiency',  loadComponent:  fuelefficiencyComponent },
  { path: '',       redirectTo:     'home', pathMatch: 'full' },
  { path: '**',     loadComponent: PageNotFoundComponent }

];
```
revisar y agregar los componentes q faltan en las carpetas antes de iniciar

```
json-server --watch server/db.json --routes server/routes.json
```










