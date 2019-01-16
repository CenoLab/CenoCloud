import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { ForumService } from './forum.service';
import { Cookie } from 'ng2-cookies/ng2-cookies'
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService {

  constructor(private router: Router,private forumService:ForumService,private apiService:ApiService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let url: string = state.url;
    return this.checkLogin(url);
  }
  checkLogin(url: string): boolean {
    //已登录
		var uid = this.apiService.getCookie("uid");
    var token = this.apiService.getCookie("token");
    console.log(uid);
    if((uid!="0"||token!="0")&&(uid!=null||token!=null)){
        return true;
    }
    //未登录
    else {
			window.open("https://www.cenocloud.com/login.html");
    }
    return false;
  }
}
