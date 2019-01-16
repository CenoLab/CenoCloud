import { Component, OnInit } from '@angular/core';
import { ForumService } from '../../../service/forum.service';
import { Router } from '@angular/router';


declare var Swiper: any;

@Component({
	selector: 'app-forum-left',
	templateUrl: './forum-left.component.html',
	styleUrls: ['./forum-left.component.css']
})
export class ForumLeftComponent implements OnInit {

	public load = false;
	public article= [];
	public page = 0;
	public article_load = 1;
	public mySwiper:any;

	constructor(private forumindex: ForumService, private _router: Router) { };

	ngOnInit() {
		this.swapperSlider();
		this.getforumindex();
	}

	getforumindex(): void {
		if (this.article_load == 3) {
			return;
		}
		this.article_load = 2;
		let num = 8;
		let page2 = this.page * num;
		this.forumindex.getForumIndexLeft(page2, num)
			.then(res => {
				if (res.state == true) {
					if (res.data.length == 8) {
						this.article =this.article.concat(res.data);
						this.load = true
						this.article_load = 1;
					}
					else {
						this.article =this.article.concat(res.data);
						this.load = true;
						this.article_load = 3
					}
				}
			});
		this.page++;
	}

	swapperSlider(): void {
		this.mySwiper = new Swiper('.swiper-container', {
			direction: 'horizontal',
			loop: true,
			autoplay: {
				delay: 3000,
				stopOnLastSlide: false,
				disableOnInteraction: false,
			},

			// 如果需要分页器
			pagination: {
				el: '.swiper-pagination',
			},

			// 如果需要前进后退按钮
			navigation: {
				nextEl: '.swiper-button-next',
				prevEl: '.swiper-button-prev',
			},

			// 如果需要滚动条
			scrollbar: {
				el: '.swiper-scrollbar',
			},
		});
	}

	To_article(article_id): void {
		$("#forum").data("lzw",$("#forum").scrollTop());
		this._router.navigate(['/forum/article', article_id]);
		$("#forum").scrollTop(0);
	}

}
