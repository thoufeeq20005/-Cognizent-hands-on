import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-country-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `<h1>Countries</h1><input [(ngModel)]="filter" placeholder="Filter countries"><button (click)="addIndia()">Add India</button><ul><li *ngFor="let country of filteredCountries()">{{ country }}</li></ul>`
})
export class CountryListComponent {
  filter = '';
  countries = ['India', 'Japan', 'Germany'];
  filteredCountries() { return this.countries.filter(country => country.toLowerCase().includes(this.filter.toLowerCase())); }
  addIndia() { if (!this.countries.includes('India')) this.countries.push('India'); }
}
