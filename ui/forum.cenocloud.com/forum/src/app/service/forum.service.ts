import { Injectable } from '@angular/core';
import { Http, Headers, } from '@angular/http';
import { ApiService } from './api.service';

@Injectable({
	providedIn: 'root'
})
export class ForumService {

	private api_url;
	private headers;
	private uid;
	private token;
	private verify = "111";

	constructor(private http: Http, private apiService: ApiService) {
		this.api_url = apiService.getUrl();
		this.headers = apiService.getHeaders();
		this.uid = apiService.getCookie("uid");
		this.token = apiService.getCookie("token");
	}

	getauthorId(): Number {
		return Number(this.apiService.getCookie("authorId"));
	}

	login(): Promise<any> {
		const url = "https://api.sso.cenocloud.com/login/" + this.uid + "/" + this.token + "/auth";
		return this.http.get(url, { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				return data;
			})
			.catch(this.handleError);
	}

	joinForum(): Promise<any> {
		const url = `${this.api_url}` + "/author/me";
		return this.http.post(url, this.param({}), { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				console.log(data);
				return data;
			})
			.catch(this.handleError);
	}

	addName(name): Promise<any> {
		let data = {
			nickname: name
		}
		const url = `${this.api_url}` + "/author/me/init";
		return this.http.post(url, this.param(data), { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				console.log(data);
				return data;
			})
			.catch(this.handleError);

	}

	getForumIndexLeft(page: Number, num: Number): Promise<any> {
		const url = `${this.api_url}` + "/article/all/"+page+"/"+num+"/list";
		return this.http.post(url, { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				return data;
			})
			.catch(this.handleError);
	}

	getForumArticle(id: Number): Promise<any> {
		const url = `${this.api_url}` + '/article/detail/' + id;
		return this.http.post(url, { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				return data;
			})
			.catch(this.handleError);
	}

	publishNew(data: any): Promise<any> {
		data.authorId = this.getauthorId();
		const url = `${this.api_url}` + "/article/" + this.verify + "/pub";
		return this.http.post(url, this.param(data), { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				console.log(data);
				return data;
			})
			.catch(this.handleError);
	}

	publishQuestion(data: any): Promise<any> {
		data.authorId = this.getauthorId();
		const url = `${this.api_url}` + "/question/" + this.verify + "/ask";
		return this.http.post(url, this.param(data), { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				console.log(data);
				return data;
			})
			.catch(this.handleError);
	}

	getQuestionList(page: Number): Promise<any> {
		let num = 8;
		const url = `${this.api_url}` + "/question/all/" + page + "/" + num + "/list";
		return this.http.post(url, { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				console.log(data);
				return data;
			})
			.catch(this.handleError);
	}

	publishComment(data: any): Promise<any> {
		const url = `${this.api_url}` + "/article/" + this.verify + "/comment";
		console.log(this.param(data));
		return this.http.post(url, this.param(data), { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				console.log(data);
				return data;
			})
			.catch(this.handleError);
	}

	getComment(id: Number, page: Number, num: Number): Promise<any> {
		const url = `${this.api_url}` + "/article/" + id + "/" + page + "/" + num + "/listComment";
		return this.http.post(url, this.param({}), { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				console.log(data);
				return data;
			})
			.catch(this.handleError);
	}


	Star(id:Number):Promise<any> {
		const url = `${this.api_url}` + "/comment/" + id + "/star";
		return this.http.post(url, this.param({}), { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res;
				console.log(data);
				return data;
			})
			.catch(this.handleError);
	}

	QuestionDetail(id:Number):Promise<any> {
		const url = `${this.api_url}` + "/question/" + id + "/get";
		return this.http.post(url, this.param({}), { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				console.log(data);
				return data;
			})
			.catch(this.handleError);
	}

	publishAnswer(data:any):Promise<any> {
		const url = `${this.api_url}` + "/question/" + this.verify + "/answer";
		return this.http.post(url, this.param(data), { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				console.log(data);
				return data;
			})
			.catch(this.handleError);
	}

	getAnswer(id: Number, page: Number, num: Number): Promise<any> {
		const url = `${this.api_url}` + "/question/" + id + "/answer/" + page + "/" + num + "/list";
		return this.http.post(url, this.param({}), { headers: this.headers })
			.toPromise()
			.then(function (res) {
				let data = res.json();
				console.log(data);
				return data;
			})
			.catch(this.handleError);
	}

	private param = function (obj) {
	var query = '';
	var name, value, fullSubName, subName, subValue, innerObj, i;

	for (name in obj) {
		value = obj[name];

		if (value instanceof Array) {
			for (i = 0; i < value.length; ++i) {
				subValue = value[i];
				fullSubName = name + '[' + i + ']';
				innerObj = {};
				innerObj[fullSubName] = subValue;
				query += this.param(innerObj) + '&';
			}
		} else if (value instanceof Object) {
			for (subName in value) {
				subValue = value[subName];
				fullSubName = name + '[' + subName + ']';
				innerObj = {};
				innerObj[fullSubName] = subValue;
				query += this.param(innerObj) + '&';
			}
		} else if (value !== undefined && value !== null) {
			query += encodeURIComponent(name) + '='
				+ encodeURIComponent(value) + '&';
		}
	}

	return query.length ? query.substr(0, query.length - 1) : query;
};

	private handleError(error: any): Promise < any > {
		console.error('An error occurred', error);
		return Promise.reject(error.message || error);
}
}
