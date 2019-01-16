import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Cookie } from 'ng2-cookies/ng2-cookies';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	title = 'app';

	ngOnInit() {

	}

	constructor(private router:Router) { }

	show_menu(): void {
		var x = $("#forum").attr("class");
		if (x == "") {
			$("#forum").addClass("mobile-translate");
			$(".moblie-menu").addClass("moblie-menu-togger");
		}
		else {
			$("#forum").removeClass("mobile-translate");
			$(".moblie-menu").removeClass("moblie-menu-togger");
		}
	}

	scroll($event):void{
		if($("#forum").scrollTop()>350){
			$(".moblie-menu").addClass("dark");
		}
		else{
			$(".moblie-menu").removeClass("dark");
		}
		//Cookie.set("lzw",$("#forum").scrollTop().toString(),null,"/");
	}

	skipto(addr):void{
		this.router.navigate([addr]);
		this.show_menu();
	}
}
