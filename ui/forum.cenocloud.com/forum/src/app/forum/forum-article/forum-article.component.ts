import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ForumService } from '../../service/forum.service'
import { ModalLogComponent } from '../modal-log/modal-log.component';
declare var $: any;

@Component({
	selector: 'app-forum-article',
	templateUrl: './forum-article.component.html',
	styleUrls: ['./forum-article.component.css']
})
export class ForumArticleComponent implements OnInit {

	public article = [];
	public load = false;
	public article_id = Number(this.route.snapshot.params['id']);
	public comments = [];
	public page = 1;
	public load_com = 1;

	@ViewChild("modal")
	modal: ModalLogComponent

	constructor(private forumservice: ForumService, private route: ActivatedRoute) {
		document.body.scrollTop = document.documentElement.scrollTop = 0;
	}

	ngOnInit() {
		this.getForumArticle();
		//this.getComment();
	}

	
	ngOnDestroy(){
		document.title = "CenoCloud中文社区";
	}

	getForumArticle(): void {
		this.forumservice.getForumArticle(this.article_id)
			.then(res => {
				if (res.state = true) {
					this.article[0] = res.data;
					this.comments = res.data.comments;
					this.load = true
					if (this.comments.length != 8) {
						this.load_com = 3;
					}
					document.title = this.article[0].article.title;
				} else {
					this.modal.show(res.msg, "1500");
				}
			});
	}

	getComment(): void {
		if (this.load_com == 3) {
			return;
		}
		this.load_com = 2;
		let num = 8;
		let page2 = this.page * num;
		this.forumservice.getComment(this.article_id, page2, num)
			.then(res => {
				if (res.state == true) {
					if (res.data.length == 8) {
						this.comments = this.comments.concat(res.data);
						this.load_com = 1;
					}
					else {
						this.comments = this.comments.concat(res.data);
						this.load_com = 3;
					}
				}
				else {
					this.modal.show(res.msg, 1500);
					this.load_com = 1;
				}
			})
		this.page++;
	}

	addComment(): void {
		if ($('textarea[name=comment]').val() == "") {
			this.modal.show("评论不能为空", "1500");
			return;
		}
		let data = {
			articleId: this.article_id,
			comment: $('textarea[name=comment]').val()
		}
		this.forumservice.publishComment(data).then(res => {
			if (res.state == true) {
				$('textarea[name=comment]').val('');
				this.modal.show("提问成功", "1500");
				this.comments.unshift(res.data);
			}
			else {
				this.modal.show("请登录", "1500");
				window.open("https://www.cenocloud.com/login.html");
			}

		})
	}

	Star(id): void {
		this.modal.show("开发中...", "1500");
		// this.forumservice.Star(id).then(res => {
		// 	console.log(res);
		// }
	}

}
