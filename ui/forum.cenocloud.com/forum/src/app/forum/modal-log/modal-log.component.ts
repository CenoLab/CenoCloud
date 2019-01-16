import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-modal-log',
  templateUrl: './modal-log.component.html',
  styleUrls: ['./modal-log.component.css']
})
export class ModalLogComponent implements OnInit {

  public msg : String;

  constructor() { }

  ngOnInit() {
  }

  show(msg,time):void{
    this.msg=msg;
    $(".log").removeClass("hidden");
    $(".log").addClass("fadeIn");
    setTimeout(function(){
      $(".log").removeClass("fadeIn");
      $(".log").addClass("hidden");
    }, time);
  }

}
