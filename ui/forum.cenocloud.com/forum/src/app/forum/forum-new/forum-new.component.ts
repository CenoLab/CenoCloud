import { Component, OnInit, ViewChild } from '@angular/core';
import { ForumService } from '../../service/forum.service';
import { Router } from '@angular/router';
import { ModalLogComponent } from '../modal-log/modal-log.component';

// import { Simditor } from 'simditor';

@Component({
	selector: 'app-forum-new',
	templateUrl: './forum-new.component.html',
	styleUrls: ['./forum-new.component.css']
})
export class ForumNewComponent implements OnInit {
	
	@ViewChild("modal")
	modal1: ModalLogComponent
	constructor(private forumService: ForumService, private router: Router) {
		document.body.scrollTop = document.documentElement.scrollTop = 0;
	 }
	editorContent: any;
	article_type1 = 1;
	article_comment = 0;
	ngOnInit() {

		change_editor();
		function change_editor() {
			$("#editor").on("click", ".ql-image2", function () {
				$(".ql-editing2").removeClass("ql-hidden");
			})

			$("#editor").on("click", "button[data-mode!=image]", function () {
				$(".ql-editing2").addClass("ql-hidden");
			})

			$("#editor").on("click", ".ql-action2", function () {
				let x = $("#editor input[data-image=image]").val();
				if (x == "") {
					$(".ql-editing2").addClass("ql-hidden");
				} else {
					$(".ql-editor").append('<img src="' + x + '"></img>');
					$(".ql-editing2").addClass("ql-hidden");
				}
			})
		}


		let top = this;
		$("input[name=article_type]").each(function () {
			$(this).click(function () {
				top.article_type1 = Number($(this).val());
			});
		});

		$("input[name=article_comment]").click(function () {
			top.article_comment = Number(!top.article_comment);
		});

	}

	ngAfterViewInit() {
		$("#editor .ql-toolbar .ql-formats:last").append('<button type="button" class="ql-image2" data-mode="image">' +
			'<svg viewBox="0 0 18 18">' +
			'<rect class="ql-stroke" height="10" width="12" x="3" y="4"></rect> ' +
			'<circle class="ql-fill" cx="6" cy="7" r="1"></circle> ' +
			'<polyline class="ql-even ql-fill" points="5 12 5 11 7 9 8 10 11 7 13 9 13 12 5 12">' +
			'</polyline> </svg></button>');

		$(".ql-container").append('<div class="ql-tooltip ql-hidden ql-editing ql-editing2" data-mode="image"><a class="ql-preview" target="_blank" href="about:blank"></a><input type="text" data-formula="e=mc^2" data-link="https://quilljs.com" data-image="image" placeholder="Embed URL"><a class="ql-action ql-action2"></a><a class="ql-remove2"></a></div>')

	}

	addNew(): void {
		let type = this.article_type1;
		var data = {
			title: $("#title-input").val(),
			content: $("#editor .ql-editor").html(),
			tags: $("#tag-input").val(),
			abstractContent: $("#abs-input").val(),
			canComment: Number(this.article_comment),
			type: Number(this.article_type1),
			fromWhere: $("input[name=from_where" + type + "]").val(),
			fromUrl: $("input[name=from_url" + type + "]").val()
		}
		this.forumService.publishNew(data).then(res => {
			if (res.state == true) {
				this.modal1.show("发表成功",1000);
				setTimeout(this.router.navigate(['/forum/index']), 1000);
			}
		})
	}
}
