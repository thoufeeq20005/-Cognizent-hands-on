// Simulated Angular-like CountryListComponent in plain JS

class CountryListComponent {
  constructor() {
    this.filter = '';
    this.countries = ['India', 'Japan', 'Germany'];
  }

  filteredCountries() {
    return this.countries.filter(country =>
      country.toLowerCase().includes(this.filter.toLowerCase())
    );
  }

  addIndia() {
    if (!this.countries.includes('India')) this.countries.push('India');
  }
}

// --- Demo execution ---
const comp = new CountryListComponent();

console.log('All countries:', comp.filteredCountries());

comp.filter = 'ja';
console.log('Filtered by "ja":', comp.filteredCountries());

comp.filter = '';
comp.countries = comp.countries.filter(c => c !== 'India');
console.log('After removing India:', comp.countries);
comp.addIndia();
console.log('After addIndia():', comp.countries);

comp.addIndia(); // duplicate check
console.log('After duplicate addIndia():', comp.countries);
