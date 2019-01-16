import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forum-right-function',
  templateUrl: './forum-right-function.component.html',
  styleUrls: ['./forum-right-function.component.css']
})
export class ForumRightFunctionComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  skip(addr): void{
    this.router.navigate([addr]);
  }

}
