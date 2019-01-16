import { Component, OnInit, ViewChild } from '@angular/core';
import { ForumService } from '../../service/forum.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ModalLogComponent } from '../modal-log/modal-log.component';

@Component({
	selector: 'app-forum-question-detail',
	templateUrl: './forum-question-detail.component.html',
	styleUrls: ['./forum-question-detail.component.css']
})
export class ForumQuestionDetailComponent implements OnInit {


	public question_id = Number(this.route.snapshot.params['id']);
	public question_detail = [];
	public load = false;
	public page = 1;
	public load_ans = 1;

	@ViewChild("modal")
	modal: ModalLogComponent

	constructor(private forumService: ForumService, private route: ActivatedRoute) {
		document.body.scrollTop = document.documentElement.scrollTop = 0;
	}

	ngOnInit() {
		this.getQuestionDetail();
	}

	getQuestionDetail(): void {
		this.forumService.QuestionDetail(this.question_id).then(res => {
			if (res.state == true) {
				this.question_detail[0] = res.data;
				this.load = true;
				if(this.question_detail[0].answers.length!=8){
					this.load_ans=3;
				}
			}
			else {
				this.modal.show(res.msg, "1500");
			}
		})
	}

	addAnswer(): void {
		var answer = $("textarea[name='answer']").val();
		if (answer == "") {
			this.modal.show("回答不能为空", "1500");
			return;
		}

		let data = {
			questionId: this.question_id,
			answer: answer
		}

		this.forumService.publishAnswer(data).then(res => {
			if (res.state == true) {
				this.modal.show("感谢回答 ^_^", "1500");
				this.question_detail[0].answers.unshift(res.data);
				console.log(this.question_detail);
				$("textarea[name='answer']").val('');
			}
			else {
				this.modal.show(res.msg, "1500");
			}
		})
	}

	getAnswer():void{
		if(this.load_ans==3){
			return;
		}
		this.load_ans=2;
		let num=8;
		let page2=this.page*num;
		this.forumService.getAnswer(this.question_id,page2,num).then(res=>{
			if(res.state==true){
				if(res.data.length==8){
					this.question_detail[0].answers=this.question_detail[0].answers.concat(res.data);
					this.load_ans=1;
				}
				else{
					this.question_detail[0].answers=this.question_detail[0].answers.concat(res.data);
					this.load_ans=3;
				}
				
			}
			else{
				this.modal.show(res.msg,"1500");
				this.load_ans=1;
			}
		})
		this.page++;
	}

}
