import { Component, OnInit, ViewChild } from '@angular/core';
import { ForumService } from '../../service/forum.service';
import { Router } from '@angular/router';
import { Cookie } from 'ng2-cookies/ng2-cookies'
import { ModalLogComponent } from '../modal-log/modal-log.component';
import { ForumLeftComponent } from './forum-left/forum-left.component';

@Component({
	selector: 'app-forum-index',
	templateUrl: './forum-index.component.html',
	styleUrls: ['./forum-index.component.css']
})
export class ForumIndexComponent implements OnInit {


	@ViewChild("modal1")
	modal1: ModalLogComponent

	 @ViewChild("left1")
	 left1: ForumLeftComponent
	constructor(private forumService: ForumService, private router: Router) {
	}

	modal = false;
	uid = "";
	token = "";
	ngOnDestroy() {
		$(".moblie-menu").removeClass("dark2");
	}
	ngDoCheck() {
		if (Cookie.get("lzwState") == "true") {
			this.left1.swapperSlider();
			$(".moblie-menu").addClass("dark2");
			var x = Number(Cookie.get("lzw"));
			$("#forum").scrollTop(x);
			Cookie.set("lzwState", "false", null, "/");
		}
	}
	ngOnInit() {
		Cookie.set("lzwState", "false", null, "/");
		$(".moblie-menu").addClass("dark2");

		//Cookie.set("uid","0",null,'/');
		//Cookie.set("token","0",null,'/');
		//Cookie.deleteAll()
		//Cookie.set("uid","1",null,'/');
		//Cookie.set("token","3shdI_MBA9RP1rDvArY02g",null,'/');
		//console.log(document.cookie);
		this.uid = Cookie.get('uid');
		this.token = Cookie.get('token');
		if ((this.uid != null && this.token != null) && (this.uid != "0" && this.token != "0")) {
			// this.forumService.login(this.uid, this.token).then(res1=>{
			// 	if(res1.state==true){
			this.forumService.joinForum().then(res2 => {
				if (res2.state == true) {
					Cookie.delete("authorId");
					Cookie.set("authorId", res2.data.authorId, null, '/');
					this.forumService.getauthorId();
					this.modal = false;
				} else {
					this.modal = true;
				}
			})
		} else {
			Cookie.set("uid", "0", null, '/', 'cenocloud.com');
			Cookie.set("token", "0", null, '/', 'cenocloud.com');
			//window.location.href="https://www.cenocloud.com/login.html";
		}
	}

	addName(): void {
		let name = $("#nickname").val().toString();
		if (name.length > 12) {
			this.modal1.show("你能不能短一点", 1000);
			return;
		}
		this.forumService.addName(name).then(res => {
			if (res.state == true) {
				Cookie.delete("authorId");
				Cookie.set("authorId", res.data.authorId);
				this.forumService.getauthorId();
				this.modal = false;
			}
			else {
				this.modal1.show(res.msg, 1000);
			}
		});
	}

}
