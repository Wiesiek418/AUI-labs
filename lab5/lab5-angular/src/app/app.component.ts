import { Component } from '@angular/core';
import {MainComponent} from './component/main/main.component';
import {NavComponent} from './component/nav/nav.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  standalone: true,
  imports: [NavComponent, MainComponent]
})
export class AppComponent {
  title = 'lab5-angular';
}
