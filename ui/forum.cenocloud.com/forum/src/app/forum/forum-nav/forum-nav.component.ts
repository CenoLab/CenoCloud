import { Component, OnInit } from '@angular/core';
import { ForumService } from '../../service/forum.service';

@Component({
	selector: 'app-forum-nav',
	templateUrl: './forum-nav.component.html',
	styleUrls: ['./forum-nav.component.css']
})
export class ForumNavComponent implements OnInit {

	public email="";

	constructor(private forumService:ForumService) { }

	ngOnInit() {
		this.forumService.login().then(res=>{
			if(res.state==true){
				this.email=res.data.email;
			}
		})
	}


}
