import { Component, OnInit, ViewChild } from '@angular/core';
import { ForumService } from '../../service/forum.service';
import { Router } from '@angular/router';
import { ModalLogComponent } from '../modal-log/modal-log.component';

@Component({
	selector: 'app-forum-question',
	templateUrl: './forum-question.component.html',
	styleUrls: ['./forum-question.component.css']
})
export class ForumQuestionComponent implements OnInit {


	
	article_type1 = 1;
	questionList=[];
	page = 0;


	@ViewChild("modal")
	modal:ModalLogComponent;
	constructor(private forumService:ForumService,private router:Router) {
		document.body.scrollTop = document.documentElement.scrollTop = 0;
	}

	ngOnInit() {

		this.init();


		// $('#example-offset-pixels').waypoint(function() { 
		//   }, { offset: 100 }); 

		let top = this;
		$("input[name=article_type]").each(function () {
			$(this).click(function () {
				top.article_type1 = Number($(this).val());
			});
		});
		change_editor();
		function change_editor(){
			$("#editor").on("click", ".ql-image2", function () {
				$(".ql-editing2").removeClass("ql-hidden");
			})
	
			$("#editor").on("click", "button[data-mode!=image]", function () {
				$(".ql-editing2").addClass("ql-hidden");
			})
	
			$("#editor").on("click", ".ql-action2", function () {
				let x=$("#editor input[data-image=image]").val();
				if(x==""){
					$(".ql-editing2").addClass("ql-hidden");
				}else{
					$(".ql-editor").append('<img src="'+x+'">');
					$(".ql-editing2").addClass("ql-hidden");
				}
			})
		};



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


	question() {
		$(".isquestion").css("left", "0%");
		$(".new-title div:eq(1)").removeClass("active");
		$(".new-title div:eq(0)").addClass("active");
		$(".underline").removeClass("col-sm-offset-2");
		$(".underline").removeClass("col-xs-offset-6");
	}

	questionlist() {
		$(".new-title div:eq(0)").removeClass("active");
		$(".new-title div:eq(1)").addClass("active");
		$(".underline").addClass("col-sm-offset-2");
		$(".underline").addClass("col-xs-offset-6");
		$(".isquestion").css("left", "-100%");
	}

	init(){
		this.forumService.getQuestionList(this.page).then(res => {
			let top=this;
			if (res.state == true) {
				this.questionList=res.data;
				console.log(this.questionList);
			}
			else{
				this.modal.show(res.msg,"1500");
			}
		})
	}

	publish_question(){
		console.log(document.cookie);
		let type = this.article_type1;
		var data = {
			title: $("#title-input").val(),
			content: $("#editor .ql-editor").html(),
			tags: $("#tag-input").val(),
			type: Number(this.article_type1),
		}

		this.forumService.publishQuestion(data).then(res => {
			let top=this;
			if (res.state == true) {
				$("#title-input").val(''),
				$("#editor .ql-editor").html(''),
				$("#tag-input").val(''),
				this.modal.show("提问成功","1500");
				setTimeout(function(){
					top.init();
					top.questionlist();
				}, 1500);
			}
			else{
				this.modal.show(res.msg,"1500");
			}
		})
	}

	go_question_detail(id){
			this.router.navigate(['/forum/questionDetail',id]);
	}

}
