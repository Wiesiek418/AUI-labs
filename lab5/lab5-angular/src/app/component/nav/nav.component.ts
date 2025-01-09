import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';

/**
 * Represents main navigation.
 */
@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  standalone: true,
  imports: [
    RouterLink
  ],
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

}
